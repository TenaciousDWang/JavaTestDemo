package com.wanghao.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ABCLogic {

	private Lock lock = new ReentrantLock();
	private Condition conditionA = lock.newCondition();
	private Condition conditionB = lock.newCondition();
	private Condition conditionC = lock.newCondition();
	private String type = "A"; 
	
	public static void main(String[] args) {
		ABCLogic test = new ABCLogic();

		// 线程0号，打印5次A。
		Thread ta = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				test.printA();
			}
		});

		// 线程1号，打印5次B。
		Thread tb = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				test.printB();
			}
		});

		// 线程2号，打印5次C。
		Thread tc = new Thread(() -> {
			for (int i = 0; i < 5; i++) {
				test.printC();
			}
		});

        //执行。
        ta.start();
        tb.start();
        tc.start();
		
	}

	public void printA() {
		lock.lock();
		try {
			while (type != "A") {
				try {
					conditionA.await(); // 将打印A的线程阻塞到conditionA的对象上。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " 打印A");
			type = "B";
			conditionB.signal(); // 唤醒在等待conditionB对象上的一个线程。
		} finally {
			lock.unlock();
		}
	}

	public void printB() {
		lock.lock();
		try {
			while (type != "B") {
				try {
					conditionB.await(); // 将打印B的线程阻塞到conditionB的对象上。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " 打印B");
			type = "C";
			conditionC.signal(); // 唤醒在等待conditionC对象上的一个线程。
		} finally {
			lock.unlock();
		}
	}

	public void printC() {
		lock.lock();
		try {
			while (type != "C") {
				try {
					conditionC.await();// 将打印C的线程阻塞到conditionC的对象上。
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println(Thread.currentThread().getName() + " 打印C");
			type = "A";
			conditionA.signal();//唤醒在等待conditionA对象上的一个线程。
		} finally {
			lock.unlock();
		}
	}
}
