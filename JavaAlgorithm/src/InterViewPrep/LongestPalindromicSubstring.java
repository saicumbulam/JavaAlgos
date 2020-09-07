package InterViewPrep;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "babad";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        int start = 0, end = 0;

        for (int i = 0; i < str.length(); i++) {
            int l1 = isPalindrome(str, i, i);
            int l2 = isPalindrome(str,i, i+1);
            int len = Math.max(l1, l2);

            if (len > end - start)
            {
                start = i - (len-1)/2; // left of the ith element
                end = i + (len)/2; // right of the ith element
            }
        }

        return str.substring(start, end+1); // +1 to include the end
    }

    private static int isPalindrome(String str, int left , int right)
    {
        int Left = left, Right = right;

        while (Left >= 0 && Right < str.length() && str.charAt(Left) == str.charAt(Right))
        {
            Left--;
            Right++;
        }

        return Right-Left-1;
    }
}
