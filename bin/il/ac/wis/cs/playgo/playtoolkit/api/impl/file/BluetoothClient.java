package il.ac.wis.cs.playgo.playtoolkit.api.impl.file;

import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.ListeningBluetoothThread.IMobile;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Vector;

import javax.bluetooth.*;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;



/**
* A simple SPP client that connects with an SPP server
*/
public class BluetoothClient implements DiscoveryListener{

	BufferedReader bReaderInput = null;
	PrintWriter pWriter = null;
	ListeningBluetoothThread lisT = null;
	StreamConnection streamConnection = null; //bluetooth socket
	OutputStream outStream  = null;
	InputStream inStream = null;
	
	//object used for waiting
	private Object lock=new Object();
	
	//vector containing the devices discovered
	private Vector vecDevices=new Vector();
	
	private String connectionURL=null;

	public void start() throws IOException {

		//RemoteDevice remoteDevice =	getBluetoothDevice();
		RemoteDevice remoteDevice =	getPairedBluetoothDevice();


		UUID[] uuidSet = new UUID[1];
		uuidSet[0]=new UUID("8e7d70e5566841c78978a72a1e43616b", false);

		System.out.println("\nSearching for service...");
		LocalDevice localDevice = LocalDevice.getLocalDevice();
		DiscoveryAgent agent = localDevice.getDiscoveryAgent();
		agent.searchServices(null,uuidSet,remoteDevice,this);

		try {
			synchronized(lock){
				lock.wait();
			}
		}
		catch (InterruptedException e) {
			e.printStackTrace();
		}

		if(connectionURL==null){
			System.out.println("Device does not support PlayGo Android Connection.");
			//System.exit(0);
			return;
		}

		//connect to the server and send a line of text    
		streamConnection=(StreamConnection)Connector.open(connectionURL);

		if(streamConnection != null) {
			System.out.println("Connected to PlayGo");

			//send string
			outStream=streamConnection.openOutputStream();
			pWriter=new PrintWriter(new OutputStreamWriter(outStream));
			//pWriter.write("Test String from SPP Client\r\n");
			//pWriter.flush();


			//read response
			inStream=streamConnection.openInputStream();
			bReaderInput=new BufferedReader(new InputStreamReader(inStream));
		}

	}	
	
	public void close() {
		try {
			if(pWriter  != null) {
				pWriter.close();
				pWriter = null;											
			}
			
			if(streamConnection != null) {
				streamConnection.close(); 
				streamConnection = null;

			}
			
			if(outStream != null) {
				outStream.close();
				outStream = null;
			}
			
			if(inStream != null) {
				inStream.close();
				inStream = null;
			}
			
			if(lisT != null) {
				lisT.cancel();
				lisT = null;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}


	private RemoteDevice getBluetoothDevice() {


		RemoteDevice remoteDevice = null;
		try {

			//display local device address and name
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			System.out.println("Address: "+localDevice.getBluetoothAddress());
			System.out.println("Name: "+localDevice.getFriendlyName());
			//find devices
			DiscoveryAgent agent = localDevice.getDiscoveryAgent();

			System.out.println("Starting device inquiry...");
			agent.startInquiry(DiscoveryAgent.GIAC, this);

		    try {
		        synchronized(lock){
		            lock.wait();
		        }
	    }
	    catch (InterruptedException e) {
	        e.printStackTrace();
	    }

	
	    System.out.println("Device Inquiry Completed. ");

	    //print all devices in vecDevices
	    int deviceCount=vecDevices.size();

	    if(deviceCount <= 0){
	        //System.out.println("No Devices Found .");
	        //System.exit(0);
	    	return null;
	    }
	    else{
	        //print bluetooth device addresses and names in the format [ No. address (name) ]
	        System.out.println("Bluetooth Devices: ");
	        for (int i = 0; i <deviceCount; i++) {
	            remoteDevice=(RemoteDevice)vecDevices.elementAt(i);
	            System.out.println((i+1)+". "+remoteDevice.getBluetoothAddress()+" ("+remoteDevice.getFriendlyName(true)+")");
	        }
	    }

	    int index= 1;
	    if(deviceCount > 1) {
	    System.out.print("Choose Device index: ");
	    BufferedReader bReader=new BufferedReader(new InputStreamReader(System.in));
	    

	    String chosenIndex=bReader.readLine();
	    index=Integer.parseInt(chosenIndex.trim());
	    }

	    //check for spp service
	    else if(index > 0) {
	    remoteDevice=(RemoteDevice)vecDevices.elementAt(index-1);

	    }
	    else {// 0 {
	    	remoteDevice = null; }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	remoteDevice = null;
	    }

	    return remoteDevice;
	  
 }

	RemoteDevice getPairedBluetoothDevice() {
		RemoteDevice remoteDevice = null;
	    try {
			LocalDevice localDevice = LocalDevice.getLocalDevice();
			
			RemoteDevice [] remoteDevices = localDevice.getDiscoveryAgent().retrieveDevices(DiscoveryAgent.PREKNOWN);
			
			if(remoteDevices.length > 0) {

				System.out.println("Connecting to 1: " + remoteDevices[0].getFriendlyName(true));

				remoteDevice = remoteDevices[0];
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    return remoteDevice;
	}
	
	public boolean sendMessage(String msg) {
		
		if(pWriter != null)
		{
			   pWriter.write(msg + "\r\n");
			   pWriter.flush();
		
		}
		return false;
	}

//methods of DiscoveryListener
public void deviceDiscovered(RemoteDevice btDevice, DeviceClass cod) {
    //add the device to the vector
    if(!vecDevices.contains(btDevice)){
        vecDevices.addElement(btDevice);
    }
}

//implement this method since services are not being discovered
public void servicesDiscovered(int transID, ServiceRecord[] servRecord) {
    if(servRecord!=null && servRecord.length>0){
        connectionURL=servRecord[0].getConnectionURL(0,false);
    }
    synchronized(lock){
        lock.notify();
    }
}

//implement this method since services are not being discovered
public void serviceSearchCompleted(int transID, int respCode) {
    synchronized(lock){
        lock.notify();
    }
}


public void inquiryCompleted(int discType) {
    synchronized(lock){
        lock.notify();
    }
    
    
}//end method

public void setMobile(IMobile mobile) {
    lisT = new ListeningBluetoothThread(bReaderInput, mobile);
    lisT.start();
	
}




}