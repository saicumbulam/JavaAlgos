package Leetcode.Easy;

import java.util.Arrays;

public class RearrangeSortedMinMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr)
    {
        int maxIdx = arr.length-1;
        int minIdx = 0;
        int maxElement = arr[maxIdx] + 1;

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0)
            {
                arr[i] += (arr[maxIdx] % maxElement) * maxElement;
                maxIdx--;
            }
            else
            {
                arr[i] += (arr[minIdx] % maxElement) * maxElement;
                minIdx++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i]/maxElement;
        }
    }
}
