package com.example.java8.features;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class ReferenceExample {

	public static void main(String[] args) {
        // Strong Reference
        String strongRef = new String("Strong Reference");

        // Soft Reference
        SoftReference<String> softRef = new SoftReference<>(new String("Soft Reference"));

        // Weak Reference
        WeakReference<String> weakRef = new WeakReference<>(new String("Weak Reference"));

        // Phantom Reference
        ReferenceQueue<String> queue = new ReferenceQueue<>();
        PhantomReference<String> phantomRef = new PhantomReference<>(new String("Phantom Reference"), queue);

        System.gc();

        // Soft reference might still be accessible if there's enough memory
        if (softRef.get() != null) {
            System.out.println("Soft Reference: " + softRef.get());
        }

        // Weak reference will likely be collected
        if (weakRef.get() == null) {
            System.out.println("Weak Reference has been collected");
        }

        // Phantom reference is always null
        System.out.println("Phantom Reference: " + phantomRef.get());
    }

}
