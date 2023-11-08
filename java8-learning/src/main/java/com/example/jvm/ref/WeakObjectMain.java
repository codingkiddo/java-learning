package com.example.jvm.ref;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WeakObjectMain {

	public static void main(String[] args) {

		try {
			ReferenceQueue aReferenceQueue = new ReferenceQueue();
			Object anObject = new Object();
			WeakReference ref = new WeakReference(anObject, aReferenceQueue);
			String extraData = new String("Extra Data");
			HashMap aHashMap = new HashMap();
			;

			// Associate extraData (value) with anObject (key) in aHashMap
			aHashMap.put(anObject, extraData);

			// Check that a reference to an object was created
			System.out.println("*** created ref to some object");
			System.out.println();
			System.out.println("contents of ref: " + ref.get());
			System.out.println();

			// Check whether the reference Object is enqueued
			System.out.println("ref.isEnqueued(): " + ref.isEnqueued());
			System.out.println();

			// Clear the strong reference to anObject
			anObject = null;

			// Clear the strong reference to extraData
			if (anObject == null) {
				extraData = null;
			}

			// Run the garbage collector, and
			// Check the Reference object's referent
			System.out.println("*** running gc...");
			System.gc();
			System.out.println();
			System.out.println("contents of ref: " + ref.get());
			System.out.println();

			// Check whether the Reference Object is enqueued
			System.out.println("ref.isEnqueued(): " + ref.isEnqueued());
			System.out.println();

			// Enqueue the Reference Object. This method returns false
			// if the Reference Object is already enqueued.
			System.out.println("enqueued=" + ref.enqueue());

			
//			for ( int i=0; i<100000; i++) {
//				List<String> list = new ArrayList<>();
//				for ( int j=0; j<100000; j++) { 
//					list.add(i+j+"");
//				}
//			}
			
		} catch (Exception e) {
			System.err.println("An exception occurred:");
			e.printStackTrace();
		}

	}

}
