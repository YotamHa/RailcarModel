//  The file MSDAspectSysManager_InitCar2.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_InitCar2 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Car_INST_car2 = 1;
	static final int Cruiser_INST_cruiser2 = 2;

	static final int int_arg_int_exact_int_arg01 = 0;
	static final int int_arg_int_exact_int_arg02 = 1;
	static final int int_arg_int_exact_int_arg00 = 2;
	static final int int_arg_int_exact_int_arg03 = 3;
	static final int int_arg_int_exact_int_arg04 = 4;

	static final int int_var_symbolic_minimalDistance = 5;

	private final String niceName = "SysManager_InitCar2";

	private static MSDAspectSysManager_InitCar2 instance = null;

	public static MSDAspectSysManager_InitCar2 getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_InitCar2();
		}
		return instance;
	}

	private MSDAspectSysManager_InitCar2()
	{
		addAspectEvent(MSDMethods.SysManager_SysManager_initCars);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "SysManager", "initCars");
		addAspectEvent(MSDMethods.SysManager_Car_setCarID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "setCarID");
		addAspectEvent(MSDMethods.SysManager_Car_setLocation);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "setLocation");
		addAspectEvent(MSDMethods.SysManager_Car_setTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "setTerminal");
		addAspectEvent(MSDMethods.SysManager_Car_setPlatform);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "setPlatform");
		addAspectEvent(MSDMethods.SysManager_Car_initCar);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Car", "initCar");
		addAspectEvent(MSDMethods.SysManager_Cruiser_setID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Cruiser", "setID");

		addMinimalEvent(MSDMethods.SysManager_SysManager_initCars);
		setHotCut(6,5,0);
		setHotCut(5,4,0);
		setHotCut(3,2,0);
		setHotCut(2,1,0);
		setHotCut(1,0,0);
		setHotCut(4,3,0);
		setLastCut(7,5,1);
		numberOfLifeLines = 3;
		numberOfInstances = 3;
		numberOfVariables = 6;
		numberOfTimeTags = 0;
		interactionId = "1499586852118";
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
			case MSDMethods.SysManager_Cruiser_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Cruiser_INST_cruiser2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg04,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(6,5,0))
					{
						cutChanged=true; activeMSD.setCut(7,5,1);
						break;
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
					if(activeMSD.isInCut(0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_initCar:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car2,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(5,4,0))
					{
						cutChanged=true; activeMSD.setCut(6,5,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_setLocation:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,1,0))
					{
						cutChanged=true; activeMSD.setCut(3,2,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_setPlatform:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg03,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,3,0))
					{
						cutChanged=true; activeMSD.setCut(5,4,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_setCarID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,1,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Car_setTerminal:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,2,0))
					{
						cutChanged=true; activeMSD.setCut(4,3,0);
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
		Car car2 = (Car)bindObjectByExpression(activeMSD,Car_INST_car2,null, true);;
		Cruiser cruiser2 = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser2,null, true);;

		int arg04 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04)!=null){
			arg04 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

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
		Car car2 = (Car)bindObjectByExpression(activeMSD,Car_INST_car2,null, true);;
		Cruiser cruiser2 = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser2,null, true);;

		int arg04 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04)!=null){
			arg04 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

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
		activeMSD.setLineInstance(Car_INST_car2,AppObjects.getObject("car2","Car"));
		activeMSD.setLineInstance(Cruiser_INST_cruiser2,AppObjects.getObject("cruiser2","Cruiser"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Car car2 = (Car)bindObjectByExpression(activeMSD,Car_INST_car2, null, false );
		Cruiser cruiser2 = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser2, null, false );

		int arg04 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04)!=null){
			arg04 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg01, (int)0);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg02, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg00, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg03, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg04, (int)2);
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

	private void after_SysManager_SysManager_initCars(Object _sysManagerSource ,Object _sysManager)
	{
		changeCutState(MSDMethods.SysManager_SysManager_initCars,
					_sysManager,_sysManager,null);
	}

	private void after_SysManager_Car_setCarID(Object _sysManager ,Object _car2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Car_setCarID,
					_sysManager,_car2,args);
	}

	private void after_SysManager_Car_setLocation(Object _sysManager ,Object _car2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Car_setLocation,
					_sysManager,_car2,args);
	}

	private void after_SysManager_Car_setTerminal(Object _sysManager ,Object _car2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Car_setTerminal,
					_sysManager,_car2,args);
	}

	private void after_SysManager_Car_setPlatform(Object _sysManager ,Object _car2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Car_setPlatform,
					_sysManager,_car2,args);
	}

	private void after_SysManager_Car_initCar(Object _sysManager ,Object _car2)
	{
		changeCutState(MSDMethods.SysManager_Car_initCar,
					_sysManager,_car2,null);
	}

	private void after_SysManager_Cruiser_setID(Object _sysManager ,Object _cruiser2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Cruiser_setID,
					_sysManager,_cruiser2,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("SysManager") && tgtClassName.equals("SysManager") && method.equals("initCars")){
			after_SysManager_SysManager_initCars(source, target);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("setCarID")){
			after_SysManager_Car_setCarID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("setLocation")){
			after_SysManager_Car_setLocation(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("setTerminal")){
			after_SysManager_Car_setTerminal(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("setPlatform")){
			after_SysManager_Car_setPlatform(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Car") && method.equals("initCar")){
			after_SysManager_Car_initCar(source, target);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Cruiser") && method.equals("setID")){
			after_SysManager_Cruiser_setID(source, target, argValues);
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
		Car car2 = (Car)bindObjectByExpression(activeMSD,Car_INST_car2,null, true);;
		Cruiser cruiser2 = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser2,null, true);;

		Integer VAR_int_exact_int_arg04 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04)!=null){
			VAR_int_exact_int_arg04 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04);
		}

		Integer VAR_int_exact_int_arg03 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			VAR_int_exact_int_arg03 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		Integer VAR_int_exact_int_arg02 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			VAR_int_exact_int_arg02 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		Integer VAR_int_exact_int_arg01 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			VAR_int_exact_int_arg01 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		Integer VAR_int_exact_int_arg00 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			VAR_int_exact_int_arg00 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		ArrayList<Object>  args28 = getArgsList(VAR_int_exact_int_arg04);
		MSDMethod MSDm28 = new MSDMethod(sysManager,cruiser2,
			MSDMethods.SysManager_Cruiser_setID,args28,"SysManager:Cruiser:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		MSDMethod MSDm29 = new MSDMethod(sysManager,sysManager,
			MSDMethods.SysManager_SysManager_initCars,null,"SysManager:SysManager:initCars",niceName,activeMSD.getGlobalId());// initCars() Monitored
		MSDMethod MSDm30 = new MSDMethod(sysManager,car2,
			MSDMethods.SysManager_Car_initCar,null,"SysManager:Car:initCar",niceName,activeMSD.getGlobalId());// initCar() Execute
		ArrayList<Object>  args31 = getArgsList(VAR_int_exact_int_arg01);
		MSDMethod MSDm31 = new MSDMethod(sysManager,car2,
			MSDMethods.SysManager_Car_setLocation,args31,"SysManager:Car:setLocation",niceName,activeMSD.getGlobalId());// setLocation() Execute
		ArrayList<Object>  args32 = getArgsList(VAR_int_exact_int_arg03);
		MSDMethod MSDm32 = new MSDMethod(sysManager,car2,
			MSDMethods.SysManager_Car_setPlatform,args32,"SysManager:Car:setPlatform",niceName,activeMSD.getGlobalId());// setPlatform() Execute
		ArrayList<Object>  args33 = getArgsList(VAR_int_exact_int_arg00);
		MSDMethod MSDm33 = new MSDMethod(sysManager,car2,
			MSDMethods.SysManager_Car_setCarID,args33,"SysManager:Car:setCarID",niceName,activeMSD.getGlobalId());// setCarID() Execute
		ArrayList<Object>  args34 = getArgsList(VAR_int_exact_int_arg02);
		MSDMethod MSDm34 = new MSDMethod(sysManager,car2,
			MSDMethods.SysManager_Car_setTerminal,args34,"SysManager:Car:setTerminal",niceName,activeMSD.getGlobalId());// setTerminal() Execute

		 if(activeMSD.isInCut(0,0,0))
		{
				ME.add(MSDm29);
				CV.add(MSDm28,MSDm30,MSDm34,MSDm32,MSDm33,MSDm31);
				return;
		}
		 if(activeMSD.isInCut(1,0,0))
		{
				if(MSDm33.sourceInstance!=null && MSDm33.targetInstance!=null){
					EE.add(MSDm33);
				}
				HV.add(MSDm28,MSDm30,MSDm29,MSDm34,MSDm32,MSDm31);
				return;
		}
		 if(activeMSD.isInCut(2,1,0))
		{
				if(MSDm31.sourceInstance!=null && MSDm31.targetInstance!=null){
					EE.add(MSDm31);
				}
				HV.add(MSDm28,MSDm30,MSDm29,MSDm34,MSDm32,MSDm33);
				return;
		}
		 if(activeMSD.isInCut(3,2,0))
		{
				if(MSDm34.sourceInstance!=null && MSDm34.targetInstance!=null){
					EE.add(MSDm34);
				}
				HV.add(MSDm28,MSDm30,MSDm29,MSDm32,MSDm33,MSDm31);
				return;
		}
		 if(activeMSD.isInCut(4,3,0))
		{
				if(MSDm32.sourceInstance!=null && MSDm32.targetInstance!=null){
					EE.add(MSDm32);
				}
				HV.add(MSDm28,MSDm30,MSDm29,MSDm34,MSDm33,MSDm31);
				return;
		}
		 if(activeMSD.isInCut(5,4,0))
		{
				if(MSDm30.sourceInstance!=null && MSDm30.targetInstance!=null){
					EE.add(MSDm30);
				}
				HV.add(MSDm28,MSDm29,MSDm34,MSDm32,MSDm33,MSDm31);
				return;
		}
		 if(activeMSD.isInCut(6,5,0))
		{
				if(MSDm28.sourceInstance!=null && MSDm28.targetInstance!=null){
					EE.add(MSDm28);
				}
				HV.add(MSDm30,MSDm29,MSDm34,MSDm32,MSDm33,MSDm31);
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

		int arg04 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04)!=null){
			arg04 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg04);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Car car2 = (Car) activeMSD.getLineInstance(Car_INST_car2);
			Cruiser cruiser2 = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser2);
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
