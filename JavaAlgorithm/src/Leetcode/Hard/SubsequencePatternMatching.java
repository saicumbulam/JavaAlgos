package Leetcode.Hard;

public class SubsequencePatternMatching {
    public static void main(String[] args) {
        String str  = "baxmx", pattern = "ax";
        System.out.println(Calculate(str, pattern, 0, 0));
    }

    private static int Calculate(String str, String pattern, int strIdx, int pattIdx)
    {
        if (pattIdx >= pattern.length())
        {
            return 1;
        }

        if (strIdx >= str.length())
        {
            return 0;
        }
        int c1 = 0;
        if (str.charAt(strIdx) == pattern.charAt(pattIdx))
        {
            c1 = Calculate(str, pattern, strIdx+1, pattIdx+1);
        }

        int c2 = Calculate(str, pattern, strIdx+1, pattIdx);

        return c1 +  c2;
    }
}
