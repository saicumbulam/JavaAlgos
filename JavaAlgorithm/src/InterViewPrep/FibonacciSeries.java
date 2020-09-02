package InterViewPrep;

public class FibonacciSeries {
    public static void main(String[] args) {
        int n = 6;
        System.out.println(Calculate(n));
    }

    private static int Calculate(int num)
    {
        if (num < 2)
        {
            return num;
        }

        int[] dp = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= num; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[num];
    }
}
