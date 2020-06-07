package Leetcode.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThressSumClosest {
    public static void main(String[] args) {
        int[] arr = {-1,2,1,-4};
        int target = 1;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target)
    {
        Integer smallest = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length-2; i++) {
            int left = i + 1, right = arr.length-1;
            while (left < right) {
                int targetDiff = target - (arr[left] + arr[right] + arr[i]) ;
                if (targetDiff == 0) {
                    return target - targetDiff;
                }

                if(Math.abs(targetDiff) < Math.abs(smallest) ||
                        ((Math.abs(targetDiff) == Math.abs(smallest)) && targetDiff > smallest))
                {
                    smallest = targetDiff;
                }

                if (targetDiff > 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return target - smallest; //lpok out for this
    }
}
