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


    private static void Calculate(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            int j = i;

            while ( j > 0 && array[j-1] > array[j])
            {
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
                j--;
            }
        }

    }
}
