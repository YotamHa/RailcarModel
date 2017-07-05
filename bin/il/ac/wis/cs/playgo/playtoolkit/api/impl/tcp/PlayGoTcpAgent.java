package il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp;

import il.ac.wis.cs.playgo.playtoolkit.SyncMessageHandler;
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
import java.util.Collections;
import java.util.List;
import java.util.TimerTask;

public class PlayGoTcpAgent implements IPlayable
{
	private static final String HOST = "localhost";
	
	private int PLAYGO_SERVER_PORT;	// = 8222;
	private int UI_SERVER_PORT;		// = PLAYGO_SERVER_PORT+1;
	//private static PrintWriter out = null;

	private IPlayGo playgo = null;
	private List<String> guiMessages = null;

    private ServerSocket listener = null;
    private Socket socket = null;

    private TimerTask playGoMessagesHandler = null;
	private boolean goOn = true;
	
	private Thread collector, handler;
	private XmlMessageHandler xmlMsgHandler = null;
	private XmlMessageCreator xmlMsgCreator = null;
	
	//CTOR
	public PlayGoTcpAgent(int port)
	{
		PLAYGO_SERVER_PORT = port;
		UI_SERVER_PORT = PLAYGO_SERVER_PORT+1;

		guiMessages = Collections.synchronizedList(new ArrayList<String>());
		xmlMsgHandler = new XmlMessageHandler();
		xmlMsgCreator = new XmlMessageCreator();
		
		collectGuiMessages();
		
		handleGuiMessages();
	}
	
	//start listening to messages from gui			
	private void collectGuiMessages()
	{
		Runnable uiEventListener = new Runnable() {
			@Override
			public void run() 
			{
				listenToGuiMessages();
			}
		}; 
		goOn=true;
		collector = new Thread(uiEventListener); 
		collector.start();
	}

	//listenToGuiMessages
	private void listenToGuiMessages()
	{
        listener = null;
    	socket = null;
        try 
        {
        	listener = new ServerSocket(PLAYGO_SERVER_PORT);
            while (goOn) 
            {
                socket = listener.accept(); 
                try {
                    BufferedReader in = new BufferedReader(
                         new InputStreamReader(socket.getInputStream()));                	

                    guiMessages.add(in.readLine());
                    synchronized (guiMessages) {
                    	guiMessages.notify();
                    }
                }catch(Exception ex){
                	ex.printStackTrace();
                } finally{
                    socket.close();
                }            
            }
        }catch(Exception ex){
        	//ex.printStackTrace();
        }
        finally {
            try {
            	if(socket!=null){
            		socket.close();
            	}
            	if(listener!=null){            	
            		listener.close();
            	}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
	}
	
	//clockTcik
	public void clockTick(int tickInterval)
	{
		SyncMessageHandler.getInstance().clockTick(tickInterval);
//		this.tickInterval = tickInterval;
//		
//		String tickMessage = XmlMessageCreator.createSystemEventXml(
//				"Clock", "Clock", "Clock", "Clock",
//				"tick",
//				null, null);
//		
//		if( ! guiMessages.contains(tickMessage) ){
//			guiMessages.add(0, new GuiMessage(tickMessage,System.currentTimeMillis()));	//add to start	
//		}
	}
	
	//handle messages received from Gui;
	private void handleGuiMessages()
	{
		handler = new Thread(new Runnable() {
			@Override
			public void run() {
				String guiMes;
				while(true)
				{
					if(guiMessages==null || guiMessages.size()<1){
						try {
							synchronized (guiMessages) {
								guiMessages.wait();
							}
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					if(guiMessages!=null && guiMessages.size()>0)
					{
						guiMes = guiMessages.remove(0);
						xmlMsgHandler.handleXmlMessageReceivedFromGui(guiMes, playgo);
					}
				}
			}
		});
		handler.start();
	}
	
	//sendMessage
	public void sendMessage(String setPropertyValueXmlMessage) 
	{
		Socket s = null; 
		try{
			s = new Socket(HOST, UI_SERVER_PORT);

			DataOutputStream out = 
	        		new DataOutputStream(s.getOutputStream());

			out.writeBytes(setPropertyValueXmlMessage + '\n');
		}
		catch(Exception ex){
			ex.printStackTrace();
	    }finally{
	    	try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		
	}

	//sendMessageAndWaitForResponse
	public String sendMessage(String xmlMessage, boolean waitForResponse) 
	{
		Socket s = null; 
		try{
			s = new Socket(HOST, UI_SERVER_PORT);

			BufferedReader input = 
	        		new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream out = 
	        		new DataOutputStream(s.getOutputStream());

			out.writeBytes(xmlMessage + '\n');		//send message
			out.flush();
			
			if(waitForResponse)
			{
		    	String answerXml = input.readLine();	//waits for the answer
		    	
				if(answerXml==null || answerXml.equals("null")){
					return null;
				}
				String answer =xmlMsgHandler.
						extractResultFromXmlMessageReceivedFromGui(answerXml); 
				
				return answer;
			}
			else{
				return "noNeedForResponse";
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
	    }finally{
	    	try {
				s.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
	    }
		return null;
	}


	//IPlayable
	//=========
	
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
	public void construct(String className, String objectName) 
	{
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

	@Override
	public void stop() {
		goOn=false;
		try{
			if(playGoMessagesHandler!=null){
				playGoMessagesHandler.cancel();
			}
			if(listener!=null){
				listener.close();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	@Override
	public void playgoIsUp(boolean playOut){
		// TODO Auto-generated method stub
	}

/*	
	//Class GuiMessage
	private class GuiMessage
	{
		private String xmlMessage;
		//private long creationTime;
		
		//CTOR
		//public GuiMessage(String xmlMessage, long creationTime){
		public GuiMessage(String xmlMessage){
			this.xmlMessage = xmlMessage;
//			this.creationTime = creationTime;
		}

		public String getXmlMessage() {
			return xmlMessage;
		}
//		public long getCreationTime() {
//			return creationTime;
//		}
	}
	*/
}

