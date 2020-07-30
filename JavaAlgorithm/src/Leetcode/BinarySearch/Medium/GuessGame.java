package Leetcode.BinarySearch.Medium;

public class GuessGame {
    private static int GuessNumber(int[] arr)
    {
        int left = 0, right = arr.length-1;
        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (Res(arr[mid]) == 0)
            {
                return mid;
            }

            if (Res(arr[mid]) > 0)
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

    private static int Res(int n)
    {
        return 0;
    }
}
