package Leetcode.Array.Easy;

import java.util.Arrays;

public class SortArrayByParity {
    public static void main(String[] args) {
        int[] nums = {3,1,2,4};

        int lastIndex = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i]%2 == 0)
            {
                int temp = nums[lastIndex];
                nums[lastIndex] = nums[i];
                nums[i] = temp;
                lastIndex++;
            }
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
}
