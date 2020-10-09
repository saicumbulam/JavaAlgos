package InterViewPrep;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberOfLongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] nums = {2,2,2,2,2};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        int[] dp = new int[nums.length];
        int[] counts = new int[nums.length];

        Arrays.fill(dp,1);
        Arrays.fill(counts,1);

        int maxLength = 1;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j])
                {
                    dp[i] = dp[j] + 1;
                    counts[i] = counts[j];
                }
                else if (dp[i] == 1 + dp[j])
                {
                    counts[i] += counts[j];
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }

        int ans = 0;
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] == maxLength)
            {
                ans += counts[i];
            }
        }
        return ans;
    }
}
