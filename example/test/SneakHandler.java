package test;

import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

import sneaker.core.Sneak;
import sneaker.http.Handler;

public class SneakHandler extends Handler{
	public static String TEST="failed";

	@Override
	public void handle(HttpExchange httpExchange){
		Map<String, String> params=getParams(httpExchange);
		boolean isFile=new Boolean(params.get("isFile")).booleanValue();
		String param=(String) params.get("param");
		String res=Sneak.run(isFile, param);
		reply(httpExchange, res);
	}
}
