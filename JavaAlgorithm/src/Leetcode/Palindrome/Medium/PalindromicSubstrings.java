package Leetcode.Palindrome.Medium;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int i = 0, count = 0;

        while (i < str.length())
        {
            count += isPalindrome(str, i, i);
            count += isPalindrome(str, i, i+1);
            i++;
        }
        return count;
    }

    private static int isPalindrome(String str, int left, int right )
    {
        int count = 0;
        int Left = left, Right = right;
        while (Left >= 0 && Right < str.length() && str.charAt(Left) == str.charAt(Right))
        {
            count++;
            Left--;
            Right++;
        }
        return count;
    }
}
