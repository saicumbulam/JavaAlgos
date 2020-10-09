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
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];

        dp[s.length()][p.length()] = true;

        for (int i = s.length(); i >= 0 ; i--) {
            for (int j = p.length()-1; j >= 0 ; j--) {
                boolean first_Match = ( i < s.length() &&
                        (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

                if(j < p.length()-1 && p.charAt(j+1) == '*')
                {
                    dp[i][j] = dp[i][j+2] || (first_Match && dp[i+1][j]); // j+2 and i+1j
                }
                else
                {
                    dp[i][j] = first_Match && dp[i+1][j+1];
                }
            }
        }

        return dp[0][0];
    }
}
