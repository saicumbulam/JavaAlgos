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
        if (low < high)
        {
            int mid = low + (high - low)/2;
            Calculate(arr, low, mid);
            Calculate(arr, mid+1, high);
            Merge(arr, low, mid, high);
        }
    }

    private static void Merge(int[] arr, int left, int mid, int right)
    {
        //mid - left + 1
        int[] leftArray = new int[mid-left+1];
        //right - mid
        int[] rightArray = new int[right - mid];

        for (int i = 0; i < leftArray.length; i++) {
            leftArray[i] = arr[left+i];
        }

        for (int i = 0; i < rightArray.length; i++) {
            rightArray[i] = arr[mid+1+i];
        }

        int k = left;    // this is important. start filling from lowest
        int i = 0, j = 0;

        while (i < leftArray.length && j < rightArray.length)
        {
            if (leftArray[i] < rightArray[j])
            {
                arr[k++] = leftArray[i++];
            }
            else
            {
                arr[k++] = rightArray[j++];
            }
        }

        while (i < leftArray.length) arr[k++] = leftArray[i++];

        while (i < rightArray.length) arr[k++] = rightArray[j++];

    }
}
