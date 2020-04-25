# Generated by the gRPC Python protocol compiler plugin. DO NOT EDIT!
import grpc

import subscriptions_pb2 as subscriptions__pb2


class SubscriptionServiceStub(object):
    """Missing associated documentation comment in .proto file"""

    def __init__(self, channel):
        """Constructor.

        Args:
            channel: A grpc.Channel.
        """
        self.subscribeWeather = channel.unary_stream(
                '/sr.grpc.SubscriptionService/subscribeWeather',
                request_serializer=subscriptions__pb2.WeatherRequest.SerializeToString,
                response_deserializer=subscriptions__pb2.WeatherResponse.FromString,
                )
        self.subscribeMeetings = channel.unary_stream(
                '/sr.grpc.SubscriptionService/subscribeMeetings',
                request_serializer=subscriptions__pb2.MeetingRequest.SerializeToString,
                response_deserializer=subscriptions__pb2.MeetingResponse.FromString,
                )


class SubscriptionServiceServicer(object):
    """Missing associated documentation comment in .proto file"""

    def subscribeWeather(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')

    def subscribeMeetings(self, request, context):
        """Missing associated documentation comment in .proto file"""
        context.set_code(grpc.StatusCode.UNIMPLEMENTED)
        context.set_details('Method not implemented!')
        raise NotImplementedError('Method not implemented!')


def add_SubscriptionServiceServicer_to_server(servicer, server):
    rpc_method_handlers = {
            'subscribeWeather': grpc.unary_stream_rpc_method_handler(
                    servicer.subscribeWeather,
                    request_deserializer=subscriptions__pb2.WeatherRequest.FromString,
                    response_serializer=subscriptions__pb2.WeatherResponse.SerializeToString,
            ),
            'subscribeMeetings': grpc.unary_stream_rpc_method_handler(
                    servicer.subscribeMeetings,
                    request_deserializer=subscriptions__pb2.MeetingRequest.FromString,
                    response_serializer=subscriptions__pb2.MeetingResponse.SerializeToString,
            ),
    }
    generic_handler = grpc.method_handlers_generic_handler(
            'sr.grpc.SubscriptionService', rpc_method_handlers)
    server.add_generic_rpc_handlers((generic_handler,))


 # This class is part of an EXPERIMENTAL API.
class SubscriptionService(object):
    """Missing associated documentation comment in .proto file"""

    @staticmethod
    def subscribeWeather(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(request, target, '/sr.grpc.SubscriptionService/subscribeWeather',
            subscriptions__pb2.WeatherRequest.SerializeToString,
            subscriptions__pb2.WeatherResponse.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)

    @staticmethod
    def subscribeMeetings(request,
            target,
            options=(),
            channel_credentials=None,
            call_credentials=None,
            compression=None,
            wait_for_ready=None,
            timeout=None,
            metadata=None):
        return grpc.experimental.unary_stream(request, target, '/sr.grpc.SubscriptionService/subscribeMeetings',
            subscriptions__pb2.MeetingRequest.SerializeToString,
            subscriptions__pb2.MeetingResponse.FromString,
            options, channel_credentials,
            call_credentials, compression, wait_for_ready, timeout, metadata)
