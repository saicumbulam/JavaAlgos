package Leetcode.Dynamic.Often;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(findLISLengthArray(nums, 0, -1,
                new ArrayList<>()));
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);
        int maxLength = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j])
                {
                    dp[i] = dp[j] + 1;
                }
            }
            maxLength = Math.max(maxLength, dp[i]);
        }
        return maxLength;
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
