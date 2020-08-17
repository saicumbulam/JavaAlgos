package Leetcode.Array.Often;

public class ValidMountainArray {
    public static void main(String[] args) {
        int[] nums = {0,3,2,1};
        System.out.println(Calculate(nums));
    }

    private static boolean Calculate(int[] nums)
    {
        int i = 0, n = nums.length;
        while (i < n-1 && nums[i] < nums[i+1])
        {
            i++;
        }
        //Don't forget the i==0 || i == n-1 check
        if (i == 0 || i == n-1)
        {
            return false;
        }

        while (i < n-1 && nums[i] > nums[i+1])
        {
            i++;
        }

        return i == n-1;
    }
}
