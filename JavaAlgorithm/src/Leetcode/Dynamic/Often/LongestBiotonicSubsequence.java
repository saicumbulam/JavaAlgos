package Leetcode.Dynamic.Often;

public class LongestBiotonicSubsequence {
    public static void main(String[] args) {
        int[] nums = {4,2,3,6,10,1,12};
        System.out.println(findLBSLength(nums));
    }

    private static int findLBSLength(int[] nums) {
        int maxLength = 0;
        for(int i=0; i<nums.length; i++) {
            int c1 = findLDSLength(nums, i, -1);
            int c2 = findLDSLengthRev(nums, i, -1);
            System.out.println(c1 + ","+ c2);   // use the c1 and c2 to get the array
            maxLength = Math.max(maxLength, c1+c2-1);
        }
        return maxLength;
    }

    // find the longest decreasing subsequence from currentIndex till the end of the array
    private static int findLDSLength(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex == nums.length)
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + findLDSLength(nums, currentIndex+1, currentIndex);

        // excluding the number at currentIndex
        int c2 = findLDSLength(nums, currentIndex+1, previousIndex);

        return Math.max(c1, c2);
    }

    // find the longest decreasing subsequence from currentIndex till the beginning of the array
    private static int findLDSLengthRev(int[] nums, int currentIndex, int previousIndex) {
        if(currentIndex < 0) // see this change
            return 0;

        // include nums[currentIndex] if it is smaller than the previous number
        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] < nums[previousIndex])
            c1 = 1 + findLDSLengthRev(nums, currentIndex-1, currentIndex); // see this change

        // excluding the number at currentIndex
        int c2 = findLDSLengthRev(nums, currentIndex-1, previousIndex);

        return Math.max(c1, c2);
    }
}
