package space;

import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Carrier {
    static String EXCHANGE_NAME = "exchangeTopic";

    public static void main(String[] argv) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Which tasks will the Carrier perform? (One of PC, PS, CS, where P - people transport" +
                "C - cargo transport, S - satellite deployment):");

        String tasksPerformed = br.readLine();
        if (!tasksPerformed.equals("PC") && !tasksPerformed.equals("PS") && !tasksPerformed.equals("CS")) {
            throw new IllegalArgumentException("Tasks must be one of PC, PS, CS");
        }

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        String queueTaskOne = "" + tasksPerformed.charAt(0);
        String queueTaskTwo = "" + tasksPerformed.charAt(1);
        channel.queueDeclare(queueTaskOne, false, false, false, null);
        channel.queueDeclare(queueTaskTwo, false, false, false, null);
        channel.basicQos(1);


        // exchange
//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        // consumer (message handling)
        Consumer consumerTaskOne = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                handleMessage(envelope, body, channel);
            }
        };
        Consumer consumerTaskTwo = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                handleMessage(envelope, body, channel);
            }
        };


//        String bindingKey = "producer.";
//        String bindingKeyOne = bindingKey + tasksPerformed.charAt(0);
//        String bindingKeyTwo = bindingKey + tasksPerformed.charAt(1);

        // queue & bind
//        String queueTaskOne = channel.queueDeclare().getQueue();
//        channel.queueBind(queueTaskOne, EXCHANGE_NAME, bindingKeyOne);
//        System.out.println("created queue: " + queueTaskOne);
//
//        String queueTaskTwo = channel.queueDeclare().getQueue();
//        channel.queueBind(queueTaskTwo, EXCHANGE_NAME, bindingKeyTwo);
//        System.out.println("created queue: " + queueTaskTwo);

//        channel.basicQos(1);

        // start listening
        System.out.println("Waiting for tasks...");
        channel.basicConsume(queueTaskOne, false, consumerTaskOne);
        channel.basicConsume(queueTaskTwo, false, consumerTaskOne);
    }

    private static void handleMessage(Envelope envelope, byte[] body, Channel channel) throws IOException {
        String message = new String(body, StandardCharsets.UTF_8);
        System.out.println("Received: " + message);
        String[] msg = message.split("-");
        if (msg.length == 3) {
            String reply = "Completed task " + msg[2] + ", id: " + msg[1];
            channel.basicPublish("", msg[0], null, reply.getBytes(StandardCharsets.UTF_8));
        }
        channel.basicAck(envelope.getDeliveryTag(), false);
    }
}
