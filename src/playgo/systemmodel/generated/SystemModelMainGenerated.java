
package playgo.systemmodel.generated;

import il.ac.wis.cs.playgo.playtoolkit.AppObjects;
import il.ac.wis.cs.playgo.playtoolkit.api.impl.java.SystemModelPlayGo;
import playgo.systemmodel.SystemModelMain;
import playgo.systemmodel.classes.Clock;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class shouldn't be changed. Any change to this class will be overridden!!!
 * 
 */
public class SystemModelMainGenerated
    extends SystemModelPlayGo
{


    public void runBThreads() {
    }

    @Override
    public void appIsUp() {
        try {
            Object object = null;
            String retval = null;
             
            object = AppObjects.getObject("sysManager", "SysManager");
            object = AppObjects.getObject("car1", "Car");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "mode");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitMode((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "CarID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitCarID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "Destination");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitDestination((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "terminal");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitTerminal((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "platform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitPlatform((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car1", "inTerminal");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitInTerminal((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal1", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal1", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal1", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal1", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal2", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal2", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal2", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal2", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("cruiser1", "Cruiser");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser1", "engineStarted");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineStarted((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser1", "engineEngaged");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineEngaged((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser1", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitID((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal3", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal3", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal3", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal3", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager1", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager1", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance1r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance1r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance1r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance1l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance1l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance1l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("platformManager2", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager2", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance2r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance2r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance2r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance2l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance2l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance2l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("existsManager1", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "existsManager1", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "existsManager1", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("existsManager2", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "existsManager2", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "existsManager2", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exitsManager3", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager3", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager3", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit1r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit1l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit1l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("car2", "Car");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "mode");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitMode((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "CarID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitCarID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "Destination");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitDestination((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "terminal");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitTerminal((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "platform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitPlatform((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Car", "car2", "inTerminal");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Car) object).pgInitInTerminal((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("cruiser2", "Cruiser");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser2", "engineStarted");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineStarted((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser2", "engineEngaged");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineEngaged((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser2", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitID((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("cruiser", "Cruiser");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser", "engineStarted");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineStarted((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser", "engineEngaged");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitEngineEngaged((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Cruiser", "cruiser", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Cruiser) object).pgInitID((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("Env", "Env");
            object = AppObjects.getObject("User", "Env");
            
			//Initialize objects which are associated with state charts
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("Car", "car1", "Car");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "existsManager1", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "existsManager2", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager3", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("Car", "car2", "Car");
             
            runBThreads();
            Clock.getInstance().startTimer();
             
        } catch (Exception _x) {
            _x.printStackTrace();
        }
    }

    @Override
    public void stop() {
    }

}
