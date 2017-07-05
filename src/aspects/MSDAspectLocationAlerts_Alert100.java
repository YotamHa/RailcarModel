//  The file MSDAspectLocationAlerts_Alert100.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectLocationAlerts_Alert100 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Terminal_INST_terminal = 1;
	static final int SysManager_INST_sysManager = 2;

	static final int int_arg_int_exact_opaque_arg00 = 0;
	static final int int_arg_int_exact_opaque_arg00Before = 1;
	static final int int_arg_int_exact_opaque_arg01 = 2;
	static final int int_arg_int_exact_opaque_arg01Before = 3;
	static final int int_arg_int_symbolic_var_distance = 4;

	static final int int_var_symbolic_minimalDistance = 5;

	private final String niceName = "LocationAlerts_Alert100";

	private static MSDAspectLocationAlerts_Alert100 instance = null;

	public static MSDAspectLocationAlerts_Alert100 getInstance(){
		if(instance==null){
			instance = new MSDAspectLocationAlerts_Alert100();
		}
		return instance;
	}

	private MSDAspectLocationAlerts_Alert100()
	{
		addAspectEvent(MSDMethods.Car_Car_moveCar);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "moveCar");
		addAspectEvent(MSDMethods.Terminal_Car_setTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "setTerminal");
		addAspectEvent(MSDMethods.SysManager_Car_alert100);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "alert100");

		addMinimalEvent(MSDMethods.Car_Car_moveCar);
		setHotCut(6,4,4);
		setHotCut(3,2,2);
		setHotCut(7,5,4);
		setHotCut(4,3,2);
		addOperCut(" (car.direction == left) && (car.location >= terminal.location) && (minimalDistance >= car.location - terminal.location) ",6,4,4);
		addOperCut(" (car.direction == left) && (car.location >= terminal.location) && (minimalDistance >= car.location - terminal.location) ",7,5,4);
		addOperCut(" (car.direction == left) && (car.location >= terminal.location) && (minimalDistance >= car.location - terminal.location) ",8,5,5);
		addOperCut(" (minimalDistance >= terminal.location - car.location) && (car.direction == right) && (terminal.location >= car.location) ",3,2,2);
		addOperCut(" (minimalDistance >= terminal.location - car.location) && (car.direction == right) && (terminal.location >= car.location) ",4,3,2);
		addOperCut(" (minimalDistance >= terminal.location - car.location) && (car.direction == right) && (terminal.location >= car.location) ",5,3,3);
		setLastCut(9,6,6);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 6;
		numberOfTimeTags = 0;
		interactionId = "1499083609574";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
			case MSDMethods.Car_Car_moveCar:
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_distance,args.get(0));

				break;

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
			case MSDMethods.Terminal_Car_setTerminal:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg01Before,int_arg_int_exact_opaque_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(6,4,4))
					{
						cutChanged=true; activeMSD.setCut(7,5,4);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg00Before,int_arg_int_exact_opaque_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,2,2))
					{
						cutChanged=true; activeMSD.setCut(4,3,2);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_alert100:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(7,5,4))
					{
						cutChanged=true; activeMSD.setCut(8,5,5);
						if(evaluateCondition(7,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(9,6,6);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(9,6,6);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(4,3,2))
					{
						cutChanged=true; activeMSD.setCut(5,3,3);
						if(evaluateCondition(7,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(9,6,6);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(9,6,6);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_moveCar:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_distance,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_distance,args.get(0));
						cutChanged=true; activeMSD.setCut(1,0,0);
						if(evaluateCondition(1,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(2,1,1);
							cutChanged=true; activeMSD.setCut(2,1,1);
							if(evaluateCondition(2,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(3,2,2);
								return cutChanged;
							}
							if(evaluateCondition(3,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(6,4,4);
								return cutChanged;
							}
							cutChanged=true; activeMSD.setCut(9,6,6);
							break;
						}
						break;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_distance,args.get(0)))
				{
					unification=true;
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

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}


		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 
		switch (conditionNumber)
		{
			case 1: 
				activeMSD.setPrivateVariable(int_var_symbolic_minimalDistance,100);
				return true;
			case 2: 
				return minimalDistance>=terminal.getLocation() - car.getLocation()&&car.getDirection().equals("right")&&terminal.getLocation()>=car.getLocation();
			case 3: 
				return car.getDirection().equals("left")&&car.getLocation()>=terminal.getLocation()&&minimalDistance>=car.getLocation() - terminal.getLocation();
			case 7: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}


		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 
	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("9,6,6" , "SYNC");
		this.setExpressionForCut("2,1,1" , "minimalDistance = 100");
		this.setExpressionForCut("6,4,4" , " (car.direction == left) && (car.location >= terminal.location) && (minimalDistance >= car.location - terminal.location) ");
		this.setExpressionForCut("3,2,2" , " (minimalDistance >= terminal.location - car.location) && (car.direction == right) && (terminal.location >= car.location) ");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg00, (int)terminal.getID());
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg01, (int)terminal.getID());
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
	
		if(car==null || terminal==null){
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

	private void before_Terminal_Car_setTerminal(Object _terminal ,Object _car, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);

			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int distance = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
				distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg00Before, (int)terminal.getID());
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg01Before, (int)terminal.getID());
			}catch(Exception e){}
		}
	}
	private void after_Terminal_Car_setTerminal(Object _terminal ,Object _car, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_Car_setTerminal,
					_terminal,_car,args);
	}

	private void after_Car_Car_moveCar(Object _carSource ,Object _car, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Car_moveCar,
					_car,_car,args);
	}

	private void after_SysManager_Car_alert100(Object _sysManager ,Object _car)
	{
		changeCutState(MSDMethods.SysManager_Car_alert100,
					_sysManager,_car,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("setTerminal")){
			after_Terminal_Car_setTerminal(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("moveCar")){
			after_Car_Car_moveCar(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("alert100")){
			after_SysManager_Car_alert100(source, target);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("setTerminal")){
			before_Terminal_Car_setTerminal(source, target, argValues);
			return;
		}
	}

	@Override
	protected void saveActiveMSDCurTimeToTimeTags(int MSDm,ActiveMSDAspect activeMSD){

		switch (MSDm)
		{
		}
	}

	protected void  evaluateWaitConditions(ActiveMSDAspect activeMSD)
	{
		for(Integer cond:activeMSD.getWaitingConditions()){
			switch(cond)
			{
			}
		}
	}

	protected void getActiveMSDCutState(MSDMethodSet ME,MSDMethodSet EE,
			MSDMethodSet CV,MSDMethodSet HV,ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		Integer VAR_int_exact_opaque_arg01 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			VAR_int_exact_opaque_arg01 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		Integer VAR_int_exact_opaque_arg00 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			VAR_int_exact_opaque_arg00 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		Integer VAR_int_symbolic_var_distance = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			VAR_int_symbolic_var_distance = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}

		ArrayList<Object>  args134 = getArgsList(VAR_int_exact_opaque_arg01);
		MSDMethod MSDm134 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_setTerminal,args134,"Terminal:Car:setTerminal",niceName,activeMSD.getGlobalId());// setTerminal() Execute
		ArrayList<Object>  args135 = getArgsList(VAR_int_exact_opaque_arg00);
		MSDMethod MSDm135 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_setTerminal,args135,"Terminal:Car:setTerminal",niceName,activeMSD.getGlobalId());// setTerminal() Execute
		MSDMethod MSDm136 = new MSDMethod(sysManager,car,
			MSDMethods.SysManager_Car_alert100,null,"SysManager:Car:alert100",niceName,activeMSD.getGlobalId());// alert100() Execute
		ArrayList<Object>  args138 = getArgsList(VAR_int_symbolic_var_distance);
		MSDMethod MSDm138 = new MSDMethod(car,car,
			MSDMethods.Car_Car_moveCar,args138,"Car:Car:moveCar",niceName,activeMSD.getGlobalId());// moveCar() Monitored

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm138);
				CV.add(MSDm134,MSDm135,MSDm136);
				return;
		}
		 if(activeMSD.isInCut(3,2,2))
		{
				if(MSDm135.sourceInstance!=null && MSDm135.targetInstance!=null){
					EE.add(MSDm135);
				}
				HV.add(MSDm138,MSDm136);
				return;
		}
		 if(activeMSD.isInCut(4,3,2))
		{
				if(MSDm136.sourceInstance!=null && MSDm136.targetInstance!=null){
					EE.add(MSDm136);
				}
				HV.add(MSDm134,MSDm138,MSDm135);
				return;
		}
		 if(activeMSD.isInCut(6,4,4))
		{
				if(MSDm134.sourceInstance!=null && MSDm134.targetInstance!=null){
					EE.add(MSDm134);
				}
				HV.add(MSDm138,MSDm136);
				return;
		}
		 if(activeMSD.isInCut(7,5,4))
		{
				if(MSDm136.sourceInstance!=null && MSDm136.targetInstance!=null){
					EE.add(MSDm136);
				}
				HV.add(MSDm134,MSDm138,MSDm135);
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
	

		int arg01 = 0;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			arg01Bound=true;
		}

		int arg00 = 0;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			arg00Bound=true;
		}

		int distance = 0;
		boolean distanceBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
			distanceBound=true;
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
	

		int arg01 = 0;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			arg01Bound=true;
		}

		int arg00 = 0;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			arg00Bound=true;
		}

		int distance = 0;
		boolean distanceBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
			distanceBound=true;
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
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
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
						result = getterminal_TerminalInstances(activeMSD, true, "NONE");
						 
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
