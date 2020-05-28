package actors;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import messages.PriceRequest;
import messages.PriceResponse;

import java.util.Random;

public class Shop extends AbstractActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    @Override
    public Receive createReceive() {
            return receiveBuilder()
                    .match(PriceRequest.class, priceRequest -> {
                        Random random = new Random();
                        int timeToSleep = random.nextInt(400) + 100;
                        log.info("Sleeping for " + timeToSleep + " ms");
                        Thread.sleep(timeToSleep);
                        PriceResponse response = new PriceResponse(
                                priceRequest.product,
                                random.nextInt(10) + 1,
                                priceRequest.id
                        );
                        getSender().tell(response, getSelf());
                    })
                    .matchAny(o -> log.info("received unknown message"))
                    .build();
    }

}
