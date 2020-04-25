package sr.ice.server;

import House.*;
import com.zeroc.Ice.Current;
import com.zeroc.Ice.Identity;

public class TeaMachineI implements TeaMachine {
    private int capacity = 5;
    private int currentAmount = 3;
    private Integer teaId = 0;


    @Override
    public TeaPrx getTea(TeaType teaType, Current current) throws MachineEmptyError {
        if (currentAmount > 0) {
            currentAmount--;
            TeaI tea = new TeaI(teaType);
            teaId++;
            return TeaPrx.checkedCast(
                    current.adapter.add(tea, new Identity("tea" + teaId.toString(), "drinks"))
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
