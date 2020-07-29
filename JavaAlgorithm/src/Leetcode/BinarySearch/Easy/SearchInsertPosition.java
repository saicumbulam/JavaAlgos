package Leetcode.BinarySearch.Easy;

public class SearchInsertPosition {
    public static void main(String[] args) {
        int[]arr = {0, 1, 2, 3, 5, 6};
        System.out.println(Calculate(arr, 5));
    }

    private static int Calculate(int[] arr, int num)
    {
        int start = 0;
        int end = arr.length - 1;
        int mid = 0, pos = 0;

        while (start <= end)
        {
            mid = start + (end-start)/2;

            if(arr[mid] == num)
            {
                return mid;
            }

            // if the number is greater than the mid element the pos(position where elemnt inserted)
            // should obvioously be more 1 step away from it.
            // so pos = mid+1; and in below pos = mid
            if(arr[mid] < num)
            {
                start = mid+1;
                pos = mid+1;
            }
            else
            {
                end = mid-1;
                pos = mid;
            }
        }

        return pos;
    }
}
