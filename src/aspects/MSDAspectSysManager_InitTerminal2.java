//  The file MSDAspectSysManager_InitTerminal2.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_InitTerminal2 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Terminal_INST_terminal2 = 1;
	static final int PlatformManager_INST_platformManager2 = 2;
	static final int Entrance_INST_entrance2r = 3;
	static final int Entrance_INST_entrance2l = 4;
	static final int ExitsManager_INST_existsManager1 = 5;
	static final int Exit_INST_exit1r = 6;
	static final int Exit_INST_exit1l = 7;

	static final int int_arg_int_exact_int_arg07 = 0;
	static final int int_arg_int_exact_int_arg08 = 1;
	static final int int_arg_int_exact_int_arg010 = 2;
	static final int int_arg_int_exact_int_arg01 = 3;
	static final int int_arg_int_exact_int_arg02 = 4;
	static final int int_arg_int_exact_int_arg03 = 5;
	static final int int_arg_int_exact_int_arg05 = 6;
	static final int int_arg_int_exact_int_arg00 = 7;
	static final int String_arg_String_exact_String_arg04 = 8;
	static final int String_arg_String_exact_String_arg09 = 9;
	static final int String_arg_String_exact_String_arg06 = 10;
	static final int String_arg_String_exact_String_arg011 = 11;

	static final int int_var_symbolic_minimalDistance = 12;

	private final String niceName = "SysManager_InitTerminal2";

	private static MSDAspectSysManager_InitTerminal2 instance = null;

	public static MSDAspectSysManager_InitTerminal2 getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_InitTerminal2();
		}
		return instance;
	}

	private MSDAspectSysManager_InitTerminal2()
	{
		addAspectEvent(MSDMethods.SysManager_SysManager_initTerminals);
		PlaygoCoordinator.getInstance().subscribe(this, 
			"SysManager", "SysManager", "initTerminals");
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

		addMinimalEvent(MSDMethods.SysManager_SysManager_initTerminals);
		setHotCut(4,2,1,0,0,0,0,0);
		setHotCut(10,2,1,2,2,1,1,0);
		setHotCut(9,2,1,2,2,1,0,0);
		setHotCut(3,2,0,0,0,0,0,0);
		setHotCut(6,2,1,2,0,0,0,0);
		setHotCut(7,2,1,2,1,0,0,0);
		setHotCut(8,2,1,2,2,0,0,0);
		setHotCut(11,2,1,2,2,1,2,0);
		setHotCut(5,2,1,1,0,0,0,0);
		setHotCut(12,2,1,2,2,1,2,1);
		setHotCut(2,1,0,0,0,0,0,0);
		setHotCut(1,0,0,0,0,0,0,0);
		setLastCut(13,2,1,2,2,1,2,2);
		numberOfLifeLines = 8;
		numberOfInstances = 8;
		numberOfVariables = 13;
		numberOfTimeTags = 0;
		interactionId = "1499083609374";
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
			case MSDMethods.SysManager_SysManager_initTerminals:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(SysManager_INST_sysManager,targetObject))
				{
					unification=true;
					if(activeMSD.isInCut(0,0,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(1,0,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Entrance_setTerminalId:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance2r,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg03,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(4,2,1,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(5,2,1,1,0,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance2l,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg05,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(6,2,1,2,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(7,2,1,2,1,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Entrance_setDirection:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance2r,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg04,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(5,2,1,1,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(6,2,1,2,0,0,0,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Entrance_INST_entrance2l,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg06,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(7,2,1,2,1,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(8,2,1,2,2,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Terminal_setLocation:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg00,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(1,0,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(2,1,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Exit_setDirection:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit1r,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg09,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(10,2,1,2,2,1,1,0))
					{
						cutChanged=true; activeMSD.setCut(11,2,1,2,2,1,2,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit1l,targetObject)
					&& activeMSD.variableEquals(String_arg_String_exact_String_arg011,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(12,2,1,2,2,1,2,1))
					{
						cutChanged=true; activeMSD.setCut(13,2,1,2,2,1,2,2);
						break;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_ExitsManager_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(ExitsManager_INST_existsManager1,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg07,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(8,2,1,2,2,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(9,2,1,2,2,1,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Terminal_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Terminal_INST_terminal2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg01,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(2,1,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(3,2,0,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_PlatformManager_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager2,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg02,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(3,2,0,0,0,0,0,0))
					{
						cutChanged=true; activeMSD.setCut(4,2,1,0,0,0,0,0);
						return cutChanged;
					}
				}
				if(!unification)//No unification...
					return false;
				break;

			case MSDMethods.SysManager_Exit_setID:
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit1r,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg08,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(9,2,1,2,2,1,0,0))
					{
						cutChanged=true; activeMSD.setCut(10,2,1,2,2,1,1,0);
						return cutChanged;
					}
				}
				if(activeMSD.instancesEquals(SysManager_INST_sysManager,sourceObject)
					&& activeMSD.instancesEquals(Exit_INST_exit1l,targetObject)
					&& activeMSD.variableEquals(int_arg_int_exact_int_arg010,args.get(0)))
				{
					unification=true;
					if(activeMSD.isInCut(11,2,1,2,2,1,2,0))
					{
						cutChanged=true; activeMSD.setCut(12,2,1,2,2,1,2,1);
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
		Terminal terminal2 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal2,null, true);;
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Entrance entrance2r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2r,null, true);;
		Entrance entrance2l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2l,null, true);;
		ExitsManager existsManager1 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager1,null, true);;
		Exit exit1r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1r,null, true);;
		Exit exit1l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1l,null, true);;

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
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
		Terminal terminal2 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal2,null, true);;
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Entrance entrance2r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2r,null, true);;
		Entrance entrance2l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2l,null, true);;
		ExitsManager existsManager1 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager1,null, true);;
		Exit exit1r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1r,null, true);;
		Exit exit1l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1l,null, true);;

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
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
		activeMSD.setLineInstance(Terminal_INST_terminal2,AppObjects.getObject("terminal2","Terminal"));
		activeMSD.setLineInstance(PlatformManager_INST_platformManager2,AppObjects.getObject("platformManager2","PlatformManager"));
		activeMSD.setLineInstance(Entrance_INST_entrance2r,AppObjects.getObject("entrance2r","Entrance"));
		activeMSD.setLineInstance(Entrance_INST_entrance2l,AppObjects.getObject("entrance2l","Entrance"));
		activeMSD.setLineInstance(ExitsManager_INST_existsManager1,AppObjects.getObject("existsManager1","ExitsManager"));
		activeMSD.setLineInstance(Exit_INST_exit1r,AppObjects.getObject("exit1r","Exit"));
		activeMSD.setLineInstance(Exit_INST_exit1l,AppObjects.getObject("exit1l","Exit"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Terminal terminal2 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal2, null, false );
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2, null, false );
		Entrance entrance2r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2r, null, false );
		Entrance entrance2l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2l, null, false );
		ExitsManager existsManager1 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager1, null, false );
		Exit exit1r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1r, null, false );
		Exit exit1l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1l, null, false );

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
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
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg07, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg08, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg010, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg01, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg02, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg03, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg05, (int)2);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg00, (int)500);
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

	private void after_SysManager_SysManager_initTerminals(Object _sysManagerSource ,Object _sysManager)
	{
		changeCutState(MSDMethods.SysManager_SysManager_initTerminals,
					_sysManager,_sysManager,null);
	}

	private void after_SysManager_Terminal_setLocation(Object _sysManager ,Object _terminal2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setLocation,
					_sysManager,_terminal2,args);
	}

	private void after_SysManager_Terminal_setID(Object _sysManager ,Object _terminal2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setID,
					_sysManager,_terminal2,args);
	}

	private void after_SysManager_PlatformManager_setID(Object _sysManager ,Object _platformManager2, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_PlatformManager_setID,
					_sysManager,_platformManager2,args);
	}

	private void after_SysManager_Entrance_setTerminalId(Object _sysManager ,Object _entrance2r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setTerminalId,
					_sysManager,_entrance2r,args);
	}

	private void after_SysManager_Entrance_setDirection(Object _sysManager ,Object _entrance2r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setDirection,
					_sysManager,_entrance2r,args);
	}

	private void after_SysManager_ExitsManager_setID(Object _sysManager ,Object _existsManager1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_ExitsManager_setID,
					_sysManager,_existsManager1,args);
	}

	private void after_SysManager_Exit_setID(Object _sysManager ,Object _exit1r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Exit_setID,
					_sysManager,_exit1r,args);
	}

	private void after_SysManager_Exit_setDirection(Object _sysManager ,Object _exit1r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Exit_setDirection,
					_sysManager,_exit1r,args);
	}

	@Override
	public void afterEvent(Object source, String srcClassName, 
		Object target, String tgtClassName, String method, 
		ArrayList<String> argTypes, ArrayList<Object> argValues)
	{
		if(srcClassName.equals("SysManager") && tgtClassName.equals("SysManager") && method.equals("initTerminals")){
			after_SysManager_SysManager_initTerminals(source, target);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setLocation")){
			after_SysManager_Terminal_setLocation(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Terminal") && method.equals("setID")){
			after_SysManager_Terminal_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("PlatformManager") && method.equals("setID")){
			after_SysManager_PlatformManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Entrance") && method.equals("setTerminalId")){
			after_SysManager_Entrance_setTerminalId(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Entrance") && method.equals("setDirection")){
			after_SysManager_Entrance_setDirection(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("ExitsManager") && method.equals("setID")){
			after_SysManager_ExitsManager_setID(source, target, argValues);
			return;
		}
		if(srcClassName.equals("SysManager") && tgtClassName.equals("Exit") && method.equals("setID")){
			after_SysManager_Exit_setID(source, target, argValues);
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
		Terminal terminal2 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal2,null, true);;
		PlatformManager platformManager2 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager2,null, true);;
		Entrance entrance2r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2r,null, true);;
		Entrance entrance2l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance2l,null, true);;
		ExitsManager existsManager1 = (ExitsManager)bindObjectByExpression(activeMSD,ExitsManager_INST_existsManager1,null, true);;
		Exit exit1r = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1r,null, true);;
		Exit exit1l = (Exit)bindObjectByExpression(activeMSD,Exit_INST_exit1l,null, true);;

		Integer VAR_int_exact_int_arg05 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05)!=null){
			VAR_int_exact_int_arg05 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05);
		}

		String VAR_String_exact_String_arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			VAR_String_exact_String_arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		Integer VAR_int_exact_int_arg03 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			VAR_int_exact_int_arg03 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		Integer VAR_int_exact_int_arg02 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			VAR_int_exact_int_arg02 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		Integer VAR_int_exact_int_arg08 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08)!=null){
			VAR_int_exact_int_arg08 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08);
		}

		Integer VAR_int_exact_int_arg07 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07)!=null){
			VAR_int_exact_int_arg07 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07);
		}

		Integer VAR_int_exact_int_arg010 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010)!=null){
			VAR_int_exact_int_arg010 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010);
		}

		String VAR_String_exact_String_arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			VAR_String_exact_String_arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String VAR_String_exact_String_arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			VAR_String_exact_String_arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		Integer VAR_int_exact_int_arg01 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			VAR_int_exact_int_arg01 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		String VAR_String_exact_String_arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			VAR_String_exact_String_arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
		}

		Integer VAR_int_exact_int_arg00 = null;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00)!=null){
			VAR_int_exact_int_arg00 = (Integer) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg00);
		}

		MSDMethod MSDm36 = new MSDMethod(sysManager,sysManager,
			MSDMethods.SysManager_SysManager_initTerminals,null,"SysManager:SysManager:initTerminals",niceName,activeMSD.getGlobalId());// initTerminals() Monitored
		ArrayList<Object>  args37 = getArgsList(VAR_int_exact_int_arg03);
		MSDMethod MSDm37 = new MSDMethod(sysManager,entrance2r,
			MSDMethods.SysManager_Entrance_setTerminalId,args37,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args38 = getArgsList(VAR_int_exact_int_arg05);
		MSDMethod MSDm38 = new MSDMethod(sysManager,entrance2l,
			MSDMethods.SysManager_Entrance_setTerminalId,args38,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args39 = getArgsList(VAR_String_exact_String_arg04);
		MSDMethod MSDm39 = new MSDMethod(sysManager,entrance2r,
			MSDMethods.SysManager_Entrance_setDirection,args39,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args40 = getArgsList(VAR_String_exact_String_arg06);
		MSDMethod MSDm40 = new MSDMethod(sysManager,entrance2l,
			MSDMethods.SysManager_Entrance_setDirection,args40,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args41 = getArgsList(VAR_int_exact_int_arg00);
		MSDMethod MSDm41 = new MSDMethod(sysManager,terminal2,
			MSDMethods.SysManager_Terminal_setLocation,args41,"SysManager:Terminal:setLocation",niceName,activeMSD.getGlobalId());// setLocation() Execute
		ArrayList<Object>  args42 = getArgsList(VAR_String_exact_String_arg09);
		MSDMethod MSDm42 = new MSDMethod(sysManager,exit1r,
			MSDMethods.SysManager_Exit_setDirection,args42,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args43 = getArgsList(VAR_String_exact_String_arg011);
		MSDMethod MSDm43 = new MSDMethod(sysManager,exit1l,
			MSDMethods.SysManager_Exit_setDirection,args43,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args44 = getArgsList(VAR_int_exact_int_arg07);
		MSDMethod MSDm44 = new MSDMethod(sysManager,existsManager1,
			MSDMethods.SysManager_ExitsManager_setID,args44,"SysManager:ExitsManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args45 = getArgsList(VAR_int_exact_int_arg01);
		MSDMethod MSDm45 = new MSDMethod(sysManager,terminal2,
			MSDMethods.SysManager_Terminal_setID,args45,"SysManager:Terminal:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args46 = getArgsList(VAR_int_exact_int_arg02);
		MSDMethod MSDm46 = new MSDMethod(sysManager,platformManager2,
			MSDMethods.SysManager_PlatformManager_setID,args46,"SysManager:PlatformManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args47 = getArgsList(VAR_int_exact_int_arg08);
		MSDMethod MSDm47 = new MSDMethod(sysManager,exit1r,
			MSDMethods.SysManager_Exit_setID,args47,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args48 = getArgsList(VAR_int_exact_int_arg010);
		MSDMethod MSDm48 = new MSDMethod(sysManager,exit1l,
			MSDMethods.SysManager_Exit_setID,args48,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute

		 if(activeMSD.isInCut(0,0,0,0,0,0,0,0))
		{
				ME.add(MSDm36);
				CV.add(MSDm41,MSDm40,MSDm48,MSDm43,MSDm46,MSDm39,MSDm47,MSDm38);
				CV.add(MSDm44,MSDm42,MSDm45,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(1,0,0,0,0,0,0,0))
		{
				if(MSDm41.sourceInstance!=null && MSDm41.targetInstance!=null){
					EE.add(MSDm41);
				}
				HV.add(MSDm40,MSDm48,MSDm43,MSDm46,MSDm39,MSDm47,MSDm38,MSDm44);
				HV.add(MSDm42,MSDm45,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(2,1,0,0,0,0,0,0))
		{
				if(MSDm45.sourceInstance!=null && MSDm45.targetInstance!=null){
					EE.add(MSDm45);
				}
				HV.add(MSDm41,MSDm40,MSDm43,MSDm39,MSDm38,MSDm42,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(3,2,0,0,0,0,0,0))
		{
				if(MSDm46.sourceInstance!=null && MSDm46.targetInstance!=null){
					EE.add(MSDm46);
				}
				HV.add(MSDm41,MSDm40,MSDm43,MSDm39,MSDm38,MSDm42,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(4,2,1,0,0,0,0,0))
		{
				if(MSDm37.sourceInstance!=null && MSDm37.targetInstance!=null){
					EE.add(MSDm37);
				}
				HV.add(MSDm41,MSDm40,MSDm48,MSDm43,MSDm46,MSDm39,MSDm47,MSDm44);
				HV.add(MSDm42,MSDm45,MSDm36);
				return;
		}
		 if(activeMSD.isInCut(5,2,1,1,0,0,0,0))
		{
				if(MSDm39.sourceInstance!=null && MSDm39.targetInstance!=null){
					EE.add(MSDm39);
				}
				HV.add(MSDm41,MSDm48,MSDm46,MSDm47,MSDm38,MSDm44,MSDm45,MSDm36);
				HV.add(MSDm37);
				return;
		}
		 if(activeMSD.isInCut(6,2,1,2,0,0,0,0))
		{
				if(MSDm38.sourceInstance!=null && MSDm38.targetInstance!=null){
					EE.add(MSDm38);
				}
				HV.add(MSDm41,MSDm40,MSDm48,MSDm43,MSDm46,MSDm39,MSDm47,MSDm44);
				HV.add(MSDm42,MSDm45,MSDm36);
				return;
		}
		 if(activeMSD.isInCut(7,2,1,2,1,0,0,0))
		{
				if(MSDm40.sourceInstance!=null && MSDm40.targetInstance!=null){
					EE.add(MSDm40);
				}
				HV.add(MSDm41,MSDm48,MSDm46,MSDm47,MSDm38,MSDm44,MSDm45,MSDm36);
				HV.add(MSDm37);
				return;
		}
		 if(activeMSD.isInCut(8,2,1,2,2,0,0,0))
		{
				if(MSDm44.sourceInstance!=null && MSDm44.targetInstance!=null){
					EE.add(MSDm44);
				}
				HV.add(MSDm41,MSDm40,MSDm43,MSDm39,MSDm38,MSDm42,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(9,2,1,2,2,1,0,0))
		{
				if(MSDm47.sourceInstance!=null && MSDm47.targetInstance!=null){
					EE.add(MSDm47);
				}
				HV.add(MSDm41,MSDm40,MSDm43,MSDm39,MSDm38,MSDm42,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(10,2,1,2,2,1,1,0))
		{
				if(MSDm42.sourceInstance!=null && MSDm42.targetInstance!=null){
					EE.add(MSDm42);
				}
				HV.add(MSDm41,MSDm48,MSDm46,MSDm47,MSDm38,MSDm44,MSDm45,MSDm36);
				HV.add(MSDm37);
				return;
		}
		 if(activeMSD.isInCut(11,2,1,2,2,1,2,0))
		{
				if(MSDm48.sourceInstance!=null && MSDm48.targetInstance!=null){
					EE.add(MSDm48);
				}
				HV.add(MSDm41,MSDm40,MSDm43,MSDm39,MSDm38,MSDm42,MSDm36,MSDm37);
				return;
		}
		 if(activeMSD.isInCut(12,2,1,2,2,1,2,1))
		{
				if(MSDm43.sourceInstance!=null && MSDm43.targetInstance!=null){
					EE.add(MSDm43);
				}
				HV.add(MSDm41,MSDm48,MSDm46,MSDm47,MSDm38,MSDm44,MSDm45,MSDm36);
				HV.add(MSDm37);
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

		int arg05 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05)!=null){
			arg05 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg05);
		}

		String arg011 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011)!=null){
			arg011 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg011);
		}

		int arg03 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03)!=null){
			arg03 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg03);
		}

		int arg02 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02)!=null){
			arg02 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg02);
		}

		int arg08 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08)!=null){
			arg08 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg08);
		}

		int arg07 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07)!=null){
			arg07 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg07);
		}

		int arg010 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010)!=null){
			arg010 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg010);
		}

		String arg09 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09)!=null){
			arg09 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg09);
		}

		String arg06 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06)!=null){
			arg06 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg06);
		}

		int arg01 = 0;
		if(activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01)!=null){
			arg01 = (int) activeMSD.getPrivateVariable(int_arg_int_exact_int_arg01);
		}

		String arg04 = null;
		if(activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04)!=null){
			arg04 = (String) activeMSD.getPrivateVariable(String_arg_String_exact_String_arg04);
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
			Terminal terminal2 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal2);
			PlatformManager platformManager2 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager2);
			Entrance entrance2r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance2r);
			Entrance entrance2l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance2l);
			ExitsManager existsManager1 = (ExitsManager) activeMSD.getLineInstance(ExitsManager_INST_existsManager1);
			Exit exit1r = (Exit) activeMSD.getLineInstance(Exit_INST_exit1r);
			Exit exit1l = (Exit) activeMSD.getLineInstance(Exit_INST_exit1l);
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
