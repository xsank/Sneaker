package sneaker.core;

import groovy.lang.GroovyClassLoader;

import java.io.File;

import sneaker.util.Util;


public class SneakData {
	public ClassLoader parent;
	public GroovyClassLoader loader;

	public boolean isFile;
	public String param;
	
	public SneakData(boolean isFile,String param){
		this(Thread.currentThread().getContextClassLoader(), isFile, param);
		this.isFile=isFile;
		this.param=param;
	}
	
	public SneakData(ClassLoader classLoader,boolean isFile,String param){
		loader=new GroovyClassLoader(classLoader);
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
			Util.severeLog("sneak data parse error:",e.getMessage());
			return null;
		}
	}
}
