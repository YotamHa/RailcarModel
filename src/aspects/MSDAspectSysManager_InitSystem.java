//  The file MSDAspectSysManager_InitSystem.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_InitSystem extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Env_INST_User = 1;
	static final int Terminal_INST_terminal1 = 2;

	static final int int_arg_int_exact_int_ID0 = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "SysManager_InitSystem";

	private static MSDAspectSysManager_InitSystem instance = null;

	public static MSDAspectSysManager_InitSystem getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_InitSystem();
		}
		return instance;
	}

	private MSDAspectSysManager_InitSystem()
	{
		addAspectEvent(MSDMethods.Env_SysManager_initSystem);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Env", "SysManager", "initSystem");
		addAspectEvent(MSDMethods.SysManager_Terminal_initTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Terminal", "initTerminal");
		addAspectEvent(MSDMethods.SysManager_SysManager_initCars);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "SysManager", "initCars");

		addMinimalEvent(MSDMethods.Env_SysManager_initSystem);
		setHotCut(1,1,0);
		setHotCut(2,1,1);
		setLastCut(3,1,1);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499083609295";
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
			case MSDMethods.SysManager_Terminal_initTerminal:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal1,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_ID0,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,1,0))
					{
						cutChanged=true; activeMSD.setCut(2,1,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Env_SysManager_initSystem:
				if(activeMSD.instancesEquals(Env_INST_User,sourceObject)
					&& activeMSD.instancesEquals(SysManager_INST_sysManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,1,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_SysManager_initCars:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(SysManager_INST_sysManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(2,1,1))
					{
						cutChanged=true; activeMSD.setCut(3,1,1);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;

		int ID0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0)!=null){
			ID0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0);
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
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User,null, true);;
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;

		int ID0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0)!=null){
			ID0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		activeMSD.setLineInstance(Env_INST_User,AppObjects.getObject("User","Env"));
		activeMSD.setLineInstance(Terminal_INST_terminal1,AppObjects.getObject("terminal1","Terminal"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Env User = (Env)bindObjectByExpression(activeMSD,Env_INST_User, null, false );
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1, null, false );

		int ID0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0)!=null){
			ID0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_ID0, (int)1);
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

	private void after_Env_SysManager_initSystem(Object _user ,Object _sysManager)
	{
		changeCutState(MSDMethods.Env_SysManager_initSystem,
					_user,_sysManager,null);
	}

	private void after_SysManager_Terminal_initTerminal(Object _sysManager ,Object _terminal1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_initTerminal,
					_sysManager,_terminal1,args);
	}

	private void after_SysManager_SysManager_initCars(Object _sysManagerSource ,Object _sysManager)
	{
		changeCutState(MSDMethods.SysManager_SysManager_initCars,
					_sysManager,_sysManager,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Env") && tgtClassName.equals("SysManager") && method.equals("initSystem")){
			after_Env_SysManager_initSystem(source, target);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("initTerminal")){
			after_SysManager_Terminal_initTerminal(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("SysManager") && method.equals("initCars")){
			after_SysManager_SysManager_initCars(source, target);
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
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;

		Integer VAR_int_exact_int_ID0 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0)!=null){
			VAR_int_exact_int_ID0 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0);
		}

		ArrayList<Object>  args0 = getArgsList(VAR_int_exact_int_ID0);
		MSDMethod MSDm0 = new MSDMethod(sysManager,terminal1,
			MSDMethods.SysManager_Terminal_initTerminal,args0,"SysManager:Terminal:initTerminal",niceName,activeMSD.getGlobalId());// initTerminal() Execute
		MSDMethod MSDm1 = new MSDMethod(User,sysManager,
			MSDMethods.Env_SysManager_initSystem,null,"Env:SysManager:initSystem",niceName,activeMSD.getGlobalId());// initSystem() Monitored
		MSDMethod MSDm2 = new MSDMethod(sysManager,sysManager,
			MSDMethods.SysManager_SysManager_initCars,null,"SysManager:SysManager:initCars",niceName,activeMSD.getGlobalId());// initCars() Execute

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm1);
				CV.add(MSDm2,MSDm0);
				return;
		}
		 if(activeMSD.isInCut(1,1,0))
		{
				if(MSDm0.sourceInstance!=null && MSDm0.targetInstance!=null){
					EE.add(MSDm0);
				}
				HV.add(MSDm2,MSDm1);
				return;
		}
		 if(activeMSD.isInCut(2,1,1))
		{
				if(MSDm2.sourceInstance!=null && MSDm2.targetInstance!=null){
					EE.add(MSDm2);
				}
				HV.add(MSDm0,MSDm1);
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

		int ID0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0)!=null){
			ID0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_ID0);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Env User = (Env) activeMSD.getLineInstance(Env_INST_User);
			Terminal terminal1 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal1);
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