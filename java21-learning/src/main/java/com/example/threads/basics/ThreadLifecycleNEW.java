package com.example.threads.basics;

public class ThreadLifecycleNEW {

//	Thread.State.NEW
//	Thread object has been created with new Thread(...) but .start() has not been called yet. The underlying OS thread does not exist at this point — only the Java object does.
//	STATE TRANSITIONS
//	→ RUNNABLE when .start() is called
//	Gotcha: Calling start() twice throws IllegalThreadStateException. Once terminated, a thread cannot be restarted.
	public static void main(String[] args) {

		Thread t = new Thread(() -> System.out.println("hello"));
		// State: NEW — OS thread not created yet
		System.out.println(t.getState()); // NEW

		t.start(); // Now OS thread is created → moves to RUNNABLE
		System.out.println(t.getState()); //  RUNNABLE
		
//		t.interrupt();
	}

}
