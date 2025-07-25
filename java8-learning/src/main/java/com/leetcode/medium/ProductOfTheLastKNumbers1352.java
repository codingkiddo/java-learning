package com.leetcode.medium;

import java.util.ArrayList;

public class ProductOfTheLastKNumbers1352 {
	ArrayList<Integer> list = new ArrayList<>();
    int prod = 1;

    public ProductOfTheLastKNumbers1352() {
        
    }
    
    public void add(int num) {
        if(num == 0){
            list = new ArrayList<>();
            prod = 1;
            return;
        }
        prod = prod * num;
        list.add(prod);
    }
    
    public int getProduct(int k) {
        if(list.size() < k) return 0;
        int ans = list.get(list.size() - 1);
        if(list.size() == k) return ans;
        return ans / list.get(list.size() - 1 - k);
    }
}
