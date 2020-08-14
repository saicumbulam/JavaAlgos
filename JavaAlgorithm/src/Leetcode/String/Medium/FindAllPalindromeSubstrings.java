package Leetcode.String.Medium;

public class FindAllPalindromeSubstrings {
    public static void main(String[] args) {
        String str = "aabbbaa";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            count += findPalindrome(str, i-1, i+1);
            count += findPalindrome(str, i, i+1);
        }

        return count;
    }

    private static int findPalindrome(String str, int left, int right) {
        int count = 0;

        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right))
        {
            System.out.println(str.substring(left, right+1));
            count++;
            left--;
            right++;
        }
        return count;
    }


}
