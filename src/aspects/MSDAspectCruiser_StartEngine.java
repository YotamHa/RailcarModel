//  The file MSDAspectCruiser_StartEngine.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCruiser_StartEngine extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Cruiser_INST_cruiser = 1;

	static final int boolean_arg_boolean_exact_boolean_arg00 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "Cruiser_StartEngine";

	private static MSDAspectCruiser_StartEngine instance = null;

	public static MSDAspectCruiser_StartEngine getInstance(){
		if(instance==null){
			instance = new MSDAspectCruiser_StartEngine();
		}
		return instance;
	}

	private MSDAspectCruiser_StartEngine()
	{
		addAspectEvent(MSDMethods.Car_Cruiser_start);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Cruiser", "start");
		addAspectEvent(MSDMethods.Cruiser_Cruiser_setEngineStarted);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Cruiser", "Cruiser", "setEngineStarted");

		addMinimalEvent(MSDMethods.Car_Cruiser_start);
		setHotCut(1,1);
		setLastCut(1,2);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499940130106";
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
			case MSDMethods.Cruiser_Cruiser_setEngineStarted:
				if(activeMSD.instancesEquals(Cruiser_INST_cruiser,sourceObject)
					&& activeMSD.instancesEquals(Cruiser_INST_cruiser,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,1))
					{
						cutChanged=true; activeMSD.setCut(1,2);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Cruiser_start:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Cruiser_INST_cruiser,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Cruiser_INST_cruiser,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						activeMSD.setLineInstance(Cruiser_INST_cruiser,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Car_INST_car,sourceObject);
						cutChanged=true; activeMSD.setCut(1,1);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Cruiser_INST_cruiser,targetObject))
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

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
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

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser, null, false );

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

	private void after_Car_Cruiser_start(Object _car ,Object _cruiser)
	{
		changeCutState(MSDMethods.Car_Cruiser_start,
					_car,_cruiser,null);
	}

	private void after_Cruiser_Cruiser_setEngineStarted(Object _cruiserSource ,Object _cruiser, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Cruiser_Cruiser_setEngineStarted,
					_cruiser,_cruiser,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Cruiser") && method.equals("start")){
			after_Car_Cruiser_start(source, target);
			return;
		}
		if(srcClassName.equals("Cruiser") && tgtClassName.equals("Cruiser") && method.equals("setEngineStarted")){
			after_Cruiser_Cruiser_setEngineStarted(source, target, argValues);
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

		Boolean VAR_boolean_exact_boolean_arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			VAR_boolean_exact_boolean_arg00 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		ArrayList<Object>  args142 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm142 = new MSDMethod(cruiser,cruiser,
			MSDMethods.Cruiser_Cruiser_setEngineStarted,args142,"Cruiser:Cruiser:setEngineStarted",niceName,activeMSD.getGlobalId());// setEngineStarted() Execute
		MSDMethod MSDm143 = new MSDMethod(car,cruiser,
			MSDMethods.Car_Cruiser_start,null,"Car:Cruiser:start",niceName,activeMSD.getGlobalId());// start() Monitored

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm143);
				CV.add(MSDm142);
				return;
		}
		 if(activeMSD.isInCut(1,1))
		{
				if(MSDm142.sourceInstance!=null && MSDm142.targetInstance!=null){
					EE.add(MSDm142);
				}
				HV.add(MSDm143);
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
	
	private ArrayList<Object> getcruiser_CruiserInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
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

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
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
