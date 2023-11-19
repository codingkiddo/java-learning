package com.example.generics;

class Wrapper<T extends Comparable<T>> implements Comparable<Wrapper<T>> {

	private final T theObject;
	
	public Wrapper(T t) { 
		theObject = t; 
	}
	
	public T getWrapper() { 
		return theObject; 
	}
	
	@Override
	public int compareTo(Wrapper<T> other) {
		return theObject.compareTo(other.theObject);
	}
	
}


public class WrapperMain {
	public static void main(String[] args) {
		Wrapper<Long> wrapper1 = new Wrapper<Long>(new Long(0L));
		Wrapper<? extends Number> wrapper2 = new Wrapper<Long>(new Long(0L));
//		Wrapper<Number> wrapper2 = new Wrapper<Number>(new Long(0L));
	}
}