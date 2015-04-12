package sneaker.http;

import java.util.HashMap;
import java.util.Map;


public abstract class SimpleBaseHttpServer {
	protected static int DEFAULT_CONNECTION=10;
	protected static boolean IS_SECURE=false;
	
	protected Router router;
	protected boolean isInitRouter=false;
	protected boolean isSecure=false;
	protected RouterHandler routerHandler;
	
	public SimpleBaseHttpServer(int port,int maxCon,boolean isSecure){
		router=new Router();
		routerHandler=new RouterHandler(router);
	}
	
	@SuppressWarnings("serial")
	public void initRouter(){
		this.initRouter(new HashMap<String,Handler>(){{
			put("/", new NullHandler());
		}});
	}
	
	public void initRouter(Map<String, Handler> urls){
		router.init(urls);
		isInitRouter=true;
	}
	
	public abstract void start();
	
	public abstract void stop();
}
