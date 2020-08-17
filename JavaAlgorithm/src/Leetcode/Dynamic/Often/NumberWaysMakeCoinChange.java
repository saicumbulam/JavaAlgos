/*
calculate the ways to make coin change

1. if amount == 0 , return 1
2. c1 = (amount-num[curIdx], curIdx)
3. c2 = (amount, curIdx+1)
4. c1 + c2
* */
package Leetcode.Dynamic.Often;

public class NumberWaysMakeCoinChange {
    public static void main(String[] args) {
        int n = 6;
        int[] denoms = {1,5};
        System.out.println(Calculate(denoms, n, 0));
    }

    private static int Calculate(int[] denoms, int amount, int curIdx)
    {
        if (amount == 0)
        {
            return 1;
        }
        if (curIdx >= denoms.length)
        {
            return 0;
        }

        int res1 = 0;
        if(denoms[curIdx] <= amount)
        {
            res1 = Calculate(denoms, amount - denoms[curIdx], curIdx);
        }

        int res2 = Calculate(denoms, amount, curIdx+1);

        return res1 + res2;
    }
}
