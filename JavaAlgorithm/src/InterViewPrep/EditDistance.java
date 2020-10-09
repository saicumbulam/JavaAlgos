package InterViewPrep;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "bat";
        String s2 = "but";
        System.out.println(Calculate(s1, s2));
        System.out.println(CalculateStr(s1, s2, 0, 0, ""));
    }

    private static int Calculate(String s1, String s2)
    {
        int[][] dp = new int[s1.length()+1][s2.length()+1];

        for (int i = 0; i <= s1.length(); i++) {
            dp[i][0] = i;
        }

        for (int i = 0; i <= s2.length(); i++) {
            dp[0][i] = i;
        }

        for (int i = 1; i <= s1.length() ; i++) {
            for (int j = 1; j <= s2.length() ; j++) {
                // if strings are matching, recursively match for the remaining
                if (s1.charAt(i-1) == s2.charAt(j-1))
                {
                    dp[i][j] = dp[i-1][j-1];
                }
                else
                {
                    dp[i][j] = 1 + Math.min(dp[i-1][j],
                            Math.min(dp[i][j-1], dp[i-1][j-1]));
                }
            }
        }

        return dp[s1.length()][s2.length()];
    }

    private static String CalculateStr(String s1, String s2, int i1, int i2, String result)
    {
        if (i1 == s1.length()  || i2 == s2.length())
        {
            return result;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            return CalculateStr(s1, s2, i1+1, i2+1, result);
        }

        String c1 = s2.charAt(i2) + CalculateStr(s1, s2, i1, i2+1, result); //added
        String c2 = s1.charAt(i1) + CalculateStr(s1, s2, i1+1, i2, result); // deleted
        String c3 = s1.charAt(i1) + CalculateStr(s1, s2, i1+1, i2+1, result); // replace

        if (c2.length() < c3.length())
        {
            return c1.length() < c2.length() ? c1 : c2;
        }
        else
        {
            return c1.length() < c3.length() ? c1 : c3;
        }
    }
}
