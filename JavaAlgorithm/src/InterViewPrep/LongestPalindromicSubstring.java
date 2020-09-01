package InterViewPrep;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        //String str = "abdbca";
        String str = "cddpd";
        //String str = "pqr";
        System.out.println(Calculate(str, 0, str.length()-1));
    }

    private static int Calculate(String str, int startIdx, int endIdx) {

        if (startIdx > endIdx)
        {
            return 0;
        }

        if (startIdx == endIdx)
        {
            return 1;
        }

        // including elements that are same at the start and the end index
        if (str.charAt(startIdx) == str.charAt(endIdx))
        {
            int remain = endIdx - startIdx - 1;
            if (remain ==  Calculate(str, startIdx+1, endIdx-1))
            {
                return  remain+2;
            }
        }

        int c1 = Calculate(str, startIdx+1, endIdx);
        int c2 = Calculate(str, startIdx, endIdx-1);
        return Math.max(c1, c2);


    }
}
