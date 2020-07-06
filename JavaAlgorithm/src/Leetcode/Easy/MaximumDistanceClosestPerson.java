package Leetcode.Easy;

import java.util.Arrays;

public class MaximumDistanceClosestPerson {
    public static void main(String[] args) {
        int[] arr = {1,0,0,0,1,0,1};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int[] left = new int[arr.length];
        int[] right = new int[arr.length];
        Arrays.fill(left, arr.length);
        Arrays.fill(right, arr.length);

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1)
            {
                left[i] = 0;
            }
            else if (i > 0)
            {
                left[i] = left[i-1] + 1;
            }
        }

        for (int i = arr.length-1; i >= 0; i--) {
            if (arr[i] == 1)
            {
                right[i] = 0;
            }
            else if (i < arr.length-1)
            {
                right[i] = right[i+1] + 1;
            }
        }

        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0)
            {
                ans = Math.max(ans, Math.min(left[i], right[i]));
            }
        }

        return ans;
    }
}
