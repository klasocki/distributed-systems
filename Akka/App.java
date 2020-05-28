import actors.Client;
import actors.Server;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import messages.ClientRequest;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class App {

    public static void main(String[] args) throws Exception {

        // create actor system & actors
        final ActorSystem system = ActorSystem.create("local_system");
        final ActorRef server = system.actorOf(Props.create(Server.class), "server");
        final ActorRef client = system.actorOf(Props.create(Client.class), "client");
        System.out.println("App started. Type a product name to get the best price, or 'q' to quit");

        // read line & send to actor
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String line = br.readLine();
            if (line.equals("q")) {
                break;
            }
            client.tell(new ClientRequest(server, line), null);     // send message to actor
        }

        // finish
        system.terminate();
    }
}