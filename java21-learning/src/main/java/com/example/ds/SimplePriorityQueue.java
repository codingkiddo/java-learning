package com.example.ds;

import java.util.Arrays;

public class SimplePriorityQueue {
	
	private Integer[] queue;
	private int size;
	
	public SimplePriorityQueue(int capacity) {
        queue = new Integer[capacity];
    }

    public int size() {
        return size;
    }

    public Integer peek() {
    	if ( size ==0 ) {
    		return null;
    	}
    	return queue[0];
    }
    
    public void offer(Integer x) {
    	int k = size;
    	queue[k] = x;
    	size++;
    	shiftUp(k);
    }
    
    private void shiftUp(int k) {
    	while (k>0) {
    		int parent = (k-1)/2;
    		if (queue[k] >= queue[parent]) {
    			break;
    		}
    		int temp = queue[k];
    		queue[k] = queue[parent];
    		queue[parent] = temp;
    		k = parent;
    	}
    }
    
    @Override
    public String toString() {
		return Arrays.toString(Arrays.copyOf(queue, size));
	}
	
	public static void main(String[] args) {
		SimplePriorityQueue queue = new SimplePriorityQueue(10);
		queue.offer(10); queue.offer(20); queue.offer(30); queue.offer(40); queue.offer(5); 
		System.out.println(queue);
	}

}
