//  The file MSDAspectPlatformManager_LSC3.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_LSC3 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int PlatformManager_INST_platformManager2 = 0;
	static final int Env_INST_User = 1;

	static final int boolean_arg_boolean_exact_boolean_arg00 = 0;
	static final int boolean_arg_boolean_exact_boolean_arg01 = 1;
	static final int boolean_arg_boolean_exact_boolean_arg02 = 2;
	static final int boolean_arg_boolean_exact_boolean_arg03 = 3;

	static final int int_var_symbolic_minimalDistance = 4;

	private final String niceName = "PlatformManager_LSC3";

	private static MSDAspectPlatformManager_LSC3 instance = null;

	public static MSDAspectPlatformManager_LSC3 getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_LSC3();
		}
		return instance;
	}

	private MSDAspectPlatformManager_LSC3()
	{
		addAspectEvent(MSDMethods.Env_PlatformManager_lockPlatforms);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Env", "PlatformManager", "lockPlatforms");
		addAspectEvent(MSDMethods.PlatformManager_PlatformManager_setPlatform1busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "PlatformManager", "setPlatform1busy");
		addAspectEvent(MSDMethods.PlatformManager_PlatformManager_setPlatform2busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "PlatformManager", "setPlatform2busy");
		addAspectEvent(MSDMethods.PlatformManager_PlatformManager_setPlatform3busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "PlatformManager", "setPlatform3busy");
		addAspectEvent(MSDMethods.PlatformManager_PlatformManager_setPlatform4busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "PlatformManager", "setPlatform4busy");

		addMinimalEvent(MSDMethods.Env_PlatformManager_lockPlatforms);
		setHotCut(3,1);
		setHotCut(4,1);
		setHotCut(1,1);
		setHotCut(2,1);
		setLastCut(5,1);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 5;
		numberOfTimeTags = 0;
		interactionId = "1499083609681";
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
			case MSDMethods.Env_PlatformManager_lockPlatforms:
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						cutChanged=true; activeMSD.setCut(1,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform2busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager2,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,1))
					{
						cutChanged=true; activeMSD.setCut(3,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform1busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager2,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,1))
					{
						cutChanged=true; activeMSD.setCut(2,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform4busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager2,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg03,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,1))
					{
						cutChanged=true; activeMSD.setCut(5,1);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform3busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager2,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,1))
					{
						cutChanged=true; activeMSD.setCut(4,1);
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
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg03 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		switch (conditionNumber)
		{
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg03 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(PlatformManager_INST_platformManager2,AppObjects.getObject("platformManager2","PlatformManager"));
		activeMSD.setLineInstance(Env_INST_User,AppObjects.getObject("User","Env"));
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2, null, false );
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User, null, false );

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg03 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg00, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg01, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg02, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg03, (boolean)true);
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
	
			return false;
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

	private void after_Env_PlatformManager_lockPlatforms(Object _user ,Object _platformManager2)
	{
		changeCutState(MSDMethods.Env_PlatformManager_lockPlatforms,
					_user,_platformManager2,null);
	}

	private void after_PlatformManager_PlatformManager_setPlatform1busy(Object _platformManager2Source ,Object _platformManager2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform1busy,
					_platformManager2,_platformManager2,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform2busy(Object _platformManager2Source ,Object _platformManager2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform2busy,
					_platformManager2,_platformManager2,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform3busy(Object _platformManager2Source ,Object _platformManager2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,
					_platformManager2,_platformManager2,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform4busy(Object _platformManager2Source ,Object _platformManager2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform4busy,
					_platformManager2,_platformManager2,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Env") && tgtClassName.equals("PlatformManager") && method.equals("lockPlatforms")){
			after_Env_PlatformManager_lockPlatforms(source, target);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform1busy")){
			after_PlatformManager_PlatformManager_setPlatform1busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform2busy")){
			after_PlatformManager_PlatformManager_setPlatform2busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform3busy")){
			after_PlatformManager_PlatformManager_setPlatform3busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform4busy")){
			after_PlatformManager_PlatformManager_setPlatform4busy(source, target, argValues);
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
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		Boolean VAR_boolean_exact_boolean_arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			VAR_boolean_exact_boolean_arg01 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		Boolean VAR_boolean_exact_boolean_arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			VAR_boolean_exact_boolean_arg00 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		Boolean VAR_boolean_exact_boolean_arg03 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			VAR_boolean_exact_boolean_arg03 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
		}

		Boolean VAR_boolean_exact_boolean_arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			VAR_boolean_exact_boolean_arg02 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		MSDMethod MSDm166 = new MSDMethod(User,platformManager2,
			MSDMethods.Env_PlatformManager_lockPlatforms,null,"Env:PlatformManager:lockPlatforms",niceName,activeMSD.getGlobalId());// lockPlatforms() Monitored
		ArrayList<Object>  args167 = getArgsList(VAR_boolean_exact_boolean_arg01);
		MSDMethod MSDm167 = new MSDMethod(platformManager2,platformManager2,
			MSDMethods.PlatformManager_PlatformManager_setPlatform2busy,args167,"PlatformManager:PlatformManager:setPlatform2busy",niceName,activeMSD.getGlobalId());// setPlatform2busy() Execute
		ArrayList<Object>  args168 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm168 = new MSDMethod(platformManager2,platformManager2,
			MSDMethods.PlatformManager_PlatformManager_setPlatform1busy,args168,"PlatformManager:PlatformManager:setPlatform1busy",niceName,activeMSD.getGlobalId());// setPlatform1busy() Execute
		ArrayList<Object>  args169 = getArgsList(VAR_boolean_exact_boolean_arg03);
		MSDMethod MSDm169 = new MSDMethod(platformManager2,platformManager2,
			MSDMethods.PlatformManager_PlatformManager_setPlatform4busy,args169,"PlatformManager:PlatformManager:setPlatform4busy",niceName,activeMSD.getGlobalId());// setPlatform4busy() Execute
		ArrayList<Object>  args170 = getArgsList(VAR_boolean_exact_boolean_arg02);
		MSDMethod MSDm170 = new MSDMethod(platformManager2,platformManager2,
			MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,args170,"PlatformManager:PlatformManager:setPlatform3busy",niceName,activeMSD.getGlobalId());// setPlatform3busy() Execute

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm166);
				CV.add(MSDm167,MSDm168,MSDm169,MSDm170);
				return;
		}
		 if(activeMSD.isInCut(1,1))
		{
				if(MSDm168.sourceInstance!=null && MSDm168.targetInstance!=null){
					EE.add(MSDm168);
				}
				HV.add(MSDm167,MSDm169,MSDm170,MSDm166);
				return;
		}
		 if(activeMSD.isInCut(2,1))
		{
				if(MSDm167.sourceInstance!=null && MSDm167.targetInstance!=null){
					EE.add(MSDm167);
				}
				HV.add(MSDm168,MSDm169,MSDm170,MSDm166);
				return;
		}
		 if(activeMSD.isInCut(3,1))
		{
				if(MSDm170.sourceInstance!=null && MSDm170.targetInstance!=null){
					EE.add(MSDm170);
				}
				HV.add(MSDm167,MSDm168,MSDm169,MSDm166);
				return;
		}
		 if(activeMSD.isInCut(4,1))
		{
				if(MSDm169.sourceInstance!=null && MSDm169.targetInstance!=null){
					EE.add(MSDm169);
				}
				HV.add(MSDm167,MSDm168,MSDm170,MSDm166);
				return;
		}
	}
	protected void updateActiveForbiddenEvents(MSDMethodSet MEall,MSDMethodSet EEall,
			MSDMethodSet CVall,MSDMethodSet HVall,ActiveMSDAspect activeMSD)
	{

	}
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		boolean arg01 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg03 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			PlatformManager platformManager2 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager2);
			Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
			switch (lifelineIndex){
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
	
	public String getNiceName()
	{
			return niceName;
	}

}
