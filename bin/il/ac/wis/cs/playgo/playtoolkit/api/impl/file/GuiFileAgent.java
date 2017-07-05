package il.ac.wis.cs.playgo.playtoolkit.api.impl.file;

import il.ac.wis.cs.playgo.playtoolkit.Utils;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileMessageCreator;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileMessageHandler;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class GuiFileAgent extends FileAgent implements IPlayGo
{
	private IPlayable playable = null;
	private XmlFileMessageHandler xmlMsgHandler = null;
	private XmlFileMessageCreator xmlMsgCreator = null;

	//CTOR
	public GuiFileAgent(IPlayable playable, String filePath) 
	{
		super(filePath);
		this.playable = playable;
		xmlMsgHandler = new XmlFileMessageHandler();
		xmlMsgHandler.appendMessages(modeAppend);
		xmlMsgCreator = new XmlFileMessageCreator();
		if(modeAppend)
			xmlMsgCreator.setAppendFile(guiFullFileName);
		
		checkFileExist(guiFullFileName, true);
		collectMessages(BEHAVIOR_FILE_NAME, behaviorFullFileName);
		handleMessages();
		appIsUp();
	}
	
	@Override
	public void setPlayable(IPlayable playable) {
		this.playable = playable;
	}

	@Override
	public IPlayable getPlayable() {
		return playable;
	}

	@Override
	public void objectEvent(String className, String objectName,
			String eventName, ArrayList<String> argTypes,
			ArrayList<String> argValues) 
	{
        String eventXml = xmlMsgCreator.createObjectEventXml(
        		className, objectName, eventName);  
        sendMessage(eventXml);
	}

	@Override
	public void objectRightClicked(String className, String objectName) 
	{
        String eventXml = xmlMsgCreator.createObjectRightClickEventXml(className, objectName);  
        sendMessage(eventXml);
	}

	@Override
	public void objectPropertyChanged(String sourceClass, String sourceObject,
			String targetClass, String targetObject, String propertyName,
			String type, String value) 
	{
        String eventXml = xmlMsgCreator.createObjectPropertyChangedXml(
        		sourceClass, sourceObject, 
        		targetClass, targetObject,
        		propertyName, type, value);  
        sendMessage(eventXml);
	}

	@Override
	public void objectPropertyChanged(String className, String objectName,
			String propertyName, String type, String value) 
	{
        String eventXml = xmlMsgCreator.createObjectPropertyChangedXml( 
        		className, objectName, propertyName, type, value);  
        sendMessage(eventXml);
	}

	@Override
	public void appIsUp() 
	{
		if (Utils.isPlayInMode()){
			return;
		}
        String eventXml = xmlMsgCreator.createAppIsUpEventXml();  
        sendMessage(eventXml);
	}

	//sendMessage
	private void sendMessage(String eventXml) 
	{
		try {
			if(modeAppend == false){
			//if(out==null){
				out = new PrintWriter(guiFullFileName);
			//}
			out.println(eventXml);
//			out.flush(); //no need for flush if close, creates two file modifications
			out.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	//handle messages received from the behavior;
	private void handleMessages()
	{
		handler = new Thread(new Runnable() {
			@Override
			public void run() {
				String behaviorMes, res;
				while(true)
				{
					if(messages==null || messages.size()<1){
						try {
							synchronized (messages) {
								messages.wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(messages!=null && messages.size()>0)
					{
						while( ! messages.isEmpty()){
							behaviorMes = messages.remove(0);
						//	System.out.println(behaviorMes); //mmm
			            	res = xmlMsgHandler.handleXmlMessageReceivedFromPlaygo(
			            			behaviorMes, playable);

			            	if(res!= null)
			            		sendMessage(res);	//send response message to playgo
						}
					}
				}
			}
		});
		handler.start();
	}

	@Override
	public void stop() {
		super.stop();
	}

	@Override
	public void systemEvent(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName, String eventName,
			ArrayList<String> argTypes, ArrayList<String> argValues) {
		throw new RuntimeException("method not implemented");
	}

}
