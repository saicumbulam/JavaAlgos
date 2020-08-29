package InterViewPrep;

public class SmallestSubarraySizeK {
    public static void main(String[] args) {
        int[] arr = {2, 1, 5, 2, 3, 2};
        int s=7;
        System.out.println(Calculate(arr, s));
    }

    private static int Calculate(int[] arr, int s)
    {
        int windowStart = 0, minLength = Integer.MAX_VALUE, curSum = 0;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            curSum += arr[windowEnd];

            // while loop to get the minimum window of the selection
            while (curSum >= s)
            {
                minLength = Math.min(minLength, (windowEnd-windowStart+1));
                curSum -= arr[windowStart++];
            }
        }
        return minLength;
    }
}
