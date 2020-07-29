/*
problem:
Insert sort the array

Time complexity : O(N^2)
space complexity is o(1)

pseudocode:
Loop from i = 1 to n-1.
a) Pick element arr[i] and insert it into sorted sequence arr[0…i-1]
--> j = i-1. j >= 0 && a[j] > ele,
*/
package Leetcode.Sorting.Easy;

public class InsertionSort {
    public static void main(String[] args) {
        int arr[] = {5,4,1,0,5,95,4,-100,200,0};
        Calculate(arr);

        for (int item: arr
             ) {
            System.out.println(item);
        }
    }


    private static void Calculate(int[] arr)
    {
        for (int i = 1; i < arr.length; i++) {
            int ele = arr[i];
            int j = i-1;

            while (j >= 0 && arr[j] > ele)
            {
                arr[j+1] = arr[j];
                j = j-1;
            }

            arr[j+1] = ele;
        }
    }
}
