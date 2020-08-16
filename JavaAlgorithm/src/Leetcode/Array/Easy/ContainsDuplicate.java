/*
Easy
* */
package Leetcode.Array.Easy;

import java.util.HashMap;

public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        System.out.println(calculate(arr));
    }

    public static boolean calculate(int[] arr)
    {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
        {
            hashMap.put(arr[i], hashMap.getOrDefault(arr[i], 0)+1);
        }

        for (int i = 0; i < arr.length; i++) {
            if(hashMap.get(arr[i]) > 1)
            {
                return true;
            }
        }

        return false;
    }
}
