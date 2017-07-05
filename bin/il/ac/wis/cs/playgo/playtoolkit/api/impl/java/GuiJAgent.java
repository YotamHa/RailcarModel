 package il.ac.wis.cs.playgo.playtoolkit.api.impl.java;

import il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;

import java.util.ArrayList;

public class GuiJAgent implements IPlayGo
{
	private IPlayable playable = null;
	private IPlayGo behavior = null;	
	
	private static GuiJAgent instance = null;
	
	//CTOR
	public GuiJAgent(IPlayable playable) {
		this.playable = playable;
        instance = this;
	}

	//getInstance
	public static GuiJAgent getInstance(){
		return instance;
	}
	
	@Override
	public void objectEvent(String className, String objectName,
			String eventName, ArrayList<String> argTypes, ArrayList<String> argValues) 
	{
		SyncMessageHandler.getInstance().
			handleGuiMessage("Env", "User", className, objectName, eventName, argTypes, argValues);		
	}

	
	//clockTcik
	public void clockTick(int tickInterval){
		SyncMessageHandler.getInstance().clockTick(tickInterval);
	}
	
	@Override
	public void objectRightClicked(String className, String objectName){
		//objectEvent(className, objectName, RIGHT_CLICK_EVENT, null);
	}

	@Override
	public void objectPropertyChanged(String className, String objectName,
			String propertyName, String type, String value) 
	{
		objectPropertyChanged(className, objectName, className, objectName, 
			propertyName, type, value);
	}

	@Override
	public void objectPropertyChanged(String sourceClass, String sourceObject,
			String targetClass, String targetObject, 
			String propertyName,String type, String value) 
	{
		String methodName = "set" + propertyName.substring(0,1).toUpperCase();
		if(propertyName.length()>1){
			methodName = methodName + propertyName.substring(1);
		}
		ArrayList<String> argTypes = new ArrayList<String>();
		argTypes.add(type);
		ArrayList<String> argValues = new ArrayList<String>();
		argValues.add(value);
		
		//added here the source object
		SyncMessageHandler.getInstance().
			handleGuiMessage(sourceClass, sourceObject, targetClass, targetObject, methodName, argTypes, argValues);		
	}

	@Override
	public void setPlayable(IPlayable playable) {
		this.playable = playable;
	}

	@Override
	public IPlayable getPlayable() {
		return playable;
	}

	public void setBehavior(IPlayGo behavior){
		this.behavior = behavior;
		playable.setPlaygo(behavior);
		behavior.setPlayable(playable);
	}

	@Override
	public void appIsUp() {
		behavior.appIsUp();
	}
	
	@Override
	public void stop(){
//		if(messagesHandler!=null){
//			messagesHandler.cancel();
//		}
	}

	@Override
	public void systemEvent(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName, String eventName,
			ArrayList<String> argTypes, ArrayList<String> argValues) {

		SyncMessageHandler.getInstance().
		handleGuiMessage(sourceClassName, sourceObjectName, targetClassName, targetObjectName, eventName, argTypes, argValues);		
	}



}
