//  The file MSDAspectPlatformManager_AllocatePlatform.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_AllocatePlatform extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int PlatformManager_INST_platformManager = 0;
	static final int Terminal_INST_terminal = 1;

	static final int int_arg_int_exact_int_number1 = 0;
	static final int int_arg_int_symbolic_var_number = 1;
	static final int int_arg_int_exact_int_number3 = 2;
	static final int int_arg_int_exact_int_number5 = 3;
	static final int boolean_arg_boolean_exact_boolean_arg00 = 4;
	static final int boolean_arg_boolean_exact_boolean_arg02 = 5;
	static final int boolean_arg_boolean_exact_boolean_arg04 = 6;
	static final int boolean_arg_boolean_exact_boolean_arg06 = 7;

	static final int int_var_symbolic_minimalDistance = 8;

	private final String niceName = "PlatformManager_AllocatePlatform";

	private static MSDAspectPlatformManager_AllocatePlatform instance = null;

	public static MSDAspectPlatformManager_AllocatePlatform getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_AllocatePlatform();
		}
		return instance;
	}

	private MSDAspectPlatformManager_AllocatePlatform()
	{
		addAspectEvent(MSDMethods.Terminal_PlatformManager_allocatePlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "allocatePlatform");
		addAspectEvent(MSDMethods.Terminal_PlatformManager_setPlatform1busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "setPlatform1busy");
		addAspectEvent(MSDMethods.PlatformManager_Terminal_platformAllocated);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"PlatformManager", "Terminal", "platformAllocated");
		addAspectEvent(MSDMethods.Terminal_PlatformManager_setPlatform2busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "setPlatform2busy");
		addAspectEvent(MSDMethods.Terminal_PlatformManager_setPlatform3busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "setPlatform3busy");
		addAspectEvent(MSDMethods.Terminal_PlatformManager_setPlatform4busy);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "PlatformManager", "setPlatform4busy");

		addMinimalEvent(MSDMethods.Terminal_PlatformManager_allocatePlatform);
		setHotCut(9,9);
		setHotCut(7,7);
		setHotCut(13,13);
		setHotCut(3,3);
		setHotCut(12,12);
		setHotCut(4,4);
		setHotCut(10,10);
		setHotCut(6,6);
		addOperCut("platformManager.platform4busy == false",12,12);
		addOperCut("platformManager.platform4busy == false",13,13);
		addOperCut("platformManager.platform4busy == false",14,14);
		addOperCut("platformManager.platform2busy == false",6,6);
		addOperCut("platformManager.platform2busy == false",7,7);
		addOperCut("platformManager.platform2busy == false",8,8);
		addOperCut("platformManager.platform3busy == false",9,9);
		addOperCut("platformManager.platform3busy == false",10,10);
		addOperCut("platformManager.platform3busy == false",11,11);
		addOperCut("platformManager.platform1busy == false",3,3);
		addOperCut("platformManager.platform1busy == false",4,4);
		addOperCut("platformManager.platform1busy == false",5,5);
		setLastCut(15,15);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 9;
		numberOfTimeTags = 0;
		interactionId = "1499586852427";
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
			case MSDMethods.Terminal_PlatformManager_setPlatform3busy:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg04,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(9,9))
					{
						cutChanged=true; activeMSD.setCut(10,10);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_PlatformManager_setPlatform2busy:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(6,6))
					{
						cutChanged=true; activeMSD.setCut(7,7);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_PlatformManager_setPlatform4busy:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg06,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(12,12))
					{
						cutChanged=true; activeMSD.setCut(13,13);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_PlatformManager_setPlatform1busy:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,3))
					{
						cutChanged=true; activeMSD.setCut(4,4);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_Terminal_platformAllocated:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_number3,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(7,7))
					{
						cutChanged=true; activeMSD.setCut(8,8);
						if(evaluateCondition(8,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(15,15);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(15,15);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_number5,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(10,10))
					{
						cutChanged=true; activeMSD.setCut(11,11);
						if(evaluateCondition(8,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(15,15);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(15,15);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_number,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(13,13))
					{
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_number,args.get(0));
						cutChanged=true; activeMSD.setCut(14,14);
						if(evaluateCondition(8,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(15,15);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(15,15);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_number1,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,4))
					{
						cutChanged=true; activeMSD.setCut(5,5);
						if(evaluateCondition(8,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(15,15);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(15,15);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_PlatformManager_allocatePlatform:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(PlatformManager_INST_platformManager,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Terminal_INST_terminal,null)) 
					&&  this.validateBoundedObject(activeMSD,Terminal_INST_terminal,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						activeMSD.setLineInstance(PlatformManager_INST_platformManager,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Terminal_INST_terminal,sourceObject);
						cutChanged=true; activeMSD.setCut(1,1);
						if(evaluateCondition(1,activeMSD))
						{
							activeMSD.notWaitingForCond(1); //out of wait condition
							cutChanged=true; activeMSD.setCut(2,2);
							cutChanged=true; activeMSD.setCut(2,2);
							if(evaluateCondition(2,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(3,3);
								return cutChanged;
							}
							if(evaluateCondition(3,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(6,6);
								return cutChanged;
							}
							if(evaluateCondition(4,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(9,9);
								return cutChanged;
							}
							if(evaluateCondition(5,activeMSD))
							{
								cutChanged=true; activeMSD.setCut(12,12);
								return cutChanged;
							}
							cutChanged=true; activeMSD.setCut(15,15);
							break;
						}
						activeMSD.setWaitingForCond(1); //in wait condition
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject))
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
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		boolean arg04 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
		}

		boolean arg06 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
		}

		int number5 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
		}

		int number3 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
		}

		int number1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
		}


		boolean platform1busy = false;
		
		if(platformManager!=null){
			platform1busy=platformManager.isPlatform1busy();
		}

		boolean platform2busy = false;
		
		if(platformManager!=null){
			platform2busy=platformManager.isPlatform2busy();
		}

		boolean platform3busy = false;
		
		if(platformManager!=null){
			platform3busy=platformManager.isPlatform3busy();
		}

		boolean platform4busy = false;
		
		if(platformManager!=null){
			platform4busy=platformManager.isPlatform4busy();
		}
		switch (conditionNumber)
		{
			case 1: 
				return platformManager.getPlatform1busy()==false||platformManager.getPlatform2busy()==false||platformManager.getPlatform3busy()==false||platformManager.getPlatform4busy()==false;
			case 2: 
				return platformManager.getPlatform1busy()==false;
			case 3: 
				return platformManager.getPlatform2busy()==false;
			case 4: 
				return platformManager.getPlatform3busy()==false;
			case 5: 
				return platformManager.getPlatform4busy()==false;
			case 8: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		boolean arg04 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
		}

		boolean arg06 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
		}

		int number5 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
		}

		int number3 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
		}

		int number1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
		}


		boolean platform1busy = false;
		
		if(platformManager!=null){
			platform1busy=platformManager.isPlatform1busy();
		}

		boolean platform2busy = false;
		
		if(platformManager!=null){
			platform2busy=platformManager.isPlatform2busy();
		}

		boolean platform3busy = false;
		
		if(platformManager!=null){
			platform3busy=platformManager.isPlatform3busy();
		}

		boolean platform4busy = false;
		
		if(platformManager!=null){
			platform4busy=platformManager.isPlatform4busy();
		}
	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("6,6" , "platformManager.platform2busy == false");
		this.setExpressionForCut("12,12" , "platformManager.platform4busy == false");
		this.setExpressionForCut("9,9" , "platformManager.platform3busy == false");
		this.setExpressionForCut("15,15" , "SYNC");
		this.setExpressionForCut("2,2" , "wait: platformManager.getPlatform1busy()==false||platformManager.getPlatform2busy()==false||platformManager.getPlatform3busy()==false||platformManager.getPlatform4busy()==false");
		this.setExpressionForCut("3,3" , "platformManager.platform1busy == false");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		boolean arg04 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
		}

		boolean arg06 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
		}

		int number5 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
		}

		int number3 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
		}

		int number1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_number1, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_number3, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_number5, (int)3);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg00, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg02, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg04, (boolean)true);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg06, (boolean)true);
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
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	
		if(platformManager==null || terminal==null){
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

	private void after_Terminal_PlatformManager_allocatePlatform(Object _terminal ,Object _platformManager)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_allocatePlatform,
					_terminal,_platformManager,null);
	}

	private void after_Terminal_PlatformManager_setPlatform1busy(Object _terminal ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_setPlatform1busy,
					_terminal,_platformManager,args);
	}

	private void after_PlatformManager_Terminal_platformAllocated(Object _platformManager ,Object _terminal, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_Terminal_platformAllocated,
					_platformManager,_terminal,args);
	}

	private void after_Terminal_PlatformManager_setPlatform2busy(Object _terminal ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_setPlatform2busy,
					_terminal,_platformManager,args);
	}

	private void after_Terminal_PlatformManager_setPlatform3busy(Object _terminal ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_setPlatform3busy,
					_terminal,_platformManager,args);
	}

	private void after_Terminal_PlatformManager_setPlatform4busy(Object _terminal ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Terminal_PlatformManager_setPlatform4busy,
					_terminal,_platformManager,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("allocatePlatform")){
			after_Terminal_PlatformManager_allocatePlatform(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform1busy")){
			after_Terminal_PlatformManager_setPlatform1busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("PlatformManager") && tgtClassName.equals("Terminal") && method.equals("platformAllocated")){
			after_PlatformManager_Terminal_platformAllocated(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform2busy")){
			after_Terminal_PlatformManager_setPlatform2busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform3busy")){
			after_Terminal_PlatformManager_setPlatform3busy(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("PlatformManager") && method.equals("setPlatform4busy")){
			after_Terminal_PlatformManager_setPlatform4busy(source, target, argValues);
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


	private void evalTrueWaitCond1(ActiveMSDAspect activeMSD){
							activeMSD.notWaitingForCond(1); //out of wait condition
							activeMSD.setCut(2,2);
							activeMSD.setCut(2,2);
							if(evaluateCondition(2,activeMSD))
							{
								activeMSD.setCut(3,3);
								return;
							}
							if(evaluateCondition(3,activeMSD))
							{
								activeMSD.setCut(6,6);
								return;
							}
							if(evaluateCondition(4,activeMSD))
							{
								activeMSD.setCut(9,9);
								return;
							}
							if(evaluateCondition(5,activeMSD))
							{
								activeMSD.setCut(12,12);
								return;
							}
							activeMSD.setCut(15,15);
							return;
	}

	protected void  evaluateWaitConditions(ActiveMSDAspect activeMSD)
	{
		for(Integer cond:activeMSD.getWaitingConditions()){
			switch(cond)
			{
				case 1:
					if(evaluateCondition(1,activeMSD))
					{
						evalTrueWaitCond1(activeMSD);

						setUpToDate(false);
						MSDCoordinatorAspect.getInstance().coordinate(null);
						closeActiveCopies();
					}
					break;
			}
		}
	}

	protected void getActiveMSDCutState(MSDMethodSet ME,MSDMethodSet EE,
			MSDMethodSet CV,MSDMethodSet HV,ActiveMSDAspect activeMSD)
	{
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;

		Integer VAR_int_symbolic_var_number = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			VAR_int_symbolic_var_number = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		Boolean VAR_boolean_exact_boolean_arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			VAR_boolean_exact_boolean_arg00 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		Boolean VAR_boolean_exact_boolean_arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			VAR_boolean_exact_boolean_arg02 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		Boolean VAR_boolean_exact_boolean_arg04 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			VAR_boolean_exact_boolean_arg04 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
		}

		Boolean VAR_boolean_exact_boolean_arg06 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			VAR_boolean_exact_boolean_arg06 = (Boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
		}

		Integer VAR_int_exact_int_number5 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			VAR_int_exact_int_number5 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
		}

		Integer VAR_int_exact_int_number3 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			VAR_int_exact_int_number3 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
		}

		Integer VAR_int_exact_int_number1 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			VAR_int_exact_int_number1 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
		}

		ArrayList<Object>  args151 = getArgsList(VAR_boolean_exact_boolean_arg04);
		MSDMethod MSDm151 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_setPlatform3busy,args151,"Terminal:PlatformManager:setPlatform3busy",niceName,activeMSD.getGlobalId());// setPlatform3busy() Execute
		ArrayList<Object>  args152 = getArgsList(VAR_boolean_exact_boolean_arg02);
		MSDMethod MSDm152 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_setPlatform2busy,args152,"Terminal:PlatformManager:setPlatform2busy",niceName,activeMSD.getGlobalId());// setPlatform2busy() Execute
		ArrayList<Object>  args153 = getArgsList(VAR_boolean_exact_boolean_arg06);
		MSDMethod MSDm153 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_setPlatform4busy,args153,"Terminal:PlatformManager:setPlatform4busy",niceName,activeMSD.getGlobalId());// setPlatform4busy() Execute
		ArrayList<Object>  args154 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm154 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_setPlatform1busy,args154,"Terminal:PlatformManager:setPlatform1busy",niceName,activeMSD.getGlobalId());// setPlatform1busy() Execute
		ArrayList<Object>  args155 = getArgsList(VAR_int_exact_int_number3);
		MSDMethod MSDm155 = new MSDMethod(platformManager,terminal,
			MSDMethods.PlatformManager_Terminal_platformAllocated,args155,"PlatformManager:Terminal:platformAllocated",niceName,activeMSD.getGlobalId());// platformAllocated() Execute
		ArrayList<Object>  args156 = getArgsList(VAR_int_exact_int_number5);
		MSDMethod MSDm156 = new MSDMethod(platformManager,terminal,
			MSDMethods.PlatformManager_Terminal_platformAllocated,args156,"PlatformManager:Terminal:platformAllocated",niceName,activeMSD.getGlobalId());// platformAllocated() Execute
		ArrayList<Object>  args157 = getArgsList(VAR_int_symbolic_var_number);
		MSDMethod MSDm157 = new MSDMethod(platformManager,terminal,
			MSDMethods.PlatformManager_Terminal_platformAllocated,args157,"PlatformManager:Terminal:platformAllocated",niceName,activeMSD.getGlobalId());// platformAllocated() Execute
		ArrayList<Object>  args158 = getArgsList(VAR_int_exact_int_number1);
		MSDMethod MSDm158 = new MSDMethod(platformManager,terminal,
			MSDMethods.PlatformManager_Terminal_platformAllocated,args158,"PlatformManager:Terminal:platformAllocated",niceName,activeMSD.getGlobalId());// platformAllocated() Execute
		MSDMethod MSDm159 = new MSDMethod(terminal,platformManager,
			MSDMethods.Terminal_PlatformManager_allocatePlatform,null,"Terminal:PlatformManager:allocatePlatform",niceName,activeMSD.getGlobalId());// allocatePlatform() Monitored

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm159);
				CV.add(MSDm155,MSDm156,MSDm157,MSDm158,MSDm153,MSDm152,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(3,3))
		{
				if(MSDm154.sourceInstance!=null && MSDm154.targetInstance!=null){
					EE.add(MSDm154);
				}
				HV.add(MSDm155,MSDm156,MSDm157,MSDm158,MSDm153,MSDm152,MSDm159,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(4,4))
		{
				if(MSDm158.sourceInstance!=null && MSDm158.targetInstance!=null){
					EE.add(MSDm158);
				}
				HV.add(MSDm153,MSDm152,MSDm159,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(6,6))
		{
				if(MSDm152.sourceInstance!=null && MSDm152.targetInstance!=null){
					EE.add(MSDm152);
				}
				HV.add(MSDm155,MSDm156,MSDm157,MSDm158,MSDm153,MSDm159,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(7,7))
		{
				if(MSDm155.sourceInstance!=null && MSDm155.targetInstance!=null){
					EE.add(MSDm155);
				}
				HV.add(MSDm153,MSDm152,MSDm159,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(9,9))
		{
				if(MSDm151.sourceInstance!=null && MSDm151.targetInstance!=null){
					EE.add(MSDm151);
				}
				HV.add(MSDm155,MSDm156,MSDm157,MSDm158,MSDm153,MSDm152,MSDm159,MSDm154);
				return;
		}
		 if(activeMSD.isInCut(10,10))
		{
				if(MSDm156.sourceInstance!=null && MSDm156.targetInstance!=null){
					EE.add(MSDm156);
				}
				HV.add(MSDm153,MSDm152,MSDm159,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(12,12))
		{
				if(MSDm153.sourceInstance!=null && MSDm153.targetInstance!=null){
					EE.add(MSDm153);
				}
				HV.add(MSDm155,MSDm156,MSDm157,MSDm158,MSDm152,MSDm159,MSDm154,MSDm151);
				return;
		}
		 if(activeMSD.isInCut(13,13))
		{
				if(MSDm157.sourceInstance!=null && MSDm157.targetInstance!=null){
					EE.add(MSDm157);
				}
				HV.add(MSDm153,MSDm152,MSDm159,MSDm154,MSDm151);
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
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
		}

		boolean arg02 = false;
		boolean arg02Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
			arg02Bound=true;
		}

		boolean arg04 = false;
		boolean arg04Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
			arg04Bound=true;
		}

		boolean arg06 = false;
		boolean arg06Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
			arg06Bound=true;
		}

		int number5 = 0;
		boolean number5Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
			number5Bound=true;
		}

		int number3 = 0;
		boolean number3Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
			number3Bound=true;
		}

		int number1 = 0;
		boolean number1Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
			number1Bound=true;
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
	
	private ArrayList<Object> getterminal_TerminalInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	

		int number = 0;
		boolean numberBound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
			numberBound=true;
		}

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
		}

		boolean arg02 = false;
		boolean arg02Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
			arg02Bound=true;
		}

		boolean arg04 = false;
		boolean arg04Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
			arg04Bound=true;
		}

		boolean arg06 = false;
		boolean arg06Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
			arg06Bound=true;
		}

		int number5 = 0;
		boolean number5Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
			number5Bound=true;
		}

		int number3 = 0;
		boolean number3Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
			number3Bound=true;
		}

		int number1 = 0;
		boolean number1Bound=false;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
			number1Bound=true;
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
	
	@SuppressWarnings("unused")
	public Object bindObjectByExpression (ActiveMSDAspect activeMSD,int lifelineIndex, 
			Object obj, boolean retrieveOnly){

		int number = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number)!=null){
			number = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_number);
		}

		boolean arg00 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
		}

		boolean arg02 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
		}

		boolean arg04 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04)!=null){
			arg04 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg04);
		}

		boolean arg06 = false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06)!=null){
			arg06 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg06);
		}

		int number5 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number5)!=null){
			number5 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number5);
		}

		int number3 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number3)!=null){
			number3 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number3);
		}

		int number1 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_number1)!=null){
			number1 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_number1);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
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
