package com.wanghao.threadTest;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
	
	static class Player extends Thread {
		private int num;
		private Semaphore semaphore;

		public Player(int num, Semaphore semaphore) {
			this.num = num;
			this.semaphore = semaphore;
		}

		@Override
		public void run() {
			try {
				semaphore.acquire();
				System.out.println("网友" + this.num + "上机中...");
				Thread.sleep(1000);
				System.out.println("网友" + this.num + "下线");
				semaphore.release();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		int count = 10; // 网友数量
		Semaphore semaphore = new Semaphore(5); // 机器数目
		for (int i = 0; i < count; i++)
			new Player(i, semaphore).start();
	}
}
