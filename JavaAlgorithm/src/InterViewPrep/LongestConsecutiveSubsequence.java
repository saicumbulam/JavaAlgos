package InterViewPrep;

import java.util.HashMap;
import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(Calculate(new int[]{100,4,200,1,3,2}));
    }

    private static int Calculate(int[] nums)
    {
        HashSet<Integer> set = new HashSet<>();

        for (int item: nums
             ) {
            set.add(item);
        }

        int maxLength = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i]) && !set.contains(nums[i]-1))
            {
                int j = nums[i];
                int count = 0;
                while (set.contains(j))
                {
                    count++;
                    j++;
                }
                maxLength = Math.max(maxLength, count);
            }
        }

        return maxLength;
    }
}
