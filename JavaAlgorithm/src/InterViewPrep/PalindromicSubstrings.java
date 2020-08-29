package InterViewPrep;

import java.util.logging.Level;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        //String str = "abdbca";
        String str = "cddpd";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str)
    {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count += isPalindrome(str, i-1, i+1);
            count += isPalindrome(str, i, i+1);

        }
        return count;
    }

    private static int isPalindrome(String str, int left, int right)
    {
        int count = 0;
        int Left = left, Right = right;
        while (Left >= 0 && Right < str.length() && str.charAt(Left) == str.charAt(Right))
        {
            System.out.println(str.substring(left, right+1));
            count++;
            Left--;
            Right++;
        }

        return count;
    }
}
