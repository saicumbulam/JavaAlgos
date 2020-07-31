package Leetcode.Subsets.Easy;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        for (int item: nums
             ) {
            int n = result.size();

            for (int i = 0; i < n; i++) {
                List<Integer> newList = new ArrayList<>(result.get(i));
                newList.add(item);
                result.add(newList);
            }
        }
        System.out.println(result);
    }
}
