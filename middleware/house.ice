
#ifndef HOUSE_ICE
#define HOUSE_ICE

module House
{
  sequence<float> seqOfReadings;
  exception TemperatureOutOfRangeError {};

  interface CentralHeating
 {
    float getCurrentTemperature();
    seqOfReadings getDailyTemperatures();
    float changeHeatingTargetTemp(float delta) throws TemperatureOutOfRangeError;
 };

exception MachineEmptyError{};

enum TeaType { GREEN, BLACK, WHITE, HERBAL };
enum CoffeeType {LATTE, ESSPRESSO, MOCCA};

 interface Drink
 {
    float getTemperature();
    string drinkIt();
 };

 interface Tea extends Drink
 {
    void addSugar();
 };

 interface Coffee extends Drink
 {
    void addMilk();
 };

 interface DrinkMachine
 {
    int getCapacity();
    int getCurrentAmount();
    void refill();
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