package Leetcode.Dynamic.Hard;

import java.util.HashMap;

public class MaximumSumIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,1,2,6,10,1,12};
        System.out.println(Calculate(nums, 0, -1, 0));
    }

    private static int Calculate(int[] nums, int currentIdx, int previousIdx, int sum)
    {
        if (currentIdx >= nums.length)
        {
            return sum;
        }

        int c1 = sum;
        if (previousIdx == -1 || nums[currentIdx] > nums[previousIdx])
        {
            c1 = Calculate(nums,currentIdx+1, currentIdx, sum + nums[currentIdx]);
        }

        int c2 = Calculate(nums,currentIdx+1, previousIdx, sum);

        return Math.max(c1, c2);
    }
}
