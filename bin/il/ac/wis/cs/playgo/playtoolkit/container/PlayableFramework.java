package il.ac.wis.cs.playgo.playtoolkit.container;

import il.ac.wis.cs.playgo.playtoolkit.Utils;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.java.GuiJAgent;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp.GuiTcpAgent;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayableComponent;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayableContainer;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class PlayableFramework implements IPlayableContainer, IPlayable {

	protected HashMap<String, IPlayableComponent> allPlayableComponents = new HashMap<String, IPlayableComponent>();
	protected static IPlayGo guiAgent;
	
	public enum PlayableOriginated
	{
		GUI,
		SYSTEM,
		NONE
	}
	
	//protected static boolean originatedFromGui = true;
	protected static PlayableOriginated originatedFrom = PlayableOriginated.GUI;
	protected static boolean initializing = true;
	
	protected int PORT;
	
	public PlayableFramework() {
		super();
		
		originatedFrom = PlayableOriginated.GUI;
		initializing = true;
		
		PORT = Utils.getPort();
		
		initPlayable();
		initialize();
		if( ! (this instanceof PlayableContainer) ){
			appIsUp();
		}
	}

	protected void initPlayable() 
	{
		if (guiAgent == null)
		{
//	        String playInStr = System.getProperty("playInMode");
//	        if(playInStr!=null && playInStr.equals("true")){
			if (Utils.isPlayInMode()){
	        	guiAgent = new GuiTcpAgent(this, PORT);	//play-in
	        }
	        else{
	        	guiAgent = new GuiJAgent(this);
	        }
		}
	}

	public PlayableOriginated getOriginatedFrom() {
		return originatedFrom;
	}

	public void setOriginatedFrom(PlayableOriginated originatedFrom) {
			this.originatedFrom = originatedFrom;
	}
	
	public boolean isOriginatedFromGui() {
		return (originatedFrom == PlayableOriginated.GUI);
		//return originatedFromGui;
	}

	public void setOriginatedFromGui(boolean originatedFromGui) {
		if(originatedFromGui)
			originatedFrom = PlayableOriginated.GUI;
		else
			originatedFrom = PlayableOriginated.NONE;
		//this.originatedFromGui = originatedFromGui;
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlaygo(IPlayGo playgo) {
		// TODO Auto-generated method stub

	}

	@Override
	public String activateMethod(String className, String objectName,
			String methodName, String... arguments) 
	{
		String retVal;
		IPlayableComponent obj = allPlayableComponents.get(objectName);
		
		if (obj!=null){
			setOriginatedFromGui(false);
			retVal =  obj.activateMethod(methodName, arguments);
			if( ! initializing){
				setOriginatedFromGui(true);
			}
			return retVal;
		}
		
		return null;
	}

	@Override
	public void setPropertyValue(String className, String objectName,
			String propertyName, String value) 
	{
		if(initializing){
			return;
		}
		setOriginatedFromGui(false);
		IPlayableComponent obj = allPlayableComponents.get(objectName);
		if (obj != null){
			obj.setPropertyValue(propertyName, value);
		}
		setOriginatedFromGui(true);
	}

	@Override
	public String getPropertyValue(String className, String objectName,
			String propertyName) {
		IPlayableComponent obj = allPlayableComponents.get(objectName);
		if (obj != null){
			return obj.getPropertyValue(propertyName);
		}
		return null;
	}

	@Override
	public void highlightObject(String objectName) 
	{
		IPlayableComponent obj = allPlayableComponents.get(objectName);
		if(obj!=null){
			obj.highlightObject(objectName);
		}
	}

	@Override
	public void clearObject(){
		// TODO Auto-generated method stub

	}

	@Override
	public String getObjectPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void construct(String className, String objectName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void destroy(String className, String objectName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(IPlayableComponent comp, String compName) {
		if (comp.getFramework() == null)
			comp.setFramework(this);
		
		allPlayableComponents.put(compName, comp);
	}
	
	public void add(IPlayableComponent comp) {
		add(comp, comp.getName());
	}

	@Override
	public void objectEvent(String className, String objectName,
			String eventName, ArrayList<String> argTypes, ArrayList<String> argValues) 
	{
		if(initializing){
			return;
		}
		
		if(isOriginatedFromGui()){
			guiAgent.objectEvent(className, objectName, eventName, argTypes, argValues);
		}
		else if(originatedFrom==PlayableOriginated.SYSTEM){
			guiAgent.systemEvent(className, objectName, className, objectName, eventName, argTypes, argValues);			
		}
		else{
			setOriginatedFromGui(true); // init to true again for the next "real" objectEvent
			return;
		}
	}

	@Override
	public void objectRightClicked(String className, String objectName) {
		guiAgent.objectRightClicked(className, objectName);
	}

	@Override
	public void objectPropertyChanged(String className, String objectName,
			String propertyName, String type, String value) {
//		// during play-in, we do not update the behavior - that's a decision we made. we may change this in the future...
//		if (Utils.isPlayInMode())
//			return;

		if(initializing){
			return;
		}

		//if (originatedFromGui){
		if(originatedFrom == originatedFrom.GUI){
			guiAgent.objectPropertyChanged("Env", "User", className, objectName, propertyName, type, value);
		}
		else if(originatedFrom==PlayableOriginated.SYSTEM){
			guiAgent.objectPropertyChanged(className, objectName, className, objectName, propertyName, type, value);			
		}
		else{
			setOriginatedFromGui(true); // initialize to true again
			return;
		}
	}

	@Override
	public void objectPropertyChanged(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName,
			String propertyName, String type, String value) 
	{
//		// during play-in, we do not update the behavior - that's a decision we made. we may change this in the future...
//		if (Utils.isPlayInMode())
//			return;
		
		if(initializing){
			return;
		}
		if (originatedFrom != originatedFrom.NONE){
			guiAgent.objectPropertyChanged(sourceClassName, sourceObjectName,
					targetClassName, targetObjectName,
					propertyName, type, value);
		}
		else{
			setOriginatedFromGui(true); // initialize to true again
			return;
		}
	}
	
	abstract protected  void initialize();

	public IPlayableComponent get(String compName) {
		return allPlayableComponents.get(compName);
	}

	protected void appIsUp() {
		initializing = false;
		guiAgent.appIsUp();
		setOriginatedFromGui(true);
	}

	public void clockTick(int tickInterval){
		if ( ! Utils.isPlayInMode()){
			((GuiJAgent)guiAgent).clockTick(tickInterval);
        }
	}

}
