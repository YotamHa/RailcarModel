
package aspects;

import il.ac.wis.cs.s2a.runtime.lib.MSDCoordinator;
import il.ac.wis.cs.s2a.runtime.lib.MSDMethod;
import il.ac.wis.cs.s2a.runtime.lib.MSDSubscribe;


public class MSDCoordinatorAspect extends MSDCoordinator implements MSDSubscribe
{
	private static MSDCoordinatorAspect instance = null;

	//CTOR
	private MSDCoordinatorAspect()
	{
	}

	public static MSDCoordinatorAspect getInstance(){
		if(instance==null){
			instance = new MSDCoordinatorAspect();
		}
		return instance;
	}

	public void init()
	{
	}

	@Override
	protected void wrapperCall(MSDMethod MSDm) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void afterImpl(MSDMethod envMeth) {
		// TODO Auto-generated method stub
	}

}

