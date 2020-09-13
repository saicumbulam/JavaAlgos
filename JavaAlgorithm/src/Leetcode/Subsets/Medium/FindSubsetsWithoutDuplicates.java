package Leetcode.Subsets.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindSubsetsWithoutDuplicates {
    public static void main(String[] args) {
        int[] nums = {1, 3, 3};
        System.out.println(Calculate(nums));
    }

    private static List<List<Integer>> Calculate(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<>());

        int startIdx = 0, endIdx=0;
        for (int i = 0; i < nums.length; i++
             ) {
            startIdx = 0;

            if(i > 0 && nums[i] == nums[i-1])
            {
                startIdx = endIdx;
            }
            endIdx = lists.size();
            for (int j = startIdx; j < endIdx ; j++) {
                List<Integer> oldList = new ArrayList<>(lists.get(j));
                oldList.add(nums[i]);
                lists.add(oldList);
            }
        }

        return lists;
    }
}
