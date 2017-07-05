
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.PlatformManagerGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class PlatformManager
    extends PlatformManagerGenerated
{


    public PlatformManager(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create PlatformManager with name: " + name);
        }
    }

    public PlatformManager() {
        super(Utils.generateInstanceName("PlatformManager"));
    }

    public PlatformManager(String name, boolean init) {
        super(name, init);
    }

}
