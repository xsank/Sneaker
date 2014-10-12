package test;

import sneaker.http.SimpleHttpServer;

public class Main {
	public static void main(String[] args){
		SimpleHttpServer sHttpServer=new SimpleHttpServer(9999, 10);
		sHttpServer.initRouter(Urls.urlpattern);
		sHttpServer.start();
	}
}
