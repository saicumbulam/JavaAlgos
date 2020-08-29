package InterViewPrep;

import java.util.ArrayList;
import java.util.List;

public class TargetSum {
    private int count = 0;
    public static void main(String[] args) {
        //int[] arr = {1, 1, 1, 1, 1};
        int[] arr = {1, 1, 2, 3};
        int target = 1;

        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target)
    {
        //sum(s1) - sum(s2) = S
        // sum(s1) + sum(s2) = total
        // adding these two we get
        // 2sum(s1) = S+ total
        // sum(s1) = (S + total)/2;

        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            total += arr[i];
        }

        if (((target + total)/2)%2 != 0)
        {
            return 0;
        }

        return Calculate1(arr, (target + total)/2);
    }

    private static int Calculate1(int[] arr, int sum)
    {
        int[][] dp = new int[arr.length][sum+1];

        for (int i = 0; i < arr.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= sum ; i++) {
            dp[0][i] = arr[0] == i ? 1 : 0;
        }

        for (int i = 1; i < arr.length; i++) {
            for (int s = 1; s <= sum ; s++) {
                dp[i][s] = dp[i-1][s];

                if (arr[i] <= s)
                {
                    dp[i][s] += dp[i-1][s-arr[i]];
                }
            }
        }

        return dp[arr.length-1][sum];
    }
}
