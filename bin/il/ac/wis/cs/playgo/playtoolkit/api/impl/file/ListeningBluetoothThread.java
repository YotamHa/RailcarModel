package il.ac.wis.cs.playgo.playtoolkit.api.impl.file;

import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;


public class ListeningBluetoothThread extends Thread {
	
	BufferedReader bufReader;
	IMobile mobile;
	
	
	public ListeningBluetoothThread(BufferedReader reader, IMobile mobile)
	{
		this.bufReader = reader;
		
		this.mobile = mobile;
	}

    public void run() {
        while (true && bufReader != null) {
           
            try {
               
            	
                String lineRead=bufReader.readLine();
                if(lineRead != null) {

                	//we read a bluetooth line with a number - inject a mobile incomingCall into playgo
	    	        //playgo.objectEvent("Mobile", "mobile", "incomingCall", null, null);
    	
                	ArrayList<String> types  = new ArrayList<String>();
                   	ArrayList<String> values  = new ArrayList<String>();
               	
                
                    String [] parts = lineRead.split(":"); 
                    if(parts.length > 1) {
                   	types.add("String");
                   	if(parts[1].equalsIgnoreCase("c")) {//character for clearing sms - send "" instead of c
                   		values.add(""); }
                   	else	{
                   		values.add(parts[1]);  	}
                   	                
                   	
                	//playgo.systemEvent(
	    	        //		"Mobile", "mobile", "Mobile", "mobile", 
	    	        //		parts[0], types, values);
                   	mobile.createMessage(parts[0], types, values);

                    }
	    	        
                	System.out.println(lineRead);
                }                                       
                
          
            } catch (IOException e) {
               System.err.println("Bluetooth connection - Failed to read buffer " + e.getMessage());
               // e.printStackTrace();
                break;
            }
       }
    }
    
    /* Call this from the main activity to shutdown the connection */
    public void cancel() {
        try {
        	if(bufReader != null && bufReader.ready())
        		bufReader.close();
        } catch (IOException e) { }
    }

    
    public interface IMobile{
        void createMessage(String method, ArrayList<String> types, ArrayList<String> values);
    }
    
    
 
}