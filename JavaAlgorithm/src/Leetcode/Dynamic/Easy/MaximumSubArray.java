package Leetcode.Dynamic.Easy;

public class MaximumSubArray {
    public static void main(String[] args) {
        int[] arr = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(Calculate(arr));
    }

    public static int Calculate(int[] arr)
    {
        int curSum = arr[0];
        int maxSum = arr[0];

        // it should be iterated from 1
        for (int i = 1; i < arr.length; i++) {
            curSum = Math.max(arr[i], curSum+arr[i]);
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
