# coding=utf-8
import subscriptions_pb2
import random
import time

cities = ["Kielce", "Kraków"]

conditions = [subscriptions_pb2.STORMY, subscriptions_pb2.SUNNY, subscriptions_pb2.CLOUDY, subscriptions_pb2.RAINY]

weathers = [subscriptions_pb2.WeatherResponse(
    city = random.choice(cities), temperature = random.random() * 40 - 20, conditions = random.choice(conditions)
)
for i in range(100)]


def weather_generator(request):
    for weather in weathers:
        if weather.city == request.city and - request.tolerance <= request.desiredTemperature - weather.temperature <= request.tolerance:
            yield weather
        time.sleep(5)



teams = ["frontend", "backend"]
types = [subscriptions_pb2.STANDUP, subscriptions_pb2.DIRECTORS, subscriptions_pb2.COMPANY_WIDE]
rooms = [str(num) + letter for num in range(256) for letter in "ABCDEFGH"]
names = ["John", "Jan", "Jacek", "Jack", "Karol", "Charles"]
surnames = ["Johnson", "Nowak", "Kowalski", "Smith", "Sigmundsson", "Takayashi"]
people = [subscriptions_pb2.Person(name=name, surname =surname) for name in names for surname in surnames]

meetings = [
    subscriptions_pb2.MeetingResponse(
        team = random.choice(teams),
        participants=random.sample(people, random.choice([2,3,4,5])),
        room=random.choice(rooms),
        type=random.choice(types),
        datetime="2020-01-01 8:00"
) for i in range(20)]

def meeting_generator(request):
    for meeting in meetings:
        if meeting.team == request.team:
            yield meeting
        time.sleep(3)
