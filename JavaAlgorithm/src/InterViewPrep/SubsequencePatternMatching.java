package InterViewPrep;

public class SubsequencePatternMatching {
    public static void main(String[] args) {
        String str =  "baxmx";
        String pattern= "ax";
        System.out.println(Calculate(str, pattern, 0, 0));
    }

    private static int Calculate(String str, String pattern,  int strIndex, int ptrIndex)
    {
        if (ptrIndex == pattern.length())
        {
            return 1;
        }

        if (strIndex == str.length())
        {
            return 0;
        }

        int c1 = 0;
        if (str.charAt(strIndex) == pattern.charAt(ptrIndex))
        {
            c1 = Calculate(str, pattern, strIndex+1, ptrIndex+1);
        }

        int c2 = Calculate(str, pattern, strIndex+1, ptrIndex);
        return c1 + c2;

    }
}
