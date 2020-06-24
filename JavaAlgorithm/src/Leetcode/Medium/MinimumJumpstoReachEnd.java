package Leetcode.Medium;

public class MinimumJumpstoReachEnd {
    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        int[] dp = new int[jumps.length];   // only array cache is working.
        // The hashMap is not working. Need to research the reason
        System.out.println(countMinJumps(jumps,0, dp));
    }

    private static int countMinJumps(int[] jumps, int currentIdx, int[] dp) {
        if (currentIdx == jumps.length-1) // this is more important or we will get maximum value
        {
            return 0;
        }

        if (jumps[currentIdx] == 0)
        {
            return Integer.MAX_VALUE;
        }

        if (dp[currentIdx] == 0)
        {
            int totalJumps = Integer.MAX_VALUE;
            int startIdx = currentIdx+1;
            int endIndex = currentIdx + jumps[currentIdx];

            while (startIdx < jumps.length && startIdx <= endIndex)
            {
                int minJumps = countMinJumps(jumps, startIdx++, dp);
                if (minJumps != Integer.MAX_VALUE)
                {
                    totalJumps = Math.min(totalJumps, minJumps+1);
                }
            }

            dp[currentIdx] = totalJumps;
        }

        return dp[currentIdx];
    }
}
