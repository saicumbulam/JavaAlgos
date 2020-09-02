package InterViewPrep;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int[] Weights = { 1, 2, 3 };
        int[] Profits = { 15, 20, 50 };
        int capacity = 5;
        System.out.println(Calculate(Weights, Profits, capacity));
    }

    private static int Calculate(int[] weights , int[] profits, int capacity)
    {
        int[][] dp = new int[weights.length][capacity+1];

        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }


        for (int i = 0; i < weights.length; i++) {
            for (int s = 1; s <= capacity ; s++) {
                int profit1 = 0;
                if (i > 0) {
                    profit1 = dp[i - 1][s];
                }
                int profit2 = 0;
                if(weights[i] <= s)
                {
                    profit2 = profits[i] + dp[i][s - weights[i]];
                }

                dp[i][s] = Math.max(profit1, profit2);
            }
        }

        return dp[weights.length-1][capacity];
    }
}
