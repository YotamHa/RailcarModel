
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.EntranceGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class Entrance
    extends EntranceGenerated
{


    public Entrance(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create Entrance with name: " + name);
        }
    }

    public Entrance() {
        super(Utils.generateInstanceName("Entrance"));
    }

    public Entrance(String name, boolean init) {
        super(name, init);
    }

}
