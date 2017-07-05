
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
public class ExitsManagerGenerated
    extends SMBaseClass
{

    protected int ID = (0);
    protected int platformHandling = (0);

    public ExitsManagerGenerated(java.lang.String name) {
        super(name);
        oneTimeInit();
    }

    public ExitsManagerGenerated(java.lang.String name, boolean init) {
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
        	setPropertyValue("ExitsManager", name, "ID", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("ExitsManager", name, "ID", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("ExitsManager"), (name), ("ID"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setID"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitID(int arg0) {
        this.ID=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("ExitsManager", name, "ID", String.valueOf(arg0));
    }

    @SystemModelGen
    public void exitClear() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> exitClear() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("exitClear"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("exitClear"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void exitAllocated() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> exitAllocated() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("exitAllocated"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("exitAllocated"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void validAllocation(int platform) {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> validAllocation(int) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("validAllocation"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(platform);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("validAllocation"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void allocateExit1() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> allocateExit1() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("allocateExit1"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("allocateExit1"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void allocateExit2() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> allocateExit2() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("allocateExit2"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("allocateExit2"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void allocateExit3() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> allocateExit3() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("allocateExit3"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("allocateExit3"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void allocateExit4() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> allocateExit4() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("ExitsManager"), (name), ("allocateExit4"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("allocateExit4"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getPlatformHandling() {
        return platformHandling;
    }

    @SystemModelGen
    public void setPlatformHandling(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setPlatformHandling"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.platformHandling=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setPlatformHandling(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("ExitsManager", name, "platformHandling", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("ExitsManager", name, "platformHandling", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("ExitsManager"), (name), ("platformHandling"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setPlatformHandling"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitPlatformHandling(int arg0) {
        this.platformHandling=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("ExitsManager", name, "platformHandling", String.valueOf(arg0));
    }

}
