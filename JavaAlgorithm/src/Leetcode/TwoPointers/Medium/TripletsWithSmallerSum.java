package Leetcode.Medium;

import java.util.Arrays;

public class TripletsWithSmallerSum {
    public static void main(String[] args) {
        int[] arr = {-1, 0, 2,3};
        int target = 3;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;

        for (int i = 0; i < arr.length-2; i++) {
            count += SearchPair(arr, target-arr[i], i);
        }
        return count;
    }

    private static int SearchPair(int[] arr, int target, int first) {
        int count = 0;
        int left = first+1, right = arr.length-1;
        while (left < right)
        {
            int sum = arr[left] + arr[right] + arr[first];
            if (target > sum)
            {
                count += right-left;
                left++;
            }
            else {
                right--;
            }
        }

        return count;
    }


}
