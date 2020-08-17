package Leetcode.BinarySearch.Alter;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {-100,0,0,1,4,4,5,5,95,200};
        System.out.println(Calculate(arr, 0));
    }

    private static int Calculate(int[] arr, int target)
    {
        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;

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

        return -1;
    }
}
