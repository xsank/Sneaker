package sneaker.util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Enumeration;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.logging.Level;


public class Util {
	public static Logger info = new Logger("info", Level.INFO);
	public static Logger warning = new Logger("warning", Level.WARNING);
	public static Logger severe = new Logger("severe", Level.SEVERE);
	
	public static void infoLog(Object ...text){
		info.log(text);
	}
	
	public static void warningLog(Object ...text){
		warning.log(text);
	}
	
	public static void severeLog(Object ...text){
		severe.log(text);
	}
	
	public static String formatPathToPkg(String path){
		return path.replace('/', '.');
	}
	
	/*
	@SuppressWarnings("unchecked")
	private static void jarFindAndAddClasses(String pkg,String path,Set<Class<TcpServlet>> classes){
		try {
			JarFile jarFile=new JarFile(new File(path));
			Enumeration<JarEntry> jarEntries=jarFile.entries();
			while(jarEntries.hasMoreElements()){
				JarEntry jarEntry=jarEntries.nextElement();
				if(jarEntry.getName().endsWith("class")){
					String fullClass=formatPathToPkg(jarEntry.getName());
					String nofixClass=fullClass.substring(0,fullClass.length()-6);
					if(fullClass.indexOf(pkg)!=-1){
						classes.add((Class<TcpServlet>) Thread.currentThread().getContextClassLoader().loadClass(nofixClass));
					}
				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
}
