//  The file MSDAspectsysEvents_ChooseDestenation3.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectsysEvents_ChooseDestenation3 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Car_INST_car1 = 1;
	static final int Env_INST_User = 2;

	static final int int_arg_int_exact_int_arg00 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "sysEvents_ChooseDestenation3";

	private static MSDAspectsysEvents_ChooseDestenation3 instance = null;

	public static MSDAspectsysEvents_ChooseDestenation3 getInstance(){
		if(instance==null){
			instance = new MSDAspectsysEvents_ChooseDestenation3();
		}
		return instance;
	}

	private MSDAspectsysEvents_ChooseDestenation3()
	{
		addAspectEvent(MSDMethods.Env_SysManager_chooseTerminal3);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Env", "SysManager", "chooseTerminal3");
		addAspectEvent(MSDMethods.SysManager_Car_setDestination);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "setDestination");
		addAspectEvent(MSDMethods.SysManager_Car_destinationSet);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "destinationSet");

		addMinimalEvent(MSDMethods.Env_SysManager_chooseTerminal3);
		setHotCut(1,0,1);
		setHotCut(2,1,1);
		setLastCut(3,2,1);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499940130246";
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
					&& activeMSD.instancesEquals(Car_INST_car1,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(2,1,1))
					{
						cutChanged=true; activeMSD.setCut(3,2,1);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Env_SysManager_chooseTerminal3:
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&& activeMSD.instancesEquals(SysManager_INST_sysManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,0,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_setDestination:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car1,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,1))
					{
						cutChanged=true; activeMSD.setCut(2,1,1);
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
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		switch (conditionNumber)
		{
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		activeMSD.setLineInstance(Car_INST_car1,AppObjects.getObject("car1","Car"));
		activeMSD.setLineInstance(Env_INST_User,AppObjects.getObject("User","Env"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1, null, false );
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User, null, false );

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg00, (int)3);
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

	private void after_Env_SysManager_chooseTerminal3(Object _user ,Object _sysManager)
	{
		changeCutState(MSDMethods.Env_SysManager_chooseTerminal3,
					_user,_sysManager,null);
	}

	private void after_SysManager_Car_setDestination(Object _sysManager ,Object _car1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Car_setDestination,
					_sysManager,_car1,args);
	}

	private void after_SysManager_Car_destinationSet(Object _sysManager ,Object _car1)
	{
		changeCutState(MSDMethods.SysManager_Car_destinationSet,
					_sysManager,_car1,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Env") && tgtClassName.equals("SysManager") && method.equals("chooseTerminal3")){
			after_Env_SysManager_chooseTerminal3(source, target);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("setDestination")){
			after_SysManager_Car_setDestination(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("destinationSet")){
			after_SysManager_Car_destinationSet(source, target);
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
		Car car1 = (Car)bindObjectByExpression(activeMSD,Car_INST_car1,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;

		Integer VAR_int_exact_int_arg00 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			VAR_int_exact_int_arg00 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		MSDMethod MSDm182 = new MSDMethod(sysManager,car1,
			MSDMethods.SysManager_Car_destinationSet,null,"SysManager:Car:destinationSet",niceName,activeMSD.getGlobalId());// destinationSet() Execute
		MSDMethod MSDm183 = new MSDMethod(User,sysManager,
			MSDMethods.Env_SysManager_chooseTerminal3,null,"Env:SysManager:chooseTerminal3",niceName,activeMSD.getGlobalId());// chooseTerminal3() Monitored
		ArrayList<Object>  args184 = getArgsList(VAR_int_exact_int_arg00);
		MSDMethod MSDm184 = new MSDMethod(sysManager,car1,
			MSDMethods.SysManager_Car_setDestination,args184,"SysManager:Car:setDestination",niceName,activeMSD.getGlobalId());// setDestination() Execute

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm183);
				CV.add(MSDm184,MSDm182);
				return;
		}
		 if(activeMSD.isInCut(1,0,1))
		{
				if(MSDm184.sourceInstance!=null && MSDm184.targetInstance!=null){
					EE.add(MSDm184);
				}
				HV.add(MSDm183,MSDm182);
				return;
		}
		 if(activeMSD.isInCut(2,1,1))
		{
				if(MSDm182.sourceInstance!=null && MSDm182.targetInstance!=null){
					EE.add(MSDm182);
				}
				HV.add(MSDm184,MSDm183);
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

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Car car1 = (Car) activeMSD.getLineInstance(Car_INST_car1);
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
