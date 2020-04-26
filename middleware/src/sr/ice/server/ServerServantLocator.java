package sr.ice.server;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;

import java.util.HashMap;
import java.util.Map;

public class ServerServantLocator implements ServantLocator {
    private final Map<String, Object> servants = new HashMap<>();

    @Override
    public LocateResult locate(Current current) throws UserException {
        String name = current.id.name;
        if(servants.containsKey(name)) return new ServantLocator.LocateResult(servants.get(name), null);

        System.out.println("Creating servant for " + name);
        Object servant;
        switch (name) {
            case "heating":
                servant = new CentralHeatingI();
                break;
            case "tea":
                servant = new TeaMachineI();
                break;
            case "coffee":
                servant = new CoffeeMachineI();
                break;
            default:
                throw new ObjectNotFoundException();
        }
        servants.put(name, servant);
        return new ServantLocator.LocateResult(servant, null);
    }

    @Override
    public void finished(Current current, Object object, java.lang.Object o) throws UserException {

    }

    @Override
    public void deactivate(String s) {

    }
}
