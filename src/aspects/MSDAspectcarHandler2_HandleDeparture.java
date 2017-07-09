//  The file MSDAspectcarHandler2_HandleDeparture.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectcarHandler2_HandleDeparture extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Terminal_INST_terminal = 1;
	static final int ExitsManager_INST_existsManager = 2;
	static final int Exit_INST_exit = 3;

	static final int int_arg_int_exact_opaque_platform0 = 0;
	static final int int_arg_int_exact_opaque_platform0Before = 1;

	static final int int_var_symbolic_minimalDistance = 2;

	private final String niceName = "carHandler2_HandleDeparture";

	private static MSDAspectcarHandler2_HandleDeparture instance = null;

	public static MSDAspectcarHandler2_HandleDeparture getInstance(){
		if(instance==null){
			instance = new MSDAspectcarHandler2_HandleDeparture();
		}
		return instance;
	}

	private MSDAspectcarHandler2_HandleDeparture()
	{
		addAspectEvent(MSDMethods.Car_Terminal_departReq);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Terminal", "departReq");
		addAspectEvent(MSDMethods.Terminal_ExitsManager_allocateExit1);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "ExitsManager", "allocateExit1");
		addAspectEvent(MSDMethods.Terminal_ExitsManager_allocateExit2);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "ExitsManager", "allocateExit2");
		addAspectEvent(MSDMethods.Terminal_ExitsManager_allocateExit3);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "ExitsManager", "allocateExit3");
		addAspectEvent(MSDMethods.Terminal_ExitsManager_allocateExit4);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "ExitsManager", "allocateExit4");
		addAspectEvent(MSDMethods.Exit_Exit_blank);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Exit", "Exit", "blank");
		addAspectEvent(MSDMethods.Terminal_Exit_moveTo);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Exit", "moveTo");
		addAspectEvent(MSDMethods.Exit_Terminal_moveCompleted);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Exit", "Terminal", "moveCompleted");
		addAspectEvent(MSDMethods.Terminal_Car_departAck);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "departAck");

		addMinimalEvent(MSDMethods.Car_Terminal_departReq);
		setHotCut(7,11,10,7);
		setHotCut(7,13,10,9);
		setHotCut(6,10,9,5);
		setHotCut(2,2,1,1);
		setHotCut(4,6,5,3);
		setHotCut(5,8,7,4);
		setHotCut(3,4,3,2);
		addOperCut("car.platform == 3",4,6,5,3);
		addOperCut("car.platform == 3",4,7,6,3);
		addOperCut("existsManager.platformHandling == car.platform",7,11,10,7);
		addOperCut("existsManager.platformHandling == car.platform",7,12,10,8);
		addOperCut("existsManager.platformHandling == car.platform",7,13,10,9);
		addOperCut("existsManager.platformHandling == car.platform",8,14,10,9);
		addOperCut("existsManager.platformHandling == car.platform",7,11,10,7);
		addOperCut("existsManager.platformHandling == car.platform",7,12,10,8);
		addOperCut("existsManager.platformHandling == car.platform",7,13,10,9);
		addOperCut("existsManager.platformHandling == car.platform",8,14,10,9);
		addOperCut("existsManager.platformHandling == car.platform",7,11,10,7);
		addOperCut("existsManager.platformHandling == car.platform",7,12,10,8);
		addOperCut("existsManager.platformHandling == car.platform",7,13,10,9);
		addOperCut("existsManager.platformHandling == car.platform",8,14,10,9);
		addOperCut("existsManager.platformHandling == car.platform",7,11,10,7);
		addOperCut("existsManager.platformHandling == car.platform",7,12,10,8);
		addOperCut("existsManager.platformHandling == car.platform",7,13,10,9);
		addOperCut("existsManager.platformHandling == car.platform",8,14,10,9);
		addOperCut("car.platform == 1",2,2,1,1);
		addOperCut("car.platform == 1",2,3,2,1);
		addOperCut("car.platform == 2",3,4,3,2);
		addOperCut("car.platform == 2",3,5,4,2);
		addOperCut("car.platform == 4",5,8,7,4);
		addOperCut("car.platform == 4",5,9,8,4);
		setLastCut(9,15,11,10);
		numberOfLifeLines = 4;
		numberOfInstances = 4;
		numberOfVariables = 3;
		numberOfTimeTags = 0;
		interactionId = "1499586852542";
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
			case MSDMethods.Terminal_ExitsManager_allocateExit3:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(4,6,5,3))
					{
						cutChanged=true; activeMSD.setCut(4,7,6,3);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10,9,5);
							return cutChanged;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10,9,5);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_Exit_moveTo:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_platform0Before,int_arg_int_exact_opaque_platform0,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(7,11,10,7))
					{
						cutChanged=true; activeMSD.setCut(7,12,10,8);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_ExitsManager_allocateExit4:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(5,8,7,4))
					{
						cutChanged=true; activeMSD.setCut(5,9,8,4);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10,9,5);
							return cutChanged;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10,9,5);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_ExitsManager_allocateExit1:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(2,2,1,1))
					{
						cutChanged=true; activeMSD.setCut(2,3,2,1);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10,9,5);
							return cutChanged;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10,9,5);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_ExitsManager_allocateExit2:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(3,4,3,2))
					{
						cutChanged=true; activeMSD.setCut(3,5,4,2);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10,9,5);
							return cutChanged;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10,9,5);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Terminal_departReq:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Terminal_INST_terminal,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Terminal_INST_terminal,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0))
					{
						activeMSD.setLineInstance(Terminal_INST_terminal,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Car_INST_car,sourceObject);
						cutChanged=true; activeMSD.setCut(1,1,0,0);
						if(evaluateCondition(1,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(2,2,1,1);
							return cutChanged;
						}
						if(evaluateCondition(2,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(3,4,3,2);
							return cutChanged;
						}
						if(evaluateCondition(3,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(4,6,5,3);
							return cutChanged;
						}
						if(evaluateCondition(4,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(5,8,7,4);
							return cutChanged;
						}
						cutChanged=true; activeMSD.setCut(6,10,9,5);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Exit_Exit_blank:
				if(activeMSD.instancesEquals(Exit_INST_exit,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(6,10,9,5))
					{
						cutChanged=true; activeMSD.setCut(6,10,9,6);
						if(evaluateCondition(14,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(7,11,10,7);
							return cutChanged;
						}
						cutChanged=true; activeMSD.setCut(9,15,11,10);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Exit_Terminal_moveCompleted:
				if(activeMSD.instancesEquals(Exit_INST_exit,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(7,12,10,8))
					{
						cutChanged=true; activeMSD.setCut(7,13,10,9);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_Car_departAck:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(7,13,10,9))
					{
						cutChanged=true; activeMSD.setCut(8,14,10,9);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(9,15,11,10);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(9,15,11,10);
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
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

		switch (conditionNumber)
		{
			case 1: 
				return car.getPlatform()==1;
			case 2: 
				return car.getPlatform()==2;
			case 3: 
				return car.getPlatform()==3;
			case 4: 
				return car.getPlatform()==4;
			case 6: 
				return true;
			case 14: 
				return existsManager.getPlatformHandling()==car.getPlatform();
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("2,2,1,1" , "car.platform == 1");
		this.setExpressionForCut("6,10,9,5" , "SYNC");
		this.setExpressionForCut("7,11,10,7" , "existsManager.platformHandling == car.platform");
		this.setExpressionForCut("4,6,5,3" , "car.platform == 3");
		this.setExpressionForCut("9,15,11,10" , "SYNC");
		this.setExpressionForCut("3,4,3,2" , "car.platform == 2");
		this.setExpressionForCut("5,8,7,4" , "car.platform == 4");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager, null, false );
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit, null, false );

		int platform0 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_platform0, (int)car.getPlatform());
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
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	
		if(car==null || terminal==null || existsManager==null || exit==null){
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

	private void before_Terminal_Exit_moveTo(Object _terminal ,Object _exit, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
			Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);

			int platform0 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
				platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_platform0Before, (int)car.getPlatform());
			}catch(Exception e){}
		}
	}
	private void after_Terminal_Exit_moveTo(Object _terminal ,Object _exit, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_Exit_moveTo,
					_terminal,_exit,args);
	}

	private void after_Car_Terminal_departReq(Object _car ,Object _terminal)
	{
		changeCutState(MSDMethods.Car_Terminal_departReq,
					_car,_terminal,null);
	}

	private void after_Terminal_ExitsManager_allocateExit1(Object _terminal ,Object _existsManager)
	{
		changeCutState(MSDMethods.Terminal_ExitsManager_allocateExit1,
					_terminal,_existsManager,null);
	}

	private void after_Terminal_ExitsManager_allocateExit2(Object _terminal ,Object _existsManager)
	{
		changeCutState(MSDMethods.Terminal_ExitsManager_allocateExit2,
					_terminal,_existsManager,null);
	}

	private void after_Terminal_ExitsManager_allocateExit3(Object _terminal ,Object _existsManager)
	{
		changeCutState(MSDMethods.Terminal_ExitsManager_allocateExit3,
					_terminal,_existsManager,null);
	}

	private void after_Terminal_ExitsManager_allocateExit4(Object _terminal ,Object _existsManager)
	{
		changeCutState(MSDMethods.Terminal_ExitsManager_allocateExit4,
					_terminal,_existsManager,null);
	}

	private void after_Exit_Exit_blank(Object _exitSource ,Object _exit)
	{
		changeCutState(MSDMethods.Exit_Exit_blank,
					_exit,_exit,null);
	}

	private void after_Exit_Terminal_moveCompleted(Object _exit ,Object _terminal)
	{
		changeCutState(MSDMethods.Exit_Terminal_moveCompleted,
					_exit,_terminal,null);
	}

	private void after_Terminal_Car_departAck(Object _terminal ,Object _car)
	{
		changeCutState(MSDMethods.Terminal_Car_departAck,
					_terminal,_car,null);
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
		if(srcClassName.equals("Car") && tgtClassName.equals("Terminal") && method.equals("departReq")){
			after_Car_Terminal_departReq(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("ExitsManager") && method.equals("allocateExit1")){
			after_Terminal_ExitsManager_allocateExit1(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("ExitsManager") && method.equals("allocateExit2")){
			after_Terminal_ExitsManager_allocateExit2(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("ExitsManager") && method.equals("allocateExit3")){
			after_Terminal_ExitsManager_allocateExit3(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("ExitsManager") && method.equals("allocateExit4")){
			after_Terminal_ExitsManager_allocateExit4(source, target);
			return;
		}
		if(srcClassName.equals("Exit") && tgtClassName.equals("Exit") && method.equals("blank")){
			after_Exit_Exit_blank(source, target);
			return;
		}
		if(srcClassName.equals("Exit") && tgtClassName.equals("Terminal") && method.equals("moveCompleted")){
			after_Exit_Terminal_moveCompleted(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("departAck")){
			after_Terminal_Car_departAck(source, target);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Exit") && method.equals("moveTo")){
			before_Terminal_Exit_moveTo(source, target, argValues);
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
		ExitsManager existsManager = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager,null, true);;
		Exit exit = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit,null, true);;

		Integer VAR_int_exact_opaque_platform0 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			VAR_int_exact_opaque_platform0 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
		}

		MSDMethod MSDm185 = new MSDMethod(terminal,existsManager,
			MSDMethods.Terminal_ExitsManager_allocateExit3,null,"Terminal:ExitsManager:allocateExit3",niceName,activeMSD.getGlobalId());// allocateExit3() Execute
		ArrayList<Object>  args186 = getArgsList(VAR_int_exact_opaque_platform0);
		MSDMethod MSDm186 = new MSDMethod(terminal,exit,
			MSDMethods.Terminal_Exit_moveTo,args186,"Terminal:Exit:moveTo",niceName,activeMSD.getGlobalId());// moveTo() Execute
		MSDMethod MSDm187 = new MSDMethod(terminal,existsManager,
			MSDMethods.Terminal_ExitsManager_allocateExit4,null,"Terminal:ExitsManager:allocateExit4",niceName,activeMSD.getGlobalId());// allocateExit4() Execute
		MSDMethod MSDm188 = new MSDMethod(terminal,existsManager,
			MSDMethods.Terminal_ExitsManager_allocateExit1,null,"Terminal:ExitsManager:allocateExit1",niceName,activeMSD.getGlobalId());// allocateExit1() Execute
		MSDMethod MSDm189 = new MSDMethod(terminal,existsManager,
			MSDMethods.Terminal_ExitsManager_allocateExit2,null,"Terminal:ExitsManager:allocateExit2",niceName,activeMSD.getGlobalId());// allocateExit2() Execute
		MSDMethod MSDm190 = new MSDMethod(car,terminal,
			MSDMethods.Car_Terminal_departReq,null,"Car:Terminal:departReq",niceName,activeMSD.getGlobalId());// departReq() Monitored
		MSDMethod MSDm191 = new MSDMethod(exit,exit,
			MSDMethods.Exit_Exit_blank,null,"Exit:Exit:blank",niceName,activeMSD.getGlobalId());// blank() Execute
		MSDMethod MSDm192 = new MSDMethod(exit,terminal,
			MSDMethods.Exit_Terminal_moveCompleted,null,"Exit:Terminal:moveCompleted",niceName,activeMSD.getGlobalId());// moveCompleted() Monitored
		MSDMethod MSDm193 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_departAck,null,"Terminal:Car:departAck",niceName,activeMSD.getGlobalId());// departAck() Execute

		 if(activeMSD.isInCut(0,0,0,0))
		{
				ME.add(MSDm190);
				CV.add(MSDm186,MSDm185,MSDm187,MSDm188,MSDm189,MSDm193,MSDm191,MSDm192);
				return;
		}
		 if(activeMSD.isInCut(2,2,1,1))
		{
				if(MSDm188.sourceInstance!=null && MSDm188.targetInstance!=null){
					EE.add(MSDm188);
				}
				HV.add(MSDm186,MSDm185,MSDm187,MSDm189,MSDm193,MSDm191,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(3,4,3,2))
		{
				if(MSDm189.sourceInstance!=null && MSDm189.targetInstance!=null){
					EE.add(MSDm189);
				}
				HV.add(MSDm186,MSDm185,MSDm187,MSDm188,MSDm193,MSDm191,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(4,6,5,3))
		{
				if(MSDm185.sourceInstance!=null && MSDm185.targetInstance!=null){
					EE.add(MSDm185);
				}
				HV.add(MSDm186,MSDm187,MSDm188,MSDm189,MSDm193,MSDm191,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(5,8,7,4))
		{
				if(MSDm187.sourceInstance!=null && MSDm187.targetInstance!=null){
					EE.add(MSDm187);
				}
				HV.add(MSDm186,MSDm185,MSDm188,MSDm189,MSDm193,MSDm191,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(6,10,9,5))
		{
				if(MSDm191.sourceInstance!=null && MSDm191.targetInstance!=null){
					EE.add(MSDm191);
				}
				HV.add(MSDm186,MSDm185,MSDm187,MSDm188,MSDm189,MSDm193,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(7,11,10,7))
		{
				if(MSDm186.sourceInstance!=null && MSDm186.targetInstance!=null){
					EE.add(MSDm186);
				}
				HV.add(MSDm185,MSDm187,MSDm188,MSDm189,MSDm193,MSDm191,MSDm192,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(7,12,10,8))
		{
				ME.add(MSDm192);
				CV.add(MSDm186,MSDm185,MSDm187,MSDm188,MSDm189,MSDm193,MSDm191,MSDm190);
				return;
		}
		 if(activeMSD.isInCut(7,13,10,9))
		{
				if(MSDm193.sourceInstance!=null && MSDm193.targetInstance!=null){
					EE.add(MSDm193);
				}
				HV.add(MSDm186,MSDm185,MSDm187,MSDm188,MSDm189,MSDm191,MSDm192,MSDm190);
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
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

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
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

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
	
	private ArrayList<Object> getexistsManager_ExitsManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
		}
		if(terminal==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("ExitsManager");
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
				if(((ExitsManager)inst).getID()==terminal.getID()){
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
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
		Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
	

		int platform0 = 0;
		boolean platform0Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0)!=null){
			platform0 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_platform0);
			platform0Bound=true;
		}
		if(car==null ||terminal==null){
			return null;				//not enabled
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
				if(((Exit)inst).getDirection().equals(car.getDirection()) && ((Exit)inst).getID()==terminal.getID()){
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
			ExitsManager existsManager = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager);
			Exit exit = (Exit) activeMSD.getLineInstance(Exit_INST_exit);
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
				case ExitsManager_INST_existsManager:
					try{
						result = getexistsManager_ExitsManagerInstances(activeMSD, false, "NONE");
						 
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
				case Exit_INST_exit:
					try{
						result = getexit_ExitInstances(activeMSD, false, "NONE");
						 
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
