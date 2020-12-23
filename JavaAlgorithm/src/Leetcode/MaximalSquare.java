package Leetcode;

public class MaximalSquare {
    public static void main(String[] args) {
        //int[][] arr = {{1,0,1,0,0},{1,0,1,1,1},{1,1,1,1,1},{1,0,0,1,0}};
        int[][] arr = {{0,0,0,0,0},
                       {0,0,1,1,1},
                       {0,0,1,1,1},
                       {0,0,0,0,0}};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[][] arr)
    {
        int[][] dp = new int[arr.length+1][arr[0].length+1];
        int maxLen = 0;

        for (int i = 1; i <= arr.length ; i++) {
            for (int j = 1; j <= arr[0].length ; j++) {
                if (arr[i-1][j-1] == 1)
                {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                    maxLen = Math.max(maxLen, dp[i][j]);
                }
            }
        }

        return maxLen;
    }
}
