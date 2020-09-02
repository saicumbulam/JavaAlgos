package InterViewPrep;

public class KnapSack {
    public static void main(String[] args) {
        String[] arr = {"Apple", "Orange", "Banana", "Melon" };
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int capacity = 7;

        System.out.println(Calculate(weights, profits, capacity));
    }

    private static int Calculate(int[] weights, int[] profits, int capacity)
    {
        int[][] dp = new int[weights.length][capacity+1];

        for (int i = 0; i < weights.length; i++) {
            dp[i][0] = 0;
        }

        for (int s = 1; s <= capacity; s++) {
            dp[0][s] = weights[0] == s ? weights[0] : 0;
        }

        for (int i = 1; i < weights.length; i++) {
            for (int s = 1; s <= capacity; s++) {
                int profit1 = dp[i-1][s];
                int profit2 = 0;
                if (weights[i] <= s)
                {
                    profit2 = profits[i] + dp[i-1][s - weights[i]];
                }

                dp[i][s] = Math.max(profit1, profit2);
            }
        }

        PrintElements(dp, weights, profits, capacity);

        return dp[weights.length-1][capacity];

    }

    private static void PrintElements(int[][] dp,int[] weights, int[] profits, int capacity)
    {
        int totalProfit = dp[weights.length-1][capacity];

        for (int i = weights.length-1; i > 0 ; i--) {
            if (totalProfit != dp[i-1][capacity])
            {
                System.out.println(weights[i]);
                totalProfit -= profits[i];
                capacity -= weights[i];
            }
        }
    }
}
