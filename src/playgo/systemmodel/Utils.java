package playgo.systemmodel;

import il.ac.wis.cs.playgo.playtoolkit.AppObjects;

public class Utils 
{
	public static String generateInstanceName(String className)
	{
		String objectNamePrefix = className.substring(0, 1).toLowerCase() 
				+ className.substring(1);
		int index = 1;
		String objName = null;
		Object obj = null;
		
		while(true){
			objName = objectNamePrefix + "_" + String.valueOf(index);
			obj = AppObjects.getObject(objName, className);
			if(obj == null){
				return objName;
			}
			index++;
		}
	}

}
