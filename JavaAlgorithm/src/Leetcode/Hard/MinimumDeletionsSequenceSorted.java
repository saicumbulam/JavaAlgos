package Leetcode.Hard;

public class MinimumDeletionsSequenceSorted {
    public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(nums.length - findLISLength(nums, 0, -1));
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

}
