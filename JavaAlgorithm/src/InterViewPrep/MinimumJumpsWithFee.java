package InterViewPrep;

public class MinimumJumpsWithFee {
    public static void main(String[] args) {
        //int[] fee = {1,2,5,2,1,2};
        int[] fee = {2,3,4,5};
        System.out.println(Calculate(fee));
    }

    private static int Calculate(int[] fee)
    {
        int[] dp = new int[fee.length+1];

        dp[0] = 0;
        dp[1] = fee[0];
        dp[2] = dp[3] = fee[0];

        for (int i = 4; i <= fee.length ; i++) {
            dp[i] = Math.min(dp[i-1]+fee[i-1],
                    Math.min(dp[i-2]+fee[i-2],
                            dp[i-3]+fee[i-3]));
        }

        return dp[fee.length];
    }
}
