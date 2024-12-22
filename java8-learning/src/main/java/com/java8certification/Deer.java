package com.java8certification;

public class Deer {

	public Deer() {
		System.out.print("Deer");
	}
	public Deer(int age) {
		System.out.print("DeerAge");
	}
	private boolean hasHorns() {
		return false;
	}
	
	public static void main(String[] args) {
		Deer deer = new Reindeer(5);
		System.out.println(", " + deer.hasHorns());
	}
	
}

class Reindeer extends Deer {
	public Reindeer() {
		System.out.println("Reindeer");
	}
	public Reindeer(int age) {
		System.out.print("ReindeerAge");
	}
	
//	@Override // You cannot override private methods 
	private boolean hasHorns() {
		return true;
	}
}
