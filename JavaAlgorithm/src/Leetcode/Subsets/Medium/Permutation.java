package Leetcode.Subsets.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Permutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(Calculate(arr));
    }
    
    private static List<List<Integer>> Calculate(int[] arr)
    {
        List<List<Integer>> result = new ArrayList<>();
        Queue<List<Integer>> queue = new LinkedList<>();
        queue.add(new ArrayList<>());

        for (int num: arr
             ) {
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                List<Integer> oldPermutation = queue.poll();

                for (int j = 0; j <= oldPermutation.size() ; j++) {
                    List<Integer> newPermutation = new ArrayList<>(oldPermutation);
                    newPermutation.add(j, num);
                    if(newPermutation.size() == arr.length)
                    {
                        result.add(newPermutation);
                    }
                    else
                    {
                        queue.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }
}
