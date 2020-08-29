package InterViewPrep;

public class EqualSubsetSum {
    public static void main(String[] args) {
        //int[] arr = {1, 2, 3, 4};
        //int[] arr = {1, 1, 3, 4, 7};
        int[] arr = {2, 3, 4, 6};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[] arr)
    {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        if (sum % 2 != 0)
        {
            return false;
        }

        boolean[][] dp = new boolean[arr.length][sum/2+1];

        // populate the sum=0 column, as we can always have '0' sum without including any element

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        // with only one number, we can form a subset only when the required sum is equal to its value
        // any element equal to sum
        for (int s = 1; s <= sum/2; s++) {
            dp[0][s] = arr[0] == s ? true : false;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= sum/2; s++) {
                if (dp[i-1][s])
                {
                    dp[i][s] = dp[i-1][s];
                }
                else if (arr[i] <= s)
                {
                    dp[i][s] = dp[i-1][s - arr[i]];
                }
            }
        }

        return dp[arr.length-1][sum/2];
    }
}
