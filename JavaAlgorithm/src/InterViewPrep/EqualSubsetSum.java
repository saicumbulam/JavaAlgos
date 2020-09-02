package InterViewPrep;

public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        //int[] arr = {1, 1, 3, 4, 7};
        //int[] arr = {2, 3, 4, 6};
        System.out.println(Calculate(arr));
    }

    private static boolean Calculate(int[] arr)
    {
        int sum = 0;

        for (int item: arr) {
            sum += item;
        }

        if (sum % 2 != 0)
        {
            return false;
        }

        sum = sum/2;
        boolean[][] dp = new boolean[arr.length][sum+1];


        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = true;
        }

        for (int s = 1; s <= sum; s++) {
            dp[0][s] = arr[0] == s;
        }


        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= sum; s++) {
                if (dp[i-1][s])
                    dp[i][s] = dp[i-1][s];
                else if (s >= arr[i])
                    dp[i][s] = dp[i-1][s - arr[i]];
            }
        }

        return dp[arr.length-1][sum];
    }
}
