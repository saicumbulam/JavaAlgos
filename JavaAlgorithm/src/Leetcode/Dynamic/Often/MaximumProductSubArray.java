package Leetcode.Dynamic.Often;

public class MaximumProductSubArray {
    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        int currMax = nums[0];
        int currMin = nums[0];
        int finalMax = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int temp = currMax;
            currMax = Math.max(nums[i], Math.max(temp*nums[i], currMin*nums[i]));
            currMin = Math.min(nums[i], Math.min(temp*nums[i], currMin*nums[i]));

            finalMax = Math.max(finalMax,currMax);
        }

        return finalMax;
    }
}
