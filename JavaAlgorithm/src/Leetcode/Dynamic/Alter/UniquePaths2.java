/*
A robot is located at the top-left corner of a m x n grid
(marked 'Start' in the diagram below).

The robot can only move either down or right at
any point in time. The robot is trying to reach the
bottom-right corner of the grid (marked 'Finish' in the diagram below).

Now consider if some obstacles are added to the grids.
How many unique paths would there be?
* */
package Leetcode.Dynamic.Alter;

public class UniquePaths2 {
    public static void main(String[] args) {
        int[][] arr = {{0,0,0},{0,1,0},{0,0,0}};
        int m = arr.length;
        int n = arr[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            if (arr[i][0] != 1)
                dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (arr[0][i] != 1)
                dp[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (arr[i][j] != 1)
                {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        System.out.println(dp[m-1][n-1]);
    }
}
