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
        System.out.println(Calculate(arr, target));
    }

    private static List<List<Integer>> Calculate(int[] arr, int target)
    {
        Arrays.sort(arr);
        List<List<Integer>> result = new ArrayList<>();
        int product = 1;
        int left = 0;

        for (int right = 0; right < arr.length; right++) {   // this is O(N) => for loop
            product *= arr[right];

            while (left < arr.length && product >= target)
            {
                product /= arr[left];
                left++;
            }

            List<Integer> temp = new ArrayList<>();   // creating subsets is O(N^2)

            for (int i = right; i >= left; i--) { // this should be right to left to get o/p without duplicates
                temp.add(arr[i]);
                result.add(new ArrayList<>(temp));
            }
        }

        return result;
    }
}
