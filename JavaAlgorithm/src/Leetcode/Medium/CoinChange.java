package Leetcode.Medium;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        int result = Calculate(coins, amount, 0);
        if (result != Integer.MAX_VALUE)
        {
            System.out.println(result);
        }
    }

    private static int Calculate(int[] coins, int amount, int index)
    {
        if (amount == 0)
        {
            return 0;
        }

        if (coins.length == 0 || index >= coins.length)
        {
            return Integer.MAX_VALUE;
        }

        int count1 = Integer.MAX_VALUE;
        if(coins[index] <= amount) // this check is important and avoids infinte loop
        {
            int res = Calculate(coins, amount-coins[index], index);
            if (res != Integer.MAX_VALUE)
            {
                count1 = res + 1;
            }
        }
        int count2 = Calculate(coins, amount, index+1);

        return Math.min(count1, count2);
    }
}
