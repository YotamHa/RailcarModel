//  The file MSDAspectPlatformManager_MoveEntrance.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_MoveEntrance extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Terminal_INST_terminal = 0;
	static final int Entrance_INST_entrance = 1;

	static final int int_arg_int_symbolic_var_platform = 0;

	static final int int_var_symbolic_minimalDistance = 1;

	private final String niceName = "PlatformManager_MoveEntrance";

	private static MSDAspectPlatformManager_MoveEntrance instance = null;

	public static MSDAspectPlatformManager_MoveEntrance getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_MoveEntrance();
		}
		return instance;
	}

	private MSDAspectPlatformManager_MoveEntrance()
	{
		addAspectEvent(MSDMethods.Terminal_Entrance_moveTo);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Entrance", "moveTo");
		addAspectEvent(MSDMethods.Entrance_Terminal_moveCompleted);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Entrance", "Terminal", "moveCompleted");

		addMinimalEvent(MSDMethods.Terminal_Entrance_moveTo);
		setHotCut(1,1);
		setLastCut(2,2);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 2;
		numberOfTimeTags = 0;
		interactionId = "1499940130217";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
			case MSDMethods.Terminal_Entrance_moveTo:
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
			case MSDMethods.Entrance_Terminal_moveCompleted:
				if(activeMSD.instancesEquals(Entrance_INST_entrance,sourceObject)
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

			case MSDMethods.Terminal_Entrance_moveTo:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Entrance_INST_entrance,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Terminal_INST_terminal,null)) 
					&&  this.validateBoundedObject(activeMSD,Terminal_INST_terminal,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Entrance_INST_entrance,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_platform,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						activeMSD.setLineInstance(Entrance_INST_entrance,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Terminal_INST_terminal,sourceObject);
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_platform,args.get(0));
						cutChanged=true; activeMSD.setCut(1,1);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_platform,args.get(0)))
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
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

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
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

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
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance, null, false );

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
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	
		if(terminal==null || entrance==null){
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

	private void after_Terminal_Entrance_moveTo(Object _terminal ,Object _entrance, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_Entrance_moveTo,
					_terminal,_entrance,args);
	}

	private void after_Entrance_Terminal_moveCompleted(Object _entrance ,Object _terminal)
	{
		changeCutState(MSDMethods.Entrance_Terminal_moveCompleted,
					_entrance,_terminal,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Entrance") && method.equals("moveTo")){
			after_Terminal_Entrance_moveTo(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Entrance") && tgtClassName.equals("Terminal") && method.equals("moveCompleted")){
			after_Entrance_Terminal_moveCompleted(source, target);
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
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

		Integer VAR_int_symbolic_var_platform = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			VAR_int_symbolic_var_platform = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
		}

		MSDMethod MSDm172 = new MSDMethod(entrance,terminal,
			MSDMethods.Entrance_Terminal_moveCompleted,null,"Entrance:Terminal:moveCompleted",niceName,activeMSD.getGlobalId());// moveCompleted() Execute
		ArrayList<Object>  args173 = getArgsList(VAR_int_symbolic_var_platform);
		MSDMethod MSDm173 = new MSDMethod(terminal,entrance,
			MSDMethods.Terminal_Entrance_moveTo,args173,"Terminal:Entrance:moveTo",niceName,activeMSD.getGlobalId());// moveTo() Monitored

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm173);
				CV.add(MSDm172);
				return;
		}
		 if(activeMSD.isInCut(1,1))
		{
				if(MSDm172.sourceInstance!=null && MSDm172.targetInstance!=null){
					EE.add(MSDm172);
				}
				HV.add(MSDm173);
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
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

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
	
	private ArrayList<Object> getentrance_EntranceInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

		int platform = 0;
		boolean platformBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform)!=null){
			platform = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_platform);
			platformBound=true;
		}
	
		ArrayList<Object> instances = AppObjects.getObjects("Entrance");
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
			Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
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
				case Entrance_INST_entrance:
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
