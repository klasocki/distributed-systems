
#ifndef HOUSE_ICE
#define HOUSE_ICE

module House
{
  sequence<float> seqOfReadings;
  exception TemperatureOutOfRangeError {};

  interface CentralHeating
 {
    idempotent float getCurrentTemperature();
    idempotent seqOfReadings getDailyTemperatures();
    float changeHeatingTargetTemp(float delta) throws TemperatureOutOfRangeError;
 };

exception MachineEmptyError{};

enum TeaType { GREEN, BLACK, WHITE, HERBAL };
enum CoffeeType {LATTE, ESSPRESSO, MOCCA};

 interface Drink
 {
    idempotent float getTemperature();
    idempotent string drinkIt();
 };

 interface Tea extends Drink
 {
    idempotent void addSugar();
 };

 interface Coffee extends Drink
 {
    idempotent void addMilk();
 };

 interface DrinkMachine
 {
    idempotent int getCapacity();
    idempotent int getCurrentAmount();
    idempotent void refill();
 };

 interface CoffeeMachine extends DrinkMachine
 {
    Coffee* getCoffee(CoffeeType coffeeType) throws MachineEmptyError;
 };

 interface TeaMachine extends DrinkMachine
 {
    Tea* getTea(TeaType teaType) throws MachineEmptyError;
 };

};

#endif

// slice2java --output-dir gen house.ice