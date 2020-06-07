package Leetcode.Easy;

import java.util.Arrays;

public class ReplaceElementsGreatestElementRightSide {
    public static void main(String[] args) {
        int[] arr = {17,18,5,4,6,1};
        int[] result = new int[arr.length];

        result[arr.length-1] = -1;

        for (int i = arr.length-2; i >= 0 ; i--) {
            result[i] = Math.max(arr[i+1], result[i+1]);
        }

        Arrays.stream(result).forEach(System.out::println);
    }
}
