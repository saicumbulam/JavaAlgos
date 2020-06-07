package Leetcode.Medium;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int left = 0, right = arr.length-1;
        int leftMax= 0, rightMax = 0;
        int ans = 0;

        while (left < right)
        {
            if (arr[left] < arr[right])
            {
                if (arr[left] > leftMax)
                {
                    leftMax = arr[left];
                }
                else
                {
                    ans += leftMax - arr[left];
                }
                left++;  //dont leave this
            }
            else
            {
                if (arr[right] > rightMax)
                {
                    rightMax = arr[right];
                }
                else
                {
                    ans += rightMax - arr[right];
                }

                right--;
            }
        }

        return ans;
    }
}
