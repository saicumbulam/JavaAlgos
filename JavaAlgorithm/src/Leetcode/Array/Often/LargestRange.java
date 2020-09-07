package Leetcode.Array.Often;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class LargestRange {
    public static void main(String[] args) {
        int[] arr = {1,11,3,0,15,5,2,4,10,7,12,6};
        System.out.println(Calculate(arr));
    }
    private static List<Integer> Calculate(int[] arr)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int item: arr
             ) {
            set.add(item);
        }

        List<Integer> result = new ArrayList<>();
        int maxLength = 0;

        for (int i = 0; i < arr.length; i++) {
            int i1 = arr[i]-1;
            int i2 = arr[i]+1;

            while (set.contains(i1))
            {
                i1--;
            }
            i1 +=1;

            while (set.contains(i2))
            {
                i2++;
            }
            i2-=1;

            if (maxLength < (i2 - i1))
            {
                result.clear();
                maxLength = i2-i1;
                result.add(0, i1);
                result.add(0, i2);

            }

        }

        return result;
    }
}
