package sr.ice.server;

import House.CentralHeating;
import House.TemperatureOutOfRangeError;
import com.zeroc.Ice.Current;

import java.util.ArrayList;

public class CentralHeatingI implements CentralHeating {
    private float currentTemperature = 21;
    private float minTemperature = 18;
    private float maxTemperature = 28;
    private ArrayList<Float> dailyTemperatures = new ArrayList<>();

    @Override
    public float getCurrentTemperature(Current current) {
        dailyTemperatures.add(currentTemperature);
        return currentTemperature;
    }

    @Override
    public float[] getDailyTemperatures(Current current) {
        float[] result = new float[dailyTemperatures.size()];
        int index = 0;
        for(Float item: dailyTemperatures) {
            result[index++] = item;
        }
        return result;
    }

    @Override
    public float changeHeatingTargetTemp(float delta, Current current) throws TemperatureOutOfRangeError {
        if (currentTemperature + delta < minTemperature || currentTemperature + delta > maxTemperature) {
            throw new TemperatureOutOfRangeError();
        }
        currentTemperature += delta;
        return currentTemperature;
    }
}
