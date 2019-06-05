package com.wanghao.threadTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolTest {

	public static void main(String[] args) {

		
		//创建一个线程池
		ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
				new ArrayBlockingQueue<Runnable>(5),new UserRejectHandler());

		for (int i = 0; i < 20; i++) {
			MyTask myTask = new MyTask(i);
			executor.execute(myTask);
			System.out.println("线程池中线程数：" + executor.getPoolSize() + 
					"，队列中等待执行的任务数：" + executor.getQueue().size());
		}
		executor.shutdown();
	}
	
	
	
}


