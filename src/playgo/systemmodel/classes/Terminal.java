
package playgo.systemmodel.classes;

import playgo.systemmodel.Utils;
import playgo.systemmodel.classes.generated.TerminalGenerated;


/**
 * This file was automatically generated using PlayGo system-model.
 * This class can be updated. Changes will not be overridden
 * 
 */
public class Terminal
    extends TerminalGenerated
{


    public Terminal(String name) {
        super(name);
        if(java.lang.System.getProperty("SYSTEM_MODEL_DEBUG")!=null){
        	java.lang.System.out.println(">>> constructor call: >>> create Terminal with name: " + name);
        }
    }

    public Terminal() {
        super(Utils.generateInstanceName("Terminal"));
    }

    public Terminal(String name, boolean init) {
        super(name, init);
    }

}
