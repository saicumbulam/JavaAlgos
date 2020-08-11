package Leetcode.String.Palindrome.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        int left = 0, right = str.length()-1;
        str = str.toLowerCase();
        while (left < right)
        {
            while (left < right && !Character.isLetterOrDigit(str.charAt(left)))
            {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(str.charAt(right)))
            {
                right--;
            }

            if (left < right && str.charAt(left++) != str.charAt(right--))
            {
                System.out.println(false);
            }
        }

        System.out.println(true);
    }
}
