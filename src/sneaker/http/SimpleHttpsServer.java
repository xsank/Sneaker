package sneaker.http;

import java.io.IOException;
import java.net.InetSocketAddress;

import sneaker.util.Util;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpsServer;


public class SimpleHttpsServer extends SimpleBaseHttpServer{
	private HttpsServer httpsServer;
	
	public SimpleHttpsServer(int port){
		this(port,DEFAULT_CONNECTION,IS_SECURE);
	}
	
	public SimpleHttpsServer(int port,int maxCon,boolean isSecure){
		super(port, maxCon, isSecure);
		try {
			httpsServer=HttpsServer.create(new InetSocketAddress(port), maxCon);
		} catch (IOException e) {
	        Util.severeLog("httpserver create failed:",e);
	    }
	}
	
	public void start(){
		if(isInitRouter){
			HttpContext context=httpsServer.createContext("/", routerHandler);
			context.getFilters().add(new ParamFilter());
			httpsServer.setExecutor(null);
			httpsServer.start();
		}else{
			Util.severeLog("the router should be initialized");
		}
	}
	
	public void stop(){
		httpsServer.stop(2);
	}
}
