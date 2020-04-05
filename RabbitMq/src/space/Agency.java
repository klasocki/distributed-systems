package space;

import com.rabbitmq.client.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class Agency {
    static String EXCHANGE_NAME = "exchangeTopic";

    public static void main(String[] argv) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Agency name: ");
        String agencyName = br.readLine();
        agencyName = agencyName.replaceAll("\\s+", "_");
        int taskId = 0;

        // connection & channel
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("localhost");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        // exchange
//        channel.exchangeDeclare(EXCHANGE_NAME, BuiltinExchangeType.TOPIC);

        // consumer (message handling)
        Consumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String message = new String(body, StandardCharsets.UTF_8);
                System.out.println("Received: " + message);
                channel.basicAck(envelope.getDeliveryTag(), false);
            }
        };

//        String queueName = channel.queueDeclare().getQueue();
//        channel.queueBind(queueName, EXCHANGE_NAME, "agency." + agencyName);
        channel.queueDeclare(agencyName, false, false, false, null);
        channel.basicConsume(agencyName, false, consumer);

        while (true) {

            System.out.println("Enter task type: (One of P, C, S, where P - people transport, " +
                    "C - cargo transport, S - satellite deployment)");
            String taskType = br.readLine();

            if (!taskType.equals("P") && !taskType.equals("C") && !taskType.equals("S")) {
                System.out.println("Unknown task, continuing...");
                continue;
            }
//            String bindingKey = "producer." + taskType;
            String message = agencyName + "-" + taskId + "-" + taskType;

            // publish
            channel.basicPublish("", taskType, null, message.getBytes(StandardCharsets.UTF_8));
            System.out.println("Submitted task: " + message);
            taskId++;
        }

        // close
//        channel.close();
//        connection.close();
    }
}
