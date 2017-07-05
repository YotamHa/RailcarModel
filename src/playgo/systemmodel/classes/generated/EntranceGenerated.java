
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
public class EntranceGenerated
    extends SMBaseClass
{

    protected int terminalId = (0);
    protected String direction = ("");

    public EntranceGenerated(java.lang.String name) {
        super(name);
        oneTimeInit();
    }

    public EntranceGenerated(java.lang.String name, boolean init) {
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
    public void moveTo(int platform) {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> moveTo(int) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Entrance"), (name), ("moveTo"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(platform);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("moveTo"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getTerminalId() {
        return terminalId;
    }

    @SystemModelGen
    public void setTerminalId(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setTerminalId"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.terminalId=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setTerminalId(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Entrance", name, "terminalId", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Entrance", name, "terminalId", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Entrance"), (name), ("terminalId"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setTerminalId"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitTerminalId(int arg0) {
        this.terminalId=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Entrance", name, "terminalId", String.valueOf(arg0));
    }

    @SystemModelGen
    public String getDirection() {
        return direction;
    }

    @SystemModelGen
    public void setDirection(String arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("String");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setDirection"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.direction=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setDirection(String) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Entrance", name, "direction", arg0);
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Entrance", name, "direction", arg0);
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Entrance"), (name), ("direction"), ("String"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setDirection"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitDirection(String arg0) {
        this.direction=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Entrance", name, "direction", arg0);
    }

}
