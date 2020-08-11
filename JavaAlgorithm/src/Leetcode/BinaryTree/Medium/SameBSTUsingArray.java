package Leetcode.BinaryTree.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SameBSTUsingArray {
    public static void main(String[] args) {
        List<Integer> arr1 = Arrays.asList(10, 15, 8, 12, 94, 81, 5, 2, 11);
        List<Integer> arr2 = Arrays.asList(10, 8, 5, 15, 2, 12, 11, 94, 81);
        System.out.println(Calculate(arr1, arr2));
    }

    private static boolean Calculate(List<Integer> arr1, List<Integer> arr2)
    {
        if (arr1.size() != arr2.size())
        {
            return false;
        }

        if (arr1.size() == 0 && arr2.size() == 0)
        {
            return true;
        }
        if (!arr1.get(0).equals(arr2.get(0)))
        {
            return false;
        }

        List<Integer> leftOne = getSmaller(arr1);
        List<Integer> leftTwo = getSmaller(arr2);
        List<Integer> RightOne = getBigger(arr1);
        List<Integer> RightTwo = getBigger(arr2);

        return Calculate(leftOne,leftTwo) && Calculate(RightOne,RightTwo);
    }

    private static List<Integer> getSmaller(List<Integer> arr)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(0))
            {
                result.add(arr.get(i));
            }
        }
        return result;
    }

    private static List<Integer> getBigger(List<Integer> arr)
    {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) > arr.get(0))
            {
                result.add(arr.get(i));
            }
        }
        return result;
    }
}
