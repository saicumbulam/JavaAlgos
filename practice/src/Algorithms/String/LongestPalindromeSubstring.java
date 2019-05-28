package Algorithms.String;

public class LongestPalindromeSubstring {
    private static LongestPalindromeSubstring lps = new LongestPalindromeSubstring();

    private boolean expand(String str, int low, int high, int k){
        while (low >= 0 && high < str.length() && (str.charAt(low) == str.charAt(high))){
            // return true palindrome of length k
            if (high - low + 1 == k) {
                return true;
            }

            //expand in both directions
            low--;
            high++;
        }
        return false;
    }

    private boolean SubstringCalc(String str, int k){
        for (int i = 0; i < str.length(); i++) {
            // check if odd length or even length palindrome of length k
            // having str.charat(i) at its mid point
            if (expand(str, i, i, k) || expand(str, i, i+1, k)) {
                return true;
            }
        }
        return false;
    }

    //Function to check if a given string is a roated palindrome or not
    public boolean isRotatedPalindrome(String str){
        int m = str.length();

        return SubstringCalc(str+str, m);
    }

    public static void main(String[] args) {
        //Palindrome string
        String str= "ABCCBA";

        // rotate it by 2 units
        str = "CCBAAB";

        if (lps.isRotatedPalindrome(str)){
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
