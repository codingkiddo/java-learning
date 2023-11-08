package com.example.thread;

public class Print1To10 {

	public void print() {
		for (int i=0; i<10; i++) {
//			try {
//				Thread.sleep(1L * 1000);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			System.out.println("Thread " + Thread.currentThread().getName() + " - " + i);
		}
	}
	
}
