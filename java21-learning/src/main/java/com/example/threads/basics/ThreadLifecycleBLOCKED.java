package com.example.threads.basics;

//Thread.State.BLOCKED
//The thread is waiting to acquire a monitor lock (intrinsic lock) on a synchronized block or method 
//that another thread currently holds. This is purely about synchronized — 
//it does NOT apply to java.util.concurrent locks like ReentrantLock.
//STATE TRANSITIONS
//→ RUNNABLE once the monitor lock becomes available and the thread wins it


public class ThreadLifecycleBLOCKED {

}
