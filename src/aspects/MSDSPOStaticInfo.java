package aspects;

import java.util.ArrayList;
import java.util.HashMap;

public class MSDSPOStaticInfo {

	private static HashMap<String,HashMap<Integer,String>> interactionsLifelines=null;
	private static HashMap<String,HashMap<Integer,String>> interactionsVariables=null;


	public static HashMap<String,HashMap<Integer,String>>
		getInteractionLifelines()
	{
		if(interactionsLifelines==null){
			buildInteractionsLifelines();
		}
		return interactionsLifelines;
	}

	private static void buildInteractionsLifelines()
	{
		interactionsLifelines=new HashMap<String,HashMap<Integer,String>>();
		HashMap<Integer,String> lifelines = null;

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"User");
		lifelines.put(2,"terminal1");
		interactionsLifelines.put("SysManager_InitSystem", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"terminal");
		lifelines.put(2,"sysManager");
		interactionsLifelines.put("LocationAlerts_Alert100", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"terminal");
		lifelines.put(2,"platformManager");
		lifelines.put(3,"entrance");
		interactionsLifelines.put("CarHandler_HandleArrival", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"cruiser");
		interactionsLifelines.put("Cruiser_StartEngine", lifelines);

		lifelines = new HashMap<Integer,String>();
		interactionsLifelines.put("CarHandler_HandleDeparture", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"User");
		lifelines.put(2,"car");
		lifelines.put(3,"cruiser");
		interactionsLifelines.put("SysManager_MoveCars", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"User");
		lifelines.put(2,"car");
		lifelines.put(3,"cruiser");
		interactionsLifelines.put("SysManager_MoveCarSmall", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car1");
		lifelines.put(1,"terminal");
		lifelines.put(2,"sysManager");
		interactionsLifelines.put("LocationAlerts_Alert80", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"car2");
		lifelines.put(2,"cruiser2");
		interactionsLifelines.put("SysManager_InitCar2", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"car1");
		lifelines.put(2,"cruiser1");
		interactionsLifelines.put("SysManager_InitCar1", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"terminal");
		lifelines.put(1,"entrance");
		interactionsLifelines.put("CarHandler_EntranceMove", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"platformManager");
		lifelines.put(1,"terminal");
		interactionsLifelines.put("PlatformManager_AllocatePlatform", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"cruiser");
		lifelines.put(2,"sysManager");
		interactionsLifelines.put("Car_StopAtTerminal", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"car1");
		lifelines.put(2,"User");
		interactionsLifelines.put("sysEvents_ChooseDestenation3", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"car1");
		lifelines.put(2,"User");
		interactionsLifelines.put("sysEvents_ChooseDestenation2", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"cruiser");
		lifelines.put(2,"terminal");
		lifelines.put(3,"sysManager");
		interactionsLifelines.put("Car_Arrival", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"sysManager");
		lifelines.put(2,"terminal");
		lifelines.put(3,"cruiser");
		interactionsLifelines.put("Car_ArrivalStop", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"terminal");
		lifelines.put(1,"exit");
		interactionsLifelines.put("CarHandler_ExitMove", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"platformManager");
		lifelines.put(1,"User");
		interactionsLifelines.put("PlatformManager_LSC2", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"sysManager");
		lifelines.put(2,"terminal");
		interactionsLifelines.put("Car_Car_choose_direction", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"terminal");
		interactionsLifelines.put("Car_PassTerminal", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal2");
		lifelines.put(2,"platformManager2");
		lifelines.put(3,"entrance2r");
		lifelines.put(4,"entrance2l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal2", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal1");
		lifelines.put(2,"platformManager1");
		lifelines.put(3,"entrance1r");
		lifelines.put(4,"entrance1l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal1", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"platformManager2");
		lifelines.put(1,"User");
		interactionsLifelines.put("PlatformManager_LSC3", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal1");
		lifelines.put(2,"platformManager1");
		lifelines.put(3,"entrance1r");
		lifelines.put(4,"entrance1l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal4", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal1");
		lifelines.put(2,"platformManager1");
		lifelines.put(3,"entrance1r");
		lifelines.put(4,"entrance1l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal3", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal1");
		lifelines.put(2,"platformManager1");
		lifelines.put(3,"entrance1r");
		lifelines.put(4,"entrance1l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal6", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"car2");
		lifelines.put(2,"User");
		interactionsLifelines.put("sysEvents_car2To2", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"sysManager");
		lifelines.put(1,"terminal1");
		lifelines.put(2,"platformManager1");
		lifelines.put(3,"entrance1r");
		lifelines.put(4,"entrance1l");
		lifelines.put(5,"existsManager1");
		lifelines.put(6,"exit1r");
		lifelines.put(7,"exit1l");
		interactionsLifelines.put("SysManager_InitTerminal5", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"terminal");
		lifelines.put(2,"sysManager");
		interactionsLifelines.put("LocationAlerts_AlertStop", lifelines);

		lifelines = new HashMap<Integer,String>();
		lifelines.put(0,"car");
		lifelines.put(1,"terminal");
		lifelines.put(2,"cruiser");
		lifelines.put(3,"existsManager");
		interactionsLifelines.put("Car_Departure", lifelines);
	}


	public static HashMap<String,HashMap<Integer,String>>
		getInteractionVariables()
	{
		if(interactionsVariables==null){
			buildInteractionsVariables();
		}
		return interactionsVariables;
	}

	private static void buildInteractionsVariables()
	{
		interactionsVariables=new HashMap<String,HashMap<Integer,String>>();
		HashMap<Integer,String> variables = null;

		variables = new HashMap<Integer,String>();
		variables.put(0,"platform");
		interactionsVariables.put("MSDAspectCarHandler_EntranceMove", variables);

		variables = new HashMap<Integer,String>();
		variables.put(0,"distance");
		interactionsVariables.put("MSDAspectLocationAlerts_Alert80", variables);

		variables = new HashMap<Integer,String>();
		variables.put(0,"distance");
		interactionsVariables.put("MSDAspectLocationAlerts_AlertStop", variables);

		variables = new HashMap<Integer,String>();
		variables.put(2,"direction");
		interactionsVariables.put("MSDAspectCar_ArrivalStop", variables);

		variables = new HashMap<Integer,String>();
		variables.put(4,"distance");
		interactionsVariables.put("MSDAspectLocationAlerts_Alert100", variables);

		variables = new HashMap<Integer,String>();
		variables.put(2,"ID");
		interactionsVariables.put("MSDAspectSysManager_InitTerminal1", variables);

		variables = new HashMap<Integer,String>();
		variables.put(0,"platform");
		interactionsVariables.put("MSDAspectCarHandler_ExitMove", variables);

		variables = new HashMap<Integer,String>();
		variables.put(1,"number");
		interactionsVariables.put("MSDAspectPlatformManager_AllocatePlatform", variables);

		variables = new HashMap<Integer,String>();
		variables.put(0,"number");
		variables.put(5,"direction");
		interactionsVariables.put("MSDAspectCarHandler_HandleArrival", variables);
	}

}

