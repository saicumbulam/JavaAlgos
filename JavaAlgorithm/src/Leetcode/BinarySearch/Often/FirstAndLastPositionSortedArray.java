/*
Find the range of a number
This is normal binary with an extra keyIndex finding

* */
package Leetcode.BinarySearch.Often;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FirstAndLastPositionSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(Calculate(nums, target));
    }

    private static List<Integer> Calculate(int[] nums, int target)
    {
        List<Integer> list = new ArrayList<>(Arrays.asList(-1, -1));
        list.set(0, Finder(nums, target, true));
        if (list.get(0) != -1)
        {
            list.set(1, Finder(nums, target, false));
        }
        return list;
    }

    private static int Finder(int[] nums, int target, boolean isFirst)
    {
        int left = 0, right = nums.length-1;
        int keyIndex = -1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (nums[mid] > target)
            {
                right = mid - 1;
            }
            else if (nums[mid] < target)
            {
                left = mid+1;
            }
            else
            {
                keyIndex = mid;
                if (isFirst)
                {
                    left = mid+1;
                }
                else
                {
                    right=mid-1;
                }
            }
        }
        return keyIndex;
    }
}
