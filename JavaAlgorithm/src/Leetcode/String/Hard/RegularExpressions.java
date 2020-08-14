package Leetcode.String.Hard;


public class RegularExpressions {
    public static void main(String[] args) {
        String str = "aabbbbbcdda";
        String pattern = "a*bb*cdda";
        System.out.println(Calculate(str, pattern));
    }

    private static boolean Calculate(String text, String pattern) {
        if (text.isEmpty() && pattern.isEmpty())
        {
            return true;
        }

        if (!text.isEmpty() && pattern.isEmpty())
        {
            return false;
        }

        boolean firstMatch = false;

        if (!text.isEmpty() && (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)))
        {
            firstMatch = true;
        }

        if (pattern.length() >= 2 && pattern.charAt(1) == '*')
        {
            return (Calculate(text, pattern.substring(2))) || (firstMatch && Calculate(text.substring(1), pattern));
        }
        else
        {
            return Calculate(text.substring(1), pattern.substring(1));
        }
    }


}
