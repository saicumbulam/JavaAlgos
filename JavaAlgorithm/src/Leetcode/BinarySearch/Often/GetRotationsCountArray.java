package Leetcode.BinarySearch.Often;

public class GetRotationsCountArray {
    public static void main(String[] args) {
        int[] arr = new int[]{4,5,6,7,1,2,3};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        // if there is only one element in the array
        if (arr.length == 1)
        {
            return arr[0];
        }


        int left = 0, right = arr.length-1;

        // if the array is already sorted, the left will be smaller than right.
        //  return the left element
        if (arr[right] > arr[left])
        {
            return arr[left];
        }

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (arr[mid-1] > arr[mid])
            {
                return arr[mid];
            }
            if (arr[mid] > arr[mid+1])
            {
                return arr[mid+1];
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
