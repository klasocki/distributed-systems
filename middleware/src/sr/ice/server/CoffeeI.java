package sr.ice.server;

import House.Coffee;
import House.CoffeeType;
import com.zeroc.Ice.Current;

public class CoffeeI implements Coffee {
    private CoffeeType coffeeType;
    private boolean hasMilk;

    public CoffeeI(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
    }

    @Override
    public void addMilk(Current current) {
        this.hasMilk = true;
    }

    @Override
    public float getTemperature(Current current) {
        return 100;
    }

    @Override
    public String drinkIt(Current current) {
        return "What a delicious " + coffeeType.toString() + " coffee " + (hasMilk? " with milk!!!": "!!!");
    }
}
