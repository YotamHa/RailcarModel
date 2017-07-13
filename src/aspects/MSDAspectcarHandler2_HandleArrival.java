//  The file MSDAspectcarHandler2_HandleArrival.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectcarHandler2_HandleArrival extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Terminal_INST_terminal = 1;
	static final int PlatformManager_INST_platformManager = 2;
	static final int Entrance_INST_entrance = 3;

	static final int int_arg_int_symbolic_var_number = 0;
	static final int int_arg_int_exact_opaque_platform0 = 1;
	static final int int_arg_int_exact_opaque_platform0Before = 2;
	static final int String_arg_String_symbolic_var_direction = 3;

	static final int int_var_symbolic_minimalDistance = 4;

	private final String niceName = "carHandler2_HandleArrival";

	private static MSDAspectcarHandler2_HandleArrival instance = null;

	public static MSDAspectcarHandler2_HandleArrival getInstance(){
		if(instance==null){
			instance = new MSDAspectcarHandler2_HandleArrival();
		}
		return instance;
	}

	private MSDAspectcarHandler2_HandleArrival()
	{
		addAspectEvent(MSDMethods.Car_Terminal_arriveReq);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Terminal", "arriveReq");
		addAspectEvent(MSDMethods.Terminal_PlatformManager_allocatePlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "allocatePlatform");
		addAspectEvent(MSDMethods.PlatformManager_Terminal_platformAllocated);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "Terminal", "platformAllocated");
		addAspectEvent(MSDMethods.Terminal_Entrance_moveTo);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Entrance", "moveTo");
		addAspectEvent(MSDMethods.Entrance_Terminal_moveCompleted);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Entrance", "Terminal", "moveCompleted");
		addAspectEvent(MSDMethods.Terminal_Car_arriveAck);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "arriveAck");

		addMinimalEvent(MSDMethods.Car_Terminal_arriveReq);
		setHotCut(1,3,2,0);
		setHotCut(1,5,2,2);
		setHotCut(1,1,0,0);
		setLastCut(2,6,2,2);
		numberOfLifeLines = 4;
		numberOfInstances = 4;
		numberOfVariables = 5;
		numberOfTimeTags = 0;
		interactionId = "1499940130297";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
			case MSDMethods.Car_Terminal_arriveReq:
						activeMSD.setPrivateVariable(String_arg_String_symbolic_var_direction,args.get(0));

				break;

			case MSDMethods.PlatformManager_Terminal_platformAllocated:
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_number,args.get(0));

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
			case MSDMethods.Terminal_Car_arriveAck:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(1,5,2,2))
					{
						cutChanged=true; activeMSD.setCut(2,6,2,2);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Entrance_Terminal_moveCompleted:
				if(activeMSD.instancesEquals(Entrance_INST_entrance,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(1,4,2,1))
					{
						cutChanged=true; activeMSD.setCut(1,5,2,2);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_Terminal_platformAllocated:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_number,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,2,1,0))
					{
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_number,args.get(0));
						cutChanged=true; activeMSD.setCut(1,3,2,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_Entrance_moveTo:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_platform0Before,int_arg_int_exact_opaque_platform0,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,3,2,0))
					{
						cutChanged=true; activeMSD.setCut(1,4,2,1);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Terminal_arriveReq:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Terminal_INST_terminal,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Terminal_INST_terminal,targetObject)
					&& activeMSD.symbolicVariableEquals(String_arg_String_symbolic_var_direction,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0))
					{
						activeMSD.setLineInstance(Terminal_INST_terminal,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Car_INST_car,sourceObject);
						activeMSD.setPrivateVariable(String_arg_String_symbolic_var_direction,args.get(0));
						cutChanged=true; activeMSD.setCut(1,1,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.symbolicVariableEquals(String_arg_String_symbolic_var_direction,args.get(0)))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_PlatformManager_allocatePlatform:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(1,1,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,2,1,0);
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
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

		String direction = null;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
		}

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
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
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

		String direction = null;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
		}

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager, null, false );
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance, null, false );

		String direction = null;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
		}

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_platform0, (int)number);
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
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	
		if(car==null || terminal==null || platformManager==null || entrance==null){
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

	private void before_Terminal_Entrance_moveTo(Object _terminal ,Object _entrance, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
			Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);

			String direction = null;
			if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
				direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
			}
	
			int number = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
				number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			}
	
			int platform0 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
				platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_platform0Before, (int)number);
			}catch(Exception e){}
		}
	}
	private void after_Terminal_Entrance_moveTo(Object _terminal ,Object _entrance, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_Entrance_moveTo,
					_terminal,_entrance,args);
	}

	private void after_Car_Terminal_arriveReq(Object _car ,Object _terminal, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Terminal_arriveReq,
					_car,_terminal,args);
	}

	private void after_Terminal_PlatformManager_allocatePlatform(Object _terminal ,Object _platformManager)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_allocatePlatform,
					_terminal,_platformManager,null);
	}

	private void after_PlatformManager_Terminal_platformAllocated(Object _platformManager ,Object _terminal, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_Terminal_platformAllocated,
					_platformManager,_terminal,args);
	}

	private void after_Entrance_Terminal_moveCompleted(Object _entrance ,Object _terminal)
	{
		changeCutState(MSDMethods.Entrance_Terminal_moveCompleted,
					_entrance,_terminal,null);
	}

	private void after_Terminal_Car_arriveAck(Object _terminal ,Object _car)
	{
		changeCutState(MSDMethods.Terminal_Car_arriveAck,
					_terminal,_car,null);
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
		if(srcClassName.equals("Car") && tgtClassName.equals("Terminal") && method.equals("arriveReq")){
			after_Car_Terminal_arriveReq(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("allocatePlatform")){
			after_Terminal_PlatformManager_allocatePlatform(source, target);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("Terminal") && method.equals("platformAllocated")){
			after_PlatformManager_Terminal_platformAllocated(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Entrance") && tgtClassName.equals("Terminal") && method.equals("moveCompleted")){
			after_Entrance_Terminal_moveCompleted(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("arriveAck")){
			after_Terminal_Car_arriveAck(source, target);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Entrance") && method.equals("moveTo")){
			before_Terminal_Entrance_moveTo(source, target, argValues);
			return;
		}
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
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Entrance entrance = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance,null, true);;

		String VAR_String_symbolic_var_direction = null;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			VAR_String_symbolic_var_direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
		}

		Integer VAR_int_symbolic_var_number = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			VAR_int_symbolic_var_number = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		Integer VAR_int_exact_opaque_platform0 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			VAR_int_exact_opaque_platform0 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

		MSDMethod MSDm197 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_arriveAck,null,"Terminal:Car:arriveAck",niceName,activeMSD.getGlobalId());// arriveAck() Execute
		MSDMethod MSDm198 = new MSDMethod(entrance,terminal,
			MSDMethods.Entrance_Terminal_moveCompleted,null,"Entrance:Terminal:moveCompleted",niceName,activeMSD.getGlobalId());// moveCompleted() Monitored
		ArrayList<Object>  args199 = getArgsList(VAR_int_symbolic_var_number);
		MSDMethod MSDm199 = new MSDMethod(platformManager,terminal,
			MSDMethods.PlatformManager_Terminal_platformAllocated,args199,"PlatformManager:Terminal:platformAllocated",niceName,activeMSD.getGlobalId());// platformAllocated() Monitored
		ArrayList<Object>  args200 = getArgsList(VAR_int_exact_opaque_platform0);
		MSDMethod MSDm200 = new MSDMethod(terminal,entrance,
			MSDMethods.Terminal_Entrance_moveTo,args200,"Terminal:Entrance:moveTo",niceName,activeMSD.getGlobalId());// moveTo() Execute
		ArrayList<Object>  args201 = getArgsList(VAR_String_symbolic_var_direction);
		MSDMethod MSDm201 = new MSDMethod(car,terminal,
			MSDMethods.Car_Terminal_arriveReq,args201,"Car:Terminal:arriveReq",niceName,activeMSD.getGlobalId());// arriveReq() Monitored
		MSDMethod MSDm202 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_allocatePlatform,null,"Terminal:PlatformManager:allocatePlatform",niceName,activeMSD.getGlobalId());// allocatePlatform() Execute

		 if(activeMSD.isInCut(0,0,0,0))
		{
				ME.add(MSDm201);
				CV.add(MSDm199,MSDm202,MSDm197,MSDm200,MSDm198);
				return;
		}
		 if(activeMSD.isInCut(1,1,0,0))
		{
				if(MSDm202.sourceInstance!=null && MSDm202.targetInstance!=null){
					EE.add(MSDm202);
				}
				HV.add(MSDm199,MSDm201,MSDm197,MSDm200,MSDm198);
				return;
		}
		 if(activeMSD.isInCut(1,2,1,0))
		{
				ME.add(MSDm199);
				CV.add(MSDm202,MSDm201,MSDm197,MSDm200,MSDm198);
				return;
		}
		 if(activeMSD.isInCut(1,3,2,0))
		{
				if(MSDm200.sourceInstance!=null && MSDm200.targetInstance!=null){
					EE.add(MSDm200);
				}
				HV.add(MSDm199,MSDm202,MSDm201,MSDm197,MSDm198);
				return;
		}
		 if(activeMSD.isInCut(1,4,2,1))
		{
				ME.add(MSDm198);
				CV.add(MSDm199,MSDm202,MSDm201,MSDm197,MSDm200);
				return;
		}
		 if(activeMSD.isInCut(1,5,2,2))
		{
				if(MSDm197.sourceInstance!=null && MSDm197.targetInstance!=null){
					EE.add(MSDm197);
				}
				HV.add(MSDm199,MSDm202,MSDm201,MSDm200,MSDm198);
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
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

		String direction = null;
		boolean directionBound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
			directionBound=true;
		}

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
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
	
	private ArrayList<Object> getterminal_TerminalInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

		String direction = null;
		boolean directionBound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
			directionBound=true;
		}

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
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
	
	private ArrayList<Object> getplatformManager_PlatformManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

		String direction = null;
		boolean directionBound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
			directionBound=true;
		}

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
		}
		if(terminal==null){
			return null;				//not enabled
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
				if(((PlatformManager)inst).getID()==terminal.getID()){
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
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
	

		String direction = null;
		boolean directionBound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
			directionBound=true;
		}

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
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

		String direction = null;
		if(activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction)!=null){
			direction = (String) activeMSD.getPrivateVariable(String_arg_String_symbolic_var_direction);
		}

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
			Entrance entrance = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance);
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
				case PlatformManager_INST_platformManager:
					try{
						result = getplatformManager_PlatformManagerInstances(activeMSD, false, "NONE");
						 
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
				case Entrance_INST_entrance:
					try{
						result = getentrance_EntranceInstances(activeMSD, false, "NONE");
						 
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
