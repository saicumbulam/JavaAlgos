package InterViewPrep;

public class StringsInterleaving {
    public static void main(String[] args) {
        //String m="abd"; String n="cef"; String p="abcdef";
        String m="abd"; String n="cef"; String p="adcbef";  // order not preserved so false result
        System.out.println(Calculate(m,n,p));
    }

    private static boolean Calculate(String m , String n , String p)
    {
        boolean[][] dp = new boolean[m.length()+1][n.length()+1];

        if (m.length() + n.length() != p.length()) return false;

        for (int mIndex = 0; mIndex <= m.length(); mIndex++) {
            for (int nIndex = 0; nIndex <= n.length(); nIndex++) {

                if (mIndex == 0 && nIndex == 0)
                {
                    dp[mIndex][nIndex] = true;
                }
                else if (mIndex == 0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
                {
                    dp[mIndex][nIndex] = dp[mIndex][nIndex-1];
                }
                else if (nIndex == 0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
                {
                    dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
                }
                else
                {
                    if (mIndex > 0 && m.charAt(mIndex-1) == p.charAt(mIndex+nIndex-1))
                    {
                        dp[mIndex][nIndex] = dp[mIndex-1][nIndex];
                    }

                    if (nIndex > 0 && n.charAt(nIndex-1) == p.charAt(mIndex+nIndex-1))
                    {
                        dp[mIndex][nIndex] = dp[mIndex][nIndex-1];
                    }
                }
            }
        }

        return dp[m.length()][n.length()];
    }
}
