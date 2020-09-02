package InterViewPrep;

public class MinimumJumpsReachEnd {
    public static void main(String[] args) {
        int[] arr = {2,1,1,1,4};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        int[] dp = new int[arr.length];

        for (int i = 1; i < arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        for (int start = 0; start < arr.length-1; start++) {
            for (int end = start+1; end <= start + arr[start+1] && end < arr.length; end++) {
                dp[end] = Math.min(dp[end], dp[start]+1); // add the previous start results
            }
        }
        return dp[arr.length-1];
    }
}
