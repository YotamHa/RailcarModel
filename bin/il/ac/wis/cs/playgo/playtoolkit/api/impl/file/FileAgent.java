package il.ac.wis.cs.playgo.playtoolkit.api.impl.file;

import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileMessageCreator;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.xml.XmlFileUtilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

public abstract class FileAgent 
{
	protected Thread collector, handler;
	protected boolean goOn = true;
	
	protected List<String> messages = null;

	public String GUI_FILE_NAME = "goitobe.xml"; //"new3_eventsFromGuiToBehavior.xml";
	protected String filePath;
	protected String guiFullFileName, behaviorFullFileName;
	protected BufferedReader bufr = null;
	
	public String BEHAVIOR_FILE_NAME = "betogoi.xml"; //"new3_eventsFromBehaviorToGui.xml";
	protected PrintWriter out = null;
	protected WatchKey wk = null;
	protected WatchKey watchKey = null;
	protected boolean modeAppend = true;
	
	XmlFileUtilities xmlUtils = null;
	Hashtable<String, String> hashMsgsToAvoid;
	
	//CTOR
	protected FileAgent(String filePath){
		
		xmlUtils = new XmlFileUtilities();
		this.filePath = filePath;
		hashMsgsToAvoid = new Hashtable<String, String>();
		
		hashMsgsToAvoid.put(XmlFileMessageCreator.CREATE_OBJECT, "");
		
		goOn=true;

		if(filePath!=null && filePath.length()>0){
			behaviorFullFileName = filePath + File.separator + BEHAVIOR_FILE_NAME;
			guiFullFileName = filePath + File.separator + GUI_FILE_NAME;
		}else{
			behaviorFullFileName = BEHAVIOR_FILE_NAME;
			guiFullFileName = GUI_FILE_NAME;
		}
		messages = Collections.synchronizedList(new ArrayList<String>());
	}

	
	
	
	//start listening to messages from gui			
	protected void collectMessages(final String simpleFileName, final String fullFileName)
	{
		Runnable uiEventListener = new Runnable() {
			@Override
			public void run() 
			{
				listenToMessages(simpleFileName, fullFileName);
			}
		}; 
		goOn=true;
		collector = new Thread(uiEventListener); 
		collector.start();
	}

	
	synchronized protected void checkFileExist(String filepath, boolean bDelete){

		try {		
		
        File f = new File(filepath);
        if(f.exists() == false){
            //if file does not exist, show warning to user
//            JOptionPane.showMessageDialog(null, "You are running a file agent, and it has not " + 
//            "located the following file for communication \n and will create a new one, at: " + 
//            		filePath + "\\" + FileAgent.GUI_FILE_NAME, 
//            "Information", JOptionPane.INFORMATION_MESSAGE);
        	
            System.out.println("You are running a file agent, and it has not " + 
            		"located the following file for communication \n and will create a new one, at: " + filePath + "\\" + GUI_FILE_NAME);
            
            f.getParentFile().mkdirs(); 
			f.createNewFile();
			
			
        }
        else if(bDelete) {
        	boolean d = f.delete();
			f.createNewFile();
      }
        	
		} catch (Exception e) {
			System.err.println("Failed to create file and directory at: " + filepath);
		}
	}
	
	public void addMessageToAvoid(String messageName)
	{
		hashMsgsToAvoid.put(messageName, messageName);
	}
	
	//listenToMessages
	protected void listenToMessages(String simpleFileName, String fullFileName)
	{
		Path path = FileSystems.getDefault().getPath(filePath);
			
		System.out.println(path);
		Path changed;
		boolean valid;
		try{
			WatchService watchService = FileSystems.getDefault().newWatchService();
			watchKey = path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
			FileReader fr;
			String behaviorMessage;

			while (goOn) {
				wk = watchService.take();
				for (WatchEvent<?> event : wk.pollEvents()) {
					//we only register "ENTRY_MODIFY" so the context is always a Path.
					changed = (Path) event.context();
					if (changed.endsWith(simpleFileName)) 
					{
							ArrayList<String> listMessages = xmlUtils.readXmlFile(fullFileName);
						
							for (String msg : listMessages) {
								synchronized (messages){
									messages.add(msg);	
									}	   
							}
						synchronized (messages) {
							messages.notify();
						}
					}
				}
				// reset the key
				valid = wk.reset();
				if (!valid) {
					System.out.println("Key has been unregistered");
				}
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public void stop() {
		try{
			goOn=false;
			if(bufr!=null){
				bufr.close();
			}
			if(out!=null){
				out.close();
			}
			if(wk!=null){
				wk.reset();
			}
			if(watchKey!=null){
				watchKey.cancel();
			}
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
