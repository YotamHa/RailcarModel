//  The file MSDAspectCar_PassTerminal.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCar_PassTerminal extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Terminal_INST_terminal = 1;
	static final int SysManager_INST_sysManager = 2;
	static final int ExitsManager_INST_exitsManager = 3;
	static final int PlatformManager_INST_platformManager = 4;

	static final int String_arg_String_exact_String_arg00 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "Car_PassTerminal";

	private static MSDAspectCar_PassTerminal instance = null;

	public static MSDAspectCar_PassTerminal getInstance(){
		if(instance==null){
			instance = new MSDAspectCar_PassTerminal();
		}
		return instance;
	}

	private MSDAspectCar_PassTerminal()
	{
		addAspectEvent(MSDMethods.Car_Car_passTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "passTerminal");
		addAspectEvent(MSDMethods.Car_Car_setMode);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "setMode");
		addAspectEvent(MSDMethods.SysManager_Car_alertStop);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "alertStop");
		addAspectEvent(MSDMethods.Car_Terminal_departReq);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Terminal", "departReq");
		addAspectEvent(MSDMethods.Terminal_Car_departAck);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "departAck");
		addAspectEvent(MSDMethods.Car_ExitsManager_exitClear);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "ExitsManager", "exitClear");
		addAspectEvent(MSDMethods.Car_PlatformManager_freePlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "PlatformManager", "freePlatform");
		addAspectEvent(MSDMethods.Car_Car_endArrival);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "endArrival");

		addMinimalEvent(MSDMethods.Car_Car_passTerminal);
		setHotCut(7,3,2,1,0);
		setHotCut(1,0,0,0,0);
		setHotCut(3,0,1,0,0);
		setHotCut(8,3,2,1,1);
		setHotCut(6,3,2,0,0);
		setLastCut(9,3,2,1,1);
		numberOfLifeLines = 5;
		numberOfInstances = 5;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499940130091";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
		}
	}

	//MSD Logic:
	@Override
	protected boolean changeActiveMSDCutState(int MSDm, Object sourceObject, 
			Object targetObject,ActiveMSDAspect activeMSD, ArrayList args, 
			boolean newlyAddedDynamicAll)	{

		boolean unification=false;
		if(SyncMessageHandler.srcObj!=null){
			sourceObject = SyncMessageHandler.srcObj;
			SyncMessageHandler.srcObj=null;
		}
		boolean cutChanged=false;
		switch (MSDm)
		{
			case MSDMethods.Car_Car_passTerminal:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0,0))
					{
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						cutChanged=true; activeMSD.setCut(1,0,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_ExitsManager_exitClear:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_exitsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(6,3,2,0,0))
					{
						cutChanged=true; activeMSD.setCut(7,3,2,1,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_PlatformManager_freePlatform:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(7,3,2,1,0))
					{
						cutChanged=true; activeMSD.setCut(8,3,2,1,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_setMode:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_alertStop:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(2,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(3,0,1,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Terminal_departReq:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(3,0,1,0,0))
					{
						cutChanged=true; activeMSD.setCut(4,1,1,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_Car_departAck:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(4,1,1,0,0))
					{
						cutChanged=true; activeMSD.setCut(5,2,1,0,0);
						if(evaluateCondition(5,activeMSD))
						{
							activeMSD.notWaitingForCond(5); //out of wait condition
							cutChanged=true; activeMSD.setCut(6,3,2,0,0);
							return cutChanged;
						}
						activeMSD.setWaitingForCond(5); //in wait condition
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_endArrival:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(8,3,2,1,1))
					{
						cutChanged=true; activeMSD.setCut(9,3,2,1,1);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			}
		if(newlyAddedDynamicAll){
			return cutChanged;
		}
		if(activeMSD.checkViolation())
			activeMSD.completion();
		return cutChanged;
	}

	@SuppressWarnings("unused")
	private boolean evaluateCondition(int conditionNumber,ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		ExitsManager exitsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}


		int location = 0;
		
		if(car!=null){
			location=car.getLocation();
		}

		
		if(terminal!=null){
			location=terminal.getLocation();
		}
		switch (conditionNumber)
		{
			case 5: 
				return car.getLocation()!=terminal.getLocation();
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		ExitsManager exitsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}


		int location = 0;
		
		if(car!=null){
			location=car.getLocation();
		}

		
		if(terminal!=null){
			location=terminal.getLocation();
		}
	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("6,3,2,0,0" , "wait: car.getLocation()!=terminal.getLocation()");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		ExitsManager exitsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager, null, false );
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager, null, false );

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg00, (String)"pass");
		}catch(Exception e){}
	}

	//Pointcuts and advices:
	@Override
	public void afterSetCut()
	{
		ArrayList<ActiveMSDAspect> tempActiveArr = new ArrayList<ActiveMSDAspect>();
		tempActiveArr.addAll(getActiveMSDArray());

		for(ActiveMSDAspect liveCopy:tempActiveArr){
			evaluateWaitConditions(liveCopy);		//re-evaluate wait conditions
			evaluateForbiddenConditions(liveCopy);	//evaluate forbidden and exitUpon conditions
		}
	}

	//re-evaluate dynamic-universal binding expressions
	public void afterchangeActiveMSDCut(int MSDm, Object sourceObject, Object targetObject, 
		ActiveMSDAspect activeMSD, ArrayList arguments, boolean cutChanged, boolean newlyAddedDynamicAll)
	{
		ArrayList<ActiveMSDAspect> tempActiveArr = new ArrayList<ActiveMSDAspect>();
		tempActiveArr.addAll(getActiveMSDArray());

		for(ActiveMSDAspect liveCopy:tempActiveArr)
		{
			activeCheckForViolation(MSDm,
					sourceObject, targetObject, arguments, liveCopy,
					(boolean)cutChanged, liveCopy == activeMSD);

			if(unboundObjectExists(liveCopy))
			{
				doBindings(liveCopy);				//try to bind objects
				if( ! unboundObjectExists(liveCopy)){
					setUpToDate(false);
				}
			}
		}
		setUpToDate(false);
	}

	private boolean unboundObjectExists(ActiveMSDAspect activeMSD)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	
		if(car==null || terminal==null || exitsManager==null || platformManager==null){
			return true;
		}else{
			return false;
		}
	}
	@Override
	public void afterTick()
	{
		//boolean coordinated = false;

		ArrayList<ActiveMSDAspect> tempActiveArr = new ArrayList<ActiveMSDAspect>();
		tempActiveArr.addAll(getActiveMSDArray());

		for(ActiveMSDAspect liveCopy:tempActiveArr){
			evaluateWaitConditions(liveCopy);		//re-evaluate wait conditions
			evaluateForbiddenConditions(liveCopy);	//evaluate forbidden and exitUpon conditions
			//coordinated = true;
		}

		//if (!coordinated) {
			//MSDCoordinatorAspect.getInstance().coordinate(null);
		//}
	}

	//activeCheckForViolation
	@Override
	protected void activeCheckForViolation(int MSDm, Object sourceObject,
			Object targetObject, ArrayList args, ActiveMSDAspect activeMSD, 
			boolean cutChanged, boolean inActiveCopy)
	{
	}

	private void after_Car_Car_passTerminal(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_passTerminal,
					_car,_car,null);
	}

	private void after_Car_Car_setMode(Object _carSource ,Object _car, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Car_setMode,
					_car,_car,args);
	}

	private void after_SysManager_Car_alertStop(Object _sysManager ,Object _car)
	{
		changeCutState(MSDMethods.SysManager_Car_alertStop,
					_sysManager,_car,null);
	}

	private void after_Car_Terminal_departReq(Object _car ,Object _terminal)
	{
		changeCutState(MSDMethods.Car_Terminal_departReq,
					_car,_terminal,null);
	}

	private void after_Terminal_Car_departAck(Object _terminal ,Object _car)
	{
		changeCutState(MSDMethods.Terminal_Car_departAck,
					_terminal,_car,null);
	}

	private void after_Car_ExitsManager_exitClear(Object _car ,Object _exitsManager)
	{
		changeCutState(MSDMethods.Car_ExitsManager_exitClear,
					_car,_exitsManager,null);
	}

	private void after_Car_PlatformManager_freePlatform(Object _car ,Object _platformManager)
	{
		changeCutState(MSDMethods.Car_PlatformManager_freePlatform,
					_car,_platformManager,null);
	}

	private void after_Car_Car_endArrival(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_endArrival,
					_car,_car,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("passTerminal")){
			after_Car_Car_passTerminal(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("setMode")){
			after_Car_Car_setMode(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("alertStop")){
			after_SysManager_Car_alertStop(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Terminal") && method.equals("departReq")){
			after_Car_Terminal_departReq(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("departAck")){
			after_Terminal_Car_departAck(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("ExitsManager") && method.equals("exitClear")){
			after_Car_ExitsManager_exitClear(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("PlatformManager") && method.equals("freePlatform")){
			after_Car_PlatformManager_freePlatform(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("endArrival")){
			after_Car_Car_endArrival(source, target);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
	}

	@Override
	protected void saveActiveMSDCurTimeToTimeTags(int MSDm,ActiveMSDAspect activeMSD){

		switch (MSDm)
		{
		}
	}


	private void evalTrueWaitCond5(ActiveMSDAspect activeMSD){
							activeMSD.notWaitingForCond(5); //out of wait condition
							activeMSD.setCut(6,3,2,0,0);
	}

	protected void  evaluateWaitConditions(ActiveMSDAspect activeMSD)
	{
		for(Integer cond:activeMSD.getWaitingConditions()){
			switch(cond)
			{
				case 5:
					if(evaluateCondition(5,activeMSD))
					{
						evalTrueWaitCond5(activeMSD);

						setUpToDate(false);
						MSDCoordinatorAspect.getInstance().coordinate(null);
						closeActiveCopies();
					}
					break;
			}
		}
	}

	protected void getActiveMSDCutState(MSDMethodSet ME,MSDMethodSet EE,
			MSDMethodSet CV,MSDMethodSet HV,ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		ExitsManager exitsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

		String VAR_String_exact_String_arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			VAR_String_exact_String_arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		MSDMethod MSDm134 = new MSDMethod(car,car,
			MSDMethods.Car_Car_passTerminal,null,"Car:Car:passTerminal",niceName,activeMSD.getGlobalId());// passTerminal() Monitored
		MSDMethod MSDm135 = new MSDMethod(car,exitsManager,
			MSDMethods.Car_ExitsManager_exitClear,null,"Car:ExitsManager:exitClear",niceName,activeMSD.getGlobalId());// exitClear() Execute
		MSDMethod MSDm136 = new MSDMethod(car,platformManager,
			MSDMethods.Car_PlatformManager_freePlatform,null,"Car:PlatformManager:freePlatform",niceName,activeMSD.getGlobalId());// freePlatform() Execute
		ArrayList<Object>  args137 = getArgsList(VAR_String_exact_String_arg00);
		MSDMethod MSDm137 = new MSDMethod(car,car,
			MSDMethods.Car_Car_setMode,args137,"Car:Car:setMode",niceName,activeMSD.getGlobalId());// setMode() Execute
		MSDMethod MSDm138 = new MSDMethod(sysManager,car,
			MSDMethods.SysManager_Car_alertStop,null,"SysManager:Car:alertStop",niceName,activeMSD.getGlobalId());// alertStop() Monitored
		MSDMethod MSDm139 = new MSDMethod(car,terminal,
			MSDMethods.Car_Terminal_departReq,null,"Car:Terminal:departReq",niceName,activeMSD.getGlobalId());// departReq() Execute
		MSDMethod MSDm140 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_departAck,null,"Terminal:Car:departAck",niceName,activeMSD.getGlobalId());// departAck() Monitored
		MSDMethod MSDm141 = new MSDMethod(car,car,
			MSDMethods.Car_Car_endArrival,null,"Car:Car:endArrival",niceName,activeMSD.getGlobalId());// endArrival() Execute

		 if(activeMSD.isInCut(0,0,0,0,0))
		{
				ME.add(MSDm134);
				CV.add(MSDm136,MSDm138,MSDm135,MSDm141,MSDm140,MSDm139,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(1,0,0,0,0))
		{
				if(MSDm137.sourceInstance!=null && MSDm137.targetInstance!=null){
					EE.add(MSDm137);
				}
				HV.add(MSDm136,MSDm138,MSDm135,MSDm134,MSDm141,MSDm140,MSDm139);
				return;
		}
		 if(activeMSD.isInCut(2,0,0,0,0))
		{
				ME.add(MSDm138);
				CV.add(MSDm136,MSDm135,MSDm134,MSDm141,MSDm140,MSDm139,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(3,0,1,0,0))
		{
				if(MSDm139.sourceInstance!=null && MSDm139.targetInstance!=null){
					EE.add(MSDm139);
				}
				HV.add(MSDm136,MSDm138,MSDm135,MSDm134,MSDm141,MSDm140,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(4,1,1,0,0))
		{
				ME.add(MSDm140);
				CV.add(MSDm136,MSDm138,MSDm135,MSDm134,MSDm141,MSDm139,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(6,3,2,0,0))
		{
				if(MSDm135.sourceInstance!=null && MSDm135.targetInstance!=null){
					EE.add(MSDm135);
				}
				HV.add(MSDm136,MSDm138,MSDm134,MSDm141,MSDm140,MSDm139,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(7,3,2,1,0))
		{
				if(MSDm136.sourceInstance!=null && MSDm136.targetInstance!=null){
					EE.add(MSDm136);
				}
				HV.add(MSDm138,MSDm135,MSDm134,MSDm141,MSDm140,MSDm139,MSDm137);
				return;
		}
		 if(activeMSD.isInCut(8,3,2,1,1))
		{
				if(MSDm141.sourceInstance!=null && MSDm141.targetInstance!=null){
					EE.add(MSDm141);
				}
				HV.add(MSDm136,MSDm138,MSDm135,MSDm134,MSDm140,MSDm139,MSDm137);
				return;
		}
	}
	protected void updateActiveForbiddenEvents(MSDMethodSet MEall,MSDMethodSet EEall,
			MSDMethodSet CVall,MSDMethodSet HVall,ActiveMSDAspect activeMSD)
	{

	}
	
	private ArrayList<Object> getcar_CarInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}
	
		ArrayList<Object> instances = AppObjects.getObjects("Car");
		ArrayList<Object> result = new ArrayList<Object>();
		if(instances==null || instances.size()<1){
			result = null;
		}
		else if(monitoredObj==null){
			result = null;
		}
		else{
			ArrayList<Object> unboundInstances = getUnboundInstances(activeMSD, instances);
			for(Object inst:unboundInstances){
				if(true){
					if(monitoredObj.equals("NONE") || monitoredObj.equals(inst)){
						result.add(inst);
						if( ! isUniversal){		//existential
							return result;		//return result with one object
						}
					}
				}
			}
		}
		if( (monitoredObj==null || monitoredObj.equals("NONE")) && (result==null || result.size()<1) ){
			activeMSD.closeAndRemove();		//enabled with no binding results
			activeMSD.setDeadCopy(true);
			return null;
		}
		return result;
	}
	
	private ArrayList<Object> getterminal_TerminalInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}
		if(car==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("Terminal");
		ArrayList<Object> result = new ArrayList<Object>();
		if(instances==null || instances.size()<1){
			result = null;
		}
		else if(monitoredObj==null){
			result = null;
		}
		else{
			ArrayList<Object> unboundInstances = getUnboundInstances(activeMSD, instances);
			for(Object inst:unboundInstances){
				if(((Terminal)inst).getID()==car.getTerminal()){
					if(monitoredObj.equals("NONE") || monitoredObj.equals(inst)){
						result.add(inst);
						if( ! isUniversal){		//existential
							return result;		//return result with one object
						}
					}
				}
			}
		}
		if( (monitoredObj==null || monitoredObj.equals("NONE")) && (result==null || result.size()<1) ){
			activeMSD.closeAndRemove();		//enabled with no binding results
			activeMSD.setDeadCopy(true);
			return null;
		}
		return result;
	}
	
	private ArrayList<Object> getexitsManager_ExitsManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}
		if(terminal==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("ExitsManager");
		ArrayList<Object> result = new ArrayList<Object>();
		if(instances==null || instances.size()<1){
			result = null;
		}
		else if(monitoredObj==null){
			result = null;
		}
		else{
			ArrayList<Object> unboundInstances = getUnboundInstances(activeMSD, instances);
			for(Object inst:unboundInstances){
				if(((ExitsManager)inst).getID()==terminal.getID()){
					if(monitoredObj.equals("NONE") || monitoredObj.equals(inst)){
						result.add(inst);
						if( ! isUniversal){		//existential
							return result;		//return result with one object
						}
					}
				}
			}
		}
		if( (monitoredObj==null || monitoredObj.equals("NONE")) && (result==null || result.size()<1) ){
			activeMSD.closeAndRemove();		//enabled with no binding results
			activeMSD.setDeadCopy(true);
			return null;
		}
		return result;
	}
	
	private ArrayList<Object> getplatformManager_PlatformManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}
		if(terminal==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("PlatformManager");
		ArrayList<Object> result = new ArrayList<Object>();
		if(instances==null || instances.size()<1){
			result = null;
		}
		else if(monitoredObj==null){
			result = null;
		}
		else{
			ArrayList<Object> unboundInstances = getUnboundInstances(activeMSD, instances);
			for(Object inst:unboundInstances){
				if(((PlatformManager)inst).getID()==terminal.getID()){
					if(monitoredObj.equals("NONE") || monitoredObj.equals(inst)){
						result.add(inst);
						if( ! isUniversal){		//existential
							return result;		//return result with one object
						}
					}
				}
			}
		}
		if( (monitoredObj==null || monitoredObj.equals("NONE")) && (result==null || result.size()<1) ){
			activeMSD.closeAndRemove();		//enabled with no binding results
			activeMSD.setDeadCopy(true);
			return null;
		}
		return result;
	}
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			ExitsManager exitsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager);
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
			switch (lifelineIndex){
				case Car_INST_car:
					try{
					if( ! activeMSD.instanceExists(obj)){
						result = obj;
					}
					}catch(NullPointerException npe){
						result = null;
					}
					if(result!=null && !retrieveOnly){
						activeMSD.setLineInstance(lifelineIndex, result);
					}
					break;
				case Terminal_INST_terminal:
					try{
						result = getterminal_TerminalInstances(activeMSD, false, "NONE");
						 
						if(result!=null && result instanceof ArrayList<?>){
							ArrayList<?> results = (ArrayList<?>)result;
							int size = results.size();
							if(size==0){
								result = null;
							}else if(size==1){
								result = results.get(0);
							}else{	//more than one object
								result = results.remove(0);
								handleDynamicLifeline(lifelineIndex, activeMSD, results);
							}
						}
					}catch(NullPointerException npe){
						result = null;
					}
					if(result!=null && !retrieveOnly){
						activeMSD.setLineInstance(lifelineIndex, result);
					}
					break;
				case ExitsManager_INST_exitsManager:
					try{
						result = getexitsManager_ExitsManagerInstances(activeMSD, false, "NONE");
						 
						if(result!=null && result instanceof ArrayList<?>){
							ArrayList<?> results = (ArrayList<?>)result;
							int size = results.size();
							if(size==0){
								result = null;
							}else if(size==1){
								result = results.get(0);
							}else{	//more than one object
								result = results.remove(0);
								handleDynamicLifeline(lifelineIndex, activeMSD, results);
							}
						}
					}catch(NullPointerException npe){
						result = null;
					}
					if(result!=null && !retrieveOnly){
						activeMSD.setLineInstance(lifelineIndex, result);
					}
					break;
				case PlatformManager_INST_platformManager:
					try{
						result = getplatformManager_PlatformManagerInstances(activeMSD, false, "NONE");
						 
						if(result!=null && result instanceof ArrayList<?>){
							ArrayList<?> results = (ArrayList<?>)result;
							int size = results.size();
							if(size==0){
								result = null;
							}else if(size==1){
								result = results.get(0);
							}else{	//more than one object
								result = results.remove(0);
								handleDynamicLifeline(lifelineIndex, activeMSD, results);
							}
						}
					}catch(NullPointerException npe){
						result = null;
					}
					if(result!=null && !retrieveOnly){
						activeMSD.setLineInstance(lifelineIndex, result);
					}
					break;
			}
		}
		return result;
	}
	
	
	public boolean validateBoundedObject(ActiveMSDAspect activeMSD, int lifelineIndex, Object object){
		boolean result = false;
		try{
			Object bounded = bindObjectByExpression(activeMSD, lifelineIndex, object, true);
			if (bounded != null){
				result = bounded.equals(object);
			}else if (object == null){
				result = true;
			}
		}catch(NullPointerException npe){
			result = false; // parent object not bounded yet
		}
		return result;
	}
	
	private ArrayList<Object> getUnboundInstances(ActiveMSDAspect activeMSD,
			ArrayList<Object> instances)
	{
		ArrayList<Object> boundInstances = activeMSD.getLineInstances();
		if(boundInstances==null || boundInstances.size() <1){
			return instances;
		}
		String className = instances.get(0).getClass().getName();
		ArrayList<String> boundInstancesNames = new ArrayList<String>();
		for(Object boundObj:boundInstances){
			if(boundObj instanceof il.ac.wis.cs.systemmodel.SMBaseClass){
				il.ac.wis.cs.systemmodel.SMBaseClass sbObj = (il.ac.wis.cs.systemmodel.SMBaseClass)boundObj;
				if(boundObj.getClass().getName().equals(className)){
					boundInstancesNames.add(sbObj.getName());
				}
			}
		}
		if(boundInstancesNames.size()<1){
			return instances;
		}
		ArrayList<Object> unboundInstances = new ArrayList<Object>();
		for(Object instance:instances){
			if(instance instanceof il.ac.wis.cs.systemmodel.SMBaseClass){
				il.ac.wis.cs.systemmodel.SMBaseClass inst = 
					(il.ac.wis.cs.systemmodel.SMBaseClass)instance;
				unboundInstances.add(inst);
				for(String boundInstanceName:boundInstancesNames){
					if(inst.getName().equals(boundInstanceName)){
						unboundInstances.remove(inst);
					}
				}
			}
		}
		return unboundInstances;
	}
 
	public String getNiceName()
	{
			return niceName;
	}

}
