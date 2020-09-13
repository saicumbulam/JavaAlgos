package Leetcode.Sorting.Easy;

public class SelectionSort {
    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        Calculate(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void Calculate(int[] arr)
    {
        for (int i = 0; i < arr.length-1; i++) {
            int minIdx = i;

            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIdx])
                {
                    minIdx = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
}
