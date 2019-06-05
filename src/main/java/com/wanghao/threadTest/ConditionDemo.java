package com.wanghao.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConditionDemo {

	final Lock lock = new ReentrantLock();
	final Condition condition = lock.newCondition();

	public static void main(String[] args) {
		ConditionDemo test = new ConditionDemo();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();

		consumer.start();
		producer.start();
		
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}

		private void consume() {

			try {
				lock.lock();
				System.out.println("消费者开始执行" + Thread.currentThread().getName());
				condition.await();
				System.out.println("消费者执行结束" + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			} finally {				
				lock.unlock();
			}

		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			produce();
		}

		private void produce() {
			try {
				lock.lock();
				System.out.println("生产者开始执行" + Thread.currentThread().getName());
				condition.signal();
				System.out.println("生产者执行结束：" + Thread.currentThread().getName());
			} finally {
				lock.unlock();
			}
		}
	}

}
