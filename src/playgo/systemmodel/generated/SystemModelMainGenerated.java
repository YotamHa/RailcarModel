
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
            object = AppObjects.getObject("exitsManager1", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager1", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager1", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exitsManager2", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager2", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager2", "platformHandling");
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
            object = AppObjects.getObject("exit2r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit2l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit2l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager3", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager3", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance3r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance3r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance3r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance3l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance3l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance3l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("exitsManager4", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager4", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager4", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit3r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit3l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit3l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal4", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal4", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal4", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal4", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager4", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager4", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance4r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance4r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance4r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance4l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance4l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance4l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("exit4r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit4l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit4l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal5", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal5", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal5", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal5", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager5", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager5", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance5r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance5r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance5r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance5l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance5l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance5l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("exitsManager6", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager6", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager6", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exitsManager5", "ExitsManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager5", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("ExitsManager", "exitsManager5", "platformHandling");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.ExitsManager) object).pgInitPlatformHandling((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit5r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit5l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit5l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("terminal6", "Terminal");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal6", "location");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitLocation((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal6", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Terminal", "terminal6", "allocatedPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Terminal) object).pgInitAllocatedPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager6", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager6", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("entrance6r", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance6r", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance6r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("entrance6l", "Entrance");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance6l", "terminalId");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitTerminalId((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Entrance", "entrance6l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Entrance) object).pgInitDirection((retval));
            }
            object = AppObjects.getObject("exit6r", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6r", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6r", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6r", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("exit6l", "Exit");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6l", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6l", "direction");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitDirection((retval));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("Exit", "exit6l", "currentPlatform");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.Exit) object).pgInitCurrentPlatform((Integer.valueOf(retval)));
            }
            object = AppObjects.getObject("platformManager", "PlatformManager");
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "ID");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitID((Integer.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "platform2busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform2busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "platform1busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform1busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "platform3busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform3busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "platform4busy");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitPlatform4busy((Boolean.valueOf(retval)));
            }
            retval = SystemModelMain.getInstance().getPlayable().getPropertyValue("PlatformManager", "platformManager", "allocating");
            if ((retval!=null)) {
                ((playgo.systemmodel.classes.PlatformManager) object).pgInitAllocating((Boolean.valueOf(retval)));
            }
            object = AppObjects.getObject("Env", "Env");
            object = AppObjects.getObject("User", "Env");
            
			//Initialize objects which are associated with state charts
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("Car", "car1", "Car");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager1", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager2", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager3", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("Car", "car2", "Car");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager4", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager6", "ExitsManager");
            playgo.systemmodel.SystemModelMain.getInstance().instantiateEngine("ExistsManager", "exitsManager5", "ExitsManager");
             
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
