package com.example.threads.basics;

public class CounterMain {

	public static void main(String[] args) {

		Counter counter = new Counter();
		counter.increment();
		System.out.println(counter.getCount());
		
	}

}
