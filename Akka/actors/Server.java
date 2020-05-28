package actors;

import akka.actor.*;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.DeciderBuilder;
import akka.routing.RoundRobinPool;
import messages.DatabaseResponse;
import messages.PriceRequest;
import messages.PriceResponse;
import messages.RequestTimeout;
import org.sqlite.SQLiteOpenMode;
import scala.concurrent.duration.Duration;
import org.sqlite.SQLiteConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Server extends AbstractActor {
    // for logging
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);

    int currentRequestId = 0;
    Map<Integer, ActorRef> requestClients = new HashMap<>();
    Map<Integer, List<PriceResponse>> requestResults = new HashMap<>();
    Map<Integer, Integer> requestCounts = new HashMap<>();

    @Override
    public AbstractActor.Receive createReceive() {
        return receiveBuilder()
                .match(String.class, productName -> {
                    log.info("Received request for the price of: " + productName);
                    ActorRef shop1 = context().actorOf(Props.create(Shop.class));
                    ActorRef shop2 = context().actorOf(Props.create(Shop.class));
                    ActorRef database = context().actorOf(Props.create(DatabaseConnection.class));
                    var request = new PriceRequest(currentRequestId, productName);
                    shop1.tell(request, getSelf());
                    shop2.tell(request, getSelf());
                    database.tell(request, getSelf());
                    requestClients.put(currentRequestId, getSender());
                    requestResults.put(currentRequestId, new ArrayList<>());
                    requestCounts.put(currentRequestId, -1);

                    getContext().system().scheduler()
                            .scheduleOnce(
                                    java.time.Duration.ofMillis(300),
                                    getSelf(),
                                    new RequestTimeout(currentRequestId++, productName),
                                    getContext().getSystem().dispatcher(),
                                    null
                            );
                })
                .match(PriceResponse.class, priceResponse -> {
                    if (!requestResults.containsKey(priceResponse.id)) return;
                    log.info("Received response with a price: " + priceResponse);

                    getContext().stop(getSender());
                    var results = requestResults.get(priceResponse.id);
                    results.add(priceResponse);
                    if (results.size() == 2) {
                        var response = results.get(0).price < results.get(1).price ? results.get(0) : results.get(1);
                        response.requestCount = requestCounts.get(priceResponse.id);
                        requestClients.get(priceResponse.id).tell(response, null);

                        requestClients.remove(priceResponse.id);
                        requestResults.remove(priceResponse.id);
                        requestCounts.remove(priceResponse.id);
                    }
                })
                .match(RequestTimeout.class, requestTimeout -> {
                    if (!requestResults.containsKey(requestTimeout.id)) return;
                    log.info("Timeout for a request: " + requestTimeout);

                    getContext().stop(getSender());
                    ActorRef client = requestClients.get(requestTimeout.id);
                    var results = requestResults.get(requestTimeout.id);
                    if (results.size() == 0) client.tell(requestTimeout, null);
                    else if (results.size() == 1) {
                        var response = results.get(0);
                        response.requestCount = requestCounts.get(requestTimeout.id);
                        client.tell(response, null);
                    }
                    else {
                        var response = results.get(0).price < results.get(1).price ? results.get(0) : results.get(1);
                        response.requestCount = requestCounts.get(requestTimeout.id);
                        client.tell(response, null);
                    }

                    requestClients.remove(requestTimeout.id);
                    requestResults.remove(requestTimeout.id);
                    requestCounts.remove(requestTimeout.id);
                })
                .match(DatabaseResponse.class, databaseResponse -> {
                    if (requestCounts.containsKey(databaseResponse.id)) {
                        log.info("Received database response in time: " + databaseResponse);
                        requestCounts.replace(databaseResponse.id, databaseResponse.requestCount);
                    }
                    else log.info("Received time outed database response: " + databaseResponse);
                    getContext().stop(getSender());
                })
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }

    @Override
    public void preStart() throws Exception {
        Class.forName("org.sqlite.JDBC");
        SQLiteConfig config = new SQLiteConfig();
        config.setOpenMode(SQLiteOpenMode.FULLMUTEX);
        Connection c = DriverManager.getConnection("jdbc:sqlite:searches.db", config.toProperties());

        Statement stmt = c.createStatement();
        stmt.executeUpdate("create table if not exists searches" +
                "(name varchar(256) not null," +
                "request_count int not null);");
        stmt.close();
        c.close();
        log.info("Created database table 'searches'");
    }

    private static final SupervisorStrategy strategy
            = new OneForOneStrategy(10, Duration.create("1 minute"), DeciderBuilder.
            matchAny(o -> (SupervisorStrategy.Directive) SupervisorStrategy.resume()).
            build());

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

}
