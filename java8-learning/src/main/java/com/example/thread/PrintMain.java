package com.example.thread;

public class PrintMain {

	private Print1To10 pringObj = new Print1To10(); 
	
	public static void main(String[] args) {

		new PrintMain().go();
		
	}

	private void go() {
		PrintWorker w1 = new PrintWorker(pringObj);
		PrintWorker w2 = new PrintWorker(pringObj);
		
		Thread t1 = new Thread(w1, "T-1");
		Thread t2 = new Thread(w2, "T-2");
		
		t1.start();
		t2.start();
	}

}
