package InterViewPrep;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String str = "abdbca";
        System.out.println(Calculate(str, 0, str.length()-1));
    }

    private static int Calculate(String str, int startIdx, int endIdx) {
        if(startIdx > endIdx)
        {
            return 0;
        }

        if (startIdx == endIdx)
        {
            return 1;
        }

        if (str.charAt(startIdx) == str.charAt(endIdx))
        {
            return 2 +  Calculate(str, startIdx+1, endIdx-1);
        }

        int c1 = Calculate(str, startIdx+1, endIdx);
        int c2 = Calculate(str, startIdx, endIdx-1);
        return Math.max(c1, c2);

    }
}
