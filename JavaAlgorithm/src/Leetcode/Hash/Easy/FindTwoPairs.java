package Leetcode.Hash.Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class FindTwoPairs {
    public static void main(String[] args) {
        int[] arr = {3,4,7,1,12,9};
        System.out.println(Calculate(arr));
    }

    private static List<Integer> Calculate(int[] arr)
    {
        List<Integer> result = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];

                if (!map.containsKey(sum))
                {
                    map.put(sum, Arrays.asList(arr[i],arr[j]));
                }
                else
                {
                    result.addAll(map.get(sum));
                    result.addAll(Arrays.asList(arr[i],arr[j]));
                    return result;
                }
            }
        }
        return  null;
    }
}
