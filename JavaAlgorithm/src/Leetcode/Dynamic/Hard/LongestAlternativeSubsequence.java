/*
* */

package Leetcode.Dynamic.Hard;

public class LongestAlternativeSubsequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Calculate(nums));
    }

    private static int Calculate(int[] nums)
    {
        return Math.max(findLASLengthRecursive(nums, -1, 0, true),
                findLASLengthRecursive(nums, -1, 0, false));
    }

    private static int findLASLengthRecursive(int[] nums, int previousIndex, int currentIndex, boolean isAsc) {
        if(currentIndex == nums.length)
            return 0;

        int c1=0;
        // if ascending, the next element should be bigger
        if(isAsc) {
            if(previousIndex == -1 || nums[previousIndex] < nums[currentIndex])
                c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
        } else { // if descending, the next element should be smaller
            if(previousIndex == -1 || nums[previousIndex] > nums[currentIndex])
                c1 = 1 + findLASLengthRecursive(nums, currentIndex, currentIndex+1, !isAsc);
        }
        // skip the current element
        int c2 = findLASLengthRecursive(nums, previousIndex, currentIndex+1, isAsc);
        return Math.max(c1,c2);
    }
}
