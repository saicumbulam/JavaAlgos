/*
1. next index = 1  and the for loop should start from 1
2.
* */
package Leetcode.Array.Often;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,2};

        int next = 1;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i-1])
            {
                arr[next++] = arr[i];
            }
        }
        System.out.println(next);
    }
}
