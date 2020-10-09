package InterViewPrep;

public class SubsequencePatternMatching {
    public static void main(String[] args) {
        String str =  "baxmx";
        String pattern= "ax";
        System.out.println(Calculate(str, pattern));
    }

    private static int Calculate(String str, String pattern)
    {
        if (pattern.length() == 0) return 1;
        if (str.length() == 0 || pattern.length() > str.length()) return 0;

        int[][] dp = new int[str.length()+1][pattern.length()+1];

        for (int i = 0; i <= str.length(); i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= str.length() ; i++) {
            for (int j = 1; j <= pattern.length() ; j++) {
                if (str.charAt(i - 1) == pattern.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                dp[i][j] += dp[i-1][j];
            }
        }

        return dp[str.length()][pattern.length()];
    }
}
