package Leetcode.String.Palindrome.Easy;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(Calculate(str.toLowerCase().toCharArray()));
    }

    private static boolean Calculate(char[] strs)
    {
        int left = 0, right = strs.length-1;

        while (left < right)
        {
            while (left < right && !Character.isLetter(strs[left]))
            {
                left++;
            }

            while (left < right && !Character.isLetter(strs[right]))
            {
                right--;
            }

            if(left < right && strs[left++] != strs[right--])
            {
                return false;
            }
        }

        return true;

    }
}
