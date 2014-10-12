package sneaker.http;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

import sneaker.util.Util;


import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.spi.HttpServerProvider;


public class SimpleHttpServer {

	private HttpServer httpServer;
	private Router router=new Router();
	
	public SimpleHttpServer(int port,int maxCon){
		HttpServerProvider provider=HttpServerProvider.provider();
		  try {
			  httpServer = provider.createHttpServer(
	                    new InetSocketAddress(port), maxCon);
	        } catch (IOException e) {
	           Util.severeLog("httpserver create failed:",e);
	        }
	}
	
	public void initRouter(Map<String, Handler> urls){
		for(String url:urls.keySet()){
			router.addUrl(url, urls.get(url));
		}
	}
	
	public void start(){
		HttpContext context=httpServer.createContext("/", router);
		context.getFilters().add(new ParamFilter());
		httpServer.setExecutor(null);
		httpServer.start();
	}
	
	public void stop(){
		httpServer.stop(2);
	}
}
