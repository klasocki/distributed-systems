import sys, Ice
import House


def change_temperature():
    delta = float(input("By how much do you want to change?: "))
    try:
        print("New temperature:", central_heating.changeHeatingTargetTemp(delta))
    except House.TemperatureOutOfRangeError:
        print("Temperature must be between 18 and 28 degrees after change!!")


def make_coffee():
    global types, coffee
    coffee_type = input("Enter coffee type (esspresso/latte/mocca): ")
    types = {"esspresso": House.CoffeeType.ESSPRESSO, "latte": House.CoffeeType.LATTE, "mocca": House.CoffeeType.MOCCA}
    if coffee_type not in types.keys():
        print("Wrong coffee type")
        return
    try:
        coffee = coffee_machine.getCoffee(types[coffee_type])
    except House.MachineEmptyError:
        print("Coffee machine empty, you need to refill first")


def make_tea():
    global types, tea
    tea_type = input("Enter tea type (green/black/white/herbal): ")
    types = {"black": House.TeaType.BLACK, "white": House.TeaType.WHITE, "herbal": House.TeaType.HERBAL,
             "green": House.TeaType.GREEN}
    if tea_type not in types.keys():
        print("Wrong tea type")
        return
    try:
        tea = tea_machine.getTea(types[tea_type])
    except House.MachineEmptyError:
        print("Tea machine empty, you need to refill first")


if __name__ == "__main__":
    with Ice.initialize(sys.argv) as communicator:
        heating_base = communicator.stringToProxy("heating:default -p 10000")
        central_heating = House.CentralHeatingPrx.checkedCast(heating_base)

        coffee_base = communicator.stringToProxy("coffee:default -p 10000")
        coffee_machine = House.CoffeeMachinePrx.checkedCast(coffee_base)

        tea_base = communicator.stringToProxy("tea:default -p 10000")
        tea_machine = House.TeaMachinePrx.checkedCast(tea_base)

        if not (central_heating and tea_machine and coffee_machine):
            raise RuntimeError("Invalid proxy")

        functions = {
            "house temperature": lambda: print(central_heating.getCurrentTemperature()),
            "change temperature": change_temperature,
            "get daily temperatures": lambda: print(central_heating.getDailyTemperatures()),
            "make coffee": make_coffee,
            "make tea": make_tea,
            "refill tea": lambda: tea_machine.refill(),
            "refill coffee": lambda: coffee_machine.refill(),
            "coffee amount": lambda: print(coffee_machine.getCurrentAmount()),
            "tea amount": lambda: print(tea_machine.getCurrentAmount()),
            "tea temperature": lambda : print(tea.getTemperature()),
            "coffee temperature": lambda : print(coffee.getTemperature()),
            "drink tea": lambda : print(tea.drinkIt()),
            "drink coffee": lambda : print(coffee.drinkIt()),
            "add sugar": lambda : tea.addSugar(),
            "add milk": lambda : coffee.addMilk()
        }

        coffee, tea = None, None
        while True:
            command = input("> ").strip()
            if command == "exit":
                break

            elif command in ["tea temperature",  "drink tea", "add sugar"] and not tea:
                print("You need to make tea first!")

            elif command in ["coffee temperature", "drink coffee", "add milk"] and not coffee:
                print("You need to make coffee first!")

            elif command in functions.keys():
                functions[command]()
