package il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml;

import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XmlFileMessageHandler 
{
	private static DocumentBuilder docBuilderForPlaygo = null;
	private static DocumentBuilder docBuilderForGui = null;
	private static DocumentBuilder docBuilderForReading = null;
	
	private /*static*/ int seqNumHandledFromPlaygo = 0;
	private /*static*/ int seqNumHandledFromGUI = 0;
	
	private XmlFileMessageCreator xmlReplyCreator = null;
	private boolean appendMessages = false; //messages appended in the same xml


	
	public XmlFileMessageHandler()
	{
		xmlReplyCreator = new XmlFileMessageCreator();
	}
	
	
	public void appendMessages(boolean append)
	{
		appendMessages = append;
	}
	
	private Node getSeqNode(String message)
	{
		Node seqNumNode = null;
		try {
			
		
//		if(appendMessages)
//		{
//	    	//we assume we get a fragment - <seqNum .../>
//	    	
//	    	InputSource is = new InputSource();
//	        is.setCharacterStream(new StringReader(message));
//
//	        Document docForReading = docBuilderForReading.parse(is);
//	        NodeList nodes = docForReading.getElementsByTagName(XmlUtilities.ELEMENT_SEQ_NUM);
//	    	
//	    	seqNumNode = docForReading.getFirstChild(); //seqNum
//	    	if(nodes != null && nodes.getLength() > 0)
//	    		seqNumNode = nodes.item(0);
//	        			
//		}
//		else
		{
	    	Node rootNode = getMessageNode(message, docBuilderForPlaygo); //node act
	    	seqNumNode = rootNode.getFirstChild(); //seqNum
		
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return seqNumNode;
	}
	
	public synchronized String handleXmlMessageReceivedFromPlaygo(
			String message, IPlayable playable)
	{
	    try  
	    {
	    	Node seqNumNode = getSeqNode(message);

	    	if(seqNumNode == null)
	    		return null;
	    	
	        NamedNodeMap messageAttributes = seqNumNode.getAttributes();
	        if(messageAttributes == null)
	    	   return null;
	        
	        Node seqNumValueNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_ID);
	        if(seqNumValueNode==null){
	        	return null;
	        }
	        String seqNum = seqNumValueNode.getNodeValue();
	        int nSeqNum = Integer.parseInt(seqNum);
	        if(nSeqNum <= seqNumHandledFromPlaygo)
	        	return null;
	        else
	        	seqNumHandledFromPlaygo = nSeqNum;

	        //get messageName from attribute message      
	        Node messageNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_MESSAGE);
	        if(messageNode==null){
	        	return null;
	        }
	        String messageName = messageNode.getNodeValue();

	        Node classNode, objectNode, methodNode, propertyNode, valueNode;
	        Node classNameNode, objectNameNode, methodNameNode, propertyNameNode, valueNameNode;
	        NamedNodeMap seqNumAttributes, classAttributes, objectAttributes, methodAttributes, propertyAttributes, valueAttributes;
	        String className, objectName, methodName, propertyName, numOfArgsStr; 
	        
	        switch(messageName)
	        {
	        	case XmlFileMessageCreator.ACTIVATE_METHOD:
	        		
	    	        //class
	        		className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();
	        		
	    	        //object
	        		objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	    	        //method
	        		methodName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_METHOD).getNodeValue();

	    	        numOfArgsStr = "0";
	    	        Node numArgsNode = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_NUM_OF_ARGS);
	    	        if(numArgsNode != null) {
	    	        	numOfArgsStr = numArgsNode.getNodeValue();
	    	        }
	    	        
	    	        int numOfArgs = Integer.valueOf(numOfArgsStr);
	    	        if(numOfArgs>0)
	    	        {
	    	        	String[] args = new String[numOfArgs];
	    	        		    	        	
	    	        	for(int i=0; i<numOfArgs; i++)
	    	        	{
	    	        		args[i] = messageAttributes.getNamedItem(
	    	        				XmlFileMessageCreator.ELEMENT_ARG_VALUE + i).getNodeValue();
	    	        	}
		        		playable.activateMethod(className, objectName, methodName, args);
	    	        }
	    	        else{	//no args
	    	        	playable.activateMethod(className, objectName, methodName);
	    	        }

	        		return xmlReplyCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlFileMessageCreator.SET_PROPERTY_VALUE:
	        		
	    	        //class
	        		className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();


	    	        //object
	        		objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	    	        //property
	        		propertyName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY).getNodeValue();


	    	        //value
	    	        String value = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY_VALUE).getNodeValue();

	        		playable.setPropertyValue(className, objectName, propertyName, value);
	        		
	        		return xmlReplyCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlFileMessageCreator.GET_PROPERTY_VALUE:	        		
	        		
	        		
	    	        //class
	    	        className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();

	    	        //object
	    	        objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	    	        //property
//	    	        propertyNode = objectNode.getNextSibling();
//	    	        propertyAttributes = propertyNode.getAttributes();
//	    	        propertyNameNode = propertyAttributes.getNamedItem("name");
//	    	        propertyName = propertyNameNode.getNodeValue();
	    	        propertyName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY).getNodeValue();

	        		String res = playable.getPropertyValue(className, objectName, propertyName);
	        		String getPropertyXmlMessage = 
	        				xmlReplyCreator.creategetPropertyMessageXml(res);	        		
	        		return getPropertyXmlMessage;
	        		
	        	case XmlFileMessageCreator.HIGHLIGHT_OBJECT:
	        		
	        		objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	    	        playable.highlightObject(objectName);
	    	        return xmlReplyCreator.createAckMessageXml(seqNum);	

	        	case XmlFileMessageCreator.CREATE_OBJECT:
	    	      
	    	        className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();

	    	        objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	        		playable.construct(className, objectName);
	        		return xmlReplyCreator.createAckMessageXml(seqNum);

	        	case XmlFileMessageCreator.DELETE_OBJECT:

	    	        className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();

	    	        objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();

	        		playable.destroy(className, objectName);
	        		return xmlReplyCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlFileMessageCreator.CLEAR_OBJECT:
	    	        playable.clearObject();
	    	        return xmlReplyCreator.createAckMessageXml(seqNum);	

	        	default:
	        		break;
	        }
	        
	/*          
			TransformerFactory tranFactory = TransformerFactory.newInstance();  
	        Transformer aTransformer = tranFactory.newTransformer();  
	        Source src = new DOMSource( document );  
	        Result dest = new StreamResult( new File( "xmlFileName.xml" ) );  
	        aTransformer.transform( src, dest );  
	*/      
	    }
	    catch (Exception ex){  
	        ex.printStackTrace();  
	    }
	    return null;
	}

	//getMessageNode
	private Node getMessageNode(String message, DocumentBuilder docbuilder) 
	{
		try{
			if(docbuilder==null){
				docbuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}else{
				//docBuilder.reset();
			}
	        // Use String reader  
			Document document = docbuilder.parse( new InputSource(  
	                new StringReader( message ) ) );  
	
	        NodeList nodes = document.getChildNodes();
	        if(nodes==null || nodes.getLength()<1){
	        	return null;
	        }
	        Node messageNode = nodes.item(0);
	        return messageNode;
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	//handleMessage
	public synchronized void handleXmlMessageReceivedFromGui(String message, IPlayGo playgo)
	{
	    try  
	    {
	    	Node seqNumNode = getSeqNode(message);

	    	if(seqNumNode == null)
	    		return;
	    	
	        NamedNodeMap messageAttributes = seqNumNode.getAttributes();
	        if(messageAttributes == null)
	        	return;
	        
	        Node seqNumValueNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_ID);
	        if(seqNumValueNode==null){
	        	return;
	        }
	        String seqNum = seqNumValueNode.getNodeValue();
	        int nSeqNum = Integer.parseInt(seqNum);
	        if(nSeqNum <= seqNumHandledFromGUI)
	        	return;
	        else
	        	seqNumHandledFromGUI = nSeqNum;

	        //get messageName from attribute message      
	        Node messageNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_MESSAGE);
	        if(messageNode==null){
	        	return;
	        }
	        String messageName = messageNode.getNodeValue();

	        
	        //message
//	        Node messageNode = nodes.item(0);
//	        NamedNodeMap messageAttributes = messageNode.getAttributes();
//	        Node messageNameNode = messageAttributes.getNamedItem("name");
//	        String messageName = messageNameNode.getNodeValue();
	        
	        String eventName;
	        
	        switch(messageName)
	        {
	        	case XmlFileMessageCreator.OBJECT_EVENT:
	    	        String className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();

	    	        String objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();
	    	        
	    	         eventName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_EVENT).getNodeValue();

	    	        playgo.objectEvent(className, objectName, eventName, null, null);
	        		break;

	        	case XmlFileMessageCreator.SYSTEM_EVENT:
	    	        
	    	        String sourceClassName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_SOURCE_CLASS).getNodeValue();
	    	        
	    	        String sourceObjectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_SOURCE_OBJECT).getNodeValue();
	    	        
	    	        String targetClassName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_TARGET_CLASS).getNodeValue();
	    	        
	    	        String targetObjectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_TARGET_OBJECT).getNodeValue();

	    	        eventName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_EVENT).getNodeValue();

	    	        String numArgs = "0";
	    	        ArrayList<String> argTypes = new ArrayList<String>();
					ArrayList<String> argValues = new ArrayList<String>();
					int numOfArgs = 0;
					 
	    	        try {
	        	        messageAttributes.getNamedItem(
		        				XmlFileMessageCreator.ELEMENT_NUM_OF_ARGS).getNodeValue();
		    	        
		    	        numOfArgs = Integer.valueOf(numArgs);
		    	        if(numOfArgs>0)
		    	        {
		    	        	for(int i=0; i<numOfArgs; i++)
		    	        	{
		    	        		argTypes.add(messageAttributes.getNamedItem(
		    	        				XmlFileMessageCreator.ELEMENT_ARG_TYPE + i).getNodeValue());
		    	        		argValues.add(messageAttributes.getNamedItem(
		    	        				XmlFileMessageCreator.ELEMENT_ARG_VALUE + i).getNodeValue());
		    	        	}
		    	        }
						
					} catch (Exception e) {
						numOfArgs = 0;
					}
					
	    	        playgo.systemEvent(
	    	        		sourceClassName, sourceObjectName, targetClassName, targetObjectName, 
	    	        		eventName, argTypes, argValues);
	        		break;
	        		
	        	case XmlFileMessageCreator.OBJECT_PROPERTY_CHANGE:

	        		
	    	        String propertyName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY).getNodeValue();
	
	    	        String type = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY).getNodeValue();
	    	        
	    	        String value = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_PROPERTY_VALUE).getNodeValue();

	    	        String targetClass = null, targetObject=null;

	    	        Node classElement = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_SOURCE_CLASS);
	    	        if (classElement == null){
	    	        	className = null;
	    	        } else{
	    	        	className = messageAttributes.getNamedItem(
	    	        			XmlFileMessageCreator.ELEMENT_SOURCE_CLASS).getNodeValue();
	    	        }
	    	        
	    	        Node objectElement = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_SOURCE_OBJECT);
	    	        if (objectElement == null){
	    	        	objectName = null;
	    	        } else{
	    	        	objectName = messageAttributes.getNamedItem(
	    	        			XmlFileMessageCreator.ELEMENT_SOURCE_OBJECT).getNodeValue();
	    	        }
	    	        
        			targetClass = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_TARGET_CLASS).getNodeValue();
        			targetObject = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_TARGET_OBJECT).getNodeValue();

	    	        // Patch for smarthome demo, until fixed by Oded (when fixed, simply remove these code lines):
        			className = targetClass;
        			objectName = targetObject;
	    	        // end of Patch for smarthome demo until fixed by Oded.
        			
    	        	playgo.objectPropertyChanged(className, objectName,
						targetClass, targetObject, propertyName, type, value);
	        		break;
	        		
	        	case XmlFileMessageCreator.OBJECT_RIGHTCLICK_EVENT:
	        		
	    	        className = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_CLASS).getNodeValue();
	    	        
	    	        objectName = messageAttributes.getNamedItem(
	        				XmlFileMessageCreator.ELEMENT_OBJECT).getNodeValue();
	    	        

	    	        playgo.objectRightClicked(className, objectName);
	    	        break;
	    	        
//	        	case XmlFileMessageCreator.APP_IS_UP:
	        	case "playgoIsUp": 
	        		// ToDo: finalize how we want this to behave. For now we dont want to handle the appIsUp event as it generate events for updating
	        		// all defaults values and for the smarthome demo we dont need this and dont want to create all this traffic between the gui and the behavior
	        		playgo.appIsUp();
	        		break;
	    	        
	        	default:
	        		break;
	        }
	        
	/*          
			TransformerFactory tranFactory = TransformerFactory.newInstance();  
	        Transformer aTransformer = tranFactory.newTransformer();  
	        Source src = new DOMSource( document );  
	        Result dest = new StreamResult( new File( "xmlFileName.xml" ) );  
	        aTransformer.transform( src, dest );  
	*/      
	    }
	    catch (Exception ex){  
	        ex.printStackTrace();  
	    }
	}

	//sendEndOfSuperstepEvent
//	public static void sendEndOfSuperstepEvent()
//	{
//		String endOfSuperstepMessageXml = 
//				XmlMessageCreator.createEndOfSuperstepMessageXml();
//		
//		PlayGoTcpAgent.sendMessage(endOfSuperstepMessageXml);
//	}

	//extractResultFromXmlMessageReceivedFromGui
	public String extractResultFromXmlMessageReceivedFromGui(String xmlMessage) 
	{
	    try  
	    {
	    	Node seqNumNode = getSeqNode(xmlMessage);

	    	if(seqNumNode == null)
	    		return null;

	        NamedNodeMap messageAttributes = seqNumNode.getAttributes();
	        Node seqNumValueNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_ID);
	        if(seqNumValueNode==null){
	        	return null;
	        }
	        String seqNum = seqNumValueNode.getNodeValue();
	        int nSeqNum = Integer.parseInt(seqNum);
	        if(nSeqNum <= seqNumHandledFromGUI)
	        	return null;
	        else
	        	seqNumHandledFromGUI = nSeqNum;

	        //get messageName from attribute message      
	        Node messageNode = messageAttributes.getNamedItem(XmlFileMessageCreator.ELEMENT_MESSAGE);
	        if(messageNode==null){
	        	return null;
	        }
	        String messageName = messageNode.getNodeValue();

	        switch(messageName)
	        {
	        	case XmlFileMessageCreator.GETTER_RETURN_VALUE:
	        		
	    	        String returnVal = messageAttributes.getNamedItem(
	        				"returnVal").getNodeValue();
	    	        

	        		return returnVal;	
	        		
	        	case XmlFileMessageCreator.MES_ACK:
	        		return "message handled " + seqNum;	
	        	default:
	        		break;
	        }
	    }
	    catch (Exception ex){  
	        ex.printStackTrace();  
	    }		
	    return null;
	}

	
	
	
	//isEndOfSuperstep
//	public static boolean isEndOfSuperstep(String playgoMes) 
//	{
//		Node messageNode = getMessageNode(playgoMes);
//		
//        NamedNodeMap messageAttributes = messageNode.getAttributes();
//        Node messageNameNode = messageAttributes.getNamedItem("name");
//        if(messageNameNode==null){
//        	return false;
//        }
//        String messageName = messageNameNode.getNodeValue();
//		if(messageName.equals(END_OF_SUPERSTEP)){
//			return true;
//		}
//		return false;
//	}


}

