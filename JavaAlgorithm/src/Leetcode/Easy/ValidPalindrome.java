package Leetcode.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";

        int left = 0, right = str.length()-1;

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

            if (left < right && Character.toLowerCase(str.charAt(left++))
             != Character.toLowerCase(str.charAt(right--)))
            {
                System.out.println(false);
            }
        }

        System.out.println(true);
    }
}
