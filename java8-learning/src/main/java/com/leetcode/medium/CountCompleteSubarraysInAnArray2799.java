package com.leetcode.medium;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CountCompleteSubarraysInAnArray2799 {
	public int countCompleteSubarrays(int[] nums) {
        int k = (int) Arrays.stream(nums).distinct().count(), res = 0;
        for (int i = 0; i < nums.length; i++) {
            Set<Integer> st = new HashSet<>();
            for (int j = i; j < nums.length; j++) {
                st.add(nums[j]);
                if (st.size() == k) res++;
            }
        }
        return res;
    }
}
