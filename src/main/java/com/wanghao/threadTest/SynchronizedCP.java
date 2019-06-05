package com.wanghao.threadTest;

import java.util.PriorityQueue;

public class SynchronizedCP {

	private int queueSize = 10;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);

	public static void main(String[] args) {
		SynchronizedCP test = new SynchronizedCP();
		Producer producer = test.new Producer();
		Consumer consumer = test.new Consumer();

		producer.start();
		consumer.start();
	}

	class Consumer extends Thread {

		@Override
		public void run() {
			consume();
		}
		volatile boolean flag=true;    
		private void consume() {
			while (flag) {
				synchronized (queue) {
					while (queue.size() == 0) {
						try {
							System.out.println("队列空，等待数据");
							queue.wait();
						} catch (InterruptedException e) {
							flag =false; 
						}
					}
					queue.poll();
					queue.notify();
					System.out.println("从队列取走一个元素，队列剩余" + queue.size() + "个元素");
				}
			}
		}
	}

	class Producer extends Thread {

		@Override
		public void run() {
			produce();
		}
		volatile boolean flag=true;    
		private void produce() {
			while (flag) {
				synchronized (queue) {
					while (queue.size() == queueSize) {
						try {
							System.out.println("队列满，等待有空余空间");
							queue.wait();
						} catch (InterruptedException e) {
							flag =false; 
						}
					}
					queue.offer(1);
					queue.notify();
					System.out.println("向队列取中插入一个元素，队列剩余空间：" + (queueSize - queue.size()));
				}
			}
		}
	}
}
