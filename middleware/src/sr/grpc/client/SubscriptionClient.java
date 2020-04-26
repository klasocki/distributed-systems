package sr.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import sr.grpc.MeetingRequest;
import sr.grpc.SubscriptionServiceGrpc;
import sr.grpc.SubscriptionServiceGrpc.*;
import sr.grpc.WeatherRequest;

import java.util.concurrent.TimeUnit;

public class SubscriptionClient {
    private final ManagedChannel channel;
    private final SubscriptionServiceStub subscriptionServiceNonBlockingStub;

    private final StreamObserver streamObserver = new StreamObserver() {

        @Override
        public void onNext(Object o) {
            System.out.println("New interesting event!");
            System.out.println(o.toString());
        }

        @Override
        public void onError(Throwable throwable) {
            if(throwable instanceof StatusRuntimeException){
                System.out.println(throwable.getMessage());
                return;
            }
            System.out.println("There has been an error: ");
            throwable.printStackTrace();
        }

        @Override
        public void onCompleted() {
        }
    };


    public SubscriptionClient(String host, int port) {
        channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext()
                .build();

        subscriptionServiceNonBlockingStub = SubscriptionServiceGrpc.newStub(channel);
    }

    public static void main(String[] args) throws Exception {
        SubscriptionClient client = new SubscriptionClient("localhost", 50051);
        client.test();
    }

    public void shutdown() throws InterruptedException {
        channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
    }


    public void test() throws InterruptedException {
        try {
            String line = null;
            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
            do {
                try {
                    System.out.print("==> ");
                    System.out.flush();
                    line = in.readLine();
                    if (line == null) break;

                    if (line.equals("subscribe meetings")) {
                        System.out.println("Team name:");
                        String team = in.readLine();
                        getMeetings(team);
                    } else if (line.equals("subscribe weather")) {
                        System.out.println("City:");
                        String city = in.readLine();
                        System.out.println("Desired temperature:");
                        float temp = Float.parseFloat(in.readLine());
                        System.out.println("Tolerance threshold:");
                        float tolerance = Float.parseFloat(in.readLine());
                        getWeather(city, temp, tolerance);
                    } else System.out.println("Unknown command");

                } catch (java.io.IOException ex) {
                    System.err.println(ex);
                } catch (StatusRuntimeException e) {
                    System.err.println(e.getMessage());
                }
            }
            while (!line.equals("x"));
        } finally {
            shutdown();
        }

    }

    public void getMeetings(String team) {
        MeetingRequest request = MeetingRequest.newBuilder().setTeam(team).build();
        subscriptionServiceNonBlockingStub.subscribeMeetings(request, streamObserver);
    }

    public void getWeather(String city, float temperature, float tolerance) {
        WeatherRequest request = WeatherRequest.newBuilder().setCity(city).setDesiredTemperature(temperature).setTolerance(tolerance).build();
        subscriptionServiceNonBlockingStub.subscribeWeather(request, streamObserver);
    }

}
