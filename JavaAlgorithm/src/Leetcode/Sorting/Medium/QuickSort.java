package Leetcode.Sorting.Medium;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {1,5,2};
        Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr)
    {
        quickSortRec(arr, 0, arr.length-1);
    }

    private static void quickSortRec(int[] arr, int low, int high)
    {
        if(high > low)
        {
            int pivotIndex = Finder(arr, low, high);
            quickSortRec(arr, low, pivotIndex-1);
            quickSortRec(arr, pivotIndex+1, high);
        }
    }

    private static int Finder(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1);
        int j = 0;
        for (j = low; j <= high ; j++) {
            if (arr[j] < pivot)
            {
                i++;

                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }
        }

        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
