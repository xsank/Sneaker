package sneaker.core;


import sneaker.constant.Constant;
import sneaker.util.Util;
import groovy.lang.GroovyObject;

public class Sneak {

	public static String run(boolean isFile,String param){
		SneakData sData=new SneakData(isFile, param);
		Class<?> gClass=sData.parseDataToClass();
		if(gClass==null){
			return Constant.DATA_PARSE_FAILED;
		}
		GroovyObject gObject;
		String res=Constant.EXEC_FAILED;
		try {
			gObject = (GroovyObject) gClass.newInstance();
			res=(String) gObject.invokeMethod("sneakRun", null);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Util.infoLog("sneak run result:",res);
		return res;
	}
}
