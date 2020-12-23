/*
There are two cases to consider:

First, the second character of p is *,
now p string can match any number of character before *.
if(isMatch(s, p.substring(2)) means we can match the remaining s string,
otherwise, we check if the first character matches or not.

Second, if the second character is not *, we need match character one by one.
* */
package InterViewPrep;

public class RegularExpressionMatching {
    public static void main(String[] args) {

        System.out.println(Calculate("aa", "a*"));
    }

    private static boolean Calculate(String s, String p) {
        if (p == null || p.length() == 0)
            return (s == null || s.length() == 0);
        int m = s.length();
        int n = p.length();

        boolean dp[][] = new boolean[m+1][n+1];
        dp[0][0] = true;
        for (int j=2; j<=n; j++) {
            dp[0][j] = p.charAt(j-1) == '*' && dp[0][j-2];
        }

//        for (int i = 0; i <= m; i++) {
//            for (int j = 0; j <= n ; j++) {
//                System.out.println("i:" + i + " j:" + j + " " + dp[i][j]);
//            }
//        }
//        System.out.println();

        for (int j=1; j<=m; j++) {
            for (int i=1; i<=n; i++) {
                if (p.charAt(j-1) == s.charAt(i-1) || p.charAt(j-1) == '.')
                    dp[i][j] = dp[i-1][j-1];
                else if(p.charAt(j-1) == '*')
                    dp[i][j] = dp[i][j-2] ||
                            ((s.charAt(i-1) == p.charAt(j-2) || p.charAt(j-2) == '.') && dp[i-1][j]);

                System.out.println("i:" + i + " j:" + j + " " + dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
