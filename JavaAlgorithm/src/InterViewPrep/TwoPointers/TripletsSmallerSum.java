/*
Given an array arr of unsorted numbers and a target sum, count all triplets
in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are
three different indices. Write a function to return the count of
such triplets.

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than
the target: [-1, 0, 3], [-1, 0, 2]

Time complexity: O(N^2)
Space complexity: O(N)

* */
package InterViewPrep.TwoPointers;

import java.util.Arrays;

public class TripletsSmallerSum {
    public static void main(String[] args) {
        int[] arr = {-1,0,2,3};
        int target = 3;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target)
    {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < arr.length -2 ; i++) {
            int left = arr[i+1];
            int right = arr.length-1;

            while (left < right)
            {
                int sum = arr[left] + arr[right] + arr[i];

                if (target > sum)
                {
                    count = right - left;
                    left++;
                }
                else
                {
                    right--;
                }
            }
        }

        return count;
    }
}
