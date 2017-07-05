//  The file MSDAspectCar_Departure.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCar_Departure extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Terminal_INST_terminal = 1;
	static final int Cruiser_INST_cruiser = 2;
	static final int ExitsManager_INST_existsManager = 3;

	static final int boolean_arg_boolean_exact_boolean_arg00 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "Car_Departure";

	private static MSDAspectCar_Departure instance = null;

	public static MSDAspectCar_Departure getInstance(){
		if(instance==null){
			instance = new MSDAspectCar_Departure();
		}
		return instance;
	}

	private MSDAspectCar_Departure()
	{
		addAspectEvent(MSDMethods.Car_Car_startDepart);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "startDepart");
		addAspectEvent(MSDMethods.Car_Cruiser_start);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Cruiser", "start");
		addAspectEvent(MSDMethods.Car_Terminal_departReq);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Terminal", "departReq");
		addAspectEvent(MSDMethods.Terminal_Car_departAck);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "departAck");
		addAspectEvent(MSDMethods.Car_Cruiser_setEngineEngaged);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Cruiser", "setEngineEngaged");
		addAspectEvent(MSDMethods.Car_Car_clearDest);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "clearDest");
		addAspectEvent(MSDMethods.Car_ExitsManager_exitClear);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "ExitsManager", "exitClear");
		addAspectEvent(MSDMethods.Car_Car_endDepart);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "endDepart");

		addMinimalEvent(MSDMethods.Car_Car_startDepart);
		setHotCut(9,4,4,1);
		setHotCut(8,4,4,0);
		setHotCut(5,3,2,0);
		setHotCut(6,3,3,0);
		setHotCut(2,0,1,0);
		setHotCut(1,0,0,0);
		setLastCut(10,4,4,1);
		numberOfLifeLines = 4;
		numberOfInstances = 4;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499083609496";
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
			case MSDMethods.Car_Cruiser_setEngineEngaged:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Cruiser_INST_cruiser,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(5,3,2,0))
					{
						cutChanged=true; activeMSD.setCut(6,3,3,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_startDepart:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0))
					{
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						cutChanged=true; activeMSD.setCut(1,0,0,0);
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
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(8,4,4,0))
					{
						cutChanged=true; activeMSD.setCut(9,4,4,1);
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
					if(activeMSD.isInCut(2,0,1,0))
					{
						cutChanged=true; activeMSD.setCut(3,1,1,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_endDepart:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(9,4,4,1))
					{
						cutChanged=true; activeMSD.setCut(10,4,4,1);
						break;
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
					if(activeMSD.isInCut(3,1,1,0))
					{
						cutChanged=true; activeMSD.setCut(4,2,1,0);
						if(evaluateCondition(4,activeMSD))
						{
							activeMSD.notWaitingForCond(4); //out of wait condition
							cutChanged=true; activeMSD.setCut(5,3,2,0);
							return cutChanged;
						}
						activeMSD.setWaitingForCond(4); //in wait condition
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_clearDest:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(6,3,3,0))
					{
						cutChanged=true; activeMSD.setCut(7,3,3,0);
						if(evaluateCondition(7,activeMSD))
						{
							activeMSD.notWaitingForCond(7); //out of wait condition
							cutChanged=true; activeMSD.setCut(8,4,4,0);
							return cutChanged;
						}
						activeMSD.setWaitingForCond(7); //in wait condition
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Cruiser_start:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Cruiser_INST_cruiser,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,0,1,0);
						return cutChanged;
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
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}


		int location = 0;
		
		if(car!=null){
			location=car.getLocation();
		}

		
		if(terminal!=null){
			location=terminal.getLocation();
		}

		boolean engineStarted = false;
		
		if(cruiser!=null){
			engineStarted=cruiser.isEngineStarted();
		}
		switch (conditionNumber)
		{
			case 4: 
				return cruiser.getEngineStarted()==true;
			case 7: 
				return car.getLocation()!=terminal.getLocation();
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}


		int location = 0;
		
		if(car!=null){
			location=car.getLocation();
		}

		
		if(terminal!=null){
			location=terminal.getLocation();
		}

		boolean engineStarted = false;
		
		if(cruiser!=null){
			engineStarted=cruiser.isEngineStarted();
		}
	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("5,3,2,0" , "wait: cruiser.getEngineStarted()==true");
		this.setExpressionForCut("8,4,4,0" , "wait: car.getLocation()!=terminal.getLocation()");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser, null, false );
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager, null, false );

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg00, (boolean)true);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
	
		if(car==null || terminal==null || cruiser==null || existsManager==null){
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

	private void after_Car_Car_startDepart(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_startDepart,
					_car,_car,null);
	}

	private void after_Car_Cruiser_start(Object _car ,Object _cruiser)
	{
		changeCutState(MSDMethods.Car_Cruiser_start,
					_car,_cruiser,null);
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

	private void after_Car_Cruiser_setEngineEngaged(Object _car ,Object _cruiser, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Cruiser_setEngineEngaged,
					_car,_cruiser,args);
	}

	private void after_Car_Car_clearDest(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_clearDest,
					_car,_car,null);
	}

	private void after_Car_ExitsManager_exitClear(Object _car ,Object _existsManager)
	{
		changeCutState(MSDMethods.Car_ExitsManager_exitClear,
					_car,_existsManager,null);
	}

	private void after_Car_Car_endDepart(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_endDepart,
					_car,_car,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("startDepart")){
			after_Car_Car_startDepart(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Cruiser") && method.equals("start")){
			after_Car_Cruiser_start(source, target);
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
		if(srcClassName.equals("Car") && tgtClassName.equals("Cruiser") && method.equals("setEngineEngaged")){
			after_Car_Cruiser_setEngineEngaged(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("clearDest")){
			after_Car_Car_clearDest(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("ExitsManager") && method.equals("exitClear")){
			after_Car_ExitsManager_exitClear(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("endDepart")){
			after_Car_Car_endDepart(source, target);
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


	private void evalTrueWaitCond4(ActiveMSDAspect activeMSD){
							activeMSD.notWaitingForCond(4); //out of wait condition
							activeMSD.setCut(5,3,2,0);
	}


	private void evalTrueWaitCond7(ActiveMSDAspect activeMSD){
							activeMSD.notWaitingForCond(7); //out of wait condition
							activeMSD.setCut(8,4,4,0);
	}

	protected void  evaluateWaitConditions(ActiveMSDAspect activeMSD)
	{
		for(Integer cond:activeMSD.getWaitingConditions()){
			switch(cond)
			{
				case 4:
					if(evaluateCondition(4,activeMSD))
					{
						evalTrueWaitCond4(activeMSD);

						setUpToDate(false);
						MSDCoordinatorAspect.getInstance().coordinate(null);
						closeActiveCopies();
					}
					break;
				case 7:
					if(evaluateCondition(7,activeMSD))
					{
						evalTrueWaitCond7(activeMSD);

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
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;

		Boolean VAR_boolean_exact_boolean_arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			VAR_boolean_exact_boolean_arg00 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		ArrayList<Object>  args101 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm101 = new MSDMethod(car,cruiser,
			MSDMethods.Car_Cruiser_setEngineEngaged,args101,"Car:Cruiser:setEngineEngaged",niceName,activeMSD.getGlobalId());// setEngineEngaged() Execute
		MSDMethod MSDm102 = new MSDMethod(car,car,
			MSDMethods.Car_Car_startDepart,null,"Car:Car:startDepart",niceName,activeMSD.getGlobalId());// startDepart() Monitored
		MSDMethod MSDm103 = new MSDMethod(car,existsManager,
			MSDMethods.Car_ExitsManager_exitClear,null,"Car:ExitsManager:exitClear",niceName,activeMSD.getGlobalId());// exitClear() Execute
		MSDMethod MSDm104 = new MSDMethod(car,terminal,
			MSDMethods.Car_Terminal_departReq,null,"Car:Terminal:departReq",niceName,activeMSD.getGlobalId());// departReq() Execute
		MSDMethod MSDm105 = new MSDMethod(car,car,
			MSDMethods.Car_Car_endDepart,null,"Car:Car:endDepart",niceName,activeMSD.getGlobalId());// endDepart() Execute
		MSDMethod MSDm106 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_departAck,null,"Terminal:Car:departAck",niceName,activeMSD.getGlobalId());// departAck() Monitored
		MSDMethod MSDm107 = new MSDMethod(car,car,
			MSDMethods.Car_Car_clearDest,null,"Car:Car:clearDest",niceName,activeMSD.getGlobalId());// clearDest() Execute
		MSDMethod MSDm108 = new MSDMethod(car,cruiser,
			MSDMethods.Car_Cruiser_start,null,"Car:Cruiser:start",niceName,activeMSD.getGlobalId());// start() Execute

		 if(activeMSD.isInCut(0,0,0,0))
		{
				ME.add(MSDm102);
				CV.add(MSDm101,MSDm104,MSDm106,MSDm108,MSDm107,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(1,0,0,0))
		{
				if(MSDm108.sourceInstance!=null && MSDm108.targetInstance!=null){
					EE.add(MSDm108);
				}
				HV.add(MSDm101,MSDm104,MSDm106,MSDm102,MSDm107,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(2,0,1,0))
		{
				if(MSDm104.sourceInstance!=null && MSDm104.targetInstance!=null){
					EE.add(MSDm104);
				}
				HV.add(MSDm101,MSDm106,MSDm108,MSDm102,MSDm107,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(3,1,1,0))
		{
				ME.add(MSDm106);
				CV.add(MSDm101,MSDm104,MSDm108,MSDm102,MSDm107,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(5,3,2,0))
		{
				if(MSDm101.sourceInstance!=null && MSDm101.targetInstance!=null){
					EE.add(MSDm101);
				}
				HV.add(MSDm104,MSDm106,MSDm108,MSDm102,MSDm107,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(6,3,3,0))
		{
				if(MSDm107.sourceInstance!=null && MSDm107.targetInstance!=null){
					EE.add(MSDm107);
				}
				HV.add(MSDm101,MSDm104,MSDm106,MSDm108,MSDm102,MSDm105,MSDm103);
				return;
		}
		 if(activeMSD.isInCut(8,4,4,0))
		{
				if(MSDm103.sourceInstance!=null && MSDm103.targetInstance!=null){
					EE.add(MSDm103);
				}
				HV.add(MSDm101,MSDm104,MSDm106,MSDm108,MSDm102,MSDm107,MSDm105);
				return;
		}
		 if(activeMSD.isInCut(9,4,4,1))
		{
				if(MSDm105.sourceInstance!=null && MSDm105.targetInstance!=null){
					EE.add(MSDm105);
				}
				HV.add(MSDm101,MSDm104,MSDm106,MSDm108,MSDm102,MSDm107,MSDm103);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
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
	
	private ArrayList<Object> getcruiser_CruiserInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
		}
		if(car==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("Cruiser");
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
				if(((Cruiser)inst).getID()==car.getCarID()){
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
	
	private ArrayList<Object> getexistsManager_ExitsManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
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
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
			ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
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
				case Cruiser_INST_cruiser:
					try{
						result = getcruiser_CruiserInstances(activeMSD, false, "NONE");
						 
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
				case ExitsManager_INST_existsManager:
					try{
						result = getexistsManager_ExitsManagerInstances(activeMSD, false, "NONE");
						 
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
