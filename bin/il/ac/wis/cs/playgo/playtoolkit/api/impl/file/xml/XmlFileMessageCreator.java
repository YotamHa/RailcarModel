package il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml;

import java.io.File;
import java.io.StringWriter;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFileMessageCreator 
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
	public static final String PLAYGO_IS_UP = "playgoIsUp";
	
	public static final String ELEMENT_ACT = "act";
	public static final String ELEMENT_MESSAGE = "msg";
	public static final String ELEMENT_SEQ_NUM = "seqNum";
	public static final String ELEMENT_ID = "id";
	public static final String ELEMENT_CLASS = "cls";
	public static final String ELEMENT_METHOD = "mtd";
	public static final String ELEMENT_OBJECT = "objc";
	public static final String ELEMENT_EVENT = "event";
//	public static final String ELEMENT_PROPERTY = "property";
	public static final String ELEMENT_PROPERTY = "prop";
//	public static final String ELEMENT_PROPERTY_VALUE = "value";
	public static final String ELEMENT_PROPERTY_VALUE = "val";
	public static final String ELEMENT_SOURCE_CLASS = "sourceClass";
	public static final String ELEMENT_SOURCE_OBJECT = "sourceObject";
	public static final String ELEMENT_TARGET_CLASS = "targetClass";
	public static final String ELEMENT_TARGET_OBJECT = "targetObject";
	public static final String ELEMENT_NUM_OF_ARGS = "numOfArgs";
	public static final String ELEMENT_ARG_VALUE = "argvalue";
	public static final String ELEMENT_ARG_TYPE = "argtype";
	public static final String ELEMENT_MODE = "mode";
	
	private static DocumentBuilder docBuilder = null;
	private static Transformer transformer = null;

	private static int messageSeqNum = 69;
	
	private Document doc = null;
	private Element rootElement = null;
//	private boolean appendElements = false;
	private String saveFilepath = "";

	
	
	
	public XmlFileMessageCreator()
	{
		initXml();
	}
	
	public void setAppendFile(String filepath)
	{
		
		if(filepath != null) {
//			appendElements = true;
			saveFilepath = filepath;
		}
		else {
//			appendElements = false;
			saveFilepath = null;
		}
		
	}
	
	private void initXml()
	{
		try {
			if(docBuilder == null) {
				docBuilder =  DocumentBuilderFactory.newInstance().newDocumentBuilder();
			}
			doc = docBuilder.newDocument();
						
			rootElement = doc.createElement(XmlFileMessageCreator.ELEMENT_ACT);
			doc.appendChild(rootElement);
			
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	
	private Element getElement()
	{
		Element seqEl = null;
		
//		if(appendElements)
//		{		
			seqEl = doc.createElement(XmlFileMessageCreator.ELEMENT_SEQ_NUM);
			seqEl.setAttribute(ELEMENT_ID, String.valueOf(messageSeqNum++));	
			rootElement.appendChild(seqEl);
	
//		}
//		else
//		{			
//			Document doc = createDoc();
//			seqEl = getElement(doc);
//		}

		return seqEl;
	}
	
	
	private Element getElement(Document doc)
	{
		Node actElement = null;
						
		if(actElement == null){
			actElement = doc.createElement(ELEMENT_ACT);
			doc.appendChild(actElement);
			
		}
			
		
		Element seqEl = doc.createElement(ELEMENT_SEQ_NUM);
		seqEl.setAttribute(ELEMENT_ID, String.valueOf(messageSeqNum++));
	
		actElement.appendChild(seqEl);
		
		return seqEl;

	}
	
	
	public void clearElements()
	{
		if(doc != null) {
				 while (rootElement.hasChildNodes())
				 rootElement.removeChild(rootElement.getFirstChild());
		}
	}

	
	//createObjectEventXml (IPlayGo)
	public String createObjectEventXml(
			String className, String objectName, String eventName)
	{
			
		Element seqEl = getElement();

		seqEl.setAttribute(ELEMENT_MESSAGE, OBJECT_EVENT);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
		seqEl.setAttribute(ELEMENT_EVENT, eventName);
		
		String xmlString = getString(doc);
		return xmlString;
	}

	//createSystemEventXml - used for simulation of internal system events via system model call-other-object calls
	public String createSystemEventXml(String sourceClassName, String sourceObjectName,
			String targetClassName, String targetObjectName,
			String eventName, ArrayList<String> argTypes, ArrayList<String> argValues)
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, SYSTEM_EVENT);
		seqEl.setAttribute(ELEMENT_SOURCE_CLASS, sourceClassName);
		seqEl.setAttribute(ELEMENT_SOURCE_OBJECT, sourceObjectName);
		seqEl.setAttribute(ELEMENT_TARGET_CLASS, targetClassName);
		seqEl.setAttribute(ELEMENT_TARGET_OBJECT, targetObjectName);
		seqEl.setAttribute(ELEMENT_EVENT, eventName);
		
		if(argTypes!=null){
			seqEl.setAttribute(ELEMENT_NUM_OF_ARGS, String.valueOf(argTypes.size()));
			for(int i=0; i<argTypes.size(); i++){
				seqEl.setAttribute("argtype"+i, argTypes.get(i));
				seqEl.setAttribute("argvalue"+i, argValues.get(i));
			}
		}
		else
			seqEl.setAttribute(ELEMENT_NUM_OF_ARGS,"0");

		
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//appIsUpEventXml
	public  String createAppIsUpEventXml()
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, APP_IS_UP);
					
	
	
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createClearObjectMessage
	public String createClearObjectMessage()
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, CLEAR_OBJECT);

		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createHighlightObjectMessage
	public  String createHighlightObjectMessage(String objectName)
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, HIGHLIGHT_OBJECT);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);

	
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createObjectPropertyChangedXml
	public String createObjectPropertyChangedXml(String className,
			String objectName, String propertyName, String type, String value) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, OBJECT_PROPERTY_CHANGE);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
		seqEl.setAttribute(ELEMENT_PROPERTY, propertyName);
		seqEl.setAttribute("type", type);
		seqEl.setAttribute(ELEMENT_PROPERTY_VALUE, value);

		String xmlString = getString(doc);
		return xmlString;
	}

	//createObjectPropertyChangedXml
	public String createObjectPropertyChangedXml(
			String sourceClass, String sourceObject, 
			String targetClass, String targetObject,
			String propertyName, String type, String value) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, OBJECT_PROPERTY_CHANGE);
		seqEl.setAttribute(ELEMENT_SOURCE_CLASS, sourceClass);
		seqEl.setAttribute(ELEMENT_SOURCE_OBJECT, sourceObject);
		seqEl.setAttribute(ELEMENT_TARGET_CLASS, targetClass);
		seqEl.setAttribute(ELEMENT_TARGET_OBJECT, targetObject);
		seqEl.setAttribute(ELEMENT_PROPERTY, propertyName);
		seqEl.setAttribute("type", type);
		seqEl.setAttribute(ELEMENT_PROPERTY_VALUE, value);

		String xmlString = getString(doc);
		return xmlString;
	}


	//createObjectRightClickEventXml (IPlayGo)
	public String createObjectRightClickEventXml(String className, String objectName) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, OBJECT_RIGHTCLICK_EVENT);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);


		String xmlString = getString(doc);
		return xmlString;
	}

	//createObjectMessage
	public String createObjectMessage(String className, String objectName)
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, CREATE_OBJECT);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
	
		String xmlString = getString(doc);
		return xmlString;
	}

	//deleteObjectMessage
	public String deleteObjectMessage(String className, String objectName)
	{
		
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, DELETE_OBJECT);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);

		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createSetPropertyValueMessage
	public String createSetPropertyValueMessage(String className,
			String objectName, String propertyName, String val)
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, SET_PROPERTY_VALUE);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
		seqEl.setAttribute(ELEMENT_PROPERTY, propertyName);
		seqEl.setAttribute(ELEMENT_PROPERTY_VALUE, val);

	
		String xmlString = getString(doc);
		return xmlString;
	}

	//createPlaygoIsUpMessage
	public String createPlaygoIsUpMessage(boolean playOut) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, PLAYGO_IS_UP);
		seqEl.setAttribute(ELEMENT_MODE, playOut?"playOut":"playIn");
		
		
		
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createGetPropertyMessage
	public String createGetPropertyMessage(String className,
			String objectName, String propertyName) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, GET_PROPERTY_VALUE);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
		seqEl.setAttribute(ELEMENT_PROPERTY, propertyName);
	
		String xmlString = getString(doc);
		return xmlString;
	}

	//createActivateMethodMessage
	public  String createActivateMethodMessage(String className,
			String objectName, String methodName, String[] arguments) 
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, ACTIVATE_METHOD);
		seqEl.setAttribute(ELEMENT_CLASS, className);
		seqEl.setAttribute(ELEMENT_OBJECT, objectName);
		seqEl.setAttribute(ELEMENT_METHOD, methodName);
		if(arguments==null)
			seqEl.setAttribute(ELEMENT_NUM_OF_ARGS, "0");
		else{
			seqEl.setAttribute(ELEMENT_NUM_OF_ARGS, String.valueOf(arguments.length));
			for(int i=0; i<arguments.length; i++){
				seqEl.setAttribute("argvalue"+i, arguments[i]);
			}
		}
			
			
		String xmlString = getString(doc);
		return xmlString;
	}

	//creategetPropertyMessageXml
	public  String creategetPropertyMessageXml(String val)
	{
		Element seqEl = getElement();
		seqEl.setAttribute(ELEMENT_MESSAGE, GETTER_RETURN_VALUE);
		seqEl.setAttribute("returnVal", val);
	
		String xmlString = getString(doc);
		return xmlString;
	}
	
	//createAckMessageXml
	public  String createAckMessageXml(String seqNum)
	{
		Element seqEl = getElement();
	

		seqEl.setAttribute(ELEMENT_MESSAGE, MES_ACK);
	
	
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
	private String getString(Document doc) {
		String res = "";
		boolean wroteFile = false;
		
		while(!wroteFile) {
		try{
//			if(appendElements == false)
//			{
//			DOMSource source = new DOMSource(doc);
//			StreamResult result = new StreamResult(new StringWriter());
//			
//			if(transformer==null){
//				transformer = TransformerFactory.newInstance().newTransformer();
//			}else{
//				//transformer.reset();
//			}
//			transformer.transform(source, result);
//			
//			return result.getWriter().toString();
//			}
//			else
//			{
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(saveFilepath));
				
				if(transformer==null){
					transformer = TransformerFactory.newInstance().newTransformer();
				}else{
					//transformer.reset();
				}
				transformer.transform(source, result);
				
				wroteFile = true;
				res = "";
			

//			}
				
		}
		catch(Exception ex){
			//ex.printStackTrace();
			try {
				Thread.sleep(15);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		}
		return res;
	}

	//createDoc
	private Document createDoc() {
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
