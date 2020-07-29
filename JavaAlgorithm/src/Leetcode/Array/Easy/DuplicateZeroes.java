package Leetcode.Array.Easy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DuplicateZeroes {
    public static void main(String[] args) {
        int[] nums = {1,0,2,3,0,4,5,0};
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
            if(nums[i] == 0)
            {
                queue.add(0);
            }
            nums[i] = queue.poll();
        }

        Arrays.stream(nums).forEach(System.out::print);
    }
}
