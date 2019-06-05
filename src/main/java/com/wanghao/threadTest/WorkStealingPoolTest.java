package com.wanghao.threadTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkStealingPoolTest {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newWorkStealingPool();
		for (int i = 0; i < 10; i++) {
			MyTask myTask = new MyTask(i);
			executorService.execute(myTask);
		}
	}

}
