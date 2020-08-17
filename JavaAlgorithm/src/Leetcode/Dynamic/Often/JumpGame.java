package Leetcode.Dynamic.Often;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(Calculate(nums));
    }

    private static boolean Calculate(int[] nums)
    {
        int[] dp = new int[nums.length];
        int minJumps = Finder(nums, 0, dp);
        if (minJumps == Integer.MAX_VALUE)
        {
            return false;
        }
        return true;
    }

    private static int Finder(int[] nums, int currentIndex, int[] dp)
    {
        if (currentIndex == nums.length-1)
        {
            return 0;
        }

        if (nums[currentIndex] == 0)
        {
            return Integer.MAX_VALUE;
        }

        if (dp[currentIndex] == 0)
        {
            int totalJumps = Integer.MAX_VALUE;
            int start = currentIndex+1;
            int end = currentIndex + nums[currentIndex];

            while (start < nums.length && start <= end)
            {
                int minJumps = Finder(nums, start++, dp);
                if (minJumps != Integer.MAX_VALUE)
                {
                    totalJumps = Math.min(totalJumps, minJumps+1);
                }
                dp[currentIndex] = totalJumps;
            }
        }

        return dp[currentIndex];
    }
}
