package test;

import java.util.HashMap;
import java.util.Map;

import sneaker.http.Handler;

public class Urls {
	@SuppressWarnings("serial")
	public static Map<String, Handler> urlpattern=new HashMap<String, Handler>(){{
		put("/sneak", new SneakHandler());
	}};
}
