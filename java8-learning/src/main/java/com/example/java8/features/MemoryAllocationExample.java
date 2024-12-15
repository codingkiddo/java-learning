package com.example.java8.features;

import java.util.ArrayList;
import java.util.List;

public class MemoryAllocationExample {
    public static void main(String[] args) {
        // Object allocation in Eden space
        Object obj1 = new Object();
        Object obj2 = new Object();

        // Objects may be moved to Survivor space after GC
        System.gc();

        // Long-lived objects may be moved to Old Generation
        List<Object> longLivedObjects = new ArrayList<>();
        for (int i = 0; i < 1000; i++) {
            longLivedObjects.add(new Object());
        }
    }
}
