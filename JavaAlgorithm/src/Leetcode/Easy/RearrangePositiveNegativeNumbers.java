package Leetcode.Easy;

import java.util.Arrays;

public class RearrangePositiveNegativeNumbers {
    public static void main(String[] args) {
        int[] arr = {10, -1, 20, 4,5,-9,-6};
        Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr)
    {
        int index = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
            {
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
                index++;
            }
        }
    }
}
