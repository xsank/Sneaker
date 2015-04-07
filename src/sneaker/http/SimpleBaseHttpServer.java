package sneaker.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

import sneaker.util.Util;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;


public abstract class SimpleBaseHttpServer {
	protected static int DEFAULT_CONNECTION=10;
	protected static boolean IS_SECURE=false;
	
	protected Router router=new Router();
	protected boolean isInitRouter=false;
	protected boolean isSecure=false;
	
	public SimpleBaseHttpServer(int port,int maxCon,boolean isSecure){
		router=new Router();
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
	
	public abstract void start();
	
	public abstract void stop();
}
