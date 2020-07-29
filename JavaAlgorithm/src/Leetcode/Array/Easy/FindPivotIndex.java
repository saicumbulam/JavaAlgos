package Leetcode.String.Easy.Easy;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] arr = {1,7,3,6,5,6};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int sum = 0, leftSum = 0;

        for(int num: arr)
        {
            sum += num;
        }

        for (int i = 0; i < arr.length; i++) {
            if (leftSum == sum - leftSum - arr[i])
            {
                return i;
            }
            leftSum += arr[i];
        }

        return -1;
    }
}
