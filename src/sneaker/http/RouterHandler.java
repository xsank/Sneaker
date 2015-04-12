package sneaker.http;

import java.io.IOException;

import sneaker.controller.ThreadPool;
import sneaker.util.Util;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class RouterHandler implements HttpHandler{
	private Router router;
	private ThreadPool workPool;
	
	public RouterHandler(Router router){
		this.router=router;
		this.workPool=new ThreadPool();
	}
	
	public RouterHandler(Router router,int poolSize){
		this.router=router;
		this.workPool=new ThreadPool(poolSize);
	}

	@Override
	public void handle(final HttpExchange exchange) throws IOException {
		String url=exchange.getRequestURI().getPath();
		final Handler handler=router.getUrlPattern().get(url);
		workPool.execute(new Task(url,handler,exchange));
	}
	
	class Task implements Runnable{
		private String url;
		private Handler handler;
		private HttpHanlderExchange exchange;
		
		public Task(String url,Handler handler,HttpExchange exchange){
			this.url=url;
			this.handler=handler;
			this.exchange=new HttpHanlderExchangeImpl(exchange);
		}

		@Override
		public void run() {
			if(handler==null){
				Util.severeLog("unknown url:",url);
			}else {
				handler.handle(exchange);
			}
		}
		
	}
}
