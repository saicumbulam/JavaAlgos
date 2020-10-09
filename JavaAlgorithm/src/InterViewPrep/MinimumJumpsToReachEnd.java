package InterViewPrep;

public class MinimumJumpsToReachEnd {
    public static void main(String[] args) {
        int[] jumps = {2, 1, 1, 1, 4};
        System.out.println(Calculate(jumps));
    }

    private static int Calculate(int[] jumps)
    {
        int[] dp = new int[jumps.length];

        for (int i = 1; i < jumps.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int start = 0; start < jumps.length-1; start++) {
            for (int end = start+1; end <= start+jumps[start] && end < jumps.length; end++) {
                dp[end] = Math.min(dp[end], dp[start]+1);
            }
        }

        return dp[jumps.length-1];
    }
}
