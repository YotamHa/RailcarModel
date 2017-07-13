//  The file MSDAspectPlatformManager_MoveExit.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_MoveExit extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Terminal_INST_terminal = 0;
	static final int Exit_INST_exit = 1;

	static final int int_arg_int_symbolic_var_platform = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "PlatformManager_MoveExit";

	private static MSDAspectPlatformManager_MoveExit instance = null;

	public static MSDAspectPlatformManager_MoveExit getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_MoveExit();
		}
		return instance;
	}

	private MSDAspectPlatformManager_MoveExit()
	{
		addAspectEvent(MSDMethods.Terminal_Exit_moveTo);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Exit", "moveTo");
		addAspectEvent(MSDMethods.Exit_Terminal_moveCompleted);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Exit", "Terminal", "moveCompleted");

		addMinimalEvent(MSDMethods.Terminal_Exit_moveTo);
		setHotCut(1,1);
		setLastCut(2,2);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499940130212";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
			case MSDMethods.Terminal_Exit_moveTo:
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_platform,args.get(0));

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
			case MSDMethods.Terminal_Exit_moveTo:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Exit_INST_exit,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Terminal_INST_terminal,null)) 
					&&  this.validateBoundedObject(activeMSD,Terminal_INST_terminal,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Exit_INST_exit,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_platform,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						activeMSD.setLineInstance(Exit_INST_exit,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Terminal_INST_terminal,sourceObject);
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_platform,args.get(0));
						cutChanged=true; activeMSD.setCut(1,1);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_platform,args.get(0)))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Exit_Terminal_moveCompleted:
				if(activeMSD.instancesEquals(Exit_INST_exit,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(1,1))
					{
						cutChanged=true; activeMSD.setCut(2,2);
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
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		int platform = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
		}

		switch (conditionNumber)
		{
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		int platform = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit, null, false );

		int platform = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
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
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	
		if(terminal==null || exit==null){
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

	private void after_Terminal_Exit_moveTo(Object _terminal ,Object _exit, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_Exit_moveTo,
					_terminal,_exit,args);
	}

	private void after_Exit_Terminal_moveCompleted(Object _exit ,Object _terminal)
	{
		changeCutState(MSDMethods.Exit_Terminal_moveCompleted,
					_exit,_terminal,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Exit") && method.equals("moveTo")){
			after_Terminal_Exit_moveTo(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Exit") && tgtClassName.equals("Terminal") && method.equals("moveCompleted")){
			after_Exit_Terminal_moveCompleted(source, target);
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
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		Integer VAR_int_symbolic_var_platform = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			VAR_int_symbolic_var_platform = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
		}

		ArrayList<Object>  args170 = getArgsList(VAR_int_symbolic_var_platform);
		MSDMethod MSDm170 = new MSDMethod(terminal,exit,
			MSDMethods.Terminal_Exit_moveTo,args170,"Terminal:Exit:moveTo",niceName,activeMSD.getGlobalId());// moveTo() Monitored
		MSDMethod MSDm171 = new MSDMethod(exit,terminal,
			MSDMethods.Exit_Terminal_moveCompleted,null,"Exit:Terminal:moveCompleted",niceName,activeMSD.getGlobalId());// moveCompleted() Execute

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm170);
				CV.add(MSDm171);
				return;
		}
		 if(activeMSD.isInCut(1,1))
		{
				if(MSDm171.sourceInstance!=null && MSDm171.targetInstance!=null){
					EE.add(MSDm171);
				}
				HV.add(MSDm170);
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
		if(monitoredObj==null){
			return null;
		}
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

		int platform = 0;
		boolean platformBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
			platformBound=true;
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
	
	private ArrayList<Object> getexit_ExitInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

		int platform = 0;
		boolean platformBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
			platformBound=true;
		}
	
		ArrayList<Object> instances = AppObjects.getObjects("Exit");
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

		int platform = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
			switch (lifelineIndex){
				case Terminal_INST_terminal:
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
				case Exit_INST_exit:
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
