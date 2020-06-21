package Leetcode.Medium;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int n = str.length();
        int count = 0;

        for (int center = 0; center < 2*n-1; center++) {
            int left = center/2;
            int right = left + center%2;
            //Expand Around Center
            while (left >= 0 && right < n && str.charAt(left) == str.charAt(right))
            {
                count++;
                left--;
                right++;
            }
        }

        return count;
    }
}
