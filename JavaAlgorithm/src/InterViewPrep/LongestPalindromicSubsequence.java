package InterViewPrep;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "bbbab";
        System.out.println(Calculate(str));
    }

    // time: o(n^2) | space: o(n)
    private static int Calculate(String str) {
        int[][] dp = new int[str.length()][str.length()];

        // single element is itself a palindrome
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = 1;
        }
        int maxLength = 1; // single element is a palindrome

        for (int i = str.length()-1; i >= 0 ; i--) {
            for (int j = i+1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j))
                {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i+1][j]
                    , dp[i][j-1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;

    }
}
