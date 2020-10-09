package Leetcode.String.Medium;

public class CountofPalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abdbca";
        System.out.println(Calculate(str));
    }

    // time : o(n^2) | space: o(n)
    private static int Calculate(String str)
    {
        boolean[][] dp = new boolean[str.length()][str.length()];
        int count = 0;

        //every single element is a palindrome
        for (int i = 0; i < str.length(); i++) {
            dp[i][i] = true;
            count++;
        }

        for (int startIdx = str.length()-1; startIdx >= 0 ; startIdx--) {
            for (int endIdx = startIdx+1; endIdx < str.length(); endIdx++) {
                if (str.charAt(startIdx) == str.charAt(endIdx))
                {
                    // if its a 2 character string or the remaining character is a string
                    if (endIdx -startIdx == 1 || dp[startIdx+1][endIdx-1])
                    {
                        dp[startIdx][endIdx] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }


}
