package Leetcode.Dynamic.Medium;

import java.util.HashMap;

public class MinimumCoinChange {
    public static void main(String[] args) {
        int[] coins = {1,2,5};
        int amount = 11;
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = Calculate(coins, amount, 0, map);
        if (result != Integer.MAX_VALUE)
        {
            System.out.println(result);
        }
    }

    private static int Calculate(int[] coins, int amount, int index, HashMap<Integer, Integer> map)
    {
        if (!map.containsKey(index))
        {
            if (amount == 0)
            {
                map.put(index, 0);
            }
            else if (coins.length == 0 || index >= coins.length)
            {
                map.put(index, Integer.MAX_VALUE);
            }
            else
            {
                int count1 = Integer.MAX_VALUE;
                if(coins[index] <= amount) // this check is important and avoids infinte loop
                {
                    int res = Calculate(coins, amount-coins[index], index, map);
                    if (res != Integer.MAX_VALUE)
                    {
                        count1 = res + 1; //res+1 is important
                    }
                }
                int count2 = Calculate(coins, amount, index+1, map);

                map.put(index, Math.min(count1, count2));
            }

        }

        return map.get(index);
    }
}
