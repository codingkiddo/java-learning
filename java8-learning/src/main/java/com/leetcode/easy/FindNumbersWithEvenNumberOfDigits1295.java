package com.leetcode.easy;

public class FindNumbersWithEvenNumberOfDigits1295 {
	public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            String s = Integer.toString(i);
            if (s.length() % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
