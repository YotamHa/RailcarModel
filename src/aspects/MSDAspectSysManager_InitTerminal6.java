//  The file MSDAspectSysManager_InitTerminal6.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_InitTerminal6 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Terminal_INST_terminal6 = 1;
	static final int PlatformManager_INST_platformManager6 = 2;
	static final int Entrance_INST_entrance6r = 3;
	static final int Entrance_INST_entrance6l = 4;
	static final int ExitsManager_INST_exitsManager6 = 5;
	static final int Exit_INST_exit6r = 6;
	static final int Exit_INST_exit6l = 7;

	static final int int_arg_int_exact_opaque_arg00 = 0;
	static final int int_arg_int_exact_opaque_arg00Before = 1;
	static final int int_arg_int_symbolic_var_ID = 2;
	static final int int_arg_int_exact_opaque_arg01 = 3;
	static final int int_arg_int_exact_opaque_arg01Before = 4;
	static final int int_arg_int_exact_opaque_arg02 = 5;
	static final int int_arg_int_exact_opaque_arg02Before = 6;
	static final int int_arg_int_exact_opaque_arg03 = 7;
	static final int int_arg_int_exact_opaque_arg03Before = 8;
	static final int int_arg_int_exact_opaque_arg05 = 9;
	static final int int_arg_int_exact_opaque_arg05Before = 10;
	static final int int_arg_int_exact_opaque_arg07 = 11;
	static final int int_arg_int_exact_opaque_arg07Before = 12;
	static final int int_arg_int_exact_opaque_arg08 = 13;
	static final int int_arg_int_exact_opaque_arg08Before = 14;
	static final int int_arg_int_exact_opaque_arg010 = 15;
	static final int int_arg_int_exact_opaque_arg010Before = 16;
	static final int String_arg_String_exact_String_arg04 = 17;
	static final int String_arg_String_exact_String_arg09 = 18;
	static final int String_arg_String_exact_String_arg06 = 19;
	static final int String_arg_String_exact_String_arg011 = 20;

	static final int int_var_symbolic_minimalDistance = 21;

	private final String niceName = "SysManager_InitTerminal6";

	private static MSDAspectSysManager_InitTerminal6 instance = null;

	public static MSDAspectSysManager_InitTerminal6 getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_InitTerminal6();
		}
		return instance;
	}

	private MSDAspectSysManager_InitTerminal6()
	{
		addAspectEvent(MSDMethods.SysManager_Terminal_initTerminal);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Terminal", "initTerminal");
		addAspectEvent(MSDMethods.SysManager_Terminal_setLocation);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Terminal", "setLocation");
		addAspectEvent(MSDMethods.SysManager_Terminal_setID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Terminal", "setID");
		addAspectEvent(MSDMethods.SysManager_PlatformManager_setID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "PlatformManager", "setID");
		addAspectEvent(MSDMethods.SysManager_Entrance_setTerminalId);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Entrance", "setTerminalId");
		addAspectEvent(MSDMethods.SysManager_Entrance_setDirection);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Entrance", "setDirection");
		addAspectEvent(MSDMethods.SysManager_ExitsManager_setID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "ExitsManager", "setID");
		addAspectEvent(MSDMethods.SysManager_Exit_setID);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Exit", "setID");
		addAspectEvent(MSDMethods.SysManager_Exit_setDirection);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "Exit", "setDirection");

		addMinimalEvent(MSDMethods.SysManager_Terminal_initTerminal);
		setHotCut(9,3,1,2,2,1,0,0);
		setHotCut(10,3,1,2,2,1,1,0);
		setHotCut(12,3,1,2,2,1,2,1);
		setHotCut(2,2,0,0,0,0,0,0);
		setHotCut(8,3,1,2,2,0,0,0);
		setHotCut(11,3,1,2,2,1,2,0);
		setHotCut(5,3,1,1,0,0,0,0);
		setHotCut(7,3,1,2,1,0,0,0);
		setHotCut(3,3,0,0,0,0,0,0);
		setHotCut(4,3,1,0,0,0,0,0);
		setHotCut(6,3,1,2,0,0,0,0);
		setHotCut(1,1,0,0,0,0,0,0);
		setLastCut(13,3,1,2,2,1,2,2);
		numberOfLifeLines = 8;
		numberOfInstances = 8;
		numberOfVariables = 22;
		numberOfTimeTags = 0;
		interactionId = "1499586852241";
		setCutsExpressions();
	}

	protected void  setPrivateVariables(int MSDm, Object sourceObject, Object targetObject,ActiveMSDAspect activeMSD,
		ArrayList args)
	{
		switch (MSDm)
		{
			case MSDMethods.SysManager_Terminal_initTerminal:
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_ID,args.get(0));

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
			case MSDMethods.SysManager_Terminal_initTerminal:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal6,targetObject)
					&& activeMSD.symbolicVariableEquals(int_arg_int_symbolic_var_ID,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0,0,0,0,0))
					{
						activeMSD.setPrivateVariable(int_arg_int_symbolic_var_ID,args.get(0));
						cutChanged=true; activeMSD.setCut(1,1,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Entrance_setTerminalId:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance6r,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg03Before,int_arg_int_exact_opaque_arg03,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,3,1,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(5,3,1,1,0,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance6l,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg05Before,int_arg_int_exact_opaque_arg05,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(6,3,1,2,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(7,3,1,2,1,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Entrance_setDirection:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance6r,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg04,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(5,3,1,1,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(6,3,1,2,0,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance6l,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg06,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(7,3,1,2,1,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(8,3,1,2,2,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Terminal_setLocation:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal6,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg00Before,int_arg_int_exact_opaque_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,1,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,2,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Exit_setDirection:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit6r,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg09,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(10,3,1,2,2,1,1,0))
					{
						cutChanged=true; activeMSD.setCut(11,3,1,2,2,1,2,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit6l,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg011,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(12,3,1,2,2,1,2,1))
					{
						cutChanged=true; activeMSD.setCut(13,3,1,2,2,1,2,2);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_ExitsManager_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_exitsManager6,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg07Before,int_arg_int_exact_opaque_arg07,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(8,3,1,2,2,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(9,3,1,2,2,1,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Terminal_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal6,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg01Before,int_arg_int_exact_opaque_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,2,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(3,3,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_PlatformManager_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager6,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg02Before,int_arg_int_exact_opaque_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,3,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(4,3,1,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Exit_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit6r,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg08Before,int_arg_int_exact_opaque_arg08,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(9,3,1,2,2,1,0,0))
					{
						cutChanged=true; activeMSD.setCut(10,3,1,2,2,1,1,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit6l,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_opaque_arg010Before,int_arg_int_exact_opaque_arg010,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(11,3,1,2,2,1,2,0))
					{
						cutChanged=true; activeMSD.setCut(12,3,1,2,2,1,2,1);
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
		Terminal terminal6 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal6,null, true);;
		PlatformManager platformManager6 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager6,null, true);;
		Entrance entrance6r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6r,null, true);;
		Entrance entrance6l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6l,null, true);;
		ExitsManager exitsManager6 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager6,null, true);;
		Exit exit6r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6r,null, true);;
		Exit exit6l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6l,null, true);;

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
		}

		int ID = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
			ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
		}

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
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
		Terminal terminal6 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal6,null, true);;
		PlatformManager platformManager6 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager6,null, true);;
		Entrance entrance6r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6r,null, true);;
		Entrance entrance6l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6l,null, true);;
		ExitsManager exitsManager6 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager6,null, true);;
		Exit exit6r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6r,null, true);;
		Exit exit6l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6l,null, true);;

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
		}

		int ID = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
			ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
		}

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
		}

	
	}

	protected void setCutsExpressions()
	{

	}


	@SuppressWarnings("unused")
	protected void doBindings(ActiveMSDAspect activeMSD)
	{
		activeMSD.setLineInstance(SysManager_INST_sysManager,AppObjects.getObject("sysManager","SysManager"));
		activeMSD.setLineInstance(Terminal_INST_terminal6,AppObjects.getObject("terminal6","Terminal"));
		activeMSD.setLineInstance(PlatformManager_INST_platformManager6,AppObjects.getObject("platformManager6","PlatformManager"));
		activeMSD.setLineInstance(Entrance_INST_entrance6r,AppObjects.getObject("entrance6r","Entrance"));
		activeMSD.setLineInstance(Entrance_INST_entrance6l,AppObjects.getObject("entrance6l","Entrance"));
		activeMSD.setLineInstance(ExitsManager_INST_exitsManager6,AppObjects.getObject("exitsManager6","ExitsManager"));
		activeMSD.setLineInstance(Exit_INST_exit6r,AppObjects.getObject("exit6r","Exit"));
		activeMSD.setLineInstance(Exit_INST_exit6l,AppObjects.getObject("exit6l","Exit"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Terminal terminal6 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal6, null, false );
		PlatformManager platformManager6 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager6, null, false );
		Entrance entrance6r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6r, null, false );
		Entrance entrance6l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6l, null, false );
		ExitsManager exitsManager6 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager6, null, false );
		Exit exit6r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6r, null, false );
		Exit exit6l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6l, null, false );

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
		}

		int ID = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
			ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
		}

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
		}
		int minimalDistance = 0;
		if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
			minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
		} 

		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg00, (int)(ID-1)*500);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg01, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg02, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg03, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg05, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg07, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg08, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg010, (int)ID);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg04, (String)"right");
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg09, (String)"right");
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg06, (String)"left");
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(String_arg_String_exact_String_arg011, (String)"left");
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

	private void before_SysManager_Exit_setID(Object _sysManager ,Object _exit6l, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg08Before, (int)ID);
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg010Before, (int)ID);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_Exit_setID(Object _sysManager ,Object _exit6l, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Exit_setID,
					_sysManager,_exit6l,args);
	}

	private void before_SysManager_ExitsManager_setID(Object _sysManager ,Object _exitsManager6, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg07Before, (int)ID);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_ExitsManager_setID(Object _sysManager ,Object _exitsManager6, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_ExitsManager_setID,
					_sysManager,_exitsManager6,args);
	}

	private void before_SysManager_Entrance_setTerminalId(Object _sysManager ,Object _entrance6l, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg03Before, (int)ID);
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg05Before, (int)ID);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_Entrance_setTerminalId(Object _sysManager ,Object _entrance6l, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setTerminalId,
					_sysManager,_entrance6l,args);
	}

	private void before_SysManager_PlatformManager_setID(Object _sysManager ,Object _platformManager6, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg02Before, (int)ID);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_PlatformManager_setID(Object _sysManager ,Object _platformManager6, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_PlatformManager_setID,
					_sysManager,_platformManager6,args);
	}

	private void before_SysManager_Terminal_setID(Object _sysManager ,Object _terminal6, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg01Before, (int)ID);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_Terminal_setID(Object _sysManager ,Object _terminal6, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setID,
					_sysManager,_terminal6,args);
	}

	private void before_SysManager_Terminal_setLocation(Object _sysManager ,Object _terminal6, ArrayList<Object> args)
	{
				for(ActiveMSDAspect activeMSD:getActiveMSDArray()){
			int minimalDistance = 0;
			if(activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance)!=null){
				minimalDistance = (Integer) activeMSD.getPrivateVariable(int_var_symbolic_minimalDistance);
			} 
	
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);

			int arg08 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
				arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
			}
	
			String arg09 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
				arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
			}
	
			String arg06 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
				arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
			}
	
			String arg04 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
				arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
			}
	
			int arg010 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
				arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
			}
	
			int ID = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
				ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
			}
	
			String arg011 = null;
			if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
				arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
			}
	
			int arg03 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
				arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
			}
	
			int arg02 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
				arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
			}
	
			int arg01 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
				arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
			}
	
			int arg00 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
				arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
			}
	
			int arg07 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
				arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
			}
	
			int arg05 = 0;
			if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
				arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
			}
	
			try{
				activeMSD.setPrivateVariable(int_arg_int_exact_opaque_arg00Before, (int)(ID-1)*500);
			}catch(Exception e){}
		}
	}
	private void after_SysManager_Terminal_setLocation(Object _sysManager ,Object _terminal6, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setLocation,
					_sysManager,_terminal6,args);
	}

	private void after_SysManager_Terminal_initTerminal(Object _sysManager ,Object _terminal6, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_initTerminal,
					_sysManager,_terminal6,args);
	}

	private void after_SysManager_Entrance_setDirection(Object _sysManager ,Object _entrance6r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setDirection,
					_sysManager,_entrance6r,args);
	}

	private void after_SysManager_Exit_setDirection(Object _sysManager ,Object _exit6r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Exit_setDirection,
					_sysManager,_exit6r,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Exit") && method.equals("setID")){
			after_SysManager_Exit_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("ExitsManager") && method.equals("setID")){
			after_SysManager_ExitsManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Entrance") && method.equals("setTerminalId")){
			after_SysManager_Entrance_setTerminalId(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("PlatformManager") && method.equals("setID")){
			after_SysManager_PlatformManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setID")){
			after_SysManager_Terminal_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setLocation")){
			after_SysManager_Terminal_setLocation(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("initTerminal")){
			after_SysManager_Terminal_initTerminal(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Entrance") && method.equals("setDirection")){
			after_SysManager_Entrance_setDirection(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Exit") && method.equals("setDirection")){
			after_SysManager_Exit_setDirection(source, target, argValues);
			return;
		}
	}

	@Override
	public void beforeEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Exit") && method.equals("setID")){
			before_SysManager_Exit_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("ExitsManager") && method.equals("setID")){
			before_SysManager_ExitsManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Entrance") && method.equals("setTerminalId")){
			before_SysManager_Entrance_setTerminalId(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("PlatformManager") && method.equals("setID")){
			before_SysManager_PlatformManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setID")){
			before_SysManager_Terminal_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setLocation")){
			before_SysManager_Terminal_setLocation(source, target, argValues);
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
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager,null, true);;
		Terminal terminal6 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal6,null, true);;
		PlatformManager platformManager6 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager6,null, true);;
		Entrance entrance6r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6r,null, true);;
		Entrance entrance6l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance6l,null, true);;
		ExitsManager exitsManager6 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_exitsManager6,null, true);;
		Exit exit6r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6r,null, true);;
		Exit exit6l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit6l,null, true);;

		Integer VAR_int_exact_opaque_arg08 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
			VAR_int_exact_opaque_arg08 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
		}

		String VAR_String_exact_String_arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			VAR_String_exact_String_arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String VAR_String_exact_String_arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			VAR_String_exact_String_arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		String VAR_String_exact_String_arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			VAR_String_exact_String_arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		Integer VAR_int_exact_opaque_arg010 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
			VAR_int_exact_opaque_arg010 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
		}

		Integer VAR_int_symbolic_var_ID = null;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
			VAR_int_symbolic_var_ID = (Integer) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
		}

		String VAR_String_exact_String_arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			VAR_String_exact_String_arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		Integer VAR_int_exact_opaque_arg03 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
			VAR_int_exact_opaque_arg03 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
		}

		Integer VAR_int_exact_opaque_arg02 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
			VAR_int_exact_opaque_arg02 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
		}

		Integer VAR_int_exact_opaque_arg01 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			VAR_int_exact_opaque_arg01 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		Integer VAR_int_exact_opaque_arg00 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			VAR_int_exact_opaque_arg00 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		Integer VAR_int_exact_opaque_arg07 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
			VAR_int_exact_opaque_arg07 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
		}

		Integer VAR_int_exact_opaque_arg05 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
			VAR_int_exact_opaque_arg05 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
		}

		ArrayList<Object>  args93 = getArgsList(VAR_int_symbolic_var_ID);
		MSDMethod MSDm93 = new MSDMethod(sysManager,terminal6,
			MSDMethods.SysManager_Terminal_initTerminal,args93,"SysManager:Terminal:initTerminal",niceName,activeMSD.getGlobalId());// initTerminal() Monitored
		ArrayList<Object>  args94 = getArgsList(VAR_int_exact_opaque_arg03);
		MSDMethod MSDm94 = new MSDMethod(sysManager,entrance6r,
			MSDMethods.SysManager_Entrance_setTerminalId,args94,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args95 = getArgsList(VAR_int_exact_opaque_arg05);
		MSDMethod MSDm95 = new MSDMethod(sysManager,entrance6l,
			MSDMethods.SysManager_Entrance_setTerminalId,args95,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args96 = getArgsList(VAR_String_exact_String_arg04);
		MSDMethod MSDm96 = new MSDMethod(sysManager,entrance6r,
			MSDMethods.SysManager_Entrance_setDirection,args96,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args97 = getArgsList(VAR_String_exact_String_arg06);
		MSDMethod MSDm97 = new MSDMethod(sysManager,entrance6l,
			MSDMethods.SysManager_Entrance_setDirection,args97,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args98 = getArgsList(VAR_int_exact_opaque_arg00);
		MSDMethod MSDm98 = new MSDMethod(sysManager,terminal6,
			MSDMethods.SysManager_Terminal_setLocation,args98,"SysManager:Terminal:setLocation",niceName,activeMSD.getGlobalId());// setLocation() Execute
		ArrayList<Object>  args99 = getArgsList(VAR_String_exact_String_arg09);
		MSDMethod MSDm99 = new MSDMethod(sysManager,exit6r,
			MSDMethods.SysManager_Exit_setDirection,args99,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args100 = getArgsList(VAR_String_exact_String_arg011);
		MSDMethod MSDm100 = new MSDMethod(sysManager,exit6l,
			MSDMethods.SysManager_Exit_setDirection,args100,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args101 = getArgsList(VAR_int_exact_opaque_arg07);
		MSDMethod MSDm101 = new MSDMethod(sysManager,exitsManager6,
			MSDMethods.SysManager_ExitsManager_setID,args101,"SysManager:ExitsManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args102 = getArgsList(VAR_int_exact_opaque_arg01);
		MSDMethod MSDm102 = new MSDMethod(sysManager,terminal6,
			MSDMethods.SysManager_Terminal_setID,args102,"SysManager:Terminal:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args103 = getArgsList(VAR_int_exact_opaque_arg02);
		MSDMethod MSDm103 = new MSDMethod(sysManager,platformManager6,
			MSDMethods.SysManager_PlatformManager_setID,args103,"SysManager:PlatformManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args104 = getArgsList(VAR_int_exact_opaque_arg08);
		MSDMethod MSDm104 = new MSDMethod(sysManager,exit6r,
			MSDMethods.SysManager_Exit_setID,args104,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args105 = getArgsList(VAR_int_exact_opaque_arg010);
		MSDMethod MSDm105 = new MSDMethod(sysManager,exit6l,
			MSDMethods.SysManager_Exit_setID,args105,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute

		 if(activeMSD.isInCut(0,0,0,0,0,0,0,0))
		{
				ME.add(MSDm93);
				CV.add(MSDm95,MSDm94,MSDm102,MSDm103,MSDm99,MSDm98,MSDm100,MSDm97);
				CV.add(MSDm101,MSDm105,MSDm96,MSDm104);
				return;
		}
		 if(activeMSD.isInCut(1,1,0,0,0,0,0,0))
		{
				if(MSDm98.sourceInstance!=null && MSDm98.targetInstance!=null){
					EE.add(MSDm98);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm102,MSDm103,MSDm99,MSDm100,MSDm97);
				HV.add(MSDm101,MSDm105,MSDm96,MSDm104);
				return;
		}
		 if(activeMSD.isInCut(2,2,0,0,0,0,0,0))
		{
				if(MSDm102.sourceInstance!=null && MSDm102.targetInstance!=null){
					EE.add(MSDm102);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm99,MSDm98,MSDm100,MSDm97,MSDm96);
				return;
		}
		 if(activeMSD.isInCut(3,3,0,0,0,0,0,0))
		{
				if(MSDm103.sourceInstance!=null && MSDm103.targetInstance!=null){
					EE.add(MSDm103);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm99,MSDm98,MSDm100,MSDm97,MSDm96);
				return;
		}
		 if(activeMSD.isInCut(4,3,1,0,0,0,0,0))
		{
				if(MSDm94.sourceInstance!=null && MSDm94.targetInstance!=null){
					EE.add(MSDm94);
				}
				HV.add(MSDm93,MSDm102,MSDm103,MSDm99,MSDm98,MSDm100,MSDm97,MSDm101);
				HV.add(MSDm105,MSDm96,MSDm104);
				return;
		}
		 if(activeMSD.isInCut(5,3,1,1,0,0,0,0))
		{
				if(MSDm96.sourceInstance!=null && MSDm96.targetInstance!=null){
					EE.add(MSDm96);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm102,MSDm103,MSDm98,MSDm101,MSDm105);
				HV.add(MSDm104);
				return;
		}
		 if(activeMSD.isInCut(6,3,1,2,0,0,0,0))
		{
				if(MSDm95.sourceInstance!=null && MSDm95.targetInstance!=null){
					EE.add(MSDm95);
				}
				HV.add(MSDm93,MSDm102,MSDm103,MSDm99,MSDm98,MSDm100,MSDm97,MSDm101);
				HV.add(MSDm105,MSDm96,MSDm104);
				return;
		}
		 if(activeMSD.isInCut(7,3,1,2,1,0,0,0))
		{
				if(MSDm97.sourceInstance!=null && MSDm97.targetInstance!=null){
					EE.add(MSDm97);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm102,MSDm103,MSDm98,MSDm101,MSDm105);
				HV.add(MSDm104);
				return;
		}
		 if(activeMSD.isInCut(8,3,1,2,2,0,0,0))
		{
				if(MSDm101.sourceInstance!=null && MSDm101.targetInstance!=null){
					EE.add(MSDm101);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm99,MSDm98,MSDm100,MSDm97,MSDm96);
				return;
		}
		 if(activeMSD.isInCut(9,3,1,2,2,1,0,0))
		{
				if(MSDm104.sourceInstance!=null && MSDm104.targetInstance!=null){
					EE.add(MSDm104);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm99,MSDm98,MSDm100,MSDm97,MSDm96);
				return;
		}
		 if(activeMSD.isInCut(10,3,1,2,2,1,1,0))
		{
				if(MSDm99.sourceInstance!=null && MSDm99.targetInstance!=null){
					EE.add(MSDm99);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm102,MSDm103,MSDm98,MSDm101,MSDm105);
				HV.add(MSDm104);
				return;
		}
		 if(activeMSD.isInCut(11,3,1,2,2,1,2,0))
		{
				if(MSDm105.sourceInstance!=null && MSDm105.targetInstance!=null){
					EE.add(MSDm105);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm99,MSDm98,MSDm100,MSDm97,MSDm96);
				return;
		}
		 if(activeMSD.isInCut(12,3,1,2,2,1,2,1))
		{
				if(MSDm100.sourceInstance!=null && MSDm100.targetInstance!=null){
					EE.add(MSDm100);
				}
				HV.add(MSDm93,MSDm95,MSDm94,MSDm102,MSDm103,MSDm98,MSDm101,MSDm105);
				HV.add(MSDm104);
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

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg08);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg010);
		}

		int ID = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID)!=null){
			ID = (int) activeMSD.getPrivateVariable(int_arg_int_symbolic_var_ID);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg02);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg01);
		}

		int arg00 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00)!=null){
			arg00 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg00);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg07);
		}

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_opaque_arg05);
		}

		Object result = null;
		// in case the object is already bounded returning the bounded object
		result = activeMSD.getLineInstance(lifelineIndex);
		if (result == null){
			SysManager sysManager = (SysManager) activeMSD.getLineInstance(SysManager_INST_sysManager);
			Terminal terminal6 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal6);
			PlatformManager platformManager6 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager6);
			Entrance entrance6r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6r);
			Entrance entrance6l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance6l);
			ExitsManager exitsManager6 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_exitsManager6);
			Exit exit6r = (Exit) activeMSD.getLineInstance(Exit_INST_exit6r);
			Exit exit6l = (Exit) activeMSD.getLineInstance(Exit_INST_exit6l);
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
