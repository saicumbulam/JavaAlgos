package InterViewPrep;

public class CountOfSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int sum=4;
        System.out.println(Calculate(arr, sum));
    }

    private static int Calculate(int[] arr, int sum)
    {
        int[][] dp = new int[arr.length][sum+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = arr[0] == s ? 1 : 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= sum; s++) {
                dp[i][s] += dp[i-1][s];
                if (s >= arr[i])
                {
                    dp[i][s] += dp[i-1][s - arr[i]];
                }
            }
        }

        return dp[arr.length-1][sum];
    }
}
