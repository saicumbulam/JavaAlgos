package Leetcode.String.Medium;

public class stringAtoi {
    public static void main(String[] args) {
        String str = "   -42";
        str = str.trim();

        char flag = '+';
        int  i = 0;
        if (str.charAt(i) == '-')
        {
            flag = '-';
            i++;
        }
        else if (i < str.length() && str.charAt(i) == flag)
        {
            i++;
        }

        long result = 0;

        while (i < str.length() && Character.isDigit(str.charAt(i)))
        {
            result = result * 10 + Character.getNumericValue(str.charAt(i));
            i++;
        }

        if (result > Integer.MAX_VALUE)
        {
            System.out.println(Integer.MAX_VALUE);
        }

        if (result < Integer.MIN_VALUE)
        {
            System.out.println(Integer.MIN_VALUE);
        }

        System.out.println(result);
    }
}
