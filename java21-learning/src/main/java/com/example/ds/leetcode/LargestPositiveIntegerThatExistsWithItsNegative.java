package com.example.ds.leetcode;

import java.util.Arrays;

public class LargestPositiveIntegerThatExistsWithItsNegative {

	public static void main(String[] args) {

		int[] nums = { -1, 10, 6, 7, -7, 1 };
		System.out.println(findMaxK(nums));

	}

	private static int findMaxK(int[] nums) {
		System.out.println(nums[0]);
		System.out.println(-nums[0]);
		Arrays.sort(nums);
		Arrays.stream(nums).forEach(n -> System.out.print(n + " "));
		int n = nums.length;
		for (int i = n - 1; i >= 0; i--) {
			if (nums[i] > 0 && Arrays.binarySearch(nums, -nums[i]) >= 0) {
				return nums[i];
			}
		}
		return -1;
	}

}
