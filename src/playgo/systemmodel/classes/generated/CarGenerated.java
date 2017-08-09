
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
public class CarGenerated
    extends SMBaseClass
{

    protected String mode = ("");
    protected int location = (0);
    protected String direction = ("");
    protected int CarID = (0);
    protected int Destination = (0);
    protected int terminal = (0);
    protected int platform = (0);
    protected boolean inTerminal = (true);

    public CarGenerated(java.lang.String name) {
        super(name);
        oneTimeInit();
    }

    public CarGenerated(java.lang.String name, boolean init) {
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
    public void initCar() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> initCar() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("initCar"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("initCar"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public String initB() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> initB() : String .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("initB"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("initB"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return "";
    }

    @SystemModelGen
    public void startDepart() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> startDepart() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("startDepart"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("startDepart"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void departAck() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> departAck() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("departAck"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("departAck"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void clearDest() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> clearDest() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("clearDest"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("clearDest"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void endDepart() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> endDepart() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("endDepart"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("endDepart"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void alert100() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> alert100() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("alert100"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("alert100"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void startArrival() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> startArrival() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("startArrival"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("startArrival"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void arriveAck() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> arriveAck() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("arriveAck"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("arriveAck"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void destinationSet() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> destinationSet() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("destinationSet"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("destinationSet"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void alertStop() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> alertStop() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("alertStop"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("alertStop"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void endArrival() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> endArrival() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("endArrival"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("endArrival"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public String getMode() {
        return mode;
    }

    @SystemModelGen
    public void setMode(String arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("String");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setMode"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.mode=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setMode(String) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "mode", arg0);
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "mode", arg0);
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("mode"), ("String"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setMode"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitMode(String arg0) {
        this.mode=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "mode", arg0);
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
        	setPropertyValue("Car", name, "location", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "location", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("location"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setLocation"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitLocation(int arg0) {
        this.location=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "location", String.valueOf(arg0));
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
        	setPropertyValue("Car", name, "direction", arg0);
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "direction", arg0);
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("direction"), ("String"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setDirection"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitDirection(String arg0) {
        this.direction=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "direction", arg0);
    }

    @SystemModelGen
    public void moveCar(int distance) {
        setLocation(location+distance);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> moveCar(int) : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("moveCar"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(distance);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("moveCar"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getCarID() {
        return CarID;
    }

    @SystemModelGen
    public void setCarID(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setCarID"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.CarID=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setCarID(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "CarID", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "CarID", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("CarID"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setCarID"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitCarID(int arg0) {
        this.CarID=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "CarID", String.valueOf(arg0));
    }

    @SystemModelGen
    public int getDestination() {
        return Destination;
    }

    @SystemModelGen
    public void setDestination(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setDestination"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.Destination=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setDestination(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "Destination", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "Destination", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("Destination"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setDestination"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitDestination(int arg0) {
        this.Destination=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "Destination", String.valueOf(arg0));
    }

    @SystemModelGen
    public int getTerminal() {
        return terminal;
    }

    @SystemModelGen
    public void setTerminal(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.terminal=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setTerminal(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "terminal", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "terminal", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("terminal"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setTerminal"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitTerminal(int arg0) {
        this.terminal=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "terminal", String.valueOf(arg0));
    }

    @SystemModelGen
    public void alert80() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> alert80() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("alert80"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("alert80"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void stopAtTerminal() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> stopAtTerminal() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("stopAtTerminal"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("stopAtTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public void passTerminal() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> passTerminal() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("passTerminal"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("passTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        return;
    }

    @SystemModelGen
    public int getPlatform() {
        return platform;
    }

    @SystemModelGen
    public void setPlatform(int arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("int");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setPlatform"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.platform=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setPlatform(int) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "platform", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "platform", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("platform"), ("int"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setPlatform"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitPlatform(int arg0) {
        this.platform=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "platform", String.valueOf(arg0));
    }

    @SystemModelGen
    public boolean isInTerminal() {
        return inTerminal;
    }

    @SystemModelGen
    public boolean getInTerminal() {
        return inTerminal;
    }

    @SystemModelGen
    public void setInTerminal(boolean arg0) {
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        argTypes.add("boolean");
        argValues.add(arg0);
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publishBefore((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setInTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        this.inTerminal=arg0;
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> setInTerminal(boolean) : void .Object name: " + name);
        }
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        	setPropertyValue("Car", name, "inTerminal", String.valueOf(arg0));
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "inTerminal", String.valueOf(arg0));
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().setPropertyValue(("Car"), (name), ("inTerminal"), ("boolean"), (String.valueOf(arg0)));
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("setInTerminal"), (argTypes), (argValues));
    }

    @SystemModelGen
    public void pgInitInTerminal(boolean arg0) {
        this.inTerminal=arg0;
         
        il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelAgent.getInstance()
        	.setPropertyValue("Car", name, "inTerminal", String.valueOf(arg0));
    }

    @SystemModelGen
    public void chooseTerminal() {
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> method call: >>> chooseTerminal() : void .Object name: " + name);
        }
        
		//ExecutionBridge handling
        SystemModelMain.getInstance().activateMethod(("Car"), (name), ("chooseTerminal"));
        java.util.ArrayList<String> argTypes = new java.util.ArrayList<String>();
        java.util.ArrayList<Object> argValues = new java.util.ArrayList<Object>();
        Object source = il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj!=null ? il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj : this;
        il.ac.wis.cs.s2a.runtime.lib.PlaygoCoordinator.getInstance().publish((source), (source.getClass().getSimpleName()), (this), (this.getClass().getSimpleName()), ("chooseTerminal"), (argTypes), (argValues));
        il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler.srcObj=null;
        //GUI handling
        playgo.systemmodel.SystemModelMain.getInstance().getPlayable().
        		activateMethod("Car", name, "chooseTerminal");
    }

}
