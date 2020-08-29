package Leetcode.Dynamic.Often;


public class DecodeWays {
    public static void main(String[] args) {
        String str = "12";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int[] dp = new int[str.length()+1]; // number of ways to decode of length of string
        dp[0] = 1; // number of ways to decode a empty string
        dp[1] = str.charAt(0) == '0' ? 0: 1;

        for (int i = 2; i <= str.length() ; i++) {
            int oneDigit = Integer.valueOf(str.substring(i-1, i)); // current and prev digit
            int twoDigit = Integer.valueOf(str.substring(i-2, i)); // current and prev 2 digit
            if(oneDigit >= 1)
            {
                dp[i] += dp[i-1];
            }
            if(twoDigit >= 10 && twoDigit <= 26)
            {
                dp[i] += dp[i-2];
            }
        }
        return dp[str.length()];
    }
}
