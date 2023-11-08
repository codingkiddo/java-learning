package com.example.thread;

public class PrintWorker implements Runnable {
	
	private Print1To10 print1To10;
	
	public PrintWorker(Print1To10 obj) {
		this.print1To10 = obj;
	}

	@Override
	public void run() {
		print1To10.print();
	}

}
