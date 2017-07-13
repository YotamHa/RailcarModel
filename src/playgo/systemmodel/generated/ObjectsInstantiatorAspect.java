
package playgo.systemmodel.generated;

import il.ac.wis.cs.playgo.playtoolkit.AppObjects;
import playgo.systemmodel.classes.Clock;
import playgo.systemmodel.classes.Env;
import playgo.systemmodel.classes.SysManager;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class shouldn't be changed. Any change to this class will be overridden!!!
 * 
 */
public class ObjectsInstantiatorAspect {

    public static boolean smFirstTime = true;
    public static boolean appFirstTime = true;
    private static ObjectsInstantiatorAspect instance = null;

    private ObjectsInstantiatorAspect() {
    }

    public static ObjectsInstantiatorAspect getInstance() {
        if(instance==null){
        	instance = new ObjectsInstantiatorAspect();
        }
        return instance;
    }

    public void createObjects() {
        if (appFirstTime) {
        	appFirstTime = false;
        	instantiateExecutionBridges();
        	if(AppObjects.getObjects().isEmpty()){
        		createSystemModelObjects();
        	}
        }
    }

    private void createSystemModelObjects() {
        try {
            AppObjects.addObject(Clock.getInstance());
            Object object = null;
            object = new SysManager("sysManager");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Car("car1");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal1");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal2");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Cruiser("cruiser1");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal3");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager1");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance1r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance1l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager2");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance2r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance2l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager1");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager2");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager3");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit1r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit1l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Car("car2");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Cruiser("cruiser2");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Cruiser("cruiser");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit2r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit2l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager3");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance3r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance3l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager4");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit3r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit3l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal4");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager4");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance4r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance4l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit4r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit4l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal5");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager5");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance5r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance5l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager6");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager5");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit5r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit5l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Terminal("terminal6");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager6");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance6r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Entrance("entrance6l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit6r");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.Exit("exit6l");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.PlatformManager("platformManager");
            AppObjects.addObject(object);
            object = new playgo.systemmodel.classes.ExitsManager("exitsManager");
            AppObjects.addObject(object);
            object = new Env("Env");
            AppObjects.addObject(object);
            object = new Env("User");
            AppObjects.addObject(object);
        } catch (Exception _x) {
            _x.printStackTrace();
        }
    }

    public void instantiateExecutionBridges() {
        il.ac.wis.cs.playgo.ee.sct.ExecutionBridge2SCT.getInstance();
    }

}
