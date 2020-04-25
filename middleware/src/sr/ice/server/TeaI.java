package sr.ice.server;

import House.Tea;
import House.TeaType;
import com.zeroc.Ice.Current;

public class TeaI implements Tea {
    private TeaType teaType;
    private boolean isSweet;

    public TeaI(TeaType teaType) {
        this.teaType = teaType;
        this.isSweet = false;
    }

    @Override
    public void addSugar(Current current) {
        this.isSweet = true;
    }

    @Override
    public float getTemperature(Current current) {
        switch (teaType) {
            case BLACK:
                return 98;
            case HERBAL:
                return 100;
            case GREEN:
                return 75;
            case WHITE:
                return 80;
            default:
                return 0;
        }
    }

    @Override
    public String drinkIt(Current current) {
        return  "What a delicious " + teaType.toString() + (isSweet ? " sweet": " dry") + " tea!!!";
    }
}
