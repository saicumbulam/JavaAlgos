package Leetcode.Array.Often;

import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class SmallestDiffrence {
    public static void main(String[] args) {
        int[] arr1 = {-1,5,10,20,28,3};
        int[] arr2 = {26,134,135,15,17};
        int[] result = Calculate(arr1, arr2);
        for (int item: result
             ) {
            System.out.println(item);
        }
    }

    // time: o(nlogn + mlogm), o(1) space
    public static int[] Calculate(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int idxOne = 0;
        int idxTwo = 0;

        int[] smallestPair = new int[2];
        int smallest = Integer.MAX_VALUE;
        int current = Integer.MAX_VALUE;

        while(idxOne < arrayOne.length && idxTwo < arrayTwo.length)
        {
            int firstNum = arrayOne[idxOne];
            int secondNum = arrayTwo[idxTwo];

            if ( firstNum < secondNum)
            {
                current = secondNum - firstNum;
                idxOne++;
            }
            else if ( firstNum > secondNum)
            {
                current = firstNum - secondNum;
                idxTwo++;
            }
            else
            {
                return new int[] {firstNum, secondNum};
            }

            if (current < smallest)
            {
                smallest = current;
                smallestPair = new int[] {firstNum, secondNum};
            }
        }

        return smallestPair;
    }
}
