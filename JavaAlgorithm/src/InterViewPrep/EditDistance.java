package InterViewPrep;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "bat";
        String s2 = "but";
        System.out.println(Calculate(s1, s2, 0, 0));
        System.out.println(CalculateStr(s1, s2, 0, 0, ""));
    }

    private static int Calculate(String s1, String s2, int i1, int i2)
    {
        if (i1 == s1.length()  || i2 == s2.length())
        {
            return 0;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            return Calculate(s1, s2, i1+1, i2+1);
        }

        int c1 = 1 + Calculate(s1, s2, i1, i2+1);
        int c2 = 1 +Calculate(s1, s2, i1+1, i2);
        int c3 = 1 + Calculate(s1, s2, i1+1, i2+1);

        return Math.min(c1, Math.min(c2, c3));
    }

    private static String CalculateStr(String s1, String s2, int i1, int i2, String result)
    {
        if (i1 == s1.length()  || i2 == s2.length())
        {
            return result;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            return CalculateStr(s1, s2, i1+1, i2+1, result);
        }

        String c1 = s2.charAt(i2) + CalculateStr(s1, s2, i1, i2+1, result); //added
        String c2 = s1.charAt(i1) + CalculateStr(s1, s2, i1+1, i2, result); // deleted
        String c3 = s1.charAt(i1) + CalculateStr(s1, s2, i1+1, i2+1, result); // replace

        if (c2.length() < c3.length())
        {
            return c1.length() < c2.length() ? c1 : c2;
        }
        else
        {
            return c1.length() < c3.length() ? c1 : c3;
        }
    }
}
