package il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml;

import java.io.File;
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
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFileUtilities 
{
	private static DocumentBuilder docBuilder = null;
	private static Transformer transformer = null;

	private XmlFileMessageCreator xmlReplyCreator = null;
	
	synchronized public ArrayList<String> readXmlFile(String existingFilePath)
	{

		Document existDoc = null;
		String debugS = "";
		long fileLen = 0;
		ArrayList<String> listMessages = new ArrayList<String>();
		try {
			
		
		//if file exists - load it into XML doc and return it, to append an element to it
		//initially assuming small files and using DOM (if files become large switch to SAX)
		File existingFile = new File(existingFilePath);
		if(docBuilder==null){
			docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		}else{
			//docBuilder.reset();
		}

		//debugS = new String(Files.readAllBytes(Paths.get(existingFilePath)));
		//fileLen = existingFile.length();
		
		//if(existingFile.length() > 0)
			existDoc = docBuilder.parse(existingFile); 
		//else 
		//	return listMessages;
		
			
		 NodeList nodes = existDoc.getChildNodes();
	     if(nodes!=null && nodes.getLength()>0){
	    	 Element actElement = (Element)nodes.item(0);
	    	 nodes = actElement.getChildNodes();
	       		for (int i = 0; i < nodes.getLength(); i++) {
	       			
	       			if(nodes.item(i).getNodeType() == Node.ELEMENT_NODE)
	       			{
	       				listMessages.add(createXml(
	       			       		nodes.item(i)));
	       			}
	       					
	       		}
	     }
		} catch (Exception e) {
			//nothing to do - not a must exist file
			System.out.println("File was: " + " len: " + fileLen);
			System.out.println(e);
		}
		return listMessages;
		
	}
	
	
	public String createXml(Node seqElement) {
		Document doc = createDoc();
		
		Element actElement = doc.createElement(XmlFileMessageCreator.ELEMENT_ACT);
			doc.appendChild(actElement);
			
 	    Node copyNode = doc.importNode(seqElement, true);

		actElement.appendChild(copyNode);
			
		String xmlString = getString(doc);
		return xmlString;

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

		
		//getString
		private String getString(Document doc) {
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

}

