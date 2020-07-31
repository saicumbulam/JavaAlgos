package Leetcode.Subsets.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindSubsetsWithoutDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        System.out.println(Calculate(nums));
    }

    private static List<List<Integer>> Calculate(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());

        int startIndex = 0, endIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            startIndex = 0;

            if (i > 0 && nums[i] == nums[i - 1]) {
                startIndex = endIndex + 1;
            }
            endIndex = result.size() - 1;

            for (int k = startIndex; k <= endIndex; k++) {
                List<Integer> list = new ArrayList<>(result.get(k));
                list.add(nums[i]);
                result.add(list);
            }
        }

        return result;
    }
}
