/*
1. but backward loop and arr[i+1] = arr[i]
* */
package Leetcode.Array.Easy;

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

        for (int i = arr.length-1; i > 0 ; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = lastElement;
    }
}
