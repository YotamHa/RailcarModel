//  The file MSDAspectSysManager_MoveCars.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_MoveCars extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Env_INST_User = 1;
	static final int Car_INST_car = 2;
	static final int Cruiser_INST_cruiser = 3;

	static final int int_arg_int_exact_int_distance0 = 0;
	static final int int_arg_int_exact_int_distance1 = 1;

	static final int int_var_symbolic_minimalDistance = 2;

	private final String niceName = "SysManager_MoveCars";

	private static MSDAspectSysManager_MoveCars instance = null;

	public static MSDAspectSysManager_MoveCars getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_MoveCars();
		}
		return instance;
	}

	private MSDAspectSysManager_MoveCars()
	{
		addAspectEvent(MSDMethods.Env_SysManager_runCycle);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Env", "SysManager", "runCycle");
		addAspectEvent(MSDMethods.Car_Car_moveCar);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "moveCar");

		addMinimalEvent(MSDMethods.Env_SysManager_runCycle);
		setHotCut(4,4,4,3);
		setHotCut(3,3,2,2);
		addOperCut("else",4,4,4,3);
		addOperCut("else",4,4,5,3);
		addOperCut("car.direction == right",3,3,2,2);
		addOperCut("car.direction == right",3,3,3,2);
		setLastCut(5,5,6,4);
		numberOfLifeLines = 4;
		numberOfInstances = 4;
		numberOfVariables = 3;
		numberOfTimeTags = 0;
		interactionId = "1499586852129";
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
			case MSDMethods.Env_SysManager_runCycle:
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&& activeMSD.instancesEquals(SysManager_INST_sysManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,1,0,0);
						if(evaluateCondition(1,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(2,2,1,1);
							cutChanged=true; activeMSD.setCut(2,2,1,1);
							if(evaluateCondition(2,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(3,3,2,2);
								return cutChanged;
							}
							if(evaluateCondition(3,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(4,4,4,3);
								return cutChanged;
							}
							cutChanged=true; activeMSD.setCut(5,5,6,4);
							break;
						}
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_moveCar:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_distance1,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,4,4,3))
					{
						cutChanged=true; activeMSD.setCut(4,4,5,3);
						if(evaluateCondition(3,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(5,5,6,4);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(5,5,6,4);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_distance0,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,3,2,2))
					{
						cutChanged=true; activeMSD.setCut(3,3,3,2);
						if(evaluateCondition(3,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(5,5,6,4);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(5,5,6,4);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;

		int distance0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
		}

		int distance1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
		}


		boolean engineEngaged = false;
		
		if(cruiser!=null){
			engineEngaged=cruiser.isEngineEngaged();
		}
		switch (conditionNumber)
		{
			case 1: 
				return cruiser.getEngineEngaged()==true;
			case 2: 
				return car.getDirection().equals("right");
			case 3: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;

		int distance0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
		}

		int distance1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
		}


		boolean engineEngaged = false;
		
		if(cruiser!=null){
			engineEngaged=cruiser.isEngineEngaged();
		}
	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("2,2,1,1" , "cruiser.engineEngaged == true");
		this.setExpressionForCut("3,3,2,2" , "car.direction == right");
		this.setExpressionForCut("4,4,4,3" , "else");
		this.setExpressionForCut("5,5,6,4" , "SYNC");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		activeMSD.setLineInstance(Env_INST_User,AppObjects.getObject("User","Env"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User, null, false );
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser, null, false );

		int distance0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
		}

		int distance1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_distance0, (int)100);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_distance1, (int)-100);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
	
		if(car==null || cruiser==null){
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

	private void after_Env_SysManager_runCycle(Object _user ,Object _sysManager)
	{
		changeCutState(MSDMethods.Env_SysManager_runCycle,
					_user,_sysManager,null);
	}

	private void after_Car_Car_moveCar(Object _carSource ,Object _car, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Car_moveCar,
					_car,_car,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Env") && tgtClassName.equals("SysManager") && method.equals("runCycle")){
			after_Env_SysManager_runCycle(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("moveCar")){
			after_Car_Car_moveCar(source, target, argValues);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;

		Integer VAR_int_exact_int_distance0 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			VAR_int_exact_int_distance0 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
		}

		Integer VAR_int_exact_int_distance1 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			VAR_int_exact_int_distance1 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
		}

		MSDMethod MSDm35 = new MSDMethod(User,sysManager,
			MSDMethods.Env_SysManager_runCycle,null,"Env:SysManager:runCycle",niceName,activeMSD.getGlobalId());// runCycle() Monitored
		ArrayList<Object>  args36 = getArgsList(VAR_int_exact_int_distance1);
		MSDMethod MSDm36 = new MSDMethod(car,car,
			MSDMethods.Car_Car_moveCar,args36,"Car:Car:moveCar",niceName,activeMSD.getGlobalId());// moveCar() Execute
		ArrayList<Object>  args37 = getArgsList(VAR_int_exact_int_distance0);
		MSDMethod MSDm37 = new MSDMethod(car,car,
			MSDMethods.Car_Car_moveCar,args37,"Car:Car:moveCar",niceName,activeMSD.getGlobalId());// moveCar() Execute

		 if(activeMSD.isInCut(0,0,0,0))
		{
				ME.add(MSDm35);
				CV.add(MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(3,3,2,2))
		{
				if(MSDm37.sourceInstance!=null && MSDm37.targetInstance!=null){
					EE.add(MSDm37);
				}
				HV.add(MSDm35);
				return;
		}
		 if(activeMSD.isInCut(4,4,4,3))
		{
				if(MSDm36.sourceInstance!=null && MSDm36.targetInstance!=null){
					EE.add(MSDm36);
				}
				HV.add(MSDm35);
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
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
	

		int distance0 = 0;
		boolean distance0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
			distance0Bound=true;
		}

		int distance1 = 0;
		boolean distance1Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
			distance1Bound=true;
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
	
	private ArrayList<Object> getcruiser_CruiserInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
		Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
	

		int distance0 = 0;
		boolean distance0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
			distance0Bound=true;
		}

		int distance1 = 0;
		boolean distance1Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
			distance1Bound=true;
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
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		int distance0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0)!=null){
			distance0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance0);
		}

		int distance1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1)!=null){
			distance1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_distance1);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
			switch (lifelineIndex){
				case Car_INST_car:
					try{
						result = getcar_CarInstances(activeMSD, true, "NONE");
						 
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
