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
        int n = profits.length;
        int[][] dp = new int[n][capacity+1];

        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        for (int c = 0; c <= capacity; c++) {
            dp[0][c] = weights[0] <= c ? profits[0]: 0;
        }


        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity ; c++) {
                int profit1= 0, profit2 = 0;
                // include the item, if it is not more than the capacity
                if(weights[i] <= c)
                    profit1 = profits[i] + dp[i-1][c-weights[i]];
                // exclude the item
                profit2 = dp[i-1][c];
                // take maximum
                dp[i][c] = Math.max(profit1, profit2);
            }
        }

        PrintItems(dp, profits, weights, capacity);

        return dp[n-1][capacity];
    }

    private static void PrintItems(int[][] dp, int[] profits, int[] weights, int capacity)
    {
        int totalProfit = dp[profits.length-1][capacity];

        for (int i = weights.length-1; i > 0 ; i--) {
            if (totalProfit != dp[i-1][capacity])
            {
                System.out.println(weights[i]);
                capacity -= weights[i];
                totalProfit -= profits[i];
            }
        }

        if (totalProfit != 0)
        {
            System.out.println(weights[0]);
        }
    }
}
