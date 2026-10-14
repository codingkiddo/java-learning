package com.example.ds;

import java.util.HashSet;
import java.util.Set;

public class PairSum {

	public static boolean hasPairSum(int[] nums, int target) {

		Set<Integer> seen = new HashSet<>();

		for (int num : nums) {

			int needed = target - num;

			if (seen.contains(needed)) {
				return true;
			}

			seen.add(num);
		}

		return false;
	}

	public static void main(String[] args) {

		int[] nums = { 8, 1, 10, 4, 2, 6 };
		int target = 12;

		System.out.println(hasPairSum(nums, target));
	}

}
