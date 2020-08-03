package Leetcode.TwoPointers.Medium;

import java.util.ArrayList;
import java.util.List;

public class SubArrayProductLessThanTarget {
    public static void main(String[] args) {
        int[] arr = {2,5,3,10};
        int target = 30;
        System.out.println(Calculate(arr, target));
    }

    private static List<List<Integer>> Calculate(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int product = 1, left = 0;

        for (int right = 0; right < arr.length; right++) {
            product *= arr[right];
            // '=' is important as the problem asks for items less than the target
            while (product >= target && left < arr.length)
            {
                product /= arr[left++];
            }

            // right to left should come to avoid duplicates
            List<Integer> tempList = new ArrayList<>();
            for (int i = right; i >= left  ; i--) {
                // index 0 should be added for getting the exact result.
                tempList.add(0, arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }

}
