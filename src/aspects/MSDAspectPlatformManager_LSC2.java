//  The file MSDAspectPlatformManager_LSC2.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_LSC2 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int PlatformManager_INST_platformManager = 0;
	static final int Env_INST_User = 1;

	static final int boolean_arg_boolean_exact_boolean_arg00 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "PlatformManager_LSC2";

	private static MSDAspectPlatformManager_LSC2 instance = null;

	public static MSDAspectPlatformManager_LSC2 getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_LSC2();
		}
		return instance;
	}

	private MSDAspectPlatformManager_LSC2()
	{
		addAspectEvent(MSDMethods.Env_PlatformManager_freePlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Env", "PlatformManager", "freePlatform");
		addAspectEvent(MSDMethods.PlatformManager_PlatformManager_setPlatform3busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "PlatformManager", "setPlatform3busy");

		addMinimalEvent(MSDMethods.Env_PlatformManager_freePlatform);
		setHotCut(1,1);
		setLastCut(2,1);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499586852461";
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
			case MSDMethods.Env_PlatformManager_freePlatform:
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(PlatformManager_INST_platformManager,null)) 
 &&  this.validateBoundedObject(activeMSD,PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						cutChanged=true; activeMSD.setCut(1,1);
						activeMSD.setLineInstance(PlatformManager_INST_platformManager,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform3busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,1))
					{
						cutChanged=true; activeMSD.setCut(2,1);
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
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

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
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

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
		activeMSD.setLineInstance(Env_INST_User,AppObjects.getObject("User","Env"));
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager, null, false );
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User, null, false );

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg00, (boolean)false);
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
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	
		if(platformManager==null){
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

	private void after_Env_PlatformManager_freePlatform(Object _user ,Object _platformManager)
	{
		changeCutState(MSDMethods.Env_PlatformManager_freePlatform,
					_user,_platformManager,null);
	}

	private void after_PlatformManager_PlatformManager_setPlatform3busy(Object _platformManagerSource ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,
					_platformManager,_platformManager,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Env") && tgtClassName.equals("PlatformManager") && method.equals("freePlatform")){
			after_Env_PlatformManager_freePlatform(source, target);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform3busy")){
			after_PlatformManager_PlatformManager_setPlatform3busy(source, target, argValues);
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
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		Boolean VAR_boolean_exact_boolean_arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			VAR_boolean_exact_boolean_arg00 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		MSDMethod MSDm160 = new MSDMethod(User,platformManager,
			MSDMethods.Env_PlatformManager_freePlatform,null,"Env:PlatformManager:freePlatform",niceName,activeMSD.getGlobalId());// freePlatform() Monitored
		ArrayList<Object>  args161 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm161 = new MSDMethod(platformManager,platformManager,
			MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,args161,"PlatformManager:PlatformManager:setPlatform3busy",niceName,activeMSD.getGlobalId());// setPlatform3busy() Execute

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm160);
				CV.add(MSDm161);
				return;
		}
		 if(activeMSD.isInCut(1,1))
		{
				if(MSDm161.sourceInstance!=null && MSDm161.targetInstance!=null){
					EE.add(MSDm161);
				}
				HV.add(MSDm160);
				return;
		}
	}
	protected void updateActiveForbiddenEvents(MSDMethodSet MEall,MSDMethodSet EEall,
			MSDMethodSet CVall,MSDMethodSet HVall,ActiveMSDAspect activeMSD)
	{

	}
	
	private ArrayList<Object> getplatformManager_PlatformManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
	

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
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
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
			Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
			switch (lifelineIndex){
				case PlatformManager_INST_platformManager:
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
