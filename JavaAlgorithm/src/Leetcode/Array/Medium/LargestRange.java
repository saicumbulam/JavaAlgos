package Leetcode.Array.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LargestRange {
    public static void main(String[] args) {
        int[] arr = {1,11,3,0,15,5,2,4,10,7,12,6};
        System.out.println(Calculate(arr));
    }
    private static List<Integer> Calculate(int[] arr)
    {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        int maxLength = 0;

        for (int num: arr
             ) {
            map.put(num, true);
        }

        for (int item: arr
             ) {
            int currentLength = 0;
            int left = item-1;
            int right = item+1;

            while (map.containsKey(left))
            {
                map.put(left, false);
                currentLength++;
                left--;
            }
            while (map.containsKey(right))
            {
                map.put(right, false);
                currentLength++;
                right++;
            }

            if (currentLength > maxLength)
            {
                maxLength = currentLength;
                result.add(0, left+1);
                result.add(1, right-1);
            }
        }
        return result;
    }
}
