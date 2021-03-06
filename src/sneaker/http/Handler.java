package sneaker.http;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

import com.sun.net.httpserver.HttpExchange;

public abstract class Handler {
	public abstract void handle(HttpHanlderExchange httpExchange);
	
	public void reply(HttpExchange httpExchange,String response){
		try {
			httpExchange.sendResponseHeaders(200, response.length());
			OutputStream oStream=httpExchange.getResponseBody();
			oStream.write(response.getBytes());
			oStream.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			httpExchange.close();
		}
	}
}
