package sneaker.http;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Map;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpPrincipal;

/*
 * Try to extends httpexchange
 * failed?
 */
public class HttpHanlderExchangeImpl extends HttpHanlderExchange{
	private HttpExchange httpExchange;
	private Map<String, String> params;
	
	@SuppressWarnings("unchecked")
	public HttpHanlderExchangeImpl(HttpExchange httpExchange){
		this.httpExchange=httpExchange;
		this.params=(Map<String, String>) httpExchange.getAttribute("params");
	}
	
	public String getParameter(String name){
		return params.get(name);
	}
	
	@SuppressWarnings("unchecked")
	public Map<String, String> getParams(){
		return params;
	}

	@Override
	public Headers getRequestHeaders() {
		// TODO Auto-generated method stub
		return httpExchange.getRequestHeaders();
	}

	@Override
	public Headers getResponseHeaders() {
		// TODO Auto-generated method stub
		return httpExchange.getResponseHeaders();
	}

	@Override
	public URI getRequestURI() {
		// TODO Auto-generated method stub
		return httpExchange.getRequestURI();
	}

	@Override
	public String getRequestMethod() {
		// TODO Auto-generated method stub
		return httpExchange.getRequestMethod();
	}

	@Override
	public HttpContext getHttpContext() {
		// TODO Auto-generated method stub
		return httpExchange.getHttpContext();
	}

	@Override
	public void close() {
		httpExchange.close();
	}

	@Override
	public InputStream getRequestBody() {
		// TODO Auto-generated method stub
		return httpExchange.getRequestBody();
	}

	@Override
	public OutputStream getResponseBody() {
		// TODO Auto-generated method stub
		return httpExchange.getResponseBody();
	}

	@Override
	public void sendResponseHeaders(int rCode, long responseLength)
			throws IOException {
		// TODO Auto-generated method stub
		httpExchange.sendResponseHeaders(rCode, responseLength);
	}

	@Override
	public InetSocketAddress getRemoteAddress() {
		// TODO Auto-generated method stub
		return httpExchange.getRemoteAddress();
	}

	@Override
	public int getResponseCode() {
		// TODO Auto-generated method stub
		return httpExchange.getResponseCode();
	}

	@Override
	public InetSocketAddress getLocalAddress() {
		// TODO Auto-generated method stub
		return httpExchange.getLocalAddress();
	}

	@Override
	public String getProtocol() {
		// TODO Auto-generated method stub
		return httpExchange.getProtocol();
	}

	@Override
	public Object getAttribute(String name) {
		// TODO Auto-generated method stub
		return httpExchange.getAttribute(name);
	}

	@Override
	public void setAttribute(String name, Object value) {
		// TODO Auto-generated method stub
		httpExchange.setAttribute(name, value);
	}

	@Override
	public void setStreams(InputStream i, OutputStream o) {
		// TODO Auto-generated method stub
		httpExchange.setStreams(i, o);
	}

	@Override
	public HttpPrincipal getPrincipal() {
		// TODO Auto-generated method stub
		return httpExchange.getPrincipal();
	}

}
