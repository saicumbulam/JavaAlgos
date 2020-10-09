/*
* */

package Leetcode.Dynamic.Often;

import java.util.Arrays;

public class LongestAlternativeSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        if(nums.length == 0) return 0;
        //dp[i][0] = stores the LAS ending at 'i' such that
        // the last two elements are in ascending order
        //dp[i][1] = stores the LAS ending at 'i' such that the
        // last two elements are in descending order
        int[][] dp = new int[nums.length][2];
        int maxLength = 1;

        // every single element can be considered as LAS 1
        Arrays.fill(dp[0], 1);
        Arrays.fill(dp[1], 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j])
                {
                    // if nums[i] is BIGGER than nums[j] then we will
                    // consider the LAS ending at 'j' where the
                    // last two elements were in DESCENDING order
                    dp[i][0] = Math.max(dp[i][0], 1 + dp[j][1]);
                    maxLength = Math.max(maxLength, dp[i][0]);
                }
                else if (nums[i] != nums[j])
                {
                    // if nums[i] is SMALLER than nums[j] then we will
                    // consider the LAS ending at 'j' where the
                    // last two elements were in ASCENDING order
                    dp[i][1] = Math.max(dp[i][1], 1 + dp[j][0]);
                    maxLength = Math.max(maxLength, dp[i][1]);
                }
            }
        }
        return maxLength;
    }
}
