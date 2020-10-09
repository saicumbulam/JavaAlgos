package Leetcode.Array.Often;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LargestRange {
    public static void main(String[] args) {
        int[] arr = {1,11,3,0,15,5,2,4,10,7,12,6};
        int[] result = Calculate(arr);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }
    private static int[] Calculate(int[] arr)
    {
        HashMap<Integer, Boolean> set = new HashMap<>();

        for (int item: arr
             ) {
            set.put(item, true); // to avoid duplicates
        }

        int[] result = new int[2];
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            if(!set.get(arr[i]))
            {
                continue;
            }
            int i1 = arr[i]-1;
            int i2 = arr[i]+1;

            int currentLength = 0;
            while (set.containsKey(i1))
            {
                set.put(i1, false);
                currentLength++;
                i1--;
            }

            while (set.containsKey(i2))
            {
                set.put(i2, false);
                currentLength++;
                i2++;
            }

            if (maxLength < currentLength)
            {
                maxLength = currentLength;
                result[0] =  i1+1;
                result[1] =  i2-1;

            }

        }

        return result;
    }
}
