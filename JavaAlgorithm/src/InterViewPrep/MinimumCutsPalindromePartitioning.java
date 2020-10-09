package InterViewPrep;

public class MinimumCutsPalindromePartitioning {
    public static void main(String[] args) {
        System.out.println(Calculate("cddpd"));
    }

    //time: o(n^2) | space: o(n)
    private static int Calculate(String s)
    {
        boolean[][] dp = new boolean[s.length()][s.length()];

        for (int i = 0; i < s.length(); i++)
        {
            dp[i][i] = true;
        }

        for(int i = s.length()-1; i >= 0; i--)
        {
            for (int j = i+1; j < s.length(); j++)
            {
                if (s.charAt(i) == s.charAt(j))
                {
                    if (j - i == 1 || dp[i+1][j-1])
                    {
                        dp[i][j] = true;
                    }
                }
            }
        }

        // now lets populate the second table,
        // every index in 'cuts' stores the minimum cuts needed
        // for the substring from that index till the end
        int[] cuts = new int[s.length()];

        for (int i = s.length()-1; i >= 0; i--)
        {
            int minCuts = s.length();
            for (int j = s.length()-1; j >= i; j--)
            {
                if (dp[i][j])
                {
                    if (j == s.length()-1)
                    {
                        minCuts = 0;
                    }
                    else
                    {
                        minCuts = Math.min(minCuts, cuts[j+1]+1);
                    }
                }
            }
            cuts[i] = minCuts;
        }

        return cuts[0];
    }
}
