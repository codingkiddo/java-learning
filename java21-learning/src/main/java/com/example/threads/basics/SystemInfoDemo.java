package com.example.threads.basics;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;

public class SystemInfoDemo {
	public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        Runtime runtime = Runtime.getRuntime();
        MemoryMXBean memoryMXBean = ManagementFactory.getMemoryMXBean();

        System.out.println("=== Current Thread Info ===");
        System.out.println("Thread ID      : " + thread.threadId());
        System.out.println("Thread Name    : " + thread.getName());
        System.out.println("Thread State   : " + thread.getState());
        System.out.println("Is Daemon      : " + thread.isDaemon());
        System.out.println("Priority       : " + thread.getPriority());

        System.out.println("\n=== Processor Info ===");
        System.out.println("Available CPUs : " + runtime.availableProcessors());

        System.out.println("\n=== JVM Memory Info ===");
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long maxMemory = runtime.maxMemory();
        long usedMemory = totalMemory - freeMemory;

        System.out.println("Used Memory    : " + bytesToMB(usedMemory) + " MB");
        System.out.println("Free Memory    : " + bytesToMB(freeMemory) + " MB");
        System.out.println("Total Memory   : " + bytesToMB(totalMemory) + " MB");
        System.out.println("Max Memory     : " + bytesToMB(maxMemory) + " MB");

        System.out.println("\n=== Heap / Non-Heap Info ===");
        MemoryUsage heap = memoryMXBean.getHeapMemoryUsage();
        MemoryUsage nonHeap = memoryMXBean.getNonHeapMemoryUsage();

        System.out.println("Heap Used      : " + bytesToMB(heap.getUsed()) + " MB");
        System.out.println("Heap Max       : " + bytesToMB(heap.getMax()) + " MB");
        System.out.println("Non-Heap Used  : " + bytesToMB(nonHeap.getUsed()) + " MB");
        System.out.println("Non-Heap Max   : " + bytesToMB(nonHeap.getMax()) + " MB");
    }

    private static long bytesToMB(long bytes) {
        return bytes / (1024 * 1024);
    }

}
