package Leetcode.BinarySearch.Often;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[]arr = {0, 1, 2, 3, 5, 6};
        System.out.println(Calculate(arr, 5));
    }

    private static int Calculate(int[] arr, int num)
    {
        int left = 0, right = arr.length-1, pos = 0;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (arr[mid] > num)
            {
                right = mid-1;
                pos = mid;
            }
            else
            {
                left = mid+1;
                pos = mid+1;
            }
        }
        return pos;
    }
}
