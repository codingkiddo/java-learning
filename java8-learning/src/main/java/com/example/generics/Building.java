package com.example.generics;

public class Building implements Comparable<Building> {

    public void paint() {
        System.out.println("Painting Building");
    }

	@Override
	public int compareTo(Building o) {
		// TODO Auto-generated method stub
		return 0;
	}
}