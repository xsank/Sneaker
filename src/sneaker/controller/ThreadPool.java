package sneaker.controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sneaker.util.Util;



public class ThreadPool {

	private static ExecutorService executor=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
	
	public static void execute(Runnable task){
		if(!executor.isShutdown()){
			executor.execute(task);
		}else{
			Util.severeLog("thread pool is shutdown!");
		}
	}
	
	public static void destroy(){
		executor.shutdownNow();
	}
}
