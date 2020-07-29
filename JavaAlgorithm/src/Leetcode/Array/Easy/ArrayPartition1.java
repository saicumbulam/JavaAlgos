package Leetcode.Array.Easy;

import java.util.Arrays;

public class ArrayPartition1 {
    public static void main(String[] args) {
        int[] arr = {1,4,3,2};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr) {
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i+=2) {
            sum += arr[i];
        }
        return sum;
    }


}
