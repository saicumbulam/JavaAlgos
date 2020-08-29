package InterViewPrep;

public class CountSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3};
        int sum =4;
        System.out.println(Calculate(arr, sum));
    }

    private static int Calculate(int[] arr, int sum)
    {
        int[][] dp = new int[arr.length][sum+1];

        // populate the sum=0 columns, as we will always have an empty set for zero sum
        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        // with only one number, we can form a subset only when the required sum is equal to its value
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = arr[0] == i ? 1 : 0;
        }

        // process all subsets for all sums
        for(int i=1; i < arr.length; i++) {
            for(int s=1; s <= sum; s++) {
                // exclude the number
                dp[i][s] = dp[i-1][s];
                // include the number, if it does not exceed the sum
                if(s >= arr[i])
                    dp[i][s] += dp[i-1][s-arr[i]];
            }
        }

        // the bottom-right corner will have our answer.
        return dp[arr.length-1][sum];
    }
}
