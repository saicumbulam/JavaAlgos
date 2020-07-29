package Leetcode.Array.Easy;

import java.util.Arrays;

public class RearrangeSortedMinMax {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        arr = Calculate(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static int[] Calculate(int[] arr)
    {
        int left = 0, right = arr.length-1;
        int[] result = new int[arr.length];
        int index = 0;

        while(left < right)
        {
            result[index++] = arr[right];
            result[index++] = arr[left];

            left++;
            right--;
        }
        result[index++] = arr[left];
        return result;
    }
}
