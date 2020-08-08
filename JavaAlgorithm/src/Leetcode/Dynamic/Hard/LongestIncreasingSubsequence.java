package Leetcode.Dynamic.Hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        //int[] nums = {4,2,3,6,10,1,12};
        //int[] nums = {5,7,-24,12,10,2,3,12,5,6,35};
        int[] nums = {1,2,3};
        //System.out.println(findLISLength(nums, 0, -1));
        System.out.println(findLISLengthArray(nums, 0, -1,
                new ArrayList<>()));
        //System.out.println(findLISLengthMap(nums, 0, -1, new HashMap<>()));
    }

    private static List<Integer> findLISLengthArray(int[] nums, int currentIdx, int prevIdx,
                                          List<Integer> curr)
    {
        if (currentIdx == nums.length)
        {
            return curr;
        }

        List<Integer> c1 = new ArrayList<>(curr);
        if (prevIdx == -1 || nums[currentIdx] > nums[prevIdx])
        {
            c1.add(nums[currentIdx]);
            c1 = findLISLengthArray(nums, currentIdx+1, currentIdx, c1);
        }

        List<Integer> c2 = findLISLengthArray(nums, currentIdx+1, prevIdx,curr);

        if(c1.size() > c2.size())
        {
            return c1;
        }
        return c2;
    }

    private static int findLISLength(int[] nums, int currentIdx, int prevIdx)
    {
        if (currentIdx >= nums.length)
        {
            return 0;
        }

        int c1 = 0;
        if (prevIdx == -1 || nums[currentIdx] > nums[prevIdx])
        {
            c1 = 1 + findLISLength(nums, currentIdx+1, currentIdx);
        }

        int c2 = findLISLength(nums, currentIdx+1, prevIdx);

        return Math.max(c1, c2);
    }

    private static int findLISLengthMap(int[] nums, int currentIdx, int prevIdx, HashMap<String, Integer> map)
    {
        if (!map.containsKey(currentIdx + "," + prevIdx))
        {
            if (currentIdx >= nums.length)
            {
                map.put(currentIdx + "," + prevIdx, 0);
            }
            else
            {
                int c1 = 0;
                if (prevIdx == -1 || nums[currentIdx] > nums[prevIdx])
                {
                    c1 = 1 + findLISLength(nums, currentIdx+1, currentIdx);
                }

                int c2 = findLISLength(nums, currentIdx+1, prevIdx);

                map.put(currentIdx + "," + prevIdx, Math.max(c1, c2));
            }
        }
        return map.get(currentIdx + "," + prevIdx);
    }
}
