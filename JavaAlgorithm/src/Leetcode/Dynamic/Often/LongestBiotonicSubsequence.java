package Leetcode.Dynamic.Often;

import java.util.Arrays;

public class LongestBiotonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums) {
        int[] lds = new int[nums.length];
        int[] ldsReverse = new int[nums.length];
        Arrays.fill(lds, 1);
        Arrays.fill(ldsReverse, 1);


        for (int i = 0; i < nums.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if (nums[j] < nums[i])
                {
                    lds[i] = Math.max(lds[i], lds[j]+1);
                }
            }
        }

        for (int i = nums.length-1; i >= 0; i--) {
            for (int j = i+1; j < nums.length ; j++) {
                if (nums[j] < nums[i])
                {
                    ldsReverse[i] = Math.max(ldsReverse[i], ldsReverse[j]+1);
                }
            }
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            //c1+c2-1
            maxLength = Math.max(maxLength, lds[i] + ldsReverse[i] - 1);
        }

        return maxLength;
    }
}
