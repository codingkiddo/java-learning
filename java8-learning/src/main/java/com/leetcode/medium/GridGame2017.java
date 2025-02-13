package com.leetcode.medium;

public class GridGame2017 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public long gridGame(int[][] grid) {
        long top = 0;
        for (int i = 0; i < grid[0].length; i++) {
            top += grid[0][i];
        }
        
        long bottom = 0, res = Long.MAX_VALUE;
        for (int i = 0; i < grid[0].length; i++) {
            top -= grid[0][i];
            res = Math.min(res, Math.max(top, bottom));
            bottom += grid[1][i];
        }
        
        return res;
    }

}
