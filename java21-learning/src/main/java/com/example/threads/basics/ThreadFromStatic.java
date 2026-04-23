package com.example.threads.basics;

public class ThreadFromStatic {

	static {
		Thread t1 = new Thread(() -> {
            System.out.println("Running in: " + Thread.currentThread().getName());
        });

        t1.setName("Worker-1");
        t1.start();
	}
//	public static void main(String[] args) {
//	}

}
