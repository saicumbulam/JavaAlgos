package Leetcode.TwoPointers.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(Calculate(arr));
    }

    private static List<List<Integer>> Calculate(int[] arr)
    {
        List<List<Integer>> result = new ArrayList<>();
        // Arrays should be sorted before continuing this problem
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            if (i > 0 && arr[i] == arr[i-1])
            {
                continue;
            }
            Calculate(arr, -arr[i], i+1, result);
        }
        return result;
    }

    private static void Calculate(int[] arr, int target, int left, List<List<Integer>> result)
    {
        int right = arr.length-1;

        // no returning anything inside the loop.
        while (left < right)
        {
            int currSum = arr[left] + arr[right];
            if (currSum == target)
            {
                result.add(Arrays.asList(arr[left], arr[right], -target));
                left++;
                right--;

                // while should be there to avoid more duplicates
                while (left < right && arr[left] == arr[left+1])
                {
                    left++;
                }
                // while should be there to avoid more duplicates
                while (left < right && arr[right] == arr[right-1])
                {
                    right--;
                }
            }
            else if (currSum < target)
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
