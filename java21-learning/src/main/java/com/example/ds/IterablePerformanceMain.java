package com.example.ds;

import java.util.ArrayList;
import java.util.List;

public class IterablePerformanceMain {

    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>();
        //		for (int i = 0; i < 1; i++) {
        //		    list.add(i);  // Autoboxing adds unnecessary overhead.
        //		}

        System.out.println(list.isEmpty());
        list.add(1);
        System.out.println(list.isEmpty());
        System.out.println(list);
        for (Integer i : list) {
            System.out.println(i);
        }

        //		for(int i=0; i<list.size(); i++) {
        //			System.out.println(list.get(i));
        //		}
    }
}
