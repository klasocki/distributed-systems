package sr.ice.server;

import House.CentralHeating;
import House.CoffeeMachine;
import House.TeaMachine;
import com.zeroc.Ice.Communicator;
import com.zeroc.Ice.ServantLocator;
import com.zeroc.Ice.Util;
import com.zeroc.Ice.ObjectAdapter;

public class Server
{
	public void t1(String[] args)
	{
		int status = 0;
		Communicator communicator = null;

		try
		{
			communicator = Util.initialize(args);

			ObjectAdapter adapter = communicator.createObjectAdapter("Adapter1");

			CentralHeating heatingServant = new CentralHeatingI();
			TeaMachine teaServant = new TeaMachineI();
            CoffeeMachine coffeeServant = new CoffeeMachineI();

            ServerServantLocator locator = new ServerServantLocator();
            locator.addServant(heatingServant, "heating");
            locator.addServant(teaServant, "tea");
            locator.addServant(coffeeServant, "coffee");

            adapter.addServantLocator(locator, "");

			adapter.activate();

			System.out.println("Entering event processing loop...");

			communicator.waitForShutdown();

		}
		catch (Exception e)
		{
			System.err.println(e);
			status = 1;
		}
		if (communicator != null)
		{
			try
			{
				communicator.destroy();
			}
			catch (Exception e)
			{
				System.err.println(e);
				status = 1;
			}
		}
		System.exit(status);
	}


	public static void main(String[] args)
	{
		Server app = new Server();
		app.t1(args);
	}
}
