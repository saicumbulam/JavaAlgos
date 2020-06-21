package Leetcode.Hard;

import java.util.HashMap;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(findLISLength(nums, 0, -1));
        System.out.println(findLISLengthMap(nums, 0, -1, new HashMap<>()));
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
