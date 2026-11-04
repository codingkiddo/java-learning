package com.example.thread;

public class SyncDemo {

	private static volatile int counter = 0;

	public static void main(String[] args) {

		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				counter++;
			}
		});

		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Counter: " + counter);
	}

}
