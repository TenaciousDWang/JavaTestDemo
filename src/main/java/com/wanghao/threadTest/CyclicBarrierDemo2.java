package com.wanghao.threadTest;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo2 {
	
	public static void main(String[] args) {
		int count = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);
		for (int j = 0; j < count; j++) {
			TaskThread taskThread = new TaskThread(cyclicBarrier);
			taskThread.start();
		}	
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("CyclicBarrier重用");
		for (int j = 0; j < count; j++) {
			TaskThread taskThread = new TaskThread(cyclicBarrier);
			taskThread.start();
		}	
	}

	private static class TaskThread extends Thread {
		private CyclicBarrier cyclicBarrier;
		public TaskThread(CyclicBarrier cyclicBarrier) {
			this.cyclicBarrier = cyclicBarrier;
		}

		@Override
		public void run() {
			try {							
				System.out.println(Thread.currentThread().getName() + "开始执行");
				System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "执行完毕");
				cyclicBarrier.await();				
			} catch (Exception e) {
				e.printStackTrace();
			}			
		}
	}
}
