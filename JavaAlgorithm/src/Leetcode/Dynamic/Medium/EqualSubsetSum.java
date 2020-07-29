package Leetcode.Dynamic.Medium;

public class EqualSubsetSum {
    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4};
        System.out.println(canPartition(num));
    }

    private static boolean Calculate(int[] num, int target, int curIdx)
    {
        if (target == 0)
        {
            return true;
        }

        if(num.length <= 0 || curIdx >= num.length)
        {
            return false;
        }

        if( num[curIdx] <= target ) {
            if(Calculate(num, target - num[curIdx], curIdx + 1))
                return true;
        }

        return Calculate(num, target, curIdx + 1);
    }

    public static boolean canPartition(int[] num) {
        int sum = 0;
        for (int i = 0; i < num.length; i++)
            sum += num[i];

        // if 'sum' is a an odd number, we can't have two subsets with equal sum
        if(sum % 2 != 0)
            return false;

        return Calculate(num, sum/2, 0);
    }
}
