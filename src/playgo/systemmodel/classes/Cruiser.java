
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.CruiserGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class Cruiser
    extends CruiserGenerated
{


    public Cruiser(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create Cruiser with name: " + name);
        }
    }

    public Cruiser() {
        super(Utils.generateInstanceName("Cruiser"));
    }

    public Cruiser(String name, boolean init) {
        super(name, init);
    }

}
