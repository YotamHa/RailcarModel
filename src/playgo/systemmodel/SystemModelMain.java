
package playgo.systemmodel;


import java.io.File;
import java.io.IOException;

import aspects.AspectsCreator;
import aspects.MSDCoordinatorAspect;
import il.ac.wis.cs.playgo.playtoolkit.Utils;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.file.PlayGoFileAgent;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayGo;
import il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable;
import il.ac.wis.cs.playgo.playtoolkit.ebridge.IExecutionCoordinator;
import playgo.systemmodel.generated.ObjectsInstantiatorAspect;
import playgo.systemmodel.generated.SystemModelMainGenerated;
import il.ac.wis.cs.systemmodel.Constants;

/**
 * This file was automatically generated using PlayGo system-model.
 * 
 */
public class SystemModelMain
    extends SystemModelMainGenerated
    implements IPlayGo, IExecutionCoordinator
{

    public static playgo.systemmodel.SystemModelMain instance = null;

    public SystemModelMain() {
    	super();
       	AspectsCreator.createAspects();
    	MSDCoordinatorAspect.getInstance().init();
    	System.setProperty("SYSTEM_MODEL_DEBUG","true");
        play();
    }

    public static playgo.systemmodel.SystemModelMain getInstance() {
        if(instance==null){
        	instance = new SystemModelMain();
        	createSMObjects();
        }
        return instance;
    }

    //to be caught by ObjectsInstantiatorAspect
    private static void createSMObjects() {
    	ObjectsInstantiatorAspect.getInstance().createObjects();
    }

    public static void main(String[] args) {
        //System.setProperty("SYSTEM_MODEL_DEBUG","true");
        System.setProperty("REMOTE_GUI","true");
        getInstance();
    }

    private void play() {
        String playInStr = System.getProperty("playInMode");
        if(playInStr!=null && playInStr.equals("true")){
        	return;	//in play-in, the APP communicates with PlayGo and not with the Behavior
        }
        boolean remoteGui = false;
        String remoteGuiStr = System.getProperty("REMOTE_GUI");
        if(remoteGuiStr!=null && remoteGuiStr.equals("true")){
        	remoteGui = true;
        }
        if(remoteGui){
        	il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable playable = 
        			new il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp.PlayGoTcpAgent(Utils.getPort());
        	setPlayable(playable);
        	playable.setPlaygo(this);
        }
        else{
            boolean useFileAgents = false;
            String useFileAgentsStr = System.getProperty(Constants.SYS_PROP_USE_FILE_AGENTS);
            if(useFileAgentsStr!=null && useFileAgentsStr.equals("true")){
            	useFileAgents = true;
            }
        	if(useFileAgents){
        		String behaviorToGuiFilePath = System.getProperty(Constants.SYS_PROP_PLAY_GO_FILE_AGENT_FILE_PATH);
            	IPlayable playable = new PlayGoFileAgent(behaviorToGuiFilePath);
            	setPlayable(playable);
            	playable.setPlaygo(this);
            	playable.playgoIsUp(true); // informs/writes to the file that behavior is up in 'play-out' mode.
        	}else{
            	if (il.ac.wis.cs.playgo.playtoolkit.api.impl.java.GuiJAgent.getInstance() != null){
            		il.ac.wis.cs.playgo.playtoolkit.api.impl.java.GuiJAgent.getInstance().setBehavior(this);
            	}
        	}        	
        	//TcpAgent for receiving events from System Model View
        	il.ac.wis.cs.playgo.playtoolkit.api.intf.IPlayable systemModelPlayable = 
        			new il.ac.wis.cs.playgo.playtoolkit.api.impl.tcp.PlayGoTcpAgent(Utils.getPort());
        	systemModelPlayable.setPlaygo(this);
        }
    }

    @Override
    public void appIsUp() 
    {
    	super.appIsUp();
    	
        String autoTest = System.getProperty("autoTestMode");
        if(autoTest!=null){
        	try {
            	File f = new File("appIsUp");
    			f.createNewFile();
    		} catch (IOException e) {
    		}
        }
    }

}
