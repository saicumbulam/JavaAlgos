/*
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.

Time Complexity: O(N^2)
Space Complexity: O(N)
* */
package InterViewPrep.TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletsSumToZero {
    public static void main(String[] args) {
        int[] arr = {-3, 0, 1, 2, -1, 1, -2};
        int target = 0;
        System.out.println(Calculate(arr, target));
    }

    private static List<List<Integer>> Calculate(int[] arr, int target)
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr); //[-3,-2,-1,0,1,1,2]

        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1])
            {
                continue;
            }

            Calculate1(arr, target, i, result);
        }

        return result;
    }

    private static void Calculate1(int[] arr, int target, int first, List<List<Integer>> result)
    {
        int left = first+1, right = arr.length-1;

        while (left < right)
        {
            int sum = arr[first] + arr[left] + arr[right];
            if (sum == target)
            {
                result.add(Arrays.asList(arr[first],arr[left],arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left-1])
                {
                    left++;
                }
                while (left < right && arr[right] == arr[right+1])
                {
                    right--;
                }
            }
            else if (target > sum)
            {
                left++;
            }
            else
            {
                right--;
            }
        }
    }
}
