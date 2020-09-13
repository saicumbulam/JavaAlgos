package Leetcode.Dynamic.Often;

import java.util.HashMap;

public class JumpGame {
    static HashMap<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.println(Calculate(nums, 0));
    }

    private static int Calculate(int[] nums, int index)
    {
        if(map.containsKey(index))
        {
            return map.get(index);
        }

        if(index == nums.length-1)
        {
            map.put(index, 0);
        }

        else if(nums[index] == 0)
        {
            map.put(index, Integer.MAX_VALUE);
        }
        else
        {
            int totalJumps = Integer.MAX_VALUE;
            int start = index+1;
            int end = index + nums[index];

            while(start < nums.length && start <= end)
            {
                int minJumps = Calculate(nums, start++);
                if(minJumps != Integer.MAX_VALUE)
                {
                    totalJumps = Math.min(totalJumps, minJumps+1);
                }
            }

            map.put(index, totalJumps);
        }

        return map.get(index);
    }

}
