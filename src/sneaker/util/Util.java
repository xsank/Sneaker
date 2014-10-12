package sneaker.util;

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
}
