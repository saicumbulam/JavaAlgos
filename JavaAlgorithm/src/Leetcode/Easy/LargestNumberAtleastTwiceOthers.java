package Leetcode.String.Easy.Easy;

public class LargestNumberAtleastTwiceOthers {
    public static void main(String[] args) {
        int[] arr = {3,6,1,0};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int maxValue = Integer.MIN_VALUE;
        int maxIdx = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue)
            {
                maxValue = arr[i];
                maxIdx = i;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (i != maxIdx && maxValue < 2 * arr[i])
            {
                return -1;
            }
        }

        return maxIdx;
    }
}
