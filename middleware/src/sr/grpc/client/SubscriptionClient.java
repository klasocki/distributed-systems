/*
 * Copyright 2015, Google Inc. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *    * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *    * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *
 *    * Neither the name of Google Inc. nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package sr.grpc.client;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;
import io.grpc.stub.StreamObserver;

import sr.grpc.SubscriptionServiceGrpc;
import sr.grpc.SubscriptionServiceGrpc.*;
import sr.grpc.Subscriptions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubscriptionClient {
	private static final Logger logger = Logger.getLogger(SubscriptionClient.class.getName());

	private final ManagedChannel channel;
	private final SubscriptionServiceBlockingStub subscriptionServiceBlockingStub;
	private final SubscriptionServiceStub subscriptionServiceNonBlockingStub;


	/** Construct client connecting to HelloWorld server at {@code host:port}. */
	public SubscriptionClient(String host, int port)
	{
		channel = ManagedChannelBuilder.forAddress(host, port)
				.usePlaintext(/*true*/)
				.build();


		subscriptionServiceBlockingStub = SubscriptionServiceGrpc.newBlockingStub(channel);
        subscriptionServiceNonBlockingStub = SubscriptionServiceGrpc.newStub(channel);
	}

	public static void main(String[] args) throws Exception
	{
		SubscriptionClient client = new SubscriptionClient("localhost", 50051);
		client.test();
	}

	public void shutdown() throws InterruptedException {
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
	}


	public void test() throws InterruptedException
	{
		try {
			String line = null;
			java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(System.in));
			do
			{
				try
				{
					System.out.print("==> ");
					System.out.flush();
					line = in.readLine();
					if (line == null)
					{
						break;
					}
					if(line.equals("subscribe meeting")) {
                        System.out.println("Team name:");
                        String team = in.readLine();
                        getMeetings(team);
                    }
					else if (line.equals("subscribe weather"))
					{
                        System.out.println("City:");
                        String city = in.readLine();
                        System.out.println("Desired temperature:");
                        float temp = Float.parseFloat(in.readLine());
                        System.out.println("Tolerance threshold:");
                        float tolerance = Float.parseFloat(in.readLine());
                        getWeather(city, temp, tolerance);
					}
				}
				catch (java.io.IOException ex)
				{
					System.err.println(ex);
				}
			}
			while (!line.equals("x"));
		} finally {
			shutdown();
		}

	}
	public void getMeetings(String team)
	{
		MeetingRequest request = MeetingRequest.newBuilder().setTeam(team).build();
		Iterator<MeetingResponse> meetings;
		try {
			meetings = subscriptionServiceBlockingStub.subscribeMeetings(request);
			while(meetings.hasNext())
			{
				MeetingResponse meeting = meetings.next();
				System.out.println("Interesting meeting: " + meeting);
			}
		} catch (StatusRuntimeException ex) {
			logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
		}
	}

    public void getWeather(String city, float temperature, float tolerance)
    {
        WeatherRequest request = WeatherRequest.newBuilder().setCity(city).setDesiredTemperature(temperature).setTolerance(tolerance).build();
        Iterator<WeatherResponse> weathers;
        try {
            weathers = subscriptionServiceBlockingStub.subscribeWeather(request);
            while(weathers.hasNext())
            {
                WeatherResponse weatherResponse = weathers.next();
                System.out.println("Desired temperature reached in " + city + ": " + weatherResponse);
            }
        } catch (StatusRuntimeException ex) {
            logger.log(Level.WARNING, "RPC failed: {0}", ex.getStatus());
        }
    }


}
