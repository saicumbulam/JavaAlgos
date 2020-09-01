package InterViewPrep;

public class CountOfPalindromicSubstrings {
    public static void main(String[] args) {
        String str = "cddpd";
        System.out.println(Calculate(str));
    }

    private static int Calculate (String str)
    {
        int count = 0;

        for (int i = 0; i < str.length(); i++) {
            count += isPlaindrome(str, i-1, i+1);
            count += isPlaindrome(str, i, i+1);
        }
        return count;
    }

    private static int isPlaindrome(String str, int left , int right)
    {
        int Left = left, Right = right, count = 0;

        while (Left >= 0 && Right < str.length() && str.charAt(Left) == str.charAt(Right))
        {
            count++;
            Left--;
            Right++;
        }

        return count;
    }
}
