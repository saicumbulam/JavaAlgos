package Leetcode.Dynamic.Hard;

public class ShortestCommonSuperSequence {
    private static String result = "";
    //cabac
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(Calculate(str1, str2, 0, 0));
        System.out.println(CalculateInt(str1, str2, 0, 0));
    }

    private static String Calculate (String str1, String str2, int i1, int i2)
    {
        if (i1 == str1.length())
        {
            return str2.substring(i2);
        }
        if (i2 == str2.length())
        {
            return str1.substring(i1);
        }

        if (str1.charAt(i1) == str2.charAt(i2))
        {
            return str1.charAt(i1) + Calculate(str1, str2, i1+1, i2+1);
        }

        String res1 = str1.charAt(i1) + Calculate(str1, str2, i1+1, i2);
        String res2 = str2.charAt(i2) + Calculate(str1, str2, i1, i2+1);

        return res1.length() < res2.length() ? res1: res2;

    }

    private static int CalculateInt(String str1, String str2, int i1, int i2)
    {
        if (i1 == str1.length())
        {
            return str2.length() - i2;
        }
        if (i2 == str2.length())
        {
            return str1.length() - i1;
        }

        if (str1.charAt(i1) == str2.charAt(i2))
        {
            return 1 + CalculateInt(str1, str2, i1+1, i2+1);
        }

        int c1 = 1 + CalculateInt(str1, str2, i1+1, i2);
        int c2 = 1 + CalculateInt(str1, str2, i1, i2+1);

        return Math.min(c1, c2);

    }
}
