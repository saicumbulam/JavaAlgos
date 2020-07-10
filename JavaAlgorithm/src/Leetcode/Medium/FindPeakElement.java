package Leetcode.Medium;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int start = 0, end = nums.length-1;
        while (start < end) // infinite loop will go if its a <= sign
        {
            int mid = start + (end -start)/2;

            if (nums[mid] > nums[mid+1])
            {
                end = mid;
            }
            else
            {
                start = mid + 1;
            }
        }

        System.out.println(start);
    }
}
