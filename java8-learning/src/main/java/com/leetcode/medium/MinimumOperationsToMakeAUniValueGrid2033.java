package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MinimumOperationsToMakeAUniValueGrid2033 {
	public int minOperations(int[][] grid, int x) {
        List<Integer> arr = new ArrayList<>();
        for (int[] row : grid) {
            for (int num : row) {
                arr.add(num);
            }
        }
        
        Collections.sort(arr);
        int median = arr.get(arr.size() / 2);
        int operations = 0;

        for (int num : arr) {
            int diff = Math.abs(num - median);
            if (diff % x != 0) return -1;
            operations += diff / x;
        }
        return operations;
    }
}
