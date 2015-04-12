package sneaker.http;

public class NullHandler extends Handler{
	private static String GREETING="hello,it works";

	@Override
	public void handle(HttpHanlderExchange httpExchange) {
		// TODO Auto-generated method stub
		reply(httpExchange, GREETING);
	}
}
