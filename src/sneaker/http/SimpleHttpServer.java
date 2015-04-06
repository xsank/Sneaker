package sneaker.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import sneaker.util.Util;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public class SimpleHttpServer {
	public static int DEFAULT_CONNECTION=10;

	private HttpServer httpServer;
	private Router router=new Router();
	private boolean isInitRouter=false;
	
	public SimpleHttpServer(int port){
		this(port, DEFAULT_CONNECTION);
	}
	
	public SimpleHttpServer(int port,int maxCon){
		try {
			httpServer=HttpServer.create(new InetSocketAddress(port), maxCon);
			router=new Router();
		} catch (IOException e) {
	        Util.severeLog("httpserver create failed:",e);
	    }

	}
	
	@SuppressWarnings("serial")
	public void initRouter(){
		this.initRouter(new HashMap<String,Handler>(){{
			put("/", new NullHandler());
		}});
	}
	
	public void initRouter(Map<String, Handler> urls){
		router.init(urls);
		isInitRouter=true;
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
