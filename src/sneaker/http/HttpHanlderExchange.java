package sneaker.http;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;


public abstract class HttpHanlderExchange extends HttpExchange{
	
	public abstract String getParameter(String name);
	
	@SuppressWarnings("unchecked")
	public abstract Map<String, String> getParams();
}
