package InterViewPrep;

public class MaximumSumSubarray {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 1, 3, 2};
        int k=3;
        System.out.println(Calculate(arr, k));
    }

    private static int Calculate(int[] arr, int k)
    {
        int curSum = 0, maxSum = 0, windowStart = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            curSum += arr[windowEnd];

            if (windowEnd >= k-1)
            {
                if (curSum > maxSum)
                {
                    maxSum = curSum;
                }
                curSum -= arr[windowStart++];
            }
        }

        return maxSum;
    }
}
