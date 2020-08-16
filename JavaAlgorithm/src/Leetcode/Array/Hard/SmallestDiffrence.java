package Leetcode.Array.Hard;

import java.util.Arrays;

public class SmallestDiffrence {
    public static void main(String[] args) {
        int[] arr1 = {-1,5,10,20,28,3};
        int[] arr2 = {26,134,135,15,17};
        int[] result = smallestDifference(arr1, arr2);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int i1 = 0, i2 = 0, smallest = Integer.MAX_VALUE;
        int[] result = new int[2];

        while (i1 < arrayOne.length &&
                i2 < arrayTwo.length )
        {
            int sum = Math.abs(arrayOne[i1] - arrayTwo[i2]);
            if (sum == 0)
            {
                return new int[]{arrayOne[i1],arrayTwo[i2]};
            }
            if (smallest > sum)
            {
                smallest = sum;
                result[0] = arrayOne[i1];
                result[1] = arrayTwo[i2];
            }
            if (arrayOne[i1] < arrayTwo[i2])
            {
                i1++;
            }
            else if (arrayOne[i1] > arrayTwo[i2])
            {
                i2++;
            }
        }
        return result;
    }

}
