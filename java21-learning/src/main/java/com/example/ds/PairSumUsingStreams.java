package com.example.ds;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class PairSumUsingStreams {

	public static int[] findPair(int[] nums, int target) {

        Map<Integer, Integer> seen = new HashMap<>();

        return IntStream.range(0, nums.length)
                .mapToObj(i -> {
                    int needed = target - nums[i];

                    if (seen.containsKey(needed)) {
                        return new int[]{seen.get(needed), i};
                    }

                    seen.put(nums[i], i);
                    return null;
                })
                .filter(pair -> pair != null)
                .findFirst()
                .orElse(new int[]{-1, -1});
    }

    public static void main(String[] args) {

        int[] nums = {8, 1, 10, 4, 2, 6};
        int target = 12;

        System.out.println(Arrays.toString(findPair(nums, target)));
    }


}
