package com.wjy.scheduled;

public class MyRunnable implements Runnable {

	@Override
	public void run() {

		try {

			System.out.println(Thread.currentThread().getName() + " running MyRunnable");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
