package InterViewPrep;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        //String str = "tomorrow";
        String str = "aabdbcec";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int[][]  dp = new int[str.length()+1][str.length()+1];
        int maxLength = 0;

        for (int i = 1; i <= str.length() ; i++) {
            for (int j = 1; j <= str.length() ; j++) {
                if (i != j && str.charAt(i-1) == str.charAt(j-1))
                {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
                maxLength = Math.max(maxLength, dp[i][j]);
            }
        }
        return maxLength;
    }
}
