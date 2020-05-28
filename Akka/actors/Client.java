package actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messages.ClientRequest;
import messages.PriceResponse;
import messages.RequestTimeout;

public class Client extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    @Override
    public AbstractActor.Receive createReceive() {
            return receiveBuilder()
                    .match(ClientRequest.class, clientRequest ->
                            clientRequest.server.tell(clientRequest.product, getSelf())
                    )
                    .match(PriceResponse.class, priceResponse -> {
                        log.info("Client received price response: " + priceResponse);
                        System.out.println("Received a price for " + priceResponse.product +  (
                                (priceResponse.requestCount != -1) ?
                                ", request count: " + priceResponse.requestCount : ""
                        ));
                        System.out.println(priceResponse.price + " PLN");
                    })
                    .match(RequestTimeout.class, requestTimeout -> {
                        System.out.println("Timeout, no price available for " + requestTimeout.product);
                    })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
    }
}
