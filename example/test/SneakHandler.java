package test;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import sneaker.core.Sneak;
import sneaker.http.Handler;
import sneaker.http.HttpHanlderExchange;

public class SneakHandler extends Handler{
	public static String TEST="failed";

	@Override
	public void handle(HttpHanlderExchange httpExchange){
		Map<String, String> params=httpExchange.getParams();
		boolean isFile=new Boolean(params.get("isFile")).booleanValue();
		String param=(String) params.get("param");
		String res=Sneak.run(isFile, param);
		reply(httpExchange, res);
	}
}
