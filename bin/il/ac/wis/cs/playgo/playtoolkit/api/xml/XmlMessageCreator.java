package il.ac.wis.cs.playgo.playtoolkit.api.xml;

import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XmlMessageCreator 
{
	public static final String OBJECT_EVENT = "objectEvent";
	public static final String SYSTEM_EVENT = "systemEvent";
	public static final String OBJECT_PROPERTY_CHANGE = "objectPropertyChange";
	public static final String OBJECT_RIGHTCLICK_EVENT = "objectRightClickEvent";
	
	public static final String SET_PROPERTY_VALUE = "setPropertyValue";
	public static final String GET_PROPERTY_VALUE = "getPropertyValue";
	public static final String ACTIVATE_METHOD= "activateMethod";
	
	public static final String CREATE_OBJECT = "createObject";
	public static final String DELETE_OBJECT = "deleteObject";
	
	public static final String APP_IS_UP = "AppIsUp";
	public static final String HIGHLIGHT_OBJECT = "hightlightObject";
	public static final String CLEAR_OBJECT = "clearObject";

	public static final String GETTER_RETURN_VALUE = "getterReturnValue";
	public static final String MES_ACK = "mesAck";

	private static DocumentBuilder docBuilder = null;
	private static Transformer transformer = null;

	private static int messageSeqNum = 1;
	
	//createObjectEventXml (IPlayGo)
	public static String createObjectEventXml(
			String className, String objectName, String eventName)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", OBJECT_EVENT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		Element eventElement = doc.createElement("event");
		eventElement.setAttribute("name", eventName);
		messageElement.appendChild(eventElement);

		String xmlString = getString(doc);
		return xmlString;
	}

	//createSystemEventXml - used for simulation of internal system events via system model call-other-object calls
	public static String createSystemEventXml(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName,
			String eventName, ArrayList<String> argTypes, ArrayList<String> argValues)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", SYSTEM_EVENT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element sourceClassElement = doc.createElement("sourceClass");
		sourceClassElement.setAttribute("name", sourceClassName);
		messageElement.appendChild(sourceClassElement);

		Element sourceObjectElement = doc.createElement("sourceObject");
		sourceObjectElement.setAttribute("name", sourceObjectName);
		messageElement.appendChild(sourceObjectElement);

		Element targetClassElement = doc.createElement("targetClass");
		targetClassElement.setAttribute("name", targetClassName);
		messageElement.appendChild(targetClassElement);

		Element targetObjectElement = doc.createElement("targetObject");
		targetObjectElement.setAttribute("name", targetObjectName);
		messageElement.appendChild(targetObjectElement);

		Element eventElement = doc.createElement("event");
		eventElement.setAttribute("name", eventName);
		messageElement.appendChild(eventElement);

		Element argElement;
		String type, value;
		if(argTypes!=null && argTypes.size()>0){
			for(int i=0; i<argTypes.size(); i++){
				type = argTypes.get(i);
				value = argValues.get(i);

				argElement = doc.createElement("arg");
				argElement.setAttribute("type", type);
				argElement.setAttribute("value", value);
				
				messageElement.appendChild(argElement);
			}
		}
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//appIsUpEventXml
	public static String createAppIsUpEventXml()
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", APP_IS_UP);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
				
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createClearObjectMessage
	public static String createClearObjectMessage()
	{
		Document doc = createDoc();

		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", CLEAR_OBJECT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createHighlightObjectMessage
	public static String createHighlightObjectMessage(String objectName)
	{
		Document doc = createDoc();

		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", HIGHLIGHT_OBJECT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createObjectPropertyChangedXml
	public static String createObjectPropertyChangedXml(String className,
			String objectName, String propertyName, String type, String value) 
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", OBJECT_PROPERTY_CHANGE);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		Element propertyElement = doc.createElement("property");
		propertyElement.setAttribute("name", propertyName);
		messageElement.appendChild(propertyElement);

		Element typeElement = doc.createElement("type");
		typeElement.setAttribute("name", type);
		messageElement.appendChild(typeElement);

		Element valueElement = doc.createElement("value");
		valueElement.setAttribute("name", value);
		messageElement.appendChild(valueElement);

		String xmlString = getString(doc);
		return xmlString;
	}

	//createObjectPropertyChangedXml
	public static String createObjectPropertyChangedXml(
			String sourceClass, String sourceObject, 
			String targetClass, String targetObject,
			String propertyName, String type, String value) 
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", OBJECT_PROPERTY_CHANGE);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element sourceClassElement = doc.createElement("sourceClass");
		sourceClassElement.setAttribute("name", sourceClass);
		messageElement.appendChild(sourceClassElement);

		Element sourceObjectElement = doc.createElement("sourceObject");
		sourceObjectElement.setAttribute("name", sourceObject);
		messageElement.appendChild(sourceObjectElement);

		Element targetClassElement = doc.createElement("targetClass");
		targetClassElement.setAttribute("name", targetClass);
		messageElement.appendChild(targetClassElement);

		Element targetObjectElement = doc.createElement("targetObject");
		targetObjectElement.setAttribute("name", targetObject);
		messageElement.appendChild(targetObjectElement);

		Element propertyElement = doc.createElement("property");
		propertyElement.setAttribute("name", propertyName);
		messageElement.appendChild(propertyElement);

		Element typeElement = doc.createElement("type");
		typeElement.setAttribute("name", type);
		messageElement.appendChild(typeElement);

		Element valueElement = doc.createElement("value");
		valueElement.setAttribute("name", value);
		messageElement.appendChild(valueElement);

		String xmlString = getString(doc);
		return xmlString;
	}


	//createObjectRightClickEventXml (IPlayGo)
	public static String createObjectRightClickEventXml(String className, String objectName) 
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", OBJECT_RIGHTCLICK_EVENT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		String xmlString = getString(doc);
		return xmlString;
	}

	//createObjectMessage
	public static String createObjectMessage(String className, String objectName)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", CREATE_OBJECT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		String xmlString = getString(doc);
		return xmlString;
	}

	//deleteObjectMessage
	public static String deleteObjectMessage(String className, String objectName)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", DELETE_OBJECT);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createSetPropertyValueMessage
	public static String createSetPropertyValueMessage(String className,
			String objectName, String propertyName, String val)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", SET_PROPERTY_VALUE);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		Element eventElement = doc.createElement("property");
		eventElement.setAttribute("name", propertyName);
		messageElement.appendChild(eventElement);

		Element valueElement = doc.createElement("value");
		valueElement.setAttribute("name", val);
		messageElement.appendChild(valueElement);

		String xmlString = getString(doc);
		return xmlString;
	}

	//createGetPropertyMessage
	public static String createGetPropertyMessage(String className,
			String objectName, String propertyName) 
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", GET_PROPERTY_VALUE);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		Element eventElement = doc.createElement("property");
		eventElement.setAttribute("name", propertyName);
		messageElement.appendChild(eventElement);

		String xmlString = getString(doc);
		return xmlString;
	}


	//createActivateMethodMessage
	public static String createActivateMethodMessage(String className,
			String objectName, String methodName, String[] arguments) 
	{
		Document doc = createDoc();

		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", ACTIVATE_METHOD);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);

		Element classElement = doc.createElement("class");
		classElement.setAttribute("name", className);
		messageElement.appendChild(classElement);

		Element objectElement = doc.createElement("object");
		objectElement.setAttribute("name", objectName);
		messageElement.appendChild(objectElement);

		Element methodElement = doc.createElement("method");
		methodElement.setAttribute("name", methodName);
		messageElement.appendChild(methodElement);

		if(arguments==null || arguments.length<1){
			Element numOfArgsElement = doc.createElement("numOfArgs");
			numOfArgsElement.setAttribute("name", "0");
			messageElement.appendChild(numOfArgsElement);
		}
		else{
			Element numOfArgsElement = doc.createElement("numOfArgs");
			numOfArgsElement.setAttribute("name", String.valueOf(arguments.length));
			messageElement.appendChild(numOfArgsElement);
			
			Element argVal;
			for(int i=0; i<arguments.length; i++){
				argVal = doc.createElement("arg"+i);
				argVal.setAttribute("value", arguments[i]);
				messageElement.appendChild(argVal);
			}
		}
		
		String xmlString = getString(doc);
		return xmlString;
	}

	//creategetPropertyMessageXml
	public static String creategetPropertyMessageXml(String val)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", GETTER_RETURN_VALUE);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);

		Element returnValElement = doc.createElement("returnVal");
		returnValElement.setAttribute("name", val);
		messageElement.appendChild(returnValElement);

		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createAckMessageXml
	public static String createAckMessageXml(String seqNum)
	{
		Document doc = createDoc();
		
		Element messageElement = doc.createElement("message");
		messageElement.setAttribute("name", MES_ACK);
		doc.appendChild(messageElement);

		Element seqNumElement = doc.createElement("seqNum");
		seqNumElement.setAttribute("value", String.valueOf(messageSeqNum++));
		messageElement.appendChild(seqNumElement);
		
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createEndOfSuperstepMessageXml
//	public static String createEndOfSuperstepMessageXml() 
//	{
//		Document doc = createDoc();
//		
//		Element messageElement = doc.createElement("message");
//		messageElement.setAttribute("name", END_OF_SUPERSTEP);
//		doc.appendChild(messageElement);
//
//		String xmlString = getString(doc);
//		return xmlString;
//	}


	//getString
	private static String getString(Document doc) {
		try{
			DOMSource source = new DOMSource(doc);
			StreamResult result = new StreamResult(new StringWriter());
			
			if(transformer==null){
				transformer = TransformerFactory.newInstance().newTransformer();
			}else{
				//transformer.reset();
			}
			transformer.transform(source, result);
			
			return result.getWriter().toString();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	//createDoc
	private static Document createDoc() {
		try{
			if(docBuilder==null){
				docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}else{
				//docBuilder.reset();
			}
			return docBuilder.newDocument();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

}
