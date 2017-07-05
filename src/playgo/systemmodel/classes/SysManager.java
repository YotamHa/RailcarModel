
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.SysManagerGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class SysManager
    extends SysManagerGenerated
{


    public SysManager(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create SysManager with name: " + name);
        }
    }

    public SysManager() {
        super(Utils.generateInstanceName("SysManager"));
    }

    public SysManager(String name, boolean init) {
        super(name, init);
    }

}
