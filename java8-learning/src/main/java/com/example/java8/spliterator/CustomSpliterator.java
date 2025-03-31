package com.example.java8.spliterator;

import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class CustomSpliterator implements Spliterator<Integer> {

	private final List<Integer> elements;
	private int currentIndex;
	
	public CustomSpliterator(List<Integer> elements) {
		this.elements = elements;
		this.currentIndex = 0;
	}
	
	@Override
	public boolean tryAdvance(Consumer<? super Integer> action) {
		if ( this.currentIndex < elements.size() ) {
			action.accept(elements.get(currentIndex));
			currentIndex++;
			return true;
		}
		return false;
	}

	@Override
	public Spliterator<Integer> trySplit() {
		int currentSize = elements.size() - this.currentIndex;
		if (currentSize < 2) {
			return null;
		}
		
		int splitIndex = currentIndex + currentSize/2;
		CustomSpliterator newSpliterator = new CustomSpliterator(elements.subList(currentIndex, splitIndex));
		currentIndex = splitIndex;
		return newSpliterator;
	}

	@Override
	public long estimateSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int characteristics() {
		// TODO Auto-generated method stub
		return 0;
	}

}
