package com.wanghao.threadTest;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
	
	public static void main(String[] args) {
		int count = 3;
		CyclicBarrier cyclicBarrier = new CyclicBarrier(count);

		for (int i = 0; i < count; i++) {
			System.out.println("创建工作线程" + i);
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
				System.out.println(Thread.currentThread().getName() + "开始等待其他线程");
				cyclicBarrier.await();
				System.out.println(Thread.currentThread().getName() + "开始执行");
				Thread.sleep(1000);
				System.out.println(Thread.currentThread().getName() + "执行完毕");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
