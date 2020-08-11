
package Leetcode.Dynamic.Medium;

public class IncreasingTripletSequence {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(Calculate(nums));
    }

    private static boolean Calculate(int[] nums)
    {
        return Finder(nums, -1, 0) >= 3;
    }

    private static int Finder(int[] nums, int previousIndex, int currentIndex)
    {
        if(currentIndex >= nums.length)
        {
            return 0;
        }

        int c1 = 0;
        if(previousIndex == -1 || nums[currentIndex] >= nums[previousIndex])
        {
            c1 = 1 + Finder(nums, currentIndex, currentIndex+1);
        }

        int c2 = Finder(nums, previousIndex, currentIndex+1);

        return Math.max(c1, c2);
    }
}
