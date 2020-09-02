package InterViewPrep;

public class CoinChange {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        int amount = 5;

        System.out.println(Calculate(arr, amount));
    }

    private static int Calculate(int[] arr, int amount)
    {
        int[][] dp = new int[arr.length][amount+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < arr.length; i++) {
            for (int s = 1; s <= amount; s++) {
                if (i > 0)
                {
                    dp[i][s] = dp[i-1][s];
                }
                if (s >= arr[i])
                    dp[i][s] += dp[i][s - arr[i]];
            }
        }

        return dp[arr.length-1][amount];
    }
}
