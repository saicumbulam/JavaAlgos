/*
1. Modified binary search algo
2. Caculate the mid of the start and end of array.
3. calculate missing elements: nums[mid] - nums[0] - mid
4. if (missing >= k) => end = mid - 1 else start = mid + 1
5.  calculate missing element  again at the end using nums[end] - nums[0]-1
6. get the missing element using nums[end] + k - missing
* */
package Leetcode.Medium;

public class MissingElementSortedArray {
    public static void main(String[] args) {
        System.out.println(Calculate(new int[]{4,7, 9,10}, 1));
    }

    public static int Calculate(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;

            int missing = nums[mid] - nums[0] - mid;

            if(missing >= k){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        int missing = nums[end] - nums[0] - end;
        return nums[end] + k - missing;
    }
}
