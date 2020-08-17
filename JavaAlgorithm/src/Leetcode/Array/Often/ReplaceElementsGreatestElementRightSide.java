/*
Input: arr = [17,18,5,4,6,1]
Output: [18,6,6,6,1,-1]
* */
package Leetcode.Array.Often;

import java.util.Arrays;

public class ReplaceElementsGreatestElementRightSide {
    public static void main(String[] args) {
        int[] arr = new int[] {17,18,5,4,6,1};
        Calculate(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void Calculate(int[] arr) {
        int maxItem = arr[arr.length-1];
        arr[arr.length-1] = -1;

        for(int i = arr.length-2; i >= 0; i--)
        {
            int temp = arr[i];
            arr[i] = maxItem;

            maxItem = Math.max(temp, maxItem);
        }

    }
}
