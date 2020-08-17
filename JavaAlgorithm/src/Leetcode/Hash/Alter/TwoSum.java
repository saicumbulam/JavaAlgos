/*
Time complexity: o(n)
space complexity : o(n)
* */
package Leetcode.Hash.Alter;

import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 7, 11, 15};
        int target = 9;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i]))
            {
                System.out.println(i + ", " + map.get(target-arr[i]));
                break;
            }
            else
            {
                map.put(arr[i], i);
            }
        }
    }
}
