package Leetcode.Sorting.Easy;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {5,4,3,2};
        Calculate(arr);

        for (int item: arr
             ) {
            System.out.println(item);
        }
    }

    private static void Calculate(int[] arr)
    {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i] < arr[j])
                {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
}
