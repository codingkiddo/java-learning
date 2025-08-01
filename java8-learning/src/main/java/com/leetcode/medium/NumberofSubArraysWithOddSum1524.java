package com.leetcode.medium;

public class NumberofSubArraysWithOddSum1524 {

}

class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1000000007;
        int odd = 0, even = 1; 
        int result = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (sum % 2 == 1) {
                result = (result + even) % MOD;
                odd++;
            } else {
                result = (result + odd) % MOD;
                even++;
            }
        }

        return result;
    }
}
