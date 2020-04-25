package sr.ice.server;

import House.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class CoffeeMachineI implements CoffeeMachine {
    private int capacity = 5;
    private int currentAmount = 3;
    private Integer coffeeId = 0;


    @Override
    public CoffeePrx getCoffee(CoffeeType coffeeType, Current current) throws MachineEmptyError {
        if (currentAmount > 0) {
            currentAmount--;
            Coffee coffee = new CoffeeI(coffeeType);
            coffeeId++;
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return CoffeePrx.checkedCast(
                    current.adapter.add(coffee, new Identity("coffee" + coffeeId.toString(), "drinks"))
            );
        } else throw new MachineEmptyError();
    }

    @Override
    public int getCapacity(Current current) {
        return capacity;
    }

    @Override
    public int getCurrentAmount(Current current) {
        return currentAmount;
    }

    @Override
    public void refill(Current current) {
        currentAmount = capacity;
    }

}
