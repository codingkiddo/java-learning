package com.example.generics;

import java.lang.annotation.Native;

public class CollectionsListMain {

	/**
     * A constant holding the minimum value an {@code int} can
     * have, -2<sup>31</sup>.
     */
    @Native public static final int   MIN_VALUE = 0x80000000;

    /**
     * A constant holding the maximum value an {@code int} can
     * have, 2<sup>31</sup>-1.
     */
    @Native public static final int   MAX_VALUE = 0x7fffffff;
    
	public static void main(String[] args) {

		System.out.println(MIN_VALUE);
		System.out.println(MAX_VALUE);
		
	}

}
