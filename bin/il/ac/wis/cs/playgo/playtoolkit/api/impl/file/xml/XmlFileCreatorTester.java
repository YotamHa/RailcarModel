package il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class XmlFileCreatorTester {

	public static void main(String[] args) 
	{
		String[] arguments = new String[2];
		arguments[0] = "left"; 
		arguments[1] = "10";
		
		XmlFileMessageCreator creator = new XmlFileMessageCreator();
		//Events from behavior to GUI
		String activateMethodXmlMessage = creator.
				createActivateMethodMessage("Car", "Mazda", "turn", arguments );

		String setPropertyValueXmlMessage = creator.
				createSetPropertyValueMessage("Car", "Mazda", "speed", "90");
		
		//there are also highlightObject, clearObject, construct, destroy
		
		PrintWriter out;
		try {
			out = new PrintWriter("C:\\Users\\Michal\\Desktop\\st\\eventsFromBehaviorToGui.xml");
			out.println(activateMethodXmlMessage);
			out.println(setPropertyValueXmlMessage);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		//Events from GUI to behavior
        String objectEventXml = creator.createObjectEventXml(
        		"Button", "someButton", "click");
        String objectRightClickedXml = creator.createObjectRightClickEventXml(
        		"Button", "someButton");
        String objectPropertyChangedXml = creator.createObjectPropertyChangedXml( 
        		"Switch", "lightSwitch", "on", "boolean", "true");
        
        //there is also appIsUp message
        
		try {
			out = new PrintWriter("C:\\Users\\Michal\\Desktop\\st\\eventsFromGuiToBehavior.xml");
			out.println(objectEventXml);
			out.println(objectRightClickedXml);
			out.println(objectPropertyChangedXml);
			out.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

}
