package com.wanghao.threadTest;

public class MyTask implements Runnable {
	private int taskId;

	public MyTask(int id) {
		this.taskId = id;
	}

	@Override
	public void run() {
		System.out.println("正在执行task " + taskId);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("task " + taskId + "执行完毕");
	}
}



