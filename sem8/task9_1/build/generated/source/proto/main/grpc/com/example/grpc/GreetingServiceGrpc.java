package com.example.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.43.1)",
    comments = "Source: Chat.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class GreetingServiceGrpc {

  private GreetingServiceGrpc() {}

  public static final String SERVICE_NAME = "com.example.grpc.GreetingService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.example.grpc.HelloRequest,
      com.example.grpc.HelloResponse> getGreetingMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "greeting",
      requestType = com.example.grpc.HelloRequest.class,
      responseType = com.example.grpc.HelloResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<com.example.grpc.HelloRequest,
      com.example.grpc.HelloResponse> getGreetingMethod() {
    io.grpc.MethodDescriptor<com.example.grpc.HelloRequest, com.example.grpc.HelloResponse> getGreetingMethod;
    if ((getGreetingMethod = GreetingServiceGrpc.getGreetingMethod) == null) {
      synchronized (GreetingServiceGrpc.class) {
        if ((getGreetingMethod = GreetingServiceGrpc.getGreetingMethod) == null) {
          GreetingServiceGrpc.getGreetingMethod = getGreetingMethod =
              io.grpc.MethodDescriptor.<com.example.grpc.HelloRequest, com.example.grpc.HelloResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "greeting"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.example.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.example.grpc.HelloResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGreetingMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static GreetingServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceStub>() {
        @java.lang.Override
        public GreetingServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceStub(channel, callOptions);
        }
      };
    return GreetingServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static GreetingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceBlockingStub>() {
        @java.lang.Override
        public GreetingServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceBlockingStub(channel, callOptions);
        }
      };
    return GreetingServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static GreetingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<GreetingServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<GreetingServiceFutureStub>() {
        @java.lang.Override
        public GreetingServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new GreetingServiceFutureStub(channel, callOptions);
        }
      };
    return GreetingServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class GreetingServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.HelloRequest> greeting(
        io.grpc.stub.StreamObserver<com.example.grpc.HelloResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGreetingMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGreetingMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                com.example.grpc.HelloRequest,
                com.example.grpc.HelloResponse>(
                  this, METHODID_GREETING)))
          .build();
    }
  }

  /**
   */
  public static final class GreetingServiceStub extends io.grpc.stub.AbstractAsyncStub<GreetingServiceStub> {
    private GreetingServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceStub(channel, callOptions);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.example.grpc.HelloRequest> greeting(
        io.grpc.stub.StreamObserver<com.example.grpc.HelloResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getGreetingMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class GreetingServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<GreetingServiceBlockingStub> {
    private GreetingServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceBlockingStub(channel, callOptions);
    }
  }

  /**
   */
  public static final class GreetingServiceFutureStub extends io.grpc.stub.AbstractFutureStub<GreetingServiceFutureStub> {
    private GreetingServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected GreetingServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new GreetingServiceFutureStub(channel, callOptions);
    }
  }

  private static final int METHODID_GREETING = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final GreetingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(GreetingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GREETING:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.greeting(
              (io.grpc.stub.StreamObserver<com.example.grpc.HelloResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (GreetingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGreetingMethod())
              .build();
        }
      }
    }
    return result;
  }
}
