package com.leetcode.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMinimumTimeToReachLastRoomII3342 {
	public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length, m = moveTime[0].length;
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }

        PriorityQueue<int[]> minh = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        minh.add(new int[]{0, 0, 0});
        moveTime[0][0] = 0;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!minh.isEmpty()) {
            int[] current = minh.poll();
            int currTime = current[0];
            int currRow  = current[1];
            int currCol  = current[2];
            if (currTime >= dp[currRow][currCol]) continue;
            if (currRow == n - 1 && currCol == m - 1) return currTime;
            dp[currRow][currCol] = currTime;

            for (int[] dir : directions) {
                int nextRow = currRow + dir[0];
                int nextCol = currCol + dir[1];
                if (nextRow >= 0 && nextRow < n &&
                    nextCol >= 0 && nextCol < m &&
                    dp[nextRow][nextCol] == INF) {
                    int cost  = (currRow + currCol) % 2 + 1;
                    int start = Math.max(moveTime[nextRow][nextCol], currTime);
                    int nextTime = start + cost;
                    minh.add(new int[]{nextTime, nextRow, nextCol});
                }
            }
        }
        return -1;
    }
}
