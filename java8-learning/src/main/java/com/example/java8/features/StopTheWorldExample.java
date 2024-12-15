package com.example.java8.features;

public class StopTheWorldExample {
    public static void main(String[] args) {
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Total Memory: " + runtime.totalMemory());
        System.out.println("Free Memory: " + runtime.freeMemory());

        // Trigger a GC
        System.gc();

        // GC may cause a stop-the-world pause
        System.out.println("Free Memory after GC: " + runtime.freeMemory());
    }
}
