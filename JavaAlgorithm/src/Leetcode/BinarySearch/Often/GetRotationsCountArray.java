package Leetcode.BinarySearch.Often;

public class GetRotationsCountArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,1,2,3};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int left = 0, right = arr.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (arr[mid] > arr[mid+1])
            {
                return mid+1;
            }
            if (arr[mid-1] > arr[mid])
            {
                return mid;
            }

            if (arr[left] < arr[mid])
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
