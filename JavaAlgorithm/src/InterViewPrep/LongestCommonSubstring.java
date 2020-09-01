package InterViewPrep;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        //String s1 = "abdca";
        //String s2 = "cbda";
        String s1 = "passport";
        String s2 = "ppsspt";
        System.out.println(Calculate(s1, s2, 0, 0, 0));
    }

    private static int Calculate(String s1, String s2, int i1, int i2, int count)
    {
        if (i1 == s1.length() || i2 == s2.length())
        {
            return count;
        }

        int c1 = count;
        if (s1.charAt(i1) == s2.charAt(i2))
        {
            c1 = Calculate(s1, s2, i1+1, i2+1, count+1);
        }

        int c2 = Calculate(s1, s2, i1+1, i2, 0);
        int c3 = Calculate(s1, s2, i1, i2+1, 0);

        return Math.max(c1, Math.max(c2, c3));
    }
}
