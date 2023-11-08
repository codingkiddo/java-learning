package com.example.thread;

class Thread2 implements Runnable {

	@Override
	public void run() {
		try {
			Thread.sleep(20L * 1000L);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Thread Name: " + Thread.currentThread().getName());
		
	}
	
}