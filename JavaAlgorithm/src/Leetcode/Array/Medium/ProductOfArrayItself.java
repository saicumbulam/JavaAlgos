package Leetcode.Array.Medium;

import java.util.ArrayList;
import java.util.List;

public class ProductOfArrayItself {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int temp = 1;
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }

        for (int i = 0; i < result.length; i++) {
            result[i] = temp;
            temp *= nums[i];
        }

        temp = 1;

        for (int i = result.length-1; i >= 0 ; i--) {
            result[i] *= temp;
            temp *= nums[i];
        }

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }
}
