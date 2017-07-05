//  The file MSDAspectCar_Arrival.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectCar_Arrival extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int Car_INST_car = 0;
	static final int Cruiser_INST_cruiser = 1;
	static final int Terminal_INST_terminal = 2;
	static final int SysManager_INST_sysManager = 3;

	static final int String_arg_String_exact_opaque_direction0 = 0;
	static final int String_arg_String_exact_opaque_direction0Before = 1;

	static final int int_var_symbolic_minimalDistance = 2;

	private final String niceName = "Car_Arrival";

	private static MSDAspectCar_Arrival instance = null;

	public static MSDAspectCar_Arrival getInstance(){
		if(instance==null){
			instance = new MSDAspectCar_Arrival();
		}
		return instance;
	}

	private MSDAspectCar_Arrival()
	{
		addAspectEvent(MSDMethods.Car_Car_startArrival);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "startArrival");
		addAspectEvent(MSDMethods.Car_Terminal_arriveReq);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Terminal", "arriveReq");
		addAspectEvent(MSDMethods.Terminal_Car_arriveAck);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Terminal", "Car", "arriveAck");
		addAspectEvent(MSDMethods.Car_Car_stopAtTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "stopAtTerminal");
		addAspectEvent(MSDMethods.Car_Car_passTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"Car", "Car", "passTerminal");

		addMinimalEvent(MSDMethods.Car_Car_startArrival);
		setHotCut(1,0,0,0);
		setHotCut(4,1,3,1);
		setHotCut(6,2,4,2);
		addOperCut("car.Destination == terminal.ID",4,1,3,1);
		addOperCut("car.Destination == terminal.ID",5,1,3,1);
		addOperCut("else",6,2,4,2);
		addOperCut("else",7,2,4,2);
		setLastCut(8,3,5,3);
		numberOfLifeLines = 4;
		numberOfInstances = 4;
		numberOfVariables = 3;
		numberOfTimeTags = 0;
		interactionId = "1499083609511";
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
			case MSDMethods.Car_Car_passTerminal:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(6,2,4,2))
					{
						cutChanged=true; activeMSD.setCut(7,2,4,2);
						if(evaluateCondition(4,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(8,3,5,3);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(8,3,5,3);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Terminal_Car_arriveAck:
				if(activeMSD.instancesEquals(Terminal_INST_terminal,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(2,0,1,0))
					{
						cutChanged=true; activeMSD.setCut(3,0,2,0);
						if(evaluateCondition(3,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(4,1,3,1);
							return cutChanged;
						}
						if(evaluateCondition(4,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(6,2,4,2);
							return cutChanged;
						}
						cutChanged=true; activeMSD.setCut(8,3,5,3);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Terminal_arriveReq:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_opaque_direction0Before,String_arg_String_exact_opaque_direction0,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,0,1,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_stopAtTerminal:
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(4,1,3,1))
					{
						cutChanged=true; activeMSD.setCut(5,1,3,1);
						if(evaluateCondition(4,activeMSD))
						{
							cutChanged=true; activeMSD.setCut(8,3,5,3);
							break;
						}
						activeMSD.checkViolation();
						cutChanged=true; activeMSD.setCut(8,3,5,3);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.Car_Car_startArrival:
				if( (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  (newlyAddedDynamicAll || activeMSD.instancesEquals(Car_INST_car,null)) 
					&&  this.validateBoundedObject(activeMSD,Car_INST_car,sourceObject)
				 &&  this.validateBoundedObject(activeMSD,Car_INST_car,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0))
					{
						activeMSD.setLineInstance(Car_INST_car,targetObject); doBindings(activeMSD);if(activeMSD.isDeadCopy())return true;
						cutChanged=true; activeMSD.setCut(1,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(Car_INST_car,sourceObject)
					&& activeMSD.instancesEquals(Car_INST_car,targetObject))
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
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String direction0 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
		}

		switch (conditionNumber)
		{
			case 3: 
				return car.getDestination()==terminal.getID();
			case 4: 
				return true;
		}
		return false;
	}

	@SuppressWarnings("unused")
	private void evaluateForbiddenConditions(ActiveMSDAspect activeMSD)
	{
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car,null, true);;
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String direction0 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
		}

	
	}

	protected void setCutsExpressions()
	{
		this.setExpressionForCut("6,2,4,2" , "else");
		this.setExpressionForCut("4,1,3,1" , "car.Destination == terminal.ID");
		this.setExpressionForCut("8,3,5,3" , "SYNC");

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		Car car = (Car)bindObjectByExpression(activeMSD,Car_INST_car, null, false );
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser, null, false );
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal, null, false );
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );

		String direction0 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_opaque_direction0, (String)car.getDirection());
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
	
		if(car==null || cruiser==null || terminal==null){
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

	private void before_Car_Terminal_arriveReq(Object _car ,Object _terminal, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);

			String direction0 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
				direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
			}
	
			try{
				activeMSD.setPrivateVariable(String_arg_String_exact_opaque_direction0Before, (String)car.getDirection());
			}catch(Exception e){}
		}
	}
	private void after_Car_Terminal_arriveReq(Object _car ,Object _terminal, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.Car_Terminal_arriveReq,
					_car,_terminal,args);
	}

	private void after_Car_Car_startArrival(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_startArrival,
					_car,_car,null);
	}

	private void after_Terminal_Car_arriveAck(Object _terminal ,Object _car)
	{
		changeCutState(MSDMethods.Terminal_Car_arriveAck,
					_terminal,_car,null);
	}

	private void after_Car_Car_stopAtTerminal(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_stopAtTerminal,
					_car,_car,null);
	}

	private void after_Car_Car_passTerminal(Object _carSource ,Object _car)
	{
		changeCutState(MSDMethods.Car_Car_passTerminal,
					_car,_car,null);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Terminal") && method.equals("arriveReq")){
			after_Car_Terminal_arriveReq(source, target, argValues);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("startArrival")){
			after_Car_Car_startArrival(source, target);
			return;
		}
		if(srcClassName.equals("Terminal") && tgtClassName.equals("Car") && method.equals("arriveAck")){
			after_Terminal_Car_arriveAck(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("stopAtTerminal")){
			after_Car_Car_stopAtTerminal(source, target);
			return;
		}
		if(srcClassName.equals("Car") && tgtClassName.equals("Car") && method.equals("passTerminal")){
			after_Car_Car_passTerminal(source, target);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("Car") && tgtClassName.equals("Terminal") && method.equals("arriveReq")){
			before_Car_Terminal_arriveReq(source, target, argValues);
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
		Cruiser cruiser = (Cruiser)bindObjectByExpression(activeMSD,Cruiser_INST_cruiser,null, true);;
		Terminal terminal = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal,null, true);;
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;

		String VAR_String_exact_opaque_direction0 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			VAR_String_exact_opaque_direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
		}

		MSDMethod MSDm109 = new MSDMethod(car,car,
			MSDMethods.Car_Car_passTerminal,null,"Car:Car:passTerminal",niceName,activeMSD.getGlobalId());// passTerminal() Execute
		MSDMethod MSDm110 = new MSDMethod(terminal,car,
			MSDMethods.Terminal_Car_arriveAck,null,"Terminal:Car:arriveAck",niceName,activeMSD.getGlobalId());// arriveAck() Monitored
		ArrayList<Object>  args111 = getArgsList(VAR_String_exact_opaque_direction0);
		MSDMethod MSDm111 = new MSDMethod(car,terminal,
			MSDMethods.Car_Terminal_arriveReq,args111,"Car:Terminal:arriveReq",niceName,activeMSD.getGlobalId());// arriveReq() Execute
		MSDMethod MSDm112 = new MSDMethod(car,car,
			MSDMethods.Car_Car_stopAtTerminal,null,"Car:Car:stopAtTerminal",niceName,activeMSD.getGlobalId());// stopAtTerminal() Execute
		MSDMethod MSDm113 = new MSDMethod(car,car,
			MSDMethods.Car_Car_startArrival,null,"Car:Car:startArrival",niceName,activeMSD.getGlobalId());// startArrival() Monitored

		 if(activeMSD.isInCut(0,0,0,0))
		{
				ME.add(MSDm113);
				CV.add(MSDm110,MSDm112,MSDm111,MSDm109);
				return;
		}
		 if(activeMSD.isInCut(1,0,0,0))
		{
				if(MSDm111.sourceInstance!=null && MSDm111.targetInstance!=null){
					EE.add(MSDm111);
				}
				HV.add(MSDm110,MSDm112,MSDm113,MSDm109);
				return;
		}
		 if(activeMSD.isInCut(2,0,1,0))
		{
				ME.add(MSDm110);
				CV.add(MSDm112,MSDm113,MSDm111,MSDm109);
				return;
		}
		 if(activeMSD.isInCut(4,1,3,1))
		{
				if(MSDm112.sourceInstance!=null && MSDm112.targetInstance!=null){
					EE.add(MSDm112);
				}
				HV.add(MSDm110,MSDm113,MSDm111,MSDm109);
				return;
		}
		 if(activeMSD.isInCut(6,2,4,2))
		{
				if(MSDm109.sourceInstance!=null && MSDm109.targetInstance!=null){
					EE.add(MSDm109);
				}
				HV.add(MSDm110,MSDm112,MSDm113,MSDm111);
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
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

		String direction0 = null;
		boolean direction0Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
			direction0Bound=true;
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
	
	private ArrayList<Object> getcruiser_CruiserInstances(ActiveMSDAspect activeMSD, 
			boolean isUniversal, Object monitoredObj)
	{
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

		String direction0 = null;
		boolean direction0Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
			direction0Bound=true;
		}
		if(car==null){
			return null;				//not enabled
		}
		ArrayList<Object> instances = AppObjects.getObjects("Cruiser");
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
				if(((Cruiser)inst).getID()==car.getCarID()){
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
		Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
		Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
		Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
		SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
	

		String direction0 = null;
		boolean direction0Bound=false;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
			direction0Bound=true;
		}
		if(car==null){
			return null;				//not enabled
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
				if(((Terminal)inst).getID()==car.getTerminal()){
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

		String direction0 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0)!=null){
			direction0 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_opaque_direction0);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			Car car = (Car) activeMSD.getLineInstance(Car_INST_car);
			Cruiser cruiser = (Cruiser) activeMSD.getLineInstance(Cruiser_INST_cruiser);
			Terminal terminal = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal);
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
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
				case Cruiser_INST_cruiser:
					try{
						result = getcruiser_CruiserInstances(activeMSD, false, "NONE");
						 
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
				case Terminal_INST_terminal:
					try{
						result = getterminal_TerminalInstances(activeMSD, false, "NONE");
						 
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
