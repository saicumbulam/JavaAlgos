package Leetcode.Array.Medium;

import java.util.Arrays;

public class SquaresSortedArray {
    public static void main(String[] args) {
        int[] nums = {-4,-1,0,3,10};
        int[] result = Calculate(nums);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static int[] Calculate(int[] nums)
    {
        int[] result = new int[nums.length];
        int resultIndex = nums.length-1, left = 0, right = nums.length-1;

        while (left < right)
        {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare)
            {
                result[resultIndex--] = leftSquare;
                left++;
            }
            else {
                result[resultIndex--] = rightSquare;
                right--;
            }
        }
        return result;
    }
}
