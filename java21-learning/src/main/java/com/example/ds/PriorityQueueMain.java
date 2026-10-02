package com.example.ds;

import java.util.PriorityQueue;

public class PriorityQueueMain {

	public static void main(String[] args) {

		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.offer(10);
		pq.offer(20);
		pq.offer(30);
		System.out.println(pq);
		System.out.println(pq.peek());
		
		PriorityQueue<Double> pqd = new PriorityQueue<>();
		PriorityQueue<Object> pqObj = new PriorityQueue<>();
		pqObj.offer(100);
		pqObj.offer("100");
		System.out.println(pqObj.peek());
		
	}

}
