package Leetcode.Medium;

public class MinimumFeeJumps {
    public static void main(String[] args) {
        int[] fee = {1,2,5,2,1,2};
        System.out.println(Calculate(fee, 0));
    }

    private static int Calculate(int[] fee, int currIndex)
    {
        if (currIndex >= fee.length)
        {
            return 0;
        }

        int step1 = Calculate(fee, currIndex+1);
        int step2 = Calculate(fee, currIndex+2);
        int step3 = Calculate(fee, currIndex+3);

        int min = Math.min(step1, Math.min(step2, step3));
        return min + fee[currIndex];
    }
}
