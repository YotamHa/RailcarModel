//  The file MSDAspectLocationAlerts_Alert80.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectLocationAlerts_Alert80 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car1 = 0;
	static final int Terminal_INST_terminal = 1;
	static final int SysManager_INST_sysManager = 2;

	static final int int_arg_int_symbolic_var_distance = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "LocationAlerts_Alert80";

	private static MSDAspectLocationAlerts_Alert80 instance = null;

	public static MSDAspectLocationAlerts_Alert80 getInstance(){
		if(instance==null){
			instance = new MSDAspectLocationAlerts_Alert80();
		}
		return instance;
	}

	private MSDAspectLocationAlerts_Alert80()
	{
		addAspectEvent(MSDMethods.Car_Car_moveCar);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "moveCar");
		addAspectEvent(MSDMethods.SysManager_Car_alert80);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "alert80");

		addMinimalEvent(MSDMethods.Car_Car_moveCar);
		setHotCut(5,3,4);
		setHotCut(3,2,2);
		addOperCut(" (minimalDistance >= terminal.location - car1.location) && (car1.direction == right) && (terminal.location >= car1.location) ",3,2,2);
		addOperCut(" (minimalDistance >= terminal.location - car1.location) && (car1.direction == right) && (terminal.location >= car1.location) ",4,2,3);
		addOperCut(" (car1.direction == left) && (car1.location >= terminal.location) && (minimalDistance >= car1.location - terminal.location) ",5,3,4);
		addOperCut(" (car1.direction == left) && (car1.location >= terminal.location) && (minimalDistance >= car1.location - terminal.location) ",6,3,5);
		setLastCut(7,4,6);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499586852394";
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
			case MSDMethods.SysManager_Car_alert80:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car1,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(5,3,4))
					{
						cutChanged=true; activeMSD.setCut(6,3,5);
						if(evaluateCondition(5,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(7,4,6);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(7,4,6);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car1,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(3,2,2))
					{
						cutChanged=true; activeMSD.setCut(4,2,3);
						if(evaluateCondition(5,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(7,4,6);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(7,4,6);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_moveCar:
				if(activeMSD.instancesEquals(Car_INST_car1,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car1,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_distance,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
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
								cutChanged=true; activeMSD.setCut(5,3,4);
								return cutChanged;
							}
							cutChanged=true; activeMSD.setCut(7,4,6);
							break;
						}
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
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

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
				activeMSD.setPrivateVariable(int_var_symbolic_minimalDistance,80);
				return true;
			case 2: 
				return minimalDistance>=terminal.getLocation() - car1.getLocation()&&car1.getDirection().equals("right")&&terminal.getLocation()>=car1.getLocation();
			case 3: 
				return car1.getDirection().equals("left")&&car1.getLocation()>=terminal.getLocation()&&minimalDistance>=car1.getLocation() - terminal.getLocation();
			case 5: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

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
		this.setExpressionForCut("7,4,6" , "SYNC");
		this.setExpressionForCut("2,1,1" , "minimalDistance = 80");
		this.setExpressionForCut("5,3,4" , " (car1.direction == left) && (car1.location >= terminal.location) && (minimalDistance >= car1.location - terminal.location) ");
		this.setExpressionForCut("3,2,2" , " (minimalDistance >= terminal.location - car1.location) && (car1.direction == right) && (terminal.location >= car1.location) ");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(Car_INST_car1,AppObjects.getObject("car1","Car"));
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

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
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	
		if(terminal==null){
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

	private void after_Car_Car_moveCar(Object _car1Source ,Object _car1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Car_moveCar,
					_car1,_car1,args);
	}

	private void after_SysManager_Car_alert80(Object _sysManager ,Object _car1)
	{
		changeCutState(MSDMethods.SysManager_Car_alert80,
					_sysManager,_car1,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("moveCar")){
			after_Car_Car_moveCar(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("alert80")){
			after_SysManager_Car_alert80(source, target);
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
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		Integer VAR_int_symbolic_var_distance = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			VAR_int_symbolic_var_distance = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}

		MSDMethod MSDm148 = new MSDMethod(sysManager,car1,
			MSDMethods.SysManager_Car_alert80,null,"SysManager:Car:alert80",niceName,activeMSD.getGlobalId());// alert80() Execute
		ArrayList<Object>  args150 = getArgsList(VAR_int_symbolic_var_distance);
		MSDMethod MSDm150 = new MSDMethod(car1,car1,
			MSDMethods.Car_Car_moveCar,args150,"Car:Car:moveCar",niceName,activeMSD.getGlobalId());// moveCar() Monitored

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm150);
				CV.add(MSDm148);
				return;
		}
		 if(activeMSD.isInCut(3,2,2))
		{
				if(MSDm148.sourceInstance!=null && MSDm148.targetInstance!=null){
					EE.add(MSDm148);
				}
				HV.add(MSDm150);
				return;
		}
		 if(activeMSD.isInCut(5,3,4))
		{
				if(MSDm148.sourceInstance!=null && MSDm148.targetInstance!=null){
					EE.add(MSDm148);
				}
				HV.add(MSDm150);
				return;
		}
	}
	protected void updateActiveForbiddenEvents(MSDMethodSet MEall,MSDMethodSet EEall,
			MSDMethodSet CVall,MSDMethodSet HVall,ActiveMSDAspect activeMSD)
	{

	}
	
	private ArrayList<Object> getterminal_TerminalInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car1 = (Car) activeMSD.getLineInstance(Car_INST_car1);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

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

		int distance = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance)!=null){
			distance = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_distance);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car1 = (Car) activeMSD.getLineInstance(Car_INST_car1);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			switch (lifelineIndex){
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
