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

        while (left <= right)
        {
            int mid = left + (right - left)/2;
            if (arr[mid] == target) return arr[mid];

            if (arr[mid] > target)
            {
                right = mid - 1;
            }
            else
            {
                left = mid+1;
            }
        }

        if((arr[left] - target) < (target - arr[right])) return arr[left];

        return arr[right];
    }
}
