package sneaker.http;

import com.sun.net.httpserver.HttpExchange;

public class NullHandler extends Handler{
	private static String GREETING="hello,it works";

	@Override
	public void handle(HttpExchange httpExchange) {
		// TODO Auto-generated method stub
		reply(httpExchange, GREETING);
	}
}
