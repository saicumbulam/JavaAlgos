/*
Given an array with positive numbers and a target number,
find all of its contiguous subarrays whose product is
less than the target number.

Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.

Time complexity: O(N^3)
Space complexity: O(N^2) for the tempList => N * (N+1)/2 =>  n + (n-1) + (n-2) + ... 3 + 2 + 1

* */
package InterViewPrep.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubArrayProductLesserThanTarget {
    public static void main(String[] args) {
        int[] arr = {2, 5, 3, 10};
        int target = 30;
        //System.out.println(Calculate(arr, target));
        System.out.println(Calculater(arr, target));
    }

    private static List<List<Integer>> Calculater(int[] arr, int target)
    {
        List<List<Integer>> result = new ArrayList<>();

        int windowStart = 0, product = 1;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            product *= arr[windowEnd];
            while (product >= target && windowStart < arr.length)
            {
                product /= arr[windowStart++];
            }

            List<Integer> tempList = new ArrayList<>();
            for (int i = windowEnd; i >= windowStart ; i--) {
                tempList.add(0,arr[i]);
                result.add(new ArrayList<>(tempList));
            }
        }
        return result;
    }
}
