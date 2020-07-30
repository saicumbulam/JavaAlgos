package Leetcode.Hash.Easy;

import java.util.*;

public class FindSymmetricArray {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {3,4}, {5,9}, {4,3}, {9,5}};
        System.out.println(Calculate(arr));
    }

    private static List<List<Integer>> Calculate(int[][] arr)
    {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int first = arr[i][0];
            int second = arr[i][1];

            if (map.containsKey(first) && map.get(first) == second)
            {
                result.add(Arrays.asList(first, second));
            }
            else
            {
                map.put(second, first);
            }
        }
        return result;
    }
}
