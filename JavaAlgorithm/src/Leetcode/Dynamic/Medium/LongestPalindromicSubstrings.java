package Leetcode.Dynamic.Medium;

import java.util.logging.Level;

public class LongestPalindromicSubstrings {
    public static void main(String[] args) {
        String input = "babad";
        System.out.println(Calculate(input));
    }

    private static String Calculate(String input)
    {
        int start = 0, end = 0;

        for (int i = 0; i < input.length(); i++) {
            int len1 = ExpandCenter(input, i, i);
            int len2 = ExpandCenter(input, i, i+1);
            int len = Math.max(len1, len2);
            if (len > end - start)
            {
                start = i - (len-1)/2; // left of middle of string
                end = i + len/2;  // right of the middle of string
            }
        }
        return input.substring(start, end+1);
    }

    private static int ExpandCenter(String s, int Left, int Right)
    {
        while (Left >= 0 && Right < s.length() && s.charAt(Left) == s.charAt(Right))
        {
            Left--;
            Right++;
        }

        return Right - Left - 1;// calculating the length, so one comes.
    }
}
