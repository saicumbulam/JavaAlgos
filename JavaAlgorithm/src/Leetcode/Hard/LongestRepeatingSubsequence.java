package Leetcode.Hard;

public class LongestRepeatingSubsequence {
    public static void main(String[] args) {
        String str = "tomorrow";
        System.out.println(Calculate(str, 0, 0));
    }

    private static int Calculate(String str, int i1, int i2)
    {
        if (i1 == str.length() || i2 == str.length())
        {
            return 0;
        }

        if (i1 != i2 && str.charAt(i1) == str.charAt(i2))
        {
            return 1 + Calculate(str, i1+1, i2+1);
        }

        int c1 = Calculate(str, i1+1, i2);
        int c2 = Calculate(str, i1, i2+1);

        return Math.max(c1, c2);

    }
}
