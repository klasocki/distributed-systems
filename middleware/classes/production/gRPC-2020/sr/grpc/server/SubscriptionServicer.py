import subscriptions_pb2
import subscriptions_pb2_grpc
import grpc
import time
from concurrent import futures
import data



class SubscriptionServicer(subscriptions_pb2_grpc.SubscriptionServiceServicer):
    def subscribeWeather(self, request, context):
        print("Received subscription", request)

        if request.city not in data.cities:
            msg = f'Weather in {request.city} is not supported, we only know about {data.cities}'
            context.set_details(msg)
            context.set_code(grpc.StatusCode.INVALID_ARGUMENT)
            return subscriptions_pb2.WeatherResponse()

        for resp in data.weather_generator(request):
            yield resp

    def subscribeMeetings(self, request, context):
        print("Received subscription", request)

        if request.team not in data.teams:
            msg = f'Team {request.team} is not in our database, we only know about {data.teams}'
            context.set_details(msg)
            context.set_code(grpc.StatusCode.INVALID_ARGUMENT)
            return subscriptions_pb2.MeetingResponse()

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