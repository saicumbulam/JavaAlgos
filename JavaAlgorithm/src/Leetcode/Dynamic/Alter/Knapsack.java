package Leetcode.Dynamic.Alter;

public class Knapsack {
    public static void main(String[] args) {
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = Calculate(profits, weights, 7, 0);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private static int Calculate(int[] profits, int[] weights, int capacity, int curIdx){
        if(capacity <= 0 || curIdx >= profits.length)
        {
            return 0;
        }

        int profit1 = 0;
        if(weights[curIdx] <= capacity)
        {
            profit1 = profits[curIdx] + Calculate(profits, weights, capacity-weights[curIdx], curIdx+1);
        }

        int profit2 = Calculate(profits, weights, capacity, curIdx+1);

        return Math.max(profit1, profit2);
    }
}
