package Leetcode.String.Easy.Easy;

import java.util.HashSet;

public class checkIfNDoubleExists {
    public static void main(String[] args) {
        int[] nums = {10,2,5,3};

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (set.contains(2*nums[i])) {
                System.out.println("true");
            } else if (nums[i]%2==0) {
                if (set.contains(nums[i]/2)) {
                    System.out.println("true");
                }
            }
            set.add(nums[i]);
        }
    }
}
