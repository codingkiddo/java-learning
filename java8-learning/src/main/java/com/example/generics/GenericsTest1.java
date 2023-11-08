package com.example.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class GenericsTest1 {

	private static final int COPY_THRESHOLD           =   10;
	
	public static void main(String[] args) {
		
//		List<Number> nums = Arrays.asList(1L, 33.33);
//		List<Integer> ints = Arrays.asList(7);
//		Exception in thread "main" java.lang.UnsupportedOperationException
//		at java.util.AbstractList.add(AbstractList.java:148)
//		at java.util.AbstractList.add(AbstractList.java:108)
//		at com.example.generics.GenericsTest1.copy(GenericsTest1.java:35)
//		at com.example.generics.GenericsTest1.main(GenericsTest1.java:21
//		Easy work around is just to pass in the List into an ArrayList's constructor.
//		For example:
//
//			String valuesInArray[]={"1","2","3","4"};  
//			List modifiableList = new ArrayList(Arrays.asList(valuesInArray));
//			System.out.println(modifiableList.remove("1") + "  remove flag");  
//			System.out.println(" collcetion "+ modifiableList); 
//			Response:
//
//			true remove flag
//
//			collcetion [2, 3, 4]

		List<Number> nums = new ArrayList<Number>(Arrays.asList(1L, 33.33));
		List<Integer> ints = new ArrayList<Integer>(Arrays.asList(7, 8, 9, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0));
		
		System.out.println("NUMBERS: " + nums);
		
//		Collections.copy(null, null);
		copy(nums, ints);
		
		System.out.println("NUMBERS: " + nums);
	}
	
	
	private static <T> void copy(List<? super T> dest, List<? extends T> src) {
        int srcSize = src.size();
//        if (srcSize > dest.size())
//            throw new IndexOutOfBoundsException("Source does not fit in dest");
        System.out.println();
        if (srcSize < COPY_THRESHOLD ||
            (src instanceof RandomAccess && dest instanceof RandomAccess)) {
            for (int i=0; i<srcSize; i++)
//                dest.set(i, src.get(i));
            	dest.add(src.get(i));
//            	dest.add(10L); // NOT OK;
//            	dest.add(10); // NOT OK;
//            	dest.add((Integer)(new Integer(10))); // NOT OK;
//            	dest.add(10); // NOT OK;
        } else {
            ListIterator<? super T> di=dest.listIterator();
            ListIterator<? extends T> si=src.listIterator();
            for (int i=0; i<srcSize; i++) {
                di.next();
//                di.set(si.next());
//                dest.add(10);
                di.add(si.next());
            }
        }
        
    }

}
