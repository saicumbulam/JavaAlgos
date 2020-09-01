package InterViewPrep;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(Calculate(n));
    }

    private static int Calculate(int n)
    {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int maxSquareIdx = (int)Math.sqrt(n)+1;
        int[] squares = new int[maxSquareIdx];

        for(int i = 0; i < squares.length; i++)
        {
            squares[i] = i*i;
        }

        for (int i = 1; i <= n; i++) {
            for (int s = 1; s < squares.length; s++) {
                if(i < squares[s])
                {
                    break;
                }

                dp[i] = Math.min(dp[i], dp[i-squares[s]]+1);
            }
        }

        return dp[n];
    }
}
