package Leetcode.Easy;

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
