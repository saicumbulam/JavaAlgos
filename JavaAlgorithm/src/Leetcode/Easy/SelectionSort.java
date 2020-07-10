package Leetcode.Easy;

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
        int minIdx = 0;

        for (int i = 0; i < arr.length; i++) {
            minIdx = FindMin(arr,i, arr.length-1);

            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }

    private static int FindMin(int[] arr, int start, int end)
    {
        if (end <= 0 || start < 0)
            return 0;

        int minInd = start;
        for (int i = start + 1; i <= end; i++) {
            if (arr[minInd] > arr[i])
                minInd = i;
        }
        return minInd;
    }
}
