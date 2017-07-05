
package playgo.systemmodel.classes.generated;

import il.ac.wis.cs.playgo.playtoolkit.AppObjects;
import il.ac.wis.cs.systemmodel.SMBaseClass;
import il.ac.wis.cs.systemmodel.SystemModelGen;
import playgo.systemmodel.SystemModelAgent;
import playgo.systemmodel.SystemModelMain;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class shouldn't be changed. Any change to this class will be overridden!!!
 * 
 */
public class TerminalGenerated
    extends SMBaseClass
{

    protected int location = (1);
    protected int ID = (0);
    protected int allocatedPlatform = (0);

    public TerminalGenerated(java.lang.String name) {
        super(name);
        oneTimeInit();
    }

    public TerminalGenerated(java.lang.String name, boolean init) {
        super(name);
        if(init)oneTimeInit();
    }

    protected void oneTimeInit() {
        AppObjects.addObject(this);
        SystemModelAgent.getInstance().construct((getClass().getSimpleName()), (name));
         
        //GUI handling
        SystemModelMain.getInstance().getPlayable().construct((getClass().getSimpleName()), (name));
         
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        argTypes.add("String");
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argValues.add(name);
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish(
        	(source), (source.getClass().getSimpleName()), this, this.getClass().getSimpleName(), "create", argTypes, argValues);
    }

    @SystemModelGen
    public String getName() {
        return name;
    }

    public void delete() {
        AppObjects.remove(this);
         
        SystemModelAgent.getInstance().destroy((getClass().getSimpleName()), (name));
         
        //GUI handling
        SystemModelMain.getInstance().getPlayable().destroy((getClass().getSimpleName()), (name));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("delete"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void departReq() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> departReq() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("departReq"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("departReq"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void arriveReq(String direction) {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> arriveReq(String) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("arriveReq"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("String");
        argValues.add(direction);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("arriveReq"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getLocation() {
        return location;
    }

    @SystemModelGen
    public void setLocation(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setLocation"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.location=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setLocation(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Terminal", name, "location", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "location", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Terminal"), (name), ("location"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setLocation"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitLocation(int arg0) {
        this.location=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "location", String.valueOf(arg0));
    }

    @SystemModelGen
    public int getID() {
        return ID;
    }

    @SystemModelGen
    public void setID(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setID"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.ID=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setID(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Terminal", name, "ID", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "ID", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Terminal"), (name), ("ID"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setID"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitID(int arg0) {
        this.ID=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "ID", String.valueOf(arg0));
    }

    @SystemModelGen
    public void platformAllocated(int number) {
        this.allocatedPlatform=number;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> platformAllocated(int) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("platformAllocated"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(number);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("platformAllocated"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getAllocatedPlatform() {
        return allocatedPlatform;
    }

    @SystemModelGen
    public void setAllocatedPlatform(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setAllocatedPlatform"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.allocatedPlatform=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setAllocatedPlatform(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Terminal", name, "allocatedPlatform", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "allocatedPlatform", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Terminal"), (name), ("allocatedPlatform"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setAllocatedPlatform"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitAllocatedPlatform(int arg0) {
        this.allocatedPlatform=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Terminal", name, "allocatedPlatform", String.valueOf(arg0));
    }

    @SystemModelGen
    public void moveCompleted() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> moveCompleted() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("moveCompleted"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("moveCompleted"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void exitAllocated() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> exitAllocated() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("exitAllocated"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("exitAllocated"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void blankMessage() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> blankMessage() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("blankMessage"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("blankMessage"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void initTerminal(int ID) {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> initTerminal(int) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Terminal"), (name), ("initTerminal"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(ID);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("initTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

}
