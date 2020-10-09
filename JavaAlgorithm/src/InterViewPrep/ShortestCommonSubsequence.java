package InterViewPrep;

public class ShortestCommonSubsequence {
    public static void main(String[] args) {
        String s1 = "abcf";
        String s2 = "bdcf";
        System.out.println(Calculate(s1, s2));
    }

    private static int Calculate(String s1, String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i <= s2.length() ; i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] =  1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] =  1 + Math.min(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }
}
