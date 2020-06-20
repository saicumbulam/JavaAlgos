package Leetcode.Medium;

public class SearchRotatedSortedArray {


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 2;
        System.out.println(Calculate(nums, target));
    }

    private static int Calculate(int[] nums, int target)
    {
        int left = 0, right = nums.length-1;

        while (left <= right)
        {
            int mid = left + (right - left)/2;

            if (nums[mid] == target)
            {
                return mid;
            }

            if (nums[left] <= nums[mid]) // ascending part
            {
                //always first is the >=
                // mid doesnt contain equal to signs.
                if (target >= nums[left] && target < nums[mid])
                {
                    right = mid-1;
                }
                else
                {
                    left = mid+1;
                }
            }
            else
            {
                if (target > nums[mid] && target <= nums[right])
                {
                    left = mid+1;
                }
                else
                {
                    right = mid-1;
                }
            }
        }

        return -1;
    }
}
