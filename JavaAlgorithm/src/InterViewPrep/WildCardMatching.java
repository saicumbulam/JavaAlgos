package InterViewPrep;

public class WildCardMatching {
    public static void main(String[] args) {
        String s = "abc";
        String p = "ab*";

        System.out.println(Calculate(s, p));
    }

    private static boolean Calculate(String s, String p)
    {
        int m = s.length();
        int n= p.length();
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j = 1; j <= n; j++)
        {
            if(p.charAt(j-1) == '*')
            {
                dp[0][j] = dp[0][j-1];
            }
        }


        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n ; j++) {
                System.out.print(dp[i][j] + ", ");
            }
        }
        System.out.println();

        for (int i = 1; i <= m; i++)
        {
            for (int j = 1; j <= n; j++)
            {
                if (p.charAt(j-1) == '*')
                {
                    dp[i][j] = dp[i][j-1] || dp[i-1][j];
                }
                else
                {
                    if (p.charAt(j-1) == '?' || s.charAt(i-1) == p.charAt(j-1))
                    {
                        dp[i][j] = dp[i-1][j-1];
                    }
                }
                System.out.println("i:" + i + " j:" + j + " " + dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
