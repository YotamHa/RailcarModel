//  The file MSDMethods.java was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

public class AspectsCreator
{
	public static void createAspects()
	{
		MSDAspectSysManager_InitSystem.getInstance();
		MSDAspectSysManager_InitTerminal1.getInstance();
		MSDAspectSysManager_InitCar1.getInstance();
		MSDAspectSysManager_InitCar2.getInstance();
		MSDAspectSysManager_MoveCars.getInstance();
		MSDAspectSysManager_MoveCarSmall.getInstance();
		MSDAspectSysManager_InitTerminal2.getInstance();
		MSDAspectSysManager_InitTerminal3.getInstance();
		MSDAspectSysManager_InitTerminal4.getInstance();
		MSDAspectSysManager_InitTerminal5.getInstance();
		MSDAspectSysManager_InitTerminal6.getInstance();
		MSDAspectCar_Departure.getInstance();
		MSDAspectCar_Arrival.getInstance();
		MSDAspectCar_ArrivalStop.getInstance();
		MSDAspectCar_Car_choose_direction.getInstance();
		MSDAspectCar_StopAtTerminal.getInstance();
		MSDAspectCar_PassTerminal.getInstance();
		MSDAspectCruiser_StartEngine.getInstance();
		MSDAspectLocationAlerts_Alert100.getInstance();
		MSDAspectLocationAlerts_AlertStop.getInstance();
		MSDAspectLocationAlerts_Alert80.getInstance();
		MSDAspectPlatformManager_AllocatePlatform.getInstance();
		MSDAspectPlatformManager_LSC2.getInstance();
		MSDAspectPlatformManager_LSC3.getInstance();
		MSDAspectPlatformManager_MoveExit.getInstance();
		MSDAspectPlatformManager_MoveEntrance.getInstance();
		MSDAspectPlatformManager_FreePlatform.getInstance();
		MSDAspectsysEvents_ChooseDestenation2.getInstance();
		MSDAspectsysEvents_ChooseDestenation3.getInstance();
		MSDAspectsysEvents_car2To2.getInstance();
		MSDAspectcarHandler2_HandleDeparture.getInstance();
		MSDAspectcarHandler2_HandleArrival.getInstance();
		MSDCoordinatorAspect.getInstance();
	}
}

