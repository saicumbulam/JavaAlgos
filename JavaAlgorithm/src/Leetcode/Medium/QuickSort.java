package Leetcode.Medium;

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
        if (high > low) {
            int pivot_index = Finder(arr, low, high);
            quickSortRec(arr, low, pivot_index - 1);
            quickSortRec(arr, pivot_index + 1, high);

        }
    }

    private static int Finder(int[] arr, int low, int high)
    {
        int pivot = arr[high];
        int i = (low-1); // index of smaller element
        for (int j=low; j<high; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;

                // swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // swap arr[i+1] and arr[high] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;

        return i+1;
    }
}
