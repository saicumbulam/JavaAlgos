package Leetcode.BinaryTree.Often;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTUsingArray {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
        List<Integer> arr2 = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
        System.out.println(Calculate(arr1, arr2, 0,0,
                Integer.MIN_VALUE,
                Integer.MAX_VALUE));
    }

    private static boolean Calculate(List<Integer> arr1, List<Integer> arr2,
                                     int arrayIdx1, int arrayIdx2,
                                     int minValue, int maxValue)
    {
        if (arrayIdx1 == -1 || arrayIdx2 == -1)
        {
            return arrayIdx1 == arrayIdx2;
        }

        if (arr1.get(arrayIdx1) != arr2.get(arrayIdx2))
        {
            return false;
        }

        int leftRootIndex1 = GetIdxFirstSmaller(arr1, arrayIdx1, minValue);
        int leftRootIndex2 = GetIdxFirstSmaller(arr2, arrayIdx2, minValue);
        int rightRootIndex1 = GetIdxFirstBigger(arr1, arrayIdx1, maxValue);
        int rightRootIndex2 = GetIdxFirstBigger(arr2, arrayIdx2, maxValue);

        int curr = arr1.get(arrayIdx1);
        boolean leftAreSame = Calculate(arr1, arr2,
                leftRootIndex1, leftRootIndex2, minValue, curr);
        boolean rightAreSame = Calculate(arr1, arr2,
                rightRootIndex1, rightRootIndex2, curr, maxValue);
        return leftAreSame && rightAreSame;
    }

    private static int GetIdxFirstSmaller(List<Integer> array, int startIdx, int minValue) {
        for (int i = startIdx+1; i < array.size(); i++) {
            if(array.get(i) < array.get(startIdx) && array.get(i) >= minValue)
            {
                return i;
            }
        }
        return -1;
    }

    private static int GetIdxFirstBigger(List<Integer> array, int startIdx, int maxValue) {
        for (int i = startIdx+1; i < array.size(); i++) {
            if(array.get(i) >= array.get(startIdx) && array.get(i) < maxValue)
            {
                return i;
            }
        }
        return -1;
    }
}
