package sneaker.http;

import java.util.HashMap;
import java.util.Map;

import sneaker.controller.ThreadPool;
import sneaker.util.Util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Router implements HttpHandler{
	private Map<String, Handler> urlPattern=new HashMap<String, Handler>();
	
	public void init(Map<String, Handler> urls){
		for(String url:urls.keySet()){
			addUrl(url,urls.get(url));
		}
	}
	
	private void addUrl(String url,Handler handler){
		this.urlPattern.put(url, handler);
	}

	@Override
	public void handle(final HttpExchange httpExchange){
		String url=httpExchange.getRequestURI().getPath();
		final Handler handler=urlPattern.get(url);
		if(handler==null){
			Util.severeLog("unknown url:",url);
		}else {
			ThreadPool.execute(new Runnable() {
				@Override
				public void run() {
					handler.proxyHandle(httpExchange);
				}
			});
		}
	}
}
