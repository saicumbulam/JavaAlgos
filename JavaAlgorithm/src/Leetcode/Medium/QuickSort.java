package Leetcode.Medium;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,2,5,4,7,8,9,2};
        Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr)
    {
        quickSortRec(arr, 0, arr.length-1);
    }

    private static void quickSortRec(int[] arr, int low, int high)
    {
        if (high > low) {
            int pivot_index = Finder(arr, low, high);
            quickSortRec(arr, low, pivot_index - 1);
            quickSortRec(arr, pivot_index + 1, high);

        }
    }

    private static int Finder(int[] arr, int low, int high)
    {
        int pivot = arr[low];
        int i = low;
        int j = high;

        while (i < j)
        {
            while (i <= high && arr[i] <= pivot)
            {
                i++;
            }
            while (arr[j] > pivot)
            {
                j--;
            }

            if (i < j)
            {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        arr[low] = arr[j];
        arr[j] = pivot;

        return j;
    }
}
