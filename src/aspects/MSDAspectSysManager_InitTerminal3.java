//  The file MSDAspectSysManager_InitTerminal3.aj was automatically generated using S2A 2.0.0.qualifier.
//  For information see http://www.wisdom.weizmann.ac.il/~maozs/s2a/

package aspects;

import playgo.systemmodel.classes.*;
import playgo.systemmodel.classes.generated.*;
import java.util.ArrayList;
import il.ac.wis.cs.s2a.runtime.lib.*;
import il.ac.wis.cs.playgo.playtoolkit.*;


public class MSDAspectSysManager_InitTerminal3 extends MSDAspect implements MSDSubscribe
{


	//Constants for instances, locations and variables
	static final int SysManager_INST_sysManager = 0;
	static final int Terminal_INST_terminal1 = 1;
	static final int PlatformManager_INST_platformManager1 = 2;
	static final int Entrance_INST_entrance1r = 3;
	static final int Entrance_INST_entrance1l = 4;
	static final int ExitsManager_INST_existsManager1 = 5;
	static final int Exit_INST_exit1r = 6;
	static final int Exit_INST_exit1l = 7;

	static final int int_arg_int_exact_int_arg00 = 0;
	static final int int_arg_int_exact_int_arg01 = 1;
	static final int int_arg_int_exact_int_arg02 = 2;
	static final int int_arg_int_exact_int_arg03 = 3;
	static final int int_arg_int_exact_int_arg05 = 4;
	static final int int_arg_int_exact_int_arg07 = 5;
	static final int int_arg_int_exact_int_arg08 = 6;
	static final int int_arg_int_exact_int_arg010 = 7;
	static final int String_arg_String_exact_String_arg04 = 8;
	static final int String_arg_String_exact_String_arg09 = 9;
	static final int String_arg_String_exact_String_arg06 = 10;
	static final int String_arg_String_exact_String_arg011 = 11;

	static final int int_var_symbolic_minimalDistance = 12;

	private final String niceName = "SysManager_InitTerminal3";

	private static MSDAspectSysManager_InitTerminal3 instance = null;

	public static MSDAspectSysManager_InitTerminal3 getInstance(){
		if(instance==null){
			instance = new MSDAspectSysManager_InitTerminal3();
		}
		return instance;
	}

	private MSDAspectSysManager_InitTerminal3()
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
		setHotCut(5,2,1,1,0,0,0,0);
		setHotCut(8,2,1,2,2,0,0,0);
		setHotCut(3,2,0,0,0,0,0,0);
		setHotCut(11,2,1,2,2,1,2,0);
		setHotCut(6,2,1,2,0,0,0,0);
		setHotCut(12,2,1,2,2,1,2,1);
		setHotCut(1,0,0,0,0,0,0,0);
		setHotCut(2,1,0,0,0,0,0,0);
		setHotCut(9,2,1,2,2,1,0,0);
		setHotCut(10,2,1,2,2,1,1,0);
		setHotCut(7,2,1,2,1,0,0,0);
		setLastCut(13,2,1,2,2,1,2,2);
		numberOfLifeLines = 8;
		numberOfInstances = 8;
		numberOfVariables = 13;
		numberOfTimeTags = 0;
		interactionId = "1499083609396";
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
					&& activeMSD.instancesEquals(Entrance_INST_entrance1r,targetObject)
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
					&& activeMSD.instancesEquals(Entrance_INST_entrance1l,targetObject)
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
					&& activeMSD.instancesEquals(Entrance_INST_entrance1r,targetObject)
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
					&& activeMSD.instancesEquals(Entrance_INST_entrance1l,targetObject)
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
					&& activeMSD.instancesEquals(Terminal_INST_terminal1,targetObject)
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
					&& activeMSD.instancesEquals(Terminal_INST_terminal1,targetObject)
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
					&& activeMSD.instancesEquals(PlatformManager_INST_platformManager1,targetObject)
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
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;
		PlatformManager platformManager1 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager1,null, true);;
		Entrance entrance1r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1r,null, true);;
		Entrance entrance1l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1l,null, true);;
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
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;
		PlatformManager platformManager1 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager1,null, true);;
		Entrance entrance1r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1r,null, true);;
		Entrance entrance1l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1l,null, true);;
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
		activeMSD.setLineInstance(Terminal_INST_terminal1,AppObjects.getObject("terminal1","Terminal"));
		activeMSD.setLineInstance(PlatformManager_INST_platformManager1,AppObjects.getObject("platformManager1","PlatformManager"));
		activeMSD.setLineInstance(Entrance_INST_entrance1r,AppObjects.getObject("entrance1r","Entrance"));
		activeMSD.setLineInstance(Entrance_INST_entrance1l,AppObjects.getObject("entrance1l","Entrance"));
		activeMSD.setLineInstance(ExitsManager_INST_existsManager1,AppObjects.getObject("existsManager1","ExitsManager"));
		activeMSD.setLineInstance(Exit_INST_exit1r,AppObjects.getObject("exit1r","Exit"));
		activeMSD.setLineInstance(Exit_INST_exit1l,AppObjects.getObject("exit1l","Exit"));
		SysManager sysManager = (SysManager)bindObjectByExpression(activeMSD,SysManager_INST_sysManager, null, false );
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1, null, false );
		PlatformManager platformManager1 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager1, null, false );
		Entrance entrance1r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1r, null, false );
		Entrance entrance1l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1l, null, false );
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
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg00, (int)0);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg01, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg02, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg03, (int)1);
		}catch(Exception e){}
		try{
			activeMSD.setPrivateVariable(int_arg_int_exact_int_arg05, (int)1);
		}catch(Exception e){}
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

	private void after_SysManager_Terminal_setLocation(Object _sysManager ,Object _terminal1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setLocation,
					_sysManager,_terminal1,args);
	}

	private void after_SysManager_Terminal_setID(Object _sysManager ,Object _terminal1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Terminal_setID,
					_sysManager,_terminal1,args);
	}

	private void after_SysManager_PlatformManager_setID(Object _sysManager ,Object _platformManager1, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_PlatformManager_setID,
					_sysManager,_platformManager1,args);
	}

	private void after_SysManager_Entrance_setTerminalId(Object _sysManager ,Object _entrance1r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setTerminalId,
					_sysManager,_entrance1r,args);
	}

	private void after_SysManager_Entrance_setDirection(Object _sysManager ,Object _entrance1r, ArrayList<Object> args)
	{
		changeCutState(MSDMethods.SysManager_Entrance_setDirection,
					_sysManager,_entrance1r,args);
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
		Terminal terminal1 = (Terminal)bindObjectByExpression(activeMSD,Terminal_INST_terminal1,null, true);;
		PlatformManager platformManager1 = (PlatformManager)bindObjectByExpression(activeMSD,PlatformManager_INST_platformManager1,null, true);;
		Entrance entrance1r = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1r,null, true);;
		Entrance entrance1l = (Entrance)bindObjectByExpression(activeMSD,Entrance_INST_entrance1l,null, true);;
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

		MSDMethod MSDm49 = new MSDMethod(sysManager,sysManager,
			MSDMethods.SysManager_SysManager_initTerminals,null,"SysManager:SysManager:initTerminals",niceName,activeMSD.getGlobalId());// initTerminals() Monitored
		ArrayList<Object>  args50 = getArgsList(VAR_int_exact_int_arg03);
		MSDMethod MSDm50 = new MSDMethod(sysManager,entrance1r,
			MSDMethods.SysManager_Entrance_setTerminalId,args50,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args51 = getArgsList(VAR_int_exact_int_arg05);
		MSDMethod MSDm51 = new MSDMethod(sysManager,entrance1l,
			MSDMethods.SysManager_Entrance_setTerminalId,args51,"SysManager:Entrance:setTerminalId",niceName,activeMSD.getGlobalId());// setTerminalId() Execute
		ArrayList<Object>  args52 = getArgsList(VAR_String_exact_String_arg04);
		MSDMethod MSDm52 = new MSDMethod(sysManager,entrance1r,
			MSDMethods.SysManager_Entrance_setDirection,args52,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args53 = getArgsList(VAR_String_exact_String_arg06);
		MSDMethod MSDm53 = new MSDMethod(sysManager,entrance1l,
			MSDMethods.SysManager_Entrance_setDirection,args53,"SysManager:Entrance:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args54 = getArgsList(VAR_int_exact_int_arg00);
		MSDMethod MSDm54 = new MSDMethod(sysManager,terminal1,
			MSDMethods.SysManager_Terminal_setLocation,args54,"SysManager:Terminal:setLocation",niceName,activeMSD.getGlobalId());// setLocation() Execute
		ArrayList<Object>  args55 = getArgsList(VAR_String_exact_String_arg09);
		MSDMethod MSDm55 = new MSDMethod(sysManager,exit1r,
			MSDMethods.SysManager_Exit_setDirection,args55,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args56 = getArgsList(VAR_String_exact_String_arg011);
		MSDMethod MSDm56 = new MSDMethod(sysManager,exit1l,
			MSDMethods.SysManager_Exit_setDirection,args56,"SysManager:Exit:setDirection",niceName,activeMSD.getGlobalId());// setDirection() Execute
		ArrayList<Object>  args57 = getArgsList(VAR_int_exact_int_arg07);
		MSDMethod MSDm57 = new MSDMethod(sysManager,existsManager1,
			MSDMethods.SysManager_ExitsManager_setID,args57,"SysManager:ExitsManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args58 = getArgsList(VAR_int_exact_int_arg01);
		MSDMethod MSDm58 = new MSDMethod(sysManager,terminal1,
			MSDMethods.SysManager_Terminal_setID,args58,"SysManager:Terminal:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args59 = getArgsList(VAR_int_exact_int_arg02);
		MSDMethod MSDm59 = new MSDMethod(sysManager,platformManager1,
			MSDMethods.SysManager_PlatformManager_setID,args59,"SysManager:PlatformManager:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args60 = getArgsList(VAR_int_exact_int_arg08);
		MSDMethod MSDm60 = new MSDMethod(sysManager,exit1r,
			MSDMethods.SysManager_Exit_setID,args60,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute
		ArrayList<Object>  args61 = getArgsList(VAR_int_exact_int_arg010);
		MSDMethod MSDm61 = new MSDMethod(sysManager,exit1l,
			MSDMethods.SysManager_Exit_setID,args61,"SysManager:Exit:setID",niceName,activeMSD.getGlobalId());// setID() Execute

		 if(activeMSD.isInCut(0,0,0,0,0,0,0,0))
		{
				ME.add(MSDm49);
				CV.add(MSDm51,MSDm53,MSDm58,MSDm50,MSDm56,MSDm55,MSDm59,MSDm61);
				CV.add(MSDm52,MSDm54,MSDm60,MSDm57);
				return;
		}
		 if(activeMSD.isInCut(1,0,0,0,0,0,0,0))
		{
				if(MSDm54.sourceInstance!=null && MSDm54.targetInstance!=null){
					EE.add(MSDm54);
				}
				HV.add(MSDm51,MSDm53,MSDm58,MSDm50,MSDm56,MSDm55,MSDm59,MSDm61);
				HV.add(MSDm52,MSDm49,MSDm60,MSDm57);
				return;
		}
		 if(activeMSD.isInCut(2,1,0,0,0,0,0,0))
		{
				if(MSDm58.sourceInstance!=null && MSDm58.targetInstance!=null){
					EE.add(MSDm58);
				}
				HV.add(MSDm51,MSDm53,MSDm50,MSDm56,MSDm55,MSDm52,MSDm49,MSDm54);
				return;
		}
		 if(activeMSD.isInCut(3,2,0,0,0,0,0,0))
		{
				if(MSDm59.sourceInstance!=null && MSDm59.targetInstance!=null){
					EE.add(MSDm59);
				}
				HV.add(MSDm51,MSDm53,MSDm50,MSDm56,MSDm55,MSDm52,MSDm49,MSDm54);
				return;
		}
		 if(activeMSD.isInCut(4,2,1,0,0,0,0,0))
		{
				if(MSDm50.sourceInstance!=null && MSDm50.targetInstance!=null){
					EE.add(MSDm50);
				}
				HV.add(MSDm53,MSDm58,MSDm56,MSDm55,MSDm59,MSDm61,MSDm52,MSDm49);
				HV.add(MSDm54,MSDm60,MSDm57);
				return;
		}
		 if(activeMSD.isInCut(5,2,1,1,0,0,0,0))
		{
				if(MSDm52.sourceInstance!=null && MSDm52.targetInstance!=null){
					EE.add(MSDm52);
				}
				HV.add(MSDm51,MSDm58,MSDm50,MSDm59,MSDm61,MSDm49,MSDm54,MSDm60);
				HV.add(MSDm57);
				return;
		}
		 if(activeMSD.isInCut(6,2,1,2,0,0,0,0))
		{
				if(MSDm51.sourceInstance!=null && MSDm51.targetInstance!=null){
					EE.add(MSDm51);
				}
				HV.add(MSDm53,MSDm58,MSDm56,MSDm55,MSDm59,MSDm61,MSDm52,MSDm49);
				HV.add(MSDm54,MSDm60,MSDm57);
				return;
		}
		 if(activeMSD.isInCut(7,2,1,2,1,0,0,0))
		{
				if(MSDm53.sourceInstance!=null && MSDm53.targetInstance!=null){
					EE.add(MSDm53);
				}
				HV.add(MSDm51,MSDm58,MSDm50,MSDm59,MSDm61,MSDm49,MSDm54,MSDm60);
				HV.add(MSDm57);
				return;
		}
		 if(activeMSD.isInCut(8,2,1,2,2,0,0,0))
		{
				if(MSDm57.sourceInstance!=null && MSDm57.targetInstance!=null){
					EE.add(MSDm57);
				}
				HV.add(MSDm51,MSDm53,MSDm50,MSDm56,MSDm55,MSDm52,MSDm49,MSDm54);
				return;
		}
		 if(activeMSD.isInCut(9,2,1,2,2,1,0,0))
		{
				if(MSDm60.sourceInstance!=null && MSDm60.targetInstance!=null){
					EE.add(MSDm60);
				}
				HV.add(MSDm51,MSDm53,MSDm50,MSDm56,MSDm55,MSDm52,MSDm49,MSDm54);
				return;
		}
		 if(activeMSD.isInCut(10,2,1,2,2,1,1,0))
		{
				if(MSDm55.sourceInstance!=null && MSDm55.targetInstance!=null){
					EE.add(MSDm55);
				}
				HV.add(MSDm51,MSDm58,MSDm50,MSDm59,MSDm61,MSDm49,MSDm54,MSDm60);
				HV.add(MSDm57);
				return;
		}
		 if(activeMSD.isInCut(11,2,1,2,2,1,2,0))
		{
				if(MSDm61.sourceInstance!=null && MSDm61.targetInstance!=null){
					EE.add(MSDm61);
				}
				HV.add(MSDm51,MSDm53,MSDm50,MSDm56,MSDm55,MSDm52,MSDm49,MSDm54);
				return;
		}
		 if(activeMSD.isInCut(12,2,1,2,2,1,2,1))
		{
				if(MSDm56.sourceInstance!=null && MSDm56.targetInstance!=null){
					EE.add(MSDm56);
				}
				HV.add(MSDm51,MSDm58,MSDm50,MSDm59,MSDm61,MSDm49,MSDm54,MSDm60);
				HV.add(MSDm57);
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
			Terminal terminal1 = (Terminal) activeMSD.getLineInstance(Terminal_INST_terminal1);
			PlatformManager platformManager1 = (PlatformManager) activeMSD.getLineInstance(PlatformManager_INST_platformManager1);
			Entrance entrance1r = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance1r);
			Entrance entrance1l = (Entrance) activeMSD.getLineInstance(Entrance_INST_entrance1l);
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
