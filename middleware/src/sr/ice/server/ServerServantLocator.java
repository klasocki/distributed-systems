package sr.ice.server;

import com.zeroc.Ice.*;
import com.zeroc.Ice.Object;

import java.util.HashMap;
import java.util.Map;

public class ServerServantLocator implements ServantLocator {
    private final Map<String, Object> servants = new HashMap<>();

    public void addServant(Object servant, String name){
        servants.put(name, servant);
    }

    @Override
    public LocateResult locate(Current current) throws UserException {
        String name = current.id.name;
        if(!servants.containsKey(name)) throw new ObjectNotFoundException();
        System.out.println("Locating servant for " + name);

        Object servant = servants.get(name);
        return new ServantLocator.LocateResult(servant, null);
    }

    @Override
    public void finished(Current current, Object object, java.lang.Object o) throws UserException {

    }

    @Override
    public void deactivate(String s) {

    }
}
