package com.example.ds;

import java.util.Arrays;

public class FindNumber {

	public static void main(String[] args) {

        int[] nums = {8, 1, 10, 4, 2, 6};
        int target = 1;
        System.out.println(find(nums, target));
        System.out.println(findUsingStream(nums, target));
        System.out.println(findUsingAnyMatch(nums, target));
    }

	private static boolean find(int[] nums, int target) {
		for ( int num : nums) {
			if ( num == target ) {
				return true;
			}
		}
		return false;
	}
	
	private static boolean findUsingStream(int[] nums, int target) {
		return !Arrays.stream(nums).filter(n -> n == target).findFirst().isEmpty();
	}
	
	private static boolean findUsingAnyMatch(int[] nums, int target) {
		return Arrays.stream(nums).anyMatch(n -> n==target);
	}

}
