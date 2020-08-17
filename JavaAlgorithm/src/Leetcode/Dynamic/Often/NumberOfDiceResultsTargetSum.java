package Leetcode.Dynamic.Often;

public class NumberOfDiceResultsTargetSum {
    public static void main(String[] args) {
        System.out.println(numRollsToTarget(6,1,6));
    }

    public static int numRollsToTarget(int d, int f, int target) {
        Integer[][] cache = new Integer[31][1001];
        return dfs(d, f, target, cache);
    }

    private static int dfs(int d, int f, int target, Integer[][] cache) {
        if (cache[d][target] != null) {
            return cache[d][target];
        }

        if (d == 0 && target == 0) {
            return 1;
        }

        if (d == 0 && target != 0) {
            return 0;
        }

        int result = 0;
        for (int i = 1; i <= f; i++) {
            if (target - i >= 0) {
                result += dfs(d - 1, f, target - i, cache);
                result %= (Math.pow(10, 9) + 7);
            }
        }

        cache[d][target] = result;

        return result;
    }
}
