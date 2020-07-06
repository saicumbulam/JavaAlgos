package Leetcode.Easy;

import java.util.Arrays;

public class RotateArrayOneIndex {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr)
    {
        int lastElement = arr[arr.length-1];

        for (int i = arr.length-2; i >=0 ; i--) {
            arr[i+1] = arr[i];
        }
        arr[0] = lastElement;
    }
}
