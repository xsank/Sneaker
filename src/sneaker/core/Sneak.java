package sneaker.core;


import sneaker.constant.Constant;
import sneaker.util.Util;
import groovy.lang.GroovyObject;

public class Sneak {
	
	public static String run(boolean isFile,String param){
		return run(Thread.currentThread().getContextClassLoader(), isFile, param);
	}

	public static String run(ClassLoader classLoader,boolean isFile,String param){
		SneakData sData=new SneakData(classLoader,isFile, param);
		Class<?> gClass=sData.parseDataToClass();
		if(gClass==null){
			return Constant.CLASS_DATA_PARSE_FAILED;
		}
		GroovyObject gObject;
		String res=Constant.EXEC_FAILED;
		try {
			gObject = (GroovyObject) gClass.newInstance();
			Object result=gObject.invokeMethod("run", null);
			if(result instanceof Integer){
				res=String.valueOf(result);
			}else{
				res=(String) result;
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			res=e.getMessage();
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			res=e.getMessage();
			e.printStackTrace();
		}
		Util.infoLog("sneak run result:",res);
		return res;
	}
}
