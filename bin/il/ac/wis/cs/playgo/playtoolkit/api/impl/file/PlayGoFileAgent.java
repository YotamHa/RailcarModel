package il.ac.wis.cs.playgo.playtoolkit.api.impl.file;

import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileMessageCreator;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileMessageHandler;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class PlayGoFileAgent extends FileAgent implements IPlayable
{
	private IPlayGo playgo = null;
	private XmlFileMessageHandler xmlMsgHandler = null;
	private XmlFileMessageCreator xmlMsgCreator = null;
	
	
	//CTOR
	public PlayGoFileAgent(String filePath)
	{
		super(filePath);
		
		
		xmlMsgHandler = new XmlFileMessageHandler();
		xmlMsgHandler.appendMessages(modeAppend);
		xmlMsgCreator = new XmlFileMessageCreator();
		if(modeAppend)
			xmlMsgCreator.setAppendFile(behaviorFullFileName);
	
		//this changes the xml to append
		//XmlMessageCreator.setModeAppend(  behaviorFullFileName);
		modeAppend = true;
		
		checkFileExist(behaviorFullFileName, true);

		collectMessages(GUI_FILE_NAME, guiFullFileName);
		handleMessages();
		

	}
	
	@Override
	public void setPlaygo(IPlayGo playgo) {
		this.playgo = playgo;
	}


	
	//BLOCKING until a done ack is received from the gui project
	@Override
	public String activateMethod(String className, String objectName, 
			String methodName, String... arguments)
	{
		String activateMethodXmlMessage = xmlMsgCreator.
				createActivateMethodMessage(className, objectName, methodName, arguments);
		
		String res = sendMessage(activateMethodXmlMessage, true);
		
	
		return res;
	}

	//BLOCKING until a done ack is received from the gui project
	@Override
	public void setPropertyValue(String className, String objectName, 
			String propertyName, String val) 
	{
		String setPropertyValueXmlMessage = xmlMsgCreator.
				createSetPropertyValueMessage(className, objectName, propertyName, val);
		
		sendMessage(setPropertyValueXmlMessage, true);
	}

	//BLOCKING until a return value is received from the gui project
	@Override
	public String getPropertyValue(String className, String objectName, String propertyName) 
	{
		String activateMethodXmlMessage = xmlMsgCreator.
				createGetPropertyMessage(className, objectName, propertyName);
		
		String res = sendMessage(activateMethodXmlMessage, true);
		
		return res;
	}

	//TODO Later
	@Override
	public void highlightObject(String objectName) 
	{
		String activateMethodXmlMessage = xmlMsgCreator.
			createHighlightObjectMessage(objectName);
		
		sendMessage(activateMethodXmlMessage, true);
	}

	@Override
	public void clearObject() 
	{
		String activateMethodXmlMessage = xmlMsgCreator.
				createClearObjectMessage();
			
		sendMessage(activateMethodXmlMessage, true);
	}

	@Override
	public String getObjectPosition() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void playgoIsUp(boolean playOut)
	{
		String playgoIsUpXmlMessage = xmlMsgCreator.
				createPlaygoIsUpMessage(playOut);
			
		sendMessage(playgoIsUpXmlMessage, true);
	}
	
	@Override
	public void construct(String className, String objectName) 
	{
		if(hashMsgsToAvoid.containsKey(XmlFileMessageCreator.CREATE_OBJECT) == true)
			return;
		
		String createObjectXmlMessage = xmlMsgCreator.
				createObjectMessage(className, objectName);
		
		sendMessage(createObjectXmlMessage, true);
	}

	@Override
	public void destroy(String className, String objectName) 
	{
		String deleteObjectXmlMessage = xmlMsgCreator.
				deleteObjectMessage(className, objectName);
		
		sendMessage(deleteObjectXmlMessage, true);
	}
	
	//sendMessage
	private String sendMessage(String messageXml, boolean shouldWait) 
	{
		
//		if(modeAppend) {
//			xmlMsgCreator.appendXMLDocs(messageXml, behaviorFullFileName);
//
//		}
		if(modeAppend == false){ //otherwise was handled as save in xmlmessagecreator
		
			try {
				//if(out==null){
					out = new PrintWriter(behaviorFullFileName);
				//}
				out.println(messageXml);
	//			out.flush();
				out.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	
	
	
	private void handleMessages()
	{
		handler = new Thread(new Runnable() {
			@Override
			public void run() {
				String guiMes;
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
							guiMes = messages.remove(0);
							xmlMsgCreator.clearElements(); //when receiveing a message - the same as external event, we clear any
							//events in our file, assuming all were handled.
							//NOTICE - this is async, and as long as we don't check acks, there is no assurance they were really handled
							xmlMsgHandler.handleXmlMessageReceivedFromGui(guiMes, playgo);

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
	
	
	
}
