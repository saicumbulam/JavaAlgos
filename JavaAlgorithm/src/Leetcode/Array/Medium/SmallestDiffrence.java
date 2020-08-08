package Leetcode.Array.Medium;

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
        int x = 0, y = 0, smallest = Integer.MAX_VALUE;
        int smallx = 0, smally=0;

        while (x < arrayOne.length &&
                y < arrayTwo.length )
        {
            int sum = Math.abs(arrayOne[x] - arrayTwo[y]);
            if (smallest > sum)
            {
                smallest = sum;
                smallx = arrayOne[x];
                smally= arrayTwo[y];
            }
            if (arrayOne[x] < arrayTwo[y])
            {
                x++;
            }
            else if (arrayOne[x] > arrayTwo[y])
            {
                y++;
            }
            else
            {
                return new int[]{arrayOne[x],arrayTwo[y]};
            }
        }
        return new int[] {smallx, smally};
    }

}
