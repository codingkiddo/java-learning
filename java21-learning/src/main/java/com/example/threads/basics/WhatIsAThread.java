package com.example.threads.basics;

public class WhatIsAThread {

	public static void main(String[] args) {

		// ── Way 1: Extend Thread ──────────────────────────────────────────
		class MyThread extends Thread {
		    @Override
		    public void run() {
		        System.out.println("Running in: " + Thread.currentThread().getName());
		    }
		}
		new MyThread().start();

		// ── Way 2: Implement Runnable (preferred) ────────────────────────
		Runnable task = new Runnable() {
		    @Override
		    public void run() {
		        System.out.println("Runnable running in: " + Thread.currentThread().getName());
		    }
		};
		new Thread(task).start();

		// ── Way 3: Lambda (Java 8+, most common in production) ───────────
		new Thread(() -> System.out.println("Lambda thread")).start();
		
	}

}
