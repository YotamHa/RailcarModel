//  The file MSDAspectPlatformManager_LSC5.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectPlatformManager_LSC5 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int PlatformManager_INST_platformManager = 1;

	static final int boolean_arg_boolean_exact_boolean_arg00 = 0;
	static final int boolean_arg_boolean_exact_boolean_arg01 = 1;
	static final int boolean_arg_boolean_exact_boolean_arg02 = 2;
	static final int boolean_arg_boolean_exact_boolean_arg03 = 3;

	static final int int_var_symbolic_minimalDistance = 4;

	private final String niceName = "PlatformManager_LSC5";

	private static MSDAspectPlatformManager_LSC5 instance = null;

	public static MSDAspectPlatformManager_LSC5 getInstance(){
		if(instance==null){
			instance = new MSDAspectPlatformManager_LSC5();
		}
		return instance;
	}

	private MSDAspectPlatformManager_LSC5()
	{
		addAspectEvent(MSDMethods.Car_PlatformManager_freePlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "PlatformManager", "freePlatform");
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

		addMinimalEvent(MSDMethods.Car_PlatformManager_freePlatform);
		setHotCut(3,4);
		setHotCut(2,2);
		setHotCut(4,6);
		setHotCut(5,8);
		addOperCut("car.platform == 2",3,4);
		addOperCut("car.platform == 2",3,5);
		addOperCut("car.platform == 1",2,2);
		addOperCut("car.platform == 1",2,3);
		addOperCut("car.platform == 3",4,6);
		addOperCut("car.platform == 3",4,7);
		addOperCut("car.platform == 4",5,8);
		addOperCut("car.platform == 4",5,9);
		setLastCut(6,10);
		numberOfLifeLines = 2;
		numberOfInstances = 2;
		numberOfVariables = 5;
		numberOfTimeTags = 0;
		interactionId = "1499586852484";
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
			case MSDMethods.Car_PlatformManager_freePlatform:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(PlatformManager_INST_platformManager,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0))
					{
						activeMSD.setLineInstance(PlatformManager_INST_platformManager,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						activeMSD.setLineInstance(Car_INST_car,sourceObject);
						cutChanged=true; activeMSD.setCut(1,1);
						if(evaluateCondition(1,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(2,2);
							return cutChanged;
						}
						if(evaluateCondition(2,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(3,4);
							return cutChanged;
						}
						if(evaluateCondition(3,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(4,6);
							return cutChanged;
						}
						if(evaluateCondition(4,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(5,8);
							return cutChanged;
						}
						cutChanged=true; activeMSD.setCut(6,10);
						break;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject))
				{
					unification=true;
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform2busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,4))
					{
						cutChanged=true; activeMSD.setCut(3,5);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform1busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,2))
					{
						cutChanged=true; activeMSD.setCut(2,3);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform4busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg03,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(5,8))
					{
						cutChanged=true; activeMSD.setCut(5,9);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.PlatformManager_PlatformManager_setPlatform3busy:
				if(activeMSD.instancesEquals(PlatformManager_INST_platformManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager,targetObject)
					&& activeMSD.variableEquals(boolean_arg_boolean_exact_boolean_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,6))
					{
						cutChanged=true; activeMSD.setCut(4,7);
						if(evaluateCondition(6,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,10);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(6,10);
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
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

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
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

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
		this.setExpressionForCut("5,8" , "car.platform == 4");
		this.setExpressionForCut("2,2" , "car.platform == 1");
		this.setExpressionForCut("3,4" , "car.platform == 2");
		this.setExpressionForCut("6,10" , "SYNC");
		this.setExpressionForCut("4,6" , "car.platform == 3");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager, null, false );

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
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg00, (boolean)false);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg01, (boolean)false);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg02, (boolean)false);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(boolean_arg_boolean_exact_boolean_arg03, (boolean)false);
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
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	
		if(car==null || platformManager==null){
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

	private void after_Car_PlatformManager_freePlatform(Object _car ,Object _platformManager)
	{
		changeCutState(MSDMethods.Car_PlatformManager_freePlatform,
					_car,_platformManager,null);
	}

	private void after_PlatformManager_PlatformManager_setPlatform1busy(Object _platformManagerSource ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform1busy,
					_platformManager,_platformManager,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform2busy(Object _platformManagerSource ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform2busy,
					_platformManager,_platformManager,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform3busy(Object _platformManagerSource ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,
					_platformManager,_platformManager,args);
	}

	private void after_PlatformManager_PlatformManager_setPlatform4busy(Object _platformManagerSource ,Object _platformManager, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.PlatformManager_PlatformManager_setPlatform4busy,
					_platformManager,_platformManager,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("PlatformManager") && method.equals("freePlatform")){
			after_Car_PlatformManager_freePlatform(source, target);
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
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		PlatformManager platformManager = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager,null, true);;

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

		MSDMethod MSDm171 = new MSDMethod(car,platformManager,
			MSDMethods.Car_PlatformManager_freePlatform,null,"Car:PlatformManager:freePlatform",niceName,activeMSD.getGlobalId());// freePlatform() Monitored
		ArrayList<Object>  args172 = getArgsList(VAR_boolean_exact_boolean_arg01);
		MSDMethod MSDm172 = new MSDMethod(platformManager,platformManager,
			MSDMethods.PlatformManager_PlatformManager_setPlatform2busy,args172,"PlatformManager:PlatformManager:setPlatform2busy",niceName,activeMSD.getGlobalId());// setPlatform2busy() Execute
		ArrayList<Object>  args173 = getArgsList(VAR_boolean_exact_boolean_arg03);
		MSDMethod MSDm173 = new MSDMethod(platformManager,platformManager,
			MSDMethods.PlatformManager_PlatformManager_setPlatform4busy,args173,"PlatformManager:PlatformManager:setPlatform4busy",niceName,activeMSD.getGlobalId());// setPlatform4busy() Execute
		ArrayList<Object>  args174 = getArgsList(VAR_boolean_exact_boolean_arg00);
		MSDMethod MSDm174 = new MSDMethod(platformManager,platformManager,
			MSDMethods.PlatformManager_PlatformManager_setPlatform1busy,args174,"PlatformManager:PlatformManager:setPlatform1busy",niceName,activeMSD.getGlobalId());// setPlatform1busy() Execute
		ArrayList<Object>  args175 = getArgsList(VAR_boolean_exact_boolean_arg02);
		MSDMethod MSDm175 = new MSDMethod(platformManager,platformManager,
			MSDMethods.PlatformManager_PlatformManager_setPlatform3busy,args175,"PlatformManager:PlatformManager:setPlatform3busy",niceName,activeMSD.getGlobalId());// setPlatform3busy() Execute

		 if(activeMSD.isInCut(0,0))
		{
				ME.add(MSDm171);
				CV.add(MSDm175,MSDm174,MSDm172,MSDm173);
				return;
		}
		 if(activeMSD.isInCut(2,2))
		{
				if(MSDm174.sourceInstance!=null && MSDm174.targetInstance!=null){
					EE.add(MSDm174);
				}
				HV.add(MSDm171,MSDm175,MSDm172,MSDm173);
				return;
		}
		 if(activeMSD.isInCut(3,4))
		{
				if(MSDm172.sourceInstance!=null && MSDm172.targetInstance!=null){
					EE.add(MSDm172);
				}
				HV.add(MSDm171,MSDm175,MSDm174,MSDm173);
				return;
		}
		 if(activeMSD.isInCut(4,6))
		{
				if(MSDm175.sourceInstance!=null && MSDm175.targetInstance!=null){
					EE.add(MSDm175);
				}
				HV.add(MSDm171,MSDm174,MSDm172,MSDm173);
				return;
		}
		 if(activeMSD.isInCut(5,8))
		{
				if(MSDm173.sourceInstance!=null && MSDm173.targetInstance!=null){
					EE.add(MSDm173);
				}
				HV.add(MSDm171,MSDm175,MSDm174,MSDm172);
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
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		boolean arg01 = false;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
			arg01Bound=true;
		}

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
		}

		boolean arg03 = false;
		boolean arg03Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
			arg03Bound=true;
		}

		boolean arg02 = false;
		boolean arg02Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
			arg02Bound=true;
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
	
	private ArrayList<Object> getplatformManager_PlatformManagerInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		if(monitoredObj==null){
			return null;
		}
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
	

		boolean arg01 = false;
		boolean arg01Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01)!=null){
			arg01 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg01);
			arg01Bound=true;
		}

		boolean arg00 = false;
		boolean arg00Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00)!=null){
			arg00 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg00);
			arg00Bound=true;
		}

		boolean arg03 = false;
		boolean arg03Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03)!=null){
			arg03 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg03);
			arg03Bound=true;
		}

		boolean arg02 = false;
		boolean arg02Bound=false;
		if(activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02)!=null){
			arg02 = (boolean) activeMSD.getPrivateVariable(boolean_arg_boolean_exact_boolean_arg02);
			arg02Bound=true;
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
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			PlatformManager platformManager = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager);
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
