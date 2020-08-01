package Leetcode.Sorting.Easy;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        Calculate(arr, 0, arr.length-1);

        for (int item : arr) {
            System.out.println(item);
        }
    }

    private static void Calculate(int[] arr, int low, int high)
    {
        if (low < 0 || high < 0)
        {
            return;
        }

        if (high > low)
        {
            int mid = low + (high - low)/2;
            // mid and mid+1. right > left
            Calculate(arr, low, mid);
            Calculate(arr, mid+1, high);
            Merge(arr, low, mid, high);
        }
    }

    private static void Merge(int[] arr, int left, int mid, int right)
    {
        // mid-left+1 and right-mid
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        int[] leftArray = new int[sizeLeft];
        int[] rightArray = new int[sizeRight];

        // left+i
        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = arr[left+i];
        }

        // mid+i+1
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = arr[mid+1+i];
        }

        int i =0, j=0, k=left;

        while (i < sizeLeft && j < sizeRight)
        {
            if(leftArray[i] <= rightArray[j])
            {
                arr[k++] = leftArray[i++];
            }
            else
            {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < sizeLeft)
        {
            arr[k++] = leftArray[i++];
        }

        while (j < sizeRight)
        {
            arr[k++] = rightArray[j++];
        }
    }
}
