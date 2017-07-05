
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.ExitGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class Exit
    extends ExitGenerated
{


    public Exit(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create Exit with name: " + name);
        }
    }

    public Exit() {
        super(Utils.generateInstanceName("Exit"));
    }

    public Exit(String name, boolean init) {
        super(name, init);
    }

}
