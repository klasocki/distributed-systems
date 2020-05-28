package actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messages.DatabaseResponse;
import messages.PriceRequest;
import org.sqlite.SQLiteConfig;
import org.sqlite.SQLiteOpenMode;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    private Connection connection;

    @Override
    public Receive createReceive() {
            return receiveBuilder()
                    .match(PriceRequest.class, priceRequest -> {
                        var startTime = System.currentTimeMillis();
                        Statement statement = connection.createStatement();

                        ResultSet resultSet = statement.executeQuery( 
                                "select request_count from searches where name='" + priceRequest.product + "';" );
                        int requestCount;

                        if(resultSet.isBeforeFirst()) {
                            requestCount = resultSet.getInt("request_count") + 1;
                            statement.executeUpdate(
                                    "update searches set request_count = " + requestCount + " where name='" + priceRequest.product + "';");

                        } else {
                            statement.executeUpdate("insert into searches (name, request_count) values ('" +
                                    priceRequest.product + "', 1);"
                            );
                            requestCount = 1;
                        }

                        resultSet.close();
                        statement.close();
                        connection.close();
                        var response = new DatabaseResponse(
                                priceRequest.product,
                                requestCount,
                                priceRequest.id
                        );
                        getSender().tell(response, getSelf());
                        var endTime = System.currentTimeMillis();
                        log.info("Processed database request in " + (endTime - startTime) + "ms");
                    })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
    }

    @Override
    public void preStart() throws Exception {
        Class.forName("org.sqlite.JDBC");
        SQLiteConfig config = new SQLiteConfig();
        config.setOpenMode(SQLiteOpenMode.FULLMUTEX);
        connection = DriverManager.getConnection("jdbc:sqlite:searches.db", config.toProperties());
    }

}
