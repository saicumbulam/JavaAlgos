package InterViewPrep;

import java.util.HashSet;

public class LongestConsecutiveSubsequence {
    public static void main(String[] args) {
        System.out.println(Calculate(new int[]{100,4,200,1,3,2}));
    }

    private static int Calculate(int[] nums)
    {
        if(nums.length == 1)
        {
            return nums.length;
        }

        int ans = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++)
        {
            set.add(nums[i]);
        }

        for (int i = 0; i < nums.length; i++)
        {
            if(!set.add(nums[i]-1))
            {
                int j = nums[i];

                while(set.contains(j))
                {
                    j++;
                }

                ans = Math.max(ans, (j - nums[i]+1));
            }
        }

        return ans;

    }
}
