package sneaker.http;

import java.io.IOException;
import java.net.InetSocketAddress;

import sneaker.util.Util;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer extends SimpleBaseHttpServer{
	private HttpServer httpServer;
	
	public SimpleHttpServer(int port){
		this(port, DEFAULT_CONNECTION,IS_SECURE);
	}
	
	public SimpleHttpServer(int port,int maxCon,boolean isSecure){
		super(port, maxCon, isSecure);
		try {
			httpServer=HttpServer.create(new InetSocketAddress(port), maxCon);
		} catch (IOException e) {
	        Util.severeLog("httpserver create failed:",e);
	    }
	}
	
	public void start(){
		if(isInitRouter){
			HttpContext context=httpServer.createContext("/", router);
			context.getFilters().add(new ParamFilter());
			httpServer.setExecutor(null);
			httpServer.start();
		}else{
			Util.severeLog("the router should be initialized");
		}
	}
	
	public void stop(){
		httpServer.stop(2);
	}
}
