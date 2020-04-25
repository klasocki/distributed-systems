import subscriptions_pb2
import subscriptions_pb2_grpc
import grpc
import time
from concurrent import futures
import data



class SubscriptionServicer(subscriptions_pb2_grpc.SubscriptionServiceServicer):
    def subscribeWeather(self, request, context):
        print("Received subscription", request)
        for resp in data.weather_generator(request):
            yield resp

    def subscribeMeetings(self, request, context):
        print("Received subscription", request)
        for resp in data.meeting_generator(request):
            yield resp


def serve():
    print("Subscription server starting...")
    server = grpc.server(futures.ThreadPoolExecutor(max_workers=4))
    subscriptions_pb2_grpc.add_SubscriptionServiceServicer_to_server(
        SubscriptionServicer(), server)
    server.add_insecure_port('[::]:50051')
    server.start()
    server.wait_for_termination()


if __name__ == '__main__':
    serve()