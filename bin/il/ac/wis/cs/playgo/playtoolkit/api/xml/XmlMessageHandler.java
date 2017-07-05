package il.ac.wis.cs.playgo.playtoolkit.api.xml;

import il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelPlayGo;
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

public class XmlMessageHandler 
{
	private static DocumentBuilder docBuilder = null;
	
	public static String handleXmlMessageReceivedFromPlaygo(
			String message, IPlayable playable)
	{
	    try  
	    {
	    	Node messageNode = getMessageNode(message);

	        NamedNodeMap messageAttributes = messageNode.getAttributes();
	        Node messageNameNode = messageAttributes.getNamedItem("name");
	        if(messageNameNode==null){
	        	return null;
	        }
	        String messageName = messageNameNode.getNodeValue();
	        
	        Node seqNumNode, classNode, objectNode, methodNode, propertyNode, valueNode;
	        Node seqNumValueNode, classNameNode, objectNameNode, methodNameNode, propertyNameNode, valueNameNode;
	        NamedNodeMap seqNumAttributes, classAttributes, objectAttributes, methodAttributes, propertyAttributes, valueAttributes;
	        String seqNum, className, objectName, methodName, propertyName, numOfArgsStr; 
	        
	        switch(messageName)
	        {
	        	case XmlMessageCreator.ACTIVATE_METHOD:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();

	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        //method
	    	        methodNode = objectNode.getNextSibling();
	    	        methodAttributes = methodNode.getAttributes();
	    	        methodNameNode = methodAttributes.getNamedItem("name");
	    	        methodName = methodNameNode.getNodeValue();

	    	        numOfArgsStr = methodNode.getNextSibling().getAttributes().getNamedItem("name").getNodeValue();
	    	        int numOfArgs = Integer.valueOf(numOfArgsStr);
	    	        if(numOfArgs>0)
	    	        {
	    	        	String[] args = new String[numOfArgs];
	    	        	Node valNode;
	    	        	
	    	        	valNode = methodNode.getNextSibling();
	    	        	
	    	        	for(int i=0; i<numOfArgs; i++)
	    	        	{
	    	        		valNode = valNode.getNextSibling();
	    	        		args[i] = valNode.getAttributes().getNamedItem("value").getNodeValue();
	    	        	}
		        		playable.activateMethod(className, objectName, methodName, args);
	    	        }
	    	        else{	//no args
	    	        	playable.activateMethod(className, objectName, methodName);
	    	        }

	        		return XmlMessageCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlMessageCreator.SET_PROPERTY_VALUE:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        //property
	    	        propertyNode = objectNode.getNextSibling();
	    	        propertyAttributes = propertyNode.getAttributes();
	    	        propertyNameNode = propertyAttributes.getNamedItem("name");
	    	        propertyName = propertyNameNode.getNodeValue();

	    	        //value
	    	        valueNode = propertyNode.getNextSibling();
	    	        valueAttributes = valueNode.getAttributes();
	    	        valueNameNode = valueAttributes.getNamedItem("name");
	    	        String value = valueNameNode.getNodeValue();

	        		playable.setPropertyValue(className, objectName, propertyName, value);
	        		
	        		return XmlMessageCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlMessageCreator.GET_PROPERTY_VALUE:	        		
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        //property
	    	        propertyNode = objectNode.getNextSibling();
	    	        propertyAttributes = propertyNode.getAttributes();
	    	        propertyNameNode = propertyAttributes.getNamedItem("name");
	    	        propertyName = propertyNameNode.getNodeValue();

	        		String res = playable.getPropertyValue(className, objectName, propertyName);
	        		String getPropertyXmlMessage = 
	        				XmlMessageCreator.creategetPropertyMessageXml(res);	        		
	        		return getPropertyXmlMessage;
	        		
	        	case XmlMessageCreator.HIGHLIGHT_OBJECT:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        objectNode = seqNumNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();

	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        playable.highlightObject(objectName);
	    	        return XmlMessageCreator.createAckMessageXml(seqNum);	

	        	case XmlMessageCreator.CREATE_OBJECT:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	        		playable.construct(className, objectName);
	        		return XmlMessageCreator.createAckMessageXml(seqNum);

	        	case XmlMessageCreator.DELETE_OBJECT:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	        		playable.destroy(className, objectName);
	        		return XmlMessageCreator.createAckMessageXml(seqNum);
	        		
	        	case XmlMessageCreator.CLEAR_OBJECT:
	        		//seqNum
	    	        seqNumNode = messageNode.getFirstChild();
	    	        seqNumAttributes = seqNumNode.getAttributes();
	    	        seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        playable.clearObject();
	    	        return XmlMessageCreator.createAckMessageXml(seqNum);	

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
	private static Node getMessageNode(String message) 
	{
		try{
			if(docBuilder==null){
				docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}else{
				//docBuilder.reset();
			}
	        // Use String reader  
			Document document = docBuilder.parse( new InputSource(  
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
	public static void handleXmlMessageReceivedFromGui(String message, IPlayGo playgo)
	{
	    try  
	    {
			if(docBuilder==null){
				docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}else{
				//docBuilder.reset();
			}
	        // Use String reader  
			Document document = docBuilder.parse( new InputSource(  
	                new StringReader( message ) ) );  
	
	        NodeList nodes = document.getChildNodes();
	        if(nodes==null || nodes.getLength()<1){
	        	return;
	        }
	        //message
	        Node messageNode = nodes.item(0);
	        NamedNodeMap messageAttributes = messageNode.getAttributes();
	        Node messageNameNode = messageAttributes.getNamedItem("name");
	        String messageName = messageNameNode.getNodeValue();
	        
	        switch(messageName)
	        {
	        	case XmlMessageCreator.OBJECT_EVENT:
	        		//seqNum
	        		Node seqNumNode = messageNode.getFirstChild();
	        		NamedNodeMap seqNumAttributes = seqNumNode.getAttributes();
	        		Node seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        String seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        Node classNode = seqNumNode.getNextSibling();
	    	        NamedNodeMap classAttributes = classNode.getAttributes();
	    	        Node classNameNode = classAttributes.getNamedItem("name");
	    	        String className = classNameNode.getNodeValue();

	    	        //object
	    	        Node objectNode = classNode.getNextSibling();
	    	        NamedNodeMap objectAttributes = objectNode.getAttributes();
	    	        Node objectNameNode = objectAttributes.getNamedItem("name");
	    	        String objectName = objectNameNode.getNodeValue();

	    	        //event
	    	        Node eventNode = objectNode.getNextSibling();
	    	        NamedNodeMap eventAttributes = eventNode.getAttributes();
	    	        Node eventNameNode = eventAttributes.getNamedItem("name");
	    	        String eventName = eventNameNode.getNodeValue();

	    	        playgo.objectEvent(className, objectName, eventName, null, null);
	        		break;

	        	case XmlMessageCreator.SYSTEM_EVENT:
	        		//seqNum
	        		seqNumNode = messageNode.getFirstChild();
	        		seqNumAttributes = seqNumNode.getAttributes();
	        		seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //sourceClass
	    	        Node sourceClassNode = seqNumNode.getNextSibling();
	    	        NamedNodeMap sourceClassAttributes = sourceClassNode.getAttributes();
	    	        Node sourceClassNameNode = sourceClassAttributes.getNamedItem("name");
	    	        String sourceClassName = sourceClassNameNode.getNodeValue();

	    	        //sourceObject
	    	        Node sourceObjectNode = sourceClassNode.getNextSibling();
	    	        NamedNodeMap sourceObjectAttributes = sourceObjectNode.getAttributes();
	    	        Node sourceObjectNameNode = sourceObjectAttributes.getNamedItem("name");
	    	        String sourceObjectName = sourceObjectNameNode.getNodeValue();

	    	        //targetClass
	    	        Node targetClassNode = sourceObjectNode.getNextSibling();
	    	        NamedNodeMap targetClassAttributes = targetClassNode.getAttributes();
	    	        Node targetClassNameNode = targetClassAttributes.getNamedItem("name");
	    	        String targetClassName = targetClassNameNode.getNodeValue();

	    	        //targetObject
	    	        Node targetObjectNode = targetClassNode.getNextSibling();
	    	        NamedNodeMap targetObjectAttributes = targetObjectNode.getAttributes();
	    	        Node targetObjectNameNode = targetObjectAttributes.getNamedItem("name");
	    	        String targetObjectName = targetObjectNameNode.getNodeValue();

	    	        //event
	    	        eventNode = targetObjectNode.getNextSibling();
	    	        eventAttributes = eventNode.getAttributes();
	    	        eventNameNode = eventAttributes.getNamedItem("name");
	    	        eventName = eventNameNode.getNodeValue();

	    	        Node nextNode = eventNode;
	    	        Node typeNode, valueNode;
	    	        NamedNodeMap argAttributes;
					ArrayList<String> argTypes = new ArrayList<String>();
					ArrayList<String> argValues = new ArrayList<String>();

	    	        while(nextNode.getNextSibling()!=null){
	    	        	nextNode = nextNode.getNextSibling();
	    	        	argAttributes = nextNode.getAttributes();
	    	        	typeNode = argAttributes.getNamedItem("type");
	    	        	valueNode = argAttributes.getNamedItem("value");
	    	        	argTypes.add(typeNode.getNodeValue());
	    	        	argValues.add(valueNode.getNodeValue());
	    	        }
	    	        ((SystemModelPlayGo)playgo).systemEvent(
	    	        		sourceClassName, sourceObjectName, targetClassName, targetObjectName, 
	    	        		eventName, argTypes, argValues);
	        		break;
	        		
	        	case XmlMessageCreator.OBJECT_PROPERTY_CHANGE:
	        		//seqNum
	        		seqNumNode = messageNode.getFirstChild();
	        		seqNumAttributes = seqNumNode.getAttributes();
	        		seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        String targetClass = null, targetObject=null;
	    	        
	    	        //if(messageNode.getChildNodes().getLength()>5){
	    	        if(messageNode.getChildNodes().getLength()>6){	    	        
		    	        //class
		    	        classNode = objectNode.getNextSibling();
		    	        classAttributes = classNode.getAttributes();
		    	        classNameNode = classAttributes.getNamedItem("name");
		    	        targetClass = classNameNode.getNodeValue();

		    	        //object
		    	        objectNode = classNode.getNextSibling();
		    	        objectAttributes = objectNode.getAttributes();
		    	        objectNameNode = objectAttributes.getNamedItem("name");
		    	        targetObject = objectNameNode.getNodeValue();
	    	        }
	    	        //property
	    	        Node propertyNode = objectNode.getNextSibling();
	    	        NamedNodeMap propertyAttributes = propertyNode.getAttributes();
	    	        Node propertyNameNode = propertyAttributes.getNamedItem("name");
	    	        String propertyName = propertyNameNode.getNodeValue();

	    	        //type 
	    	        typeNode = propertyNode.getNextSibling();
	    	        NamedNodeMap typeAttributes = typeNode.getAttributes();
	    	        Node typeNameNode = typeAttributes.getNamedItem("name");
	    	        String type = typeNameNode.getNodeValue();

	    	        //value 
	    	        valueNode = typeNode.getNextSibling();
	    	        NamedNodeMap valueAttributes = valueNode.getAttributes();
	    	        Node valueNameNode = valueAttributes.getNamedItem("name");
	    	        String value = valueNameNode.getNodeValue();
	    	        
	    	        //if(messageNode.getChildNodes().getLength()>5){
	    	        if(messageNode.getChildNodes().getLength()>6){	    	        
	    	        	playgo.objectPropertyChanged(className, objectName,
							targetClass, targetObject, propertyName, type, value);
	    	        }else{
	    	        	playgo.objectPropertyChanged(className, objectName, 
	    	        			propertyName, type, value);
	    	        }
	        		break;
	        		
	        	case XmlMessageCreator.OBJECT_RIGHTCLICK_EVENT:
	        		//seqNum
	        		seqNumNode = messageNode.getFirstChild();
	        		seqNumAttributes = seqNumNode.getAttributes();
	        		seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //class
	    	        classNode = seqNumNode.getNextSibling();
	    	        classAttributes = classNode.getAttributes();
	    	        classNameNode = classAttributes.getNamedItem("name");
	    	        className = classNameNode.getNodeValue();

	    	        //object
	    	        objectNode = classNode.getNextSibling();
	    	        objectAttributes = objectNode.getAttributes();
	    	        objectNameNode = objectAttributes.getNamedItem("name");
	    	        objectName = objectNameNode.getNodeValue();

	    	        playgo.objectRightClicked(className, objectName);
	    	        break;
	    	        
	        	case XmlMessageCreator.APP_IS_UP:
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
	public static String extractResultFromXmlMessageReceivedFromGui(String xmlMessage) 
	{
	    try  
	    {
			if(docBuilder==null){
				docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}else{
				//docBuilder.reset();
			}
	        // Use String reader  
			Document document = docBuilder.parse( new InputSource(  
	                new StringReader( xmlMessage ) ) );  
	
	        NodeList nodes = document.getChildNodes();
	        if(nodes==null || nodes.getLength()<1){
	        	return null;
	        }
	        //message
	        Node messageNode = nodes.item(0);
	        NamedNodeMap messageAttributes = messageNode.getAttributes();
	        Node messageNameNode = messageAttributes.getNamedItem("name");
	        String messageName = messageNameNode.getNodeValue();
	        
	        switch(messageName)
	        {
	        	case XmlMessageCreator.GETTER_RETURN_VALUE:
	        		//seqNum
	        		Node seqNumNode = messageNode.getFirstChild();
	        		NamedNodeMap seqNumAttributes = seqNumNode.getAttributes();
	        		Node seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        String seqNum = seqNumValueNode.getNodeValue();
	        		
	    	        //return val
	    	        Node returnValNode = seqNumNode.getNextSibling();
	    	        NamedNodeMap returnValAttributes = returnValNode.getAttributes();
	    	        Node returnValNameNode = returnValAttributes.getNamedItem("name");
	    	        String returnVal = returnValNameNode.getNodeValue();
	        		return returnVal
	        				;	
	        	case XmlMessageCreator.MES_ACK:
	        		//seqNum
	        		seqNumNode = messageNode.getFirstChild();
	        		seqNumAttributes = seqNumNode.getAttributes();
	        		seqNumValueNode = seqNumAttributes.getNamedItem("value");
	    	        seqNum = seqNumValueNode.getNodeValue();
	    	        
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

