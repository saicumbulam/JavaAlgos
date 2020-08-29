package InterViewPrep;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] denominations = {1, 2, 3};
        System.out.println(Calculate(denominations, 5));
    }

    private static int Calculate(int[] arr, int capacity)
    {
        int[][] dp = new int[arr.length][capacity+1];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= capacity; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int s = 0; s <= capacity; s++) {
                if (i > 0)
                {
                    dp[i][s] = dp[i-1][s];
                }
                if (arr[i] <= s)
                {
                    if (dp[i][s - arr[i]] != Integer.MAX_VALUE)
                    {
                        dp[i][s] = Math.min(dp[i][s], dp[i][s - arr[i]]+1);
                    }
                }
            }
        }

        return dp[arr.length-1][capacity] == Integer.MAX_VALUE ? -1 : dp[arr.length-1][capacity];
    }
}
