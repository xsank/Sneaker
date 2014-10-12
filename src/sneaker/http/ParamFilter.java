package sneaker.http;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sun.net.httpserver.Filter;
import com.sun.net.httpserver.HttpExchange;

public class ParamFilter extends Filter{
	@Override
	public String description(){
		return "parse the url parameters";
	}
	
	@Override
	public void doFilter(HttpExchange httpExchange,Chain chain) throws IOException{
		parseGet(httpExchange);
		parsePost(httpExchange);
		chain.doFilter(httpExchange);
	}
	
	private void parseGet(HttpExchange httpExchange) throws UnsupportedEncodingException{
		Map<String, Object> params=new HashMap<String, Object>();
		URI requestUri=httpExchange.getRequestURI();
		String query=requestUri.getRawQuery();
		parseQuery(query, params);
		httpExchange.setAttribute("params", params);
	}
	
	private void parsePost(HttpExchange httpExchange) throws IOException{
		if("post".equalsIgnoreCase(httpExchange.getRequestMethod())){
			@SuppressWarnings("unchecked")
			Map<String, Object> params=(Map<String, Object>) httpExchange.getAttribute("params");
			InputStreamReader isr=new InputStreamReader(httpExchange.getRequestBody(),"utf-8");
			BufferedReader bReader=new BufferedReader(isr);
			String query=bReader.readLine();
			parseQuery(query, params);
			httpExchange.setAttribute("params", params);
		}
	}
	
	private void parseQuery(String query,Map<String, Object> params) throws UnsupportedEncodingException{
		if(query!=null){
			String pairs[]=query.split("[&]");
			for(String pair:pairs){
				String param[]=pair.split("[=]");
				String key=null,value=null;
				if(param.length>0){
					key=URLDecoder.decode(param[0], System.getProperty("file.encoding"));
				}
				if(param.length>1){
					value=URLDecoder.decode(param[1],System.getProperty("file.encoding"));
				}
				
				if(params.containsKey(key)){
					Object obj=params.get(key);
					if(obj instanceof List<?>){
						@SuppressWarnings("unchecked")
						List<String> values=(List<String>) obj;
						values.add(value);
					}else if(obj instanceof String){
						List<String> values=new ArrayList<>();
						values.add((String) obj);
						values.add(value);
					}
				}else{
					params.put(key, value);
				}
			}
		}
	}
}
