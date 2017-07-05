
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.CarGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class Car
    extends CarGenerated
{


    public Car(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create Car with name: " + name);
        }
    }

    public Car() {
        super(Utils.generateInstanceName("Car"));
    }

    public Car(String name, boolean init) {
        super(name, init);
    }

}
