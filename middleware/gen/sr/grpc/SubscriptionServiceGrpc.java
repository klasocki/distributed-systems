package sr.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.27.0)",
    comments = "Source: subscriptions.proto")
public final class SubscriptionServiceGrpc {

  private SubscriptionServiceGrpc() {}

  public static final String SERVICE_NAME = "sr.grpc.SubscriptionService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<sr.grpc.Subscriptions.WeatherRequest,
      sr.grpc.Subscriptions.WeatherResponse> getSubscribeWeatherMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribeWeather",
      requestType = sr.grpc.Subscriptions.WeatherRequest.class,
      responseType = sr.grpc.Subscriptions.WeatherResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sr.grpc.Subscriptions.WeatherRequest,
      sr.grpc.Subscriptions.WeatherResponse> getSubscribeWeatherMethod() {
    io.grpc.MethodDescriptor<sr.grpc.Subscriptions.WeatherRequest, sr.grpc.Subscriptions.WeatherResponse> getSubscribeWeatherMethod;
    if ((getSubscribeWeatherMethod = SubscriptionServiceGrpc.getSubscribeWeatherMethod) == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        if ((getSubscribeWeatherMethod = SubscriptionServiceGrpc.getSubscribeWeatherMethod) == null) {
          SubscriptionServiceGrpc.getSubscribeWeatherMethod = getSubscribeWeatherMethod =
              io.grpc.MethodDescriptor.<sr.grpc.Subscriptions.WeatherRequest, sr.grpc.Subscriptions.WeatherResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribeWeather"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.Subscriptions.WeatherRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.Subscriptions.WeatherResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriptionServiceMethodDescriptorSupplier("subscribeWeather"))
              .build();
        }
      }
    }
    return getSubscribeWeatherMethod;
  }

  private static volatile io.grpc.MethodDescriptor<sr.grpc.Subscriptions.MeetingRequest,
      sr.grpc.Subscriptions.MeetingResponse> getSubscribeMeetingsMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "subscribeMeetings",
      requestType = sr.grpc.Subscriptions.MeetingRequest.class,
      responseType = sr.grpc.Subscriptions.MeetingResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<sr.grpc.Subscriptions.MeetingRequest,
      sr.grpc.Subscriptions.MeetingResponse> getSubscribeMeetingsMethod() {
    io.grpc.MethodDescriptor<sr.grpc.Subscriptions.MeetingRequest, sr.grpc.Subscriptions.MeetingResponse> getSubscribeMeetingsMethod;
    if ((getSubscribeMeetingsMethod = SubscriptionServiceGrpc.getSubscribeMeetingsMethod) == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        if ((getSubscribeMeetingsMethod = SubscriptionServiceGrpc.getSubscribeMeetingsMethod) == null) {
          SubscriptionServiceGrpc.getSubscribeMeetingsMethod = getSubscribeMeetingsMethod =
              io.grpc.MethodDescriptor.<sr.grpc.Subscriptions.MeetingRequest, sr.grpc.Subscriptions.MeetingResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "subscribeMeetings"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.Subscriptions.MeetingRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  sr.grpc.Subscriptions.MeetingResponse.getDefaultInstance()))
              .setSchemaDescriptor(new SubscriptionServiceMethodDescriptorSupplier("subscribeMeetings"))
              .build();
        }
      }
    }
    return getSubscribeMeetingsMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static SubscriptionServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceStub>() {
        @java.lang.Override
        public SubscriptionServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceStub(channel, callOptions);
        }
      };
    return SubscriptionServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static SubscriptionServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceBlockingStub>() {
        @java.lang.Override
        public SubscriptionServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceBlockingStub(channel, callOptions);
        }
      };
    return SubscriptionServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static SubscriptionServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<SubscriptionServiceFutureStub>() {
        @java.lang.Override
        public SubscriptionServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new SubscriptionServiceFutureStub(channel, callOptions);
        }
      };
    return SubscriptionServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class SubscriptionServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void subscribeWeather(sr.grpc.Subscriptions.WeatherRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.WeatherResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeWeatherMethod(), responseObserver);
    }

    /**
     */
    public void subscribeMeetings(sr.grpc.Subscriptions.MeetingRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.MeetingResponse> responseObserver) {
      asyncUnimplementedUnaryCall(getSubscribeMeetingsMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSubscribeWeatherMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                sr.grpc.Subscriptions.WeatherRequest,
                sr.grpc.Subscriptions.WeatherResponse>(
                  this, METHODID_SUBSCRIBE_WEATHER)))
          .addMethod(
            getSubscribeMeetingsMethod(),
            asyncServerStreamingCall(
              new MethodHandlers<
                sr.grpc.Subscriptions.MeetingRequest,
                sr.grpc.Subscriptions.MeetingResponse>(
                  this, METHODID_SUBSCRIBE_MEETINGS)))
          .build();
    }
  }

  /**
   */
  public static final class SubscriptionServiceStub extends io.grpc.stub.AbstractAsyncStub<SubscriptionServiceStub> {
    private SubscriptionServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceStub(channel, callOptions);
    }

    /**
     */
    public void subscribeWeather(sr.grpc.Subscriptions.WeatherRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.WeatherResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeWeatherMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void subscribeMeetings(sr.grpc.Subscriptions.MeetingRequest request,
        io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.MeetingResponse> responseObserver) {
      asyncServerStreamingCall(
          getChannel().newCall(getSubscribeMeetingsMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class SubscriptionServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<SubscriptionServiceBlockingStub> {
    private SubscriptionServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.Subscriptions.WeatherResponse> subscribeWeather(
        sr.grpc.Subscriptions.WeatherRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeWeatherMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<sr.grpc.Subscriptions.MeetingResponse> subscribeMeetings(
        sr.grpc.Subscriptions.MeetingRequest request) {
      return blockingServerStreamingCall(
          getChannel(), getSubscribeMeetingsMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class SubscriptionServiceFutureStub extends io.grpc.stub.AbstractFutureStub<SubscriptionServiceFutureStub> {
    private SubscriptionServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected SubscriptionServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new SubscriptionServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_SUBSCRIBE_WEATHER = 0;
  private static final int METHODID_SUBSCRIBE_MEETINGS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final SubscriptionServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(SubscriptionServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SUBSCRIBE_WEATHER:
          serviceImpl.subscribeWeather((sr.grpc.Subscriptions.WeatherRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.WeatherResponse>) responseObserver);
          break;
        case METHODID_SUBSCRIBE_MEETINGS:
          serviceImpl.subscribeMeetings((sr.grpc.Subscriptions.MeetingRequest) request,
              (io.grpc.stub.StreamObserver<sr.grpc.Subscriptions.MeetingResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class SubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    SubscriptionServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return sr.grpc.Subscriptions.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("SubscriptionService");
    }
  }

  private static final class SubscriptionServiceFileDescriptorSupplier
      extends SubscriptionServiceBaseDescriptorSupplier {
    SubscriptionServiceFileDescriptorSupplier() {}
  }

  private static final class SubscriptionServiceMethodDescriptorSupplier
      extends SubscriptionServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    SubscriptionServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (SubscriptionServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new SubscriptionServiceFileDescriptorSupplier())
              .addMethod(getSubscribeWeatherMethod())
              .addMethod(getSubscribeMeetingsMethod())
              .build();
        }
      }
    }
    return result;
  }
}
