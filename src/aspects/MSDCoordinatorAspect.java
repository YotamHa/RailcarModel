//  The file MSDCoordinatorAspect.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import java.util.Vector;
import java.util.Stack;
import il.ac.wis.cs.s2a.runtime.Utils;
import il.ac.wis.cs.playgo.playtoolkit.ExplayOutViewUtil;
import il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler;
import il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator;
import il.ac.wis.cs.s2a.runtime.lib.*;


public class MSDCoordinatorAspect extends MSDCoordinator implements MSDSubscribe
{
	private static MSDCoordinatorAspect instance = null;
	MSDMethod chosenMethod = null;

	//CTOR
	private MSDCoordinatorAspect()
	{
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Cruiser", "setEngineEngaged");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "runCycle");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "alert80");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "runCycleSmall");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "passTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "moveCar");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "stopAtTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "setCarID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "PlatformManager", "setPlatform1busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "PlatformManager", "PlatformManager", "setPlatform1busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Exit", "setID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Terminal", "setID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Cruiser", "setID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "PlatformManager", "setID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "ExitsManager", "setID");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "Exit", "moveTo");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "Entrance", "moveTo");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "initCar");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "PlatformManager", "setPlatform2busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "PlatformManager", "PlatformManager", "setPlatform2busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "startDepart");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "setPlatform");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "Car", "arriveAck");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "PlatformManager", "lockPlatforms");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "clearDest");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "Car", "departAck");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Exit", "Exit", "blank");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "PlatformManager", "freePlatform");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "PlatformManager", "freePlatform");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Terminal", "arriveReq");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "setTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "Car", "setTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Entrance", "setTerminalId");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Cruiser", "start");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "initSystem");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "PlatformManager", "setPlatform3busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "PlatformManager", "PlatformManager", "setPlatform3busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "startArrival");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Terminal", "initTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "destinationSet");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "ExitsManager", "exitClear");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "chooseTerminal");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Terminal", "departReq");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "setDestination");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "endArrival");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Exit", "setDirection");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Entrance", "setDirection");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "setDirection");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "alert100");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Cruiser", "Cruiser", "setEngineStarted");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "setMode");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Exit", "Terminal", "moveCompleted");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Entrance", "Terminal", "moveCompleted");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "PlatformManager", "allocatePlatform");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "alertStop");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "chooseTerminal3");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Env", "SysManager", "car2To2");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "SysManager", "initCars");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "PlatformManager", "setPlatform4busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "PlatformManager", "PlatformManager", "setPlatform4busy");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Car", "Car", "endDepart");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Terminal", "setLocation");
		PlaygoCoordinator.getInstance().subscribe(
				this, "SysManager", "Car", "setLocation");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "ExitsManager", "allocateExit1");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "ExitsManager", "allocateExit2");
		PlaygoCoordinator.getInstance().subscribe(
				this, "PlatformManager", "Terminal", "platformAllocated");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "ExitsManager", "allocateExit3");
		PlaygoCoordinator.getInstance().subscribe(
				this, "Terminal", "ExitsManager", "allocateExit4");
	}

	public static MSDCoordinatorAspect getInstance(){
		if(instance==null){
			instance = new MSDCoordinatorAspect();
		}
		return instance;
	}

	public void init()
	{
		super.init(MSDSPOStaticInfo.getInteractionLifelines(),
				MSDSPOStaticInfo.getInteractionVariables());
	}
	protected void afterImpl(MSDMethod envMeth) 
	{
		ArrayList<MSDAspect> aspects = new ArrayList<MSDAspect>();

		MSDMethodSet monitoringEnabled = new MSDMethodSet();
		MSDMethodSet executingEnabled = new MSDMethodSet();
		MSDMethodSet coldViolation = new MSDMethodSet();
		MSDMethodSet hotViolation = new MSDMethodSet();

		 // Coordinate all execution engines:
		playgo.systemmodel.SystemModelMain.getInstance().coordinateAll();

		MSDAspectSysManager_InitSystem.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitSystem.getInstance());

		MSDAspectSysManager_InitTerminal1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal1.getInstance());

		MSDAspectSysManager_InitCar1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitCar1.getInstance());

		MSDAspectSysManager_InitCar2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitCar2.getInstance());

		MSDAspectSysManager_MoveCars.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_MoveCars.getInstance());

		MSDAspectSysManager_MoveCarSmall.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_MoveCarSmall.getInstance());

		MSDAspectSysManager_InitTerminal2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal2.getInstance());

		MSDAspectSysManager_InitTerminal3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal3.getInstance());

		MSDAspectSysManager_InitTerminal4.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal4.getInstance());

		MSDAspectSysManager_InitTerminal5.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal5.getInstance());

		MSDAspectSysManager_InitTerminal6.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectSysManager_InitTerminal6.getInstance());

		MSDAspectCar_Departure.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_Departure.getInstance());

		MSDAspectCar_Arrival.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_Arrival.getInstance());

		MSDAspectCar_ArrivalStop.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_ArrivalStop.getInstance());

		MSDAspectCar_Car_choose_direction.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_Car_choose_direction.getInstance());

		MSDAspectCar_StopAtTerminal.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_StopAtTerminal.getInstance());

		MSDAspectCar_PassTerminal.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCar_PassTerminal.getInstance());

		MSDAspectCruiser_StartEngine.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectCruiser_StartEngine.getInstance());

		MSDAspectLocationAlerts_Alert100.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectLocationAlerts_Alert100.getInstance());

		MSDAspectLocationAlerts_AlertStop.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectLocationAlerts_AlertStop.getInstance());

		MSDAspectLocationAlerts_Alert80.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectLocationAlerts_Alert80.getInstance());

		MSDAspectPlatformManager_AllocatePlatform.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_AllocatePlatform.getInstance());

		MSDAspectPlatformManager_LSC2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_LSC2.getInstance());

		MSDAspectPlatformManager_LSC3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_LSC3.getInstance());

		MSDAspectPlatformManager_LSC1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_LSC1.getInstance());

		MSDAspectPlatformManager_LSC4.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_LSC4.getInstance());

		MSDAspectPlatformManager_LSC5.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectPlatformManager_LSC5.getInstance());

		MSDAspectsysEvents_ChooseDestenation2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectsysEvents_ChooseDestenation2.getInstance());

		MSDAspectsysEvents_ChooseDestenation3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectsysEvents_ChooseDestenation3.getInstance());

		MSDAspectsysEvents_car2To2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectsysEvents_car2To2.getInstance());

		MSDAspectcarHandler2_HandleDeparture.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectcarHandler2_HandleDeparture.getInstance());

		MSDAspectcarHandler2_HandleArrival.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		aspects.add(MSDAspectcarHandler2_HandleArrival.getInstance());

		MSDAspectSysManager_InitSystem.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal1.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitCar1.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitCar2.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_MoveCars.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_MoveCarSmall.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal2.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal3.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal4.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal5.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal6.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Departure.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Arrival.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_ArrivalStop.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Car_choose_direction.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_StopAtTerminal.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_PassTerminal.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCruiser_StartEngine.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_Alert100.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_AlertStop.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_Alert80.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_AllocatePlatform.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC2.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC3.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC1.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC4.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC5.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_ChooseDestenation2.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_ChooseDestenation3.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_car2To2.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectcarHandler2_HandleDeparture.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectcarHandler2_HandleArrival.getInstance().updateForbiddenEvents(monitoringEnabled, executingEnabled, coldViolation, hotViolation);

		MSDMethod MSDm = chooseMethod(strategy, monitoringEnabled, executingEnabled, 
				coldViolation, hotViolation, 
				history, aspects, il.ac.wis.cs.common.lsc.element.LSCMessage.DELETE);

		ExplayOutViewUtil.getInstance().updateSelection(envMeth, MSDm, monitoringEnabled, executingEnabled, coldViolation, hotViolation);

		chosenMethod = MSDm;
		history.add(MSDm);
		dealWithTraceVis(MSDm, envMeth);
		wrapperCallPoint(MSDm);
	}

	protected void dealWithTraceVis(MSDMethod MSDm, MSDMethod envMeth) {
		TraceVisMSDMethodSet monitoringEnabled = new TraceVisMSDMethodSet();
		TraceVisMSDMethodSet executingEnabled = new TraceVisMSDMethodSet();
		TraceVisMSDMethodSet coldViolation = new TraceVisMSDMethodSet();
		TraceVisMSDMethodSet hotViolation = new TraceVisMSDMethodSet();

		MSDAspectSysManager_InitSystem.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitCar1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitCar2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_MoveCars.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_MoveCarSmall.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal4.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal5.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectSysManager_InitTerminal6.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Departure.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Arrival.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_ArrivalStop.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_Car_choose_direction.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_StopAtTerminal.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCar_PassTerminal.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectCruiser_StartEngine.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_Alert100.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_AlertStop.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectLocationAlerts_Alert80.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_AllocatePlatform.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC1.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC4.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectPlatformManager_LSC5.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_ChooseDestenation2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_ChooseDestenation3.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectsysEvents_car2To2.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectcarHandler2_HandleDeparture.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);
		MSDAspectcarHandler2_HandleArrival.getInstance().getCutState(monitoringEnabled, executingEnabled, coldViolation, hotViolation);

	if (envMeth != null && MSDm != null && envMeth.messageID == ENV_MESSAGE_ID) {
		envMeth = null;
	}

		traceVisHandler.notify(monitoringEnabled, executingEnabled, coldViolation, hotViolation, MSDm, envMeth);
	}


	protected void wrapperCall(MSDMethod MSDm)
	{
		if(MSDm==null){
			return;
		}
		if(MSDm.targetInstance!=MSDm.sourceInstance){
			SyncMessageHandler.srcObj = MSDm.sourceInstance;
		}else{
			SyncMessageHandler.srcObj = null;
		}
		switch (MSDm.messageID)
		{
			case MSDMethods.Terminal_PlatformManager_setPlatform3busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform3busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.PlatformManager_PlatformManager_setPlatform3busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform3busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Cruiser_setEngineEngaged:
			 ((Cruiser)MSDm.targetInstance).setEngineEngaged(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_alert80:
			 ((Car)MSDm.targetInstance).alert80();
			break;
			case MSDMethods.SysManager_Terminal_initTerminal:
			 ((Terminal)MSDm.targetInstance).initTerminal(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_destinationSet:
			 ((Car)MSDm.targetInstance).destinationSet();
			break;
			case MSDMethods.Car_ExitsManager_exitClear:
			 ((ExitsManager)MSDm.targetInstance).exitClear();
			break;
			case MSDMethods.Car_Car_passTerminal:
			 ((Car)MSDm.targetInstance).passTerminal();
			break;
			case MSDMethods.Car_Terminal_departReq:
			 ((Terminal)MSDm.targetInstance).departReq();
			break;
			case MSDMethods.SysManager_Car_setDestination:
			 ((Car)MSDm.targetInstance).setDestination(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Car_endArrival:
			 ((Car)MSDm.targetInstance).endArrival();
			break;
			case MSDMethods.SysManager_Entrance_setDirection:
			 ((Entrance)MSDm.targetInstance).setDirection(
				(String)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Exit_setDirection:
			 ((Exit)MSDm.targetInstance).setDirection(
				(String)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Car_setDirection:
			 ((Car)MSDm.targetInstance).setDirection(
				(String)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Car_moveCar:
			 ((Car)MSDm.targetInstance).moveCar(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_alert100:
			 ((Car)MSDm.targetInstance).alert100();
			break;
			case MSDMethods.Car_Car_stopAtTerminal:
			 ((Car)MSDm.targetInstance).stopAtTerminal();
			break;
			case MSDMethods.Cruiser_Cruiser_setEngineStarted:
			 ((Cruiser)MSDm.targetInstance).setEngineStarted(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_setCarID:
			 ((Car)MSDm.targetInstance).setCarID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_PlatformManager_setPlatform1busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform1busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.PlatformManager_PlatformManager_setPlatform1busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform1busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Car_setMode:
			 ((Car)MSDm.targetInstance).setMode(
				(String)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Cruiser_setID:
			 ((Cruiser)MSDm.targetInstance).setID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Terminal_setID:
			 ((Terminal)MSDm.targetInstance).setID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_PlatformManager_setID:
			 ((PlatformManager)MSDm.targetInstance).setID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Exit_setID:
			 ((Exit)MSDm.targetInstance).setID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_ExitsManager_setID:
			 ((ExitsManager)MSDm.targetInstance).setID(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Exit_Terminal_moveCompleted:
			 ((Terminal)MSDm.targetInstance).moveCompleted();
			break;
			case MSDMethods.Entrance_Terminal_moveCompleted:
			 ((Terminal)MSDm.targetInstance).moveCompleted();
			break;
			case MSDMethods.Terminal_Exit_moveTo:
			 ((Exit)MSDm.targetInstance).moveTo(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_Entrance_moveTo:
			 ((Entrance)MSDm.targetInstance).moveTo(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_initCar:
			 ((Car)MSDm.targetInstance).initCar();
			break;
			case MSDMethods.Terminal_PlatformManager_setPlatform2busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform2busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.PlatformManager_PlatformManager_setPlatform2busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform2busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_PlatformManager_allocatePlatform:
			 ((PlatformManager)MSDm.targetInstance).allocatePlatform();
			break;
			case MSDMethods.SysManager_Car_setPlatform:
			 ((Car)MSDm.targetInstance).setPlatform(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_Car_arriveAck:
			 ((Car)MSDm.targetInstance).arriveAck();
			break;
			case MSDMethods.SysManager_Car_alertStop:
			 ((Car)MSDm.targetInstance).alertStop();
			break;
			case MSDMethods.SysManager_SysManager_initCars:
			 ((SysManager)MSDm.targetInstance).initCars();
			break;
			case MSDMethods.Car_Car_clearDest:
			 ((Car)MSDm.targetInstance).clearDest();
			break;
			case MSDMethods.Terminal_PlatformManager_setPlatform4busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform4busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.PlatformManager_PlatformManager_setPlatform4busy:
			 ((PlatformManager)MSDm.targetInstance).setPlatform4busy(
				(Boolean)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_Car_departAck:
			 ((Car)MSDm.targetInstance).departAck();
			break;
			case MSDMethods.Exit_Exit_blank:
			 ((Exit)MSDm.targetInstance).blank();
			break;
			case MSDMethods.Car_PlatformManager_freePlatform:
			 ((PlatformManager)MSDm.targetInstance).freePlatform();
			break;
			case MSDMethods.Car_Car_endDepart:
			 ((Car)MSDm.targetInstance).endDepart();
			break;
			case MSDMethods.Car_Terminal_arriveReq:
			 ((Terminal)MSDm.targetInstance).arriveReq(
				(String)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_setTerminal:
			 ((Car)MSDm.targetInstance).setTerminal(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_Car_setTerminal:
			 ((Car)MSDm.targetInstance).setTerminal(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Terminal_setLocation:
			 ((Terminal)MSDm.targetInstance).setLocation(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Car_setLocation:
			 ((Car)MSDm.targetInstance).setLocation(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.SysManager_Entrance_setTerminalId:
			 ((Entrance)MSDm.targetInstance).setTerminalId(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Car_Cruiser_start:
			 ((Cruiser)MSDm.targetInstance).start();
			break;
			case MSDMethods.Terminal_ExitsManager_allocateExit1:
			 ((ExitsManager)MSDm.targetInstance).allocateExit1();
			break;
			case MSDMethods.Terminal_ExitsManager_allocateExit2:
			 ((ExitsManager)MSDm.targetInstance).allocateExit2();
			break;
			case MSDMethods.PlatformManager_Terminal_platformAllocated:
			 ((Terminal)MSDm.targetInstance).platformAllocated(
				(Integer)MSDm.args.get(0));
			break;
			case MSDMethods.Terminal_ExitsManager_allocateExit3:
			 ((ExitsManager)MSDm.targetInstance).allocateExit3();
			break;
			case MSDMethods.Terminal_ExitsManager_allocateExit4:
			 ((ExitsManager)MSDm.targetInstance).allocateExit4();
			break;
		}
	}

}

