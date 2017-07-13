//  The file MSDAspectCar_StopAtTerminal.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCar_StopAtTerminal extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Cruiser_INST_cruiser = 1;
	static final int SysManager_INST_sysManager = 2;

	static final int String_arg_String_exact_String_arg00 = 0;
	static final int boolean_arg_boolean_exact_boolean_arg01 = 1;

	static final int int_var_symbolic_minimalDistance = 2;

	private final String niceName = "Car_StopAtTerminal";

	private static MSDAspectCar_StopAtTerminal instance = null;

	public static MSDAspectCar_StopAtTerminal getInstance(){
		if(instance==null){
			instance = new MSDAspectCar_StopAtTerminal();
		}
		return instance;
	}

	private MSDAspectCar_StopAtTerminal()
	{
		addAspectEvent(MSDMethods.Car_Car_stopAtTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "stopAtTerminal");
		addAspectEvent(MSDMethods.Car_Car_setMode);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "setMode");
		addAspectEvent(MSDMethods.SysManager_Car_alertStop);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "alertStop");
		addAspectEvent(MSDMethods.Car_Cruiser_setEngineEngaged);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Cruiser", "setEngineEngaged");
		addAspectEvent(MSDMethods.Car_Car_endArrival);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "endArrival");

		addMinimalEvent(MSDMethods.Car_Car_stopAtTerminal);
		setHotCut(4,1,1);
		setHotCut(3,0,1);
		setHotCut(1,0,0);
		setLastCut(5,1,1);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 3;
		numberOfTimeTags = 0;
		interactionId = "1499940130082";
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
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,0,1))
					{
						cutChanged=true; activeMSD.setCut(4,1,1);
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
					if(activeMSD.isInCut(1,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,0,0);
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
					if(activeMSD.isInCut(2,0,0))
					{
						cutChanged=true; activeMSD.setCut(3,0,1);
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
					if(activeMSD.isInCut(4,1,1))
					{
						cutChanged=true; activeMSD.setCut(5,1,1);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_stopAtTerminal:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						cutChanged=true; activeMSD.setCut(1,0,0);
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
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		switch (conditionNumber)
		{
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg00, (String)"stop");
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg01, (boolean)false);
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

	private void after_Car_Car_stopAtTerminal(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_stopAtTerminal,
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

	private void after_Car_Cruiser_setEngineEngaged(Object _car ,Object _cruiser, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Cruiser_setEngineEngaged,
					_car,_cruiser,args);
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
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("stopAtTerminal")){
			after_Car_Car_stopAtTerminal(source, target);
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
		if(srcClassName.equals("Car") && tgtClassName.equals("Cruiser") && method.equals("setEngineEngaged")){
			after_Car_Cruiser_setEngineEngaged(source, target, argValues);
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
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String VAR_String_exact_String_arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			VAR_String_exact_String_arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		Boolean VAR_boolean_exact_boolean_arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			VAR_boolean_exact_boolean_arg01 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		ArrayList<Object>  args129 = getArgsList(VAR_boolean_exact_boolean_arg01);
		MSDMethod MSDm129 = new MSDMethod(car,cruiser,
			MSDMethods.Car_Cruiser_setEngineEngaged,args129,"Car:Cruiser:setEngineEngaged",niceName,activeMSD.getGlobalId());// setEngineEngaged() Execute
		ArrayList<Object>  args130 = getArgsList(VAR_String_exact_String_arg00);
		MSDMethod MSDm130 = new MSDMethod(car,car,
			MSDMethods.Car_Car_setMode,args130,"Car:Car:setMode",niceName,activeMSD.getGlobalId());// setMode() Execute
		MSDMethod MSDm131 = new MSDMethod(sysManager,car,
			MSDMethods.SysManager_Car_alertStop,null,"SysManager:Car:alertStop",niceName,activeMSD.getGlobalId());// alertStop() Monitored
		MSDMethod MSDm132 = new MSDMethod(car,car,
			MSDMethods.Car_Car_endArrival,null,"Car:Car:endArrival",niceName,activeMSD.getGlobalId());// endArrival() Execute
		MSDMethod MSDm133 = new MSDMethod(car,car,
			MSDMethods.Car_Car_stopAtTerminal,null,"Car:Car:stopAtTerminal",niceName,activeMSD.getGlobalId());// stopAtTerminal() Monitored

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm133);
				CV.add(MSDm131,MSDm129,MSDm132,MSDm130);
				return;
		}
		 if(activeMSD.isInCut(1,0,0))
		{
				if(MSDm130.sourceInstance!=null && MSDm130.targetInstance!=null){
					EE.add(MSDm130);
				}
				HV.add(MSDm131,MSDm129,MSDm133,MSDm132);
				return;
		}
		 if(activeMSD.isInCut(2,0,0))
		{
				ME.add(MSDm131);
				CV.add(MSDm129,MSDm133,MSDm132,MSDm130);
				return;
		}
		 if(activeMSD.isInCut(3,0,1))
		{
				if(MSDm129.sourceInstance!=null && MSDm129.targetInstance!=null){
					EE.add(MSDm129);
				}
				HV.add(MSDm131,MSDm133,MSDm132,MSDm130);
				return;
		}
		 if(activeMSD.isInCut(4,1,1))
		{
				if(MSDm132.sourceInstance!=null && MSDm132.targetInstance!=null){
					EE.add(MSDm132);
				}
				HV.add(MSDm131,MSDm129,MSDm133,MSDm130);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}

		boolean arg01 = false;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
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
	
	private ArrayList<Object> getcruiser_CruiserInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

		String arg00 = null;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
			arg00Bound=true;
		}

		boolean arg01 = false;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
			arg01Bound=true;
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

		String arg00 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00)!=null){
			arg00 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg00);
		}

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
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
