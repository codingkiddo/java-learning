package com.leetcode.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

	public static void main(String[] args) {
		String[] arr1 = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(arr1));
		
		String[] arr2 = {"xyza", "xyzb"};
		System.out.println(longestCommonPrefix(arr2));
	}

	public static String longestCommonPrefix(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String first = v[0];
        String last = v[v.length-1];
        for (int i=0; i<Math.min(first.length(), last.length()); i++) {
            if (first.charAt(i) != last.charAt(i)) {
                return ans.toString();
            }
            ans.append(first.charAt(i));
        }
        return ans.toString();
    }

}
