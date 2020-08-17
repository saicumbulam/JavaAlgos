package Leetcode.BinarySearch.Often;

public class MinimumDiffElement {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,6,7};
        int target = 5;
        System.out.println(Calculate(arr, target));
    }

    private static int Calculate(int[] arr, int target)
    {
        int left = 0, right = arr.length-1;
        int mid = 0;
        while (left <= right)
        {
            mid = left + (right - left)/2;

            if (arr[mid] == target)
            {
                return mid;
            }

            if (target > arr[mid])
            {
                left = mid+1;
            }
            else
            {
                right = mid-1;
            }
        }

        // if mid is not captured, return the element
        // that is closest to 2 pointer left and right
        // notice the subtraction below, it means left > right after
        // the while loops comes out
        if ((arr[left] - target) < (target - arr[right]))
        {
            return arr[left];
        }
        return arr[right];
    }
}
