package il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp;

import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;
import il.ac.wis.cs.playgo.playtoolkit.api.xml.XmlMessageCreator;
import il.ac.wis.cs.playgo.playtoolkit.api.xml.XmlMessageHandler;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class SystemModelTcpAgent implements IPlayGo
{
	private int PLAYGO_SERVER_PORT;								// = 8222;
	private int UI_SERVER_PORT;									// = PLAYGO_SERVER_PORT+1;
	private int SYSTEM_MODEL_SERVER_PORT;						// = UI_SERVER_PORT+1;	

	private static final String HOST = "localhost";
	
	private IPlayable playable = null;
	
	private Socket socket = null;
	private XmlMessageHandler xmlMsgHandler = null;
	private XmlMessageCreator xmlMsgCreator = null;
	
	//CTOR
	public SystemModelTcpAgent(IPlayable playable, int port) 
	{
		PLAYGO_SERVER_PORT = port;
		UI_SERVER_PORT = PLAYGO_SERVER_PORT+1;
		SYSTEM_MODEL_SERVER_PORT = UI_SERVER_PORT+1;
		
		this.playable = playable;
		xmlMsgHandler = new XmlMessageHandler();
		xmlMsgCreator = new XmlMessageCreator();
		listenAndHandlePlaygoMessages();
		appIsUp();
	}

	//listenAndHandlelaygoMessages
	private void listenAndHandlePlaygoMessages()
	{
		Runnable guiListener = new Runnable() {
			public void run(){
				listenToPlaygoMessages();
			}
		}; 
		Thread th = new Thread(guiListener); 
		th.start();
	}
	
	//listenToPlaygoMessages
	private void listenToPlaygoMessages()
	{
        ServerSocket playgoListener = null;
        try{
        	playgoListener = new ServerSocket(SYSTEM_MODEL_SERVER_PORT);
        	socket = null;        	       	
            while (true){
                try {
                    socket = playgoListener.accept(); 

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(socket.getInputStream()));
                    String playgoMessage = in.readLine();
                    if(playgoMessage!=null)
                    {
                    	xmlMsgHandler.handleXmlMessageReceivedFromPlaygo(playgoMessage, playable);
                    }
                }catch(Exception ex){
                	ex.printStackTrace();
                } finally{
                    socket.close();
                }            
            }
        }catch(Exception ex){
//        	ex.printStackTrace();
        }
        finally {
            try {
            	if(playgoListener!=null){
            		playgoListener.close();
            	}
			} catch (IOException e) {
//				e.printStackTrace();
			}
        }	
	}

	//systemEvent - used for simulation of internal system events via system model call-other-object calls
	public void systemEvent(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName,
			String eventName, ArrayList<String> argTypes, ArrayList<String> argValues)
	{
        String eventXml = xmlMsgCreator.createSystemEventXml(
        		sourceClassName, sourceObjectName, 
        		targetClassName, targetObjectName,
        		eventName, argTypes, argValues);  
        sendEventXml(eventXml);
	}
	
	//IPlayGo
	//=======
	@Override
	public void objectEvent(String className, String objectName, String eventName, 
			ArrayList<String> argTypes, ArrayList<String> argValues) 
	{
        String eventXml = xmlMsgCreator.createObjectEventXml(
        		className, objectName, eventName);  
        sendEventXml(eventXml);
	}

	@Override
	public void objectRightClicked(String className, String objectName) 
	{
        String eventXml = xmlMsgCreator.createObjectRightClickEventXml(className, objectName);  
        sendEventXml(eventXml);
	}

	@Override
	public void objectPropertyChanged(String className, String objectName,
			String propertyName, String type, String value) 
	{
        String eventXml = xmlMsgCreator.createObjectPropertyChangedXml(
        		className, objectName, propertyName, type, value);  
        sendEventXml(eventXml);
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
        sendEventXml(eventXml);
	}

	@Override
	public void setPlayable(IPlayable playable) {
		this.playable = playable;
	}

	@Override
	public IPlayable getPlayable() {
		return playable;
	}

	//sendEventXml
	private void sendEventXml(String eventXml)
	{
		boolean success;
		for(int i=0; i<10; i++)	//10 tries
		{
			success = sendXml(eventXml);
			if(success){
				return;
			}else{
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		System.out.println("failure sending xml");
	}

	private boolean sendXml(String eventXml) {
		Socket s = null;
		try{
			s = new Socket(HOST, PLAYGO_SERVER_PORT);
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			out.writeBytes(eventXml + '\n');	//send message XML via tcp
			return true;
		}
		catch(Exception ex){
			//ex.printStackTrace();
			System.out.println(">>> sendXml FAIL <<<");
		}finally{
	    	try {
	    		if (s != null){
	    			s.close();
	    		}
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return false;
	}

	@Override
	public void appIsUp()
	{
	}
	
	@Override
	public void stop()
	{
		try{
			if(socket!=null){
				socket.close();
			}
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}

}
