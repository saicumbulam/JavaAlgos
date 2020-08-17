package Leetcode.Array.Alter;

public class RotateArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        int k = 3;
        Rotater(arr, k);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    private static void Rotater(int[] arr, int k)
    {
        int n = arr.length;
        k = k % n;
        if(k < 0)
        {
            k += n;
        }

        Rotate(arr, 0, n-1);
        Rotate(arr, k, n-1);
        Rotate(arr, 0, k-1);
    }

    private static void Rotate(int[] arr, int start, int end)
    {
        while (start < end)
        {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
