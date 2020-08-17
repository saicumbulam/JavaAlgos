package Leetcode.Dynamic.Often;

public class MinDelInsTransString {
    public static void main(String[] args) {
        String s1 = "abdca" ,s2 = "cbda";
        Calculate(s1, s2);
    }

    private static void Calculate(String s1, String s2)
    {
        int lcs = CalculateLcs(s1, s2, 0, 0);
        System.out.println(String.format("Deletion: %d", s1.length() - lcs));
        System.out.println(String.format("Insertion: %d", s2.length() - lcs));
    }

    private static int CalculateLcs(String s1, String s2, int i1, int i2)
    {
        if (i1 >= s1.length() || i2 >= s2.length())
        {
            return 0;
        }

        if(s1.charAt(i1) == s2.charAt(i2))
        {
            return 1 + CalculateLcs(s1, s2, i1+1, i2+1);
        }

        int c1 = CalculateLcs(s1, s2, i1, i2+1);
        int c2 = CalculateLcs(s1, s2, i1+1, i2);

        return Math.max(c1, c2);
    }
}
