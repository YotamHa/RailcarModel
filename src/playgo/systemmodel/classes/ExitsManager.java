
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.ExitsManagerGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class ExitsManager
    extends ExitsManagerGenerated
{


    public ExitsManager(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create ExitsManager with name: " + name);
        }
    }

    public ExitsManager() {
        super(Utils.generateInstanceName("ExitsManager"));
    }

    public ExitsManager(String name, boolean init) {
        super(name, init);
    }

}
