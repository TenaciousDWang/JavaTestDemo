package com.wanghao.threadTest;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BufferTest {
	
	private int bufferCount;
	
	public BufferTest(int bufferCount) {
		this.bufferCount = bufferCount;
	}

	final Lock lock = new ReentrantLock();// 锁对象
	final Condition notFull = lock.newCondition(); // 写线程条件
	final Condition notEmpty = lock.newCondition();// 读线程条件
	final Object[] items = new Object[bufferCount];// 初始化队列
	int putptr/* 写索引 */=0; 
	int takeptr/* 读索引 */=0;  
	int count/* 队列中存在的数据个数 */=0; 
	
	public int getCount() {
		return count;
	}

	public void put(Object x) throws InterruptedException {
		lock.lock(); // 获取锁
		try {
			while (count == items.length) {
				notFull.await();// 当计数器count等于队列的长度时，不能再插入，因此等待。阻塞写线程。
			}
				
			items[putptr] = x;// 赋值
			putptr++;

			if (putptr == items.length)
				putptr = 0;// 若写索引写到队列的最后一个位置了，将putptr置为0。
			count++; // 每放入一个对象就将计数器加1。
			notEmpty.signal(); // 一旦插入就唤醒取数据线程。
		} finally {
			lock.unlock(); // 最后释放锁
		}
	}

	public Object take() throws InterruptedException {
		lock.lock(); // 获取锁
		try {
			while (count == 0)
				notEmpty.await(); // 如果计数器等于0则等待，即阻塞读线程。
			Object x = items[takeptr]; // 取值
			takeptr++;
			if (takeptr == items.length)
				takeptr = 0; // 若读锁应读到了队列的最后一个位置了，则读锁应置为0；即当takeptr达到队列长度时，从零开始取
			count--; // 每取一个将计数器减1。
			notFull.signal(); // 枚取走一个就唤醒存线程。
			return x;
		} finally {
			lock.unlock();// 释放锁
		}
	}

}
