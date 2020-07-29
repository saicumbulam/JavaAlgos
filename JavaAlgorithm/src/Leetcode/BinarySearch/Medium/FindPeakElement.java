/*
1. This is a modified binary search.
2. comparison of num[mid]  and target is replaced by num[mid] and num[mid+1]
3. id num[mid] > num[mid+1] => end = mid else start = mid+1
* */
package Leetcode.BinarySearch.Medium;

public class FindPeakElement {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};

        int start = 0, end = nums.length-1;
        while (start < end) // infinite loop will go if its a <= sign
        {
            int mid = start + (end -start)/2;

            // The mid shld be greater than mid+1
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
