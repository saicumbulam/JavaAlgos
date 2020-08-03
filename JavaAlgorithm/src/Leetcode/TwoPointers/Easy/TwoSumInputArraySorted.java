package Leetcode.TwoPointers.Easy;

public class TwoSumInputArraySorted {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] result = Calculate(nums, target);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    private static int[] Calculate(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;

        while (left < right)
        {
            int sum = nums[left] + nums[right];
            if (sum == target)
            {
                return new int[]{left+1, right+1}; // Not zero based result
            }
            if (target > sum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }

        return new int[]{-1};
    }
}
