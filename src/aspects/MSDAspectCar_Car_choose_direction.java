//  The file MSDAspectCar_Car_choose_direction.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCar_Car_choose_direction extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int SysManager_INST_sysManager = 1;
	static final int Terminal_INST_terminal = 2;

	static final int String_arg_String_exact_String_arg01 = 0;
	static final int String_arg_String_exact_String_arg00 = 1;

	static final int int_var_symbolic_minimalDistance = 2;

	private final String niceName = "Car_Car_choose_direction";

	private static MSDAspectCar_Car_choose_direction instance = null;

	public static MSDAspectCar_Car_choose_direction getInstance(){
		if(instance==null){
			instance = new MSDAspectCar_Car_choose_direction();
		}
		return instance;
	}

	private MSDAspectCar_Car_choose_direction()
	{
		addAspectEvent(MSDMethods.SysManager_Car_destinationSet);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "destinationSet");
		addAspectEvent(MSDMethods.Car_Car_setDirection);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "setDirection");

		addMinimalEvent(MSDMethods.SysManager_Car_destinationSet);
		setHotCut(4,3,2);
		setHotCut(2,2,1);
		addOperCut("else",4,3,2);
		addOperCut("else",5,3,2);
		addOperCut("car.location > terminal.location",2,2,1);
		addOperCut("car.location > terminal.location",3,2,1);
		setLastCut(6,4,3);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 3;
		numberOfTimeTags = 0;
		interactionId = "1499940130072";
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
			case MSDMethods.SysManager_Car_destinationSet:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,1,0);
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;if(evaluateCondition(1,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(2,2,1);
							activeMSD.setLineInstance(Car_INST_car,targetObject);return cutChanged;
						}
						activeMSD.setLineInstance(Car_INST_car,targetObject);if(evaluateCondition(2,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(4,3,2);
							activeMSD.setLineInstance(Car_INST_car,targetObject);return cutChanged;
						}
						cutChanged=true; activeMSD.setCut(6,4,3);
						activeMSD.setLineInstance(Car_INST_car,targetObject);break;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_setDirection:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,2,1))
					{
						cutChanged=true; activeMSD.setCut(3,2,1);
						if(evaluateCondition(2,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,4,3);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,4,3);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,3,2))
					{
						cutChanged=true; activeMSD.setCut(5,3,2);
						if(evaluateCondition(2,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,4,3);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,4,3);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		String arg01 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
		}

		switch (conditionNumber)
		{
			case 1: 
				return car.getLocation()>terminal.getLocation();
			case 2: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		String arg01 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
		}

	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("4,3,2" , "else");
		this.setExpressionForCut("2,2,1" , "car.location > terminal.location");
		this.setExpressionForCut("6,4,3" , "SYNC");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		String arg01 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg01, (String)"right");
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg00, (String)"left");
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

	private void after_SysManager_Car_destinationSet(Object _sysManager ,Object _car)
	{
		changeCutState(MSDMethods.SysManager_Car_destinationSet,
					_sysManager,_car,null);
	}

	private void after_Car_Car_setDirection(Object _carSource ,Object _car, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Car_setDirection,
					_car,_car,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("destinationSet")){
			after_SysManager_Car_destinationSet(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("setDirection")){
			after_Car_Car_setDirection(source, target, argValues);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		String VAR_String_exact_String_arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			VAR_String_exact_String_arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		String VAR_String_exact_String_arg01 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			VAR_String_exact_String_arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
		}

		MSDMethod MSDm126 = new MSDMethod(sysManager,car,
			MSDMethods.SysManager_Car_destinationSet,null,"SysManager:Car:destinationSet",niceName,activeMSD.getGlobalId());// destinationSet() Monitored
		ArrayList<Object>  args127 = getArgsList(VAR_String_exact_String_arg00);
		MSDMethod MSDm127 = new MSDMethod(car,car,
			MSDMethods.Car_Car_setDirection,args127,"Car:Car:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args128 = getArgsList(VAR_String_exact_String_arg01);
		MSDMethod MSDm128 = new MSDMethod(car,car,
			MSDMethods.Car_Car_setDirection,args128,"Car:Car:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm126);
				CV.add(MSDm127,MSDm128);
				return;
		}
		 if(activeMSD.isInCut(2,2,1))
		{
				if(MSDm127.sourceInstance!=null && MSDm127.targetInstance!=null){
					EE.add(MSDm127);
				}
				HV.add(MSDm126);
				return;
		}
		 if(activeMSD.isInCut(4,3,2))
		{
				if(MSDm128.sourceInstance!=null && MSDm128.targetInstance!=null){
					EE.add(MSDm128);
				}
				HV.add(MSDm126);
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
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}

		String arg01 = null;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
			arg01Bound=true;
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
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}

		String arg01 = null;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
			arg01Bound=true;
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
				if(((Terminal)inst).getID()==car.getDestination()){
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

		String arg01 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01)!=null){
			arg01 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg01);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
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
