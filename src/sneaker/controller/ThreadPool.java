package sneaker.controller;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import com.sun.net.httpserver.HttpExchange;

import sneaker.http.Handler;
import sneaker.util.Util;



public class ThreadPool {
	private static int POOL_SIZE=Runtime.getRuntime().availableProcessors();
	private ExecutorService executor;
	
	public ThreadPool(){
		this(POOL_SIZE);
	}
	
	public ThreadPool(int size){
		this.executor=Executors.newFixedThreadPool(size);
	}
	
	public void execute(Runnable task){
		assert !executor.isShutdown();
		executor.execute(task);
	}
	
	public Future<?> submit(Callable<?> task){
		assert !executor.isShutdown();
		return executor.submit(task);
	}
	
	public void destroy(){
		executor.shutdownNow();
	}
}
