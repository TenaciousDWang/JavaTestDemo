package com.wanghao.threadTest;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

	public static void main(String[] args) {
		final CountDownLatch latch = new CountDownLatch(2);

		new Thread(() -> {
			try {
				System.out.println("子线程" + Thread.currentThread().getName() + "开始");
				Thread.sleep(1000);
				System.out.println("子线程" + Thread.currentThread().getName() + "结束");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		new Thread(() -> {
			try {
				System.out.println("子线程" + Thread.currentThread().getName() + "开始");
				Thread.sleep(1000);
				System.out.println("子线程" + Thread.currentThread().getName() + "结束");
				latch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}).start();

		try {
			System.out.println("等待2个子线程执行完毕...");
			latch.await();
			System.out.println("2个子线程已经执行完毕");
			System.out.println("继续执行主线程");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

