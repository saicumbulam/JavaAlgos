package Leetcode.TwoPointers.After;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadruplesSum {
    public static void main(String[] args) {
        int[] arr = {4,1,2,-1,1,-3};
        int target = 1;
        System.out.println(Calculate(arr, target));
    }

    private static List<List<Integer>> Calculate(int[] arr, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);
        // subtract 3 from array length
        for (int i = 0; i < arr.length-3; i++) {
            if (i > 0 && arr[i] == arr[i-1])
            {
                continue;
            }
            // subtract 2 from array length
            for (int j = i+1; j < arr.length-2; j++) {
                if (j > i+1 && arr[j] == arr[j-1])
                {
                    continue;
                }
                SearchPair(arr, target, i, j, result);
            }
        }
        return result;
    }

    private static void SearchPair(int[] arr, int target, int first, int second, List<List<Integer>> result) {
        int left = second+1;
        int right = arr.length-1;

        while (left < right)
        {
            int sum = arr[left] + arr[right] + arr[first] + arr[second];
            if (sum == target)
            {
                result.add(Arrays.asList(arr[left],arr[right],arr[first],arr[second]));
                left++;
                right--;
                // minus comparision for left
                // Plus comparision for right
                while (left < right && arr[left] == arr[left+1])
                {
                    left++;
                }
                while (left < right && arr[right] == arr[right-1])
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
