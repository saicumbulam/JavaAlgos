/*
problem:
Calculate the maximum profit for robbery if adjacent houses are not allowed.

Time complexity : O(N) if memoization, O(2^N) if its ordinary.
space complexity is o(n)

pseudocode:
For every house ‘i’, we have two options:
Base condition : idx >= arr.length, return 0
1. Steal from the current house (‘i’), and steal from (‘i+2’).
    arr[idx] + recfn(arr,idx+2)
2. Skip the current house (‘i’), and steal from (‘i+1’).
   recfn(arr,idx+1)

3. Get the maximum value from two steals.
*/
package Leetcode.Dynamic.Often;

import java.util.HashMap;

public class HouseRobber {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,1};
        HashMap<Integer, Integer> map = new HashMap<>();
        System.out.println(Calculate(arr, 0, map));
    }

    public static int Calculate(int[] arr, int currentIndex, HashMap<Integer, Integer> map)
    {
        if (!map.containsKey(currentIndex))
        {
            if(currentIndex >= arr.length)
            {
                map.put(currentIndex, 0);
            }
            else
            {
                int steal = arr[currentIndex] + Calculate(arr, currentIndex+2, map);
                int skip = Calculate(arr, currentIndex+1, map);
                map.put(currentIndex, Math.max(steal, skip));
            }
        }
        return map.get(currentIndex);
    }
}
