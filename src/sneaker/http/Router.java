package sneaker.http;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import sneaker.controller.ThreadPool;
import sneaker.util.Util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class Router{
	private Map<String, Handler> urlPattern;
	
	public Router(){
		urlPattern=new HashMap<String, Handler>();
	}
	
	public void init(Map<String, Handler> urls){
		Iterator<Entry<String, Handler>> iterator=urls.entrySet().iterator();
		while(iterator.hasNext()){
			Entry<String, Handler> entry=iterator.next();
			addUrl(entry.getKey(), entry.getValue());
		}
	}
	
	private void addUrl(String url,Handler handler){
		this.urlPattern.put(url, handler);
	}
	
	public Map<String, Handler> getUrlPattern(){
		return urlPattern;
	}
}
