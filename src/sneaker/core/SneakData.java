package sneaker.core;

import groovy.lang.GroovyClassLoader;

import java.io.File;

import sneaker.util.Util;


public class SneakData {
	public static ClassLoader parent = SneakData.class.getClassLoader();
	public static GroovyClassLoader loader = new GroovyClassLoader(parent);

	public boolean isFile;
	public String param;
	
	public SneakData(boolean isFile,String param){
		this.isFile=isFile;
		this.param=param;
	}
	
	public Class<?> parseDataToClass(){
		try{
			if(isFile){
				File file=new File(param);
				return loader.parseClass(file);
			}else{
				return loader.parseClass(param);
			}
		}catch (Exception e) {
			e.printStackTrace();
			Util.severeLog("sneak data parse error:",e);
			return null;
		}
	}
}
