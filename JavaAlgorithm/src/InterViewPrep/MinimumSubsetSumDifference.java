package InterViewPrep;

public class MinimumSubsetSumDifference {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 9};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        int halfSum = sum/2;

        boolean[][] dp = new boolean[arr.length][halfSum+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= halfSum; s++) {
            dp[0][s] = arr[0] == s ? true : false;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= halfSum; s++) {
                if (dp[i-1][s])
                {
                    dp[i][s] = dp[i-1][s];
                }
                else if (s >= arr[i])
                {
                    dp[i][s] = dp[i-1][s - arr[i]];
                }
            }
        }


        int sum1 = 0;

        for (int i = halfSum; i >= 0 ; i--) {
            if (dp[arr.length-1][i])
            {
                sum1 = i;
                break;
            }
        }

        int sum2 = sum - sum1;
        return Math.abs(sum1 - sum2);
    }
}
