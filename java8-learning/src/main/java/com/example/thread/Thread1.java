package com.example.thread;

public class Thread1 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(10L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		
	}
	
}
