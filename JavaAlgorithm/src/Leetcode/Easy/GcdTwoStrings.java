package Leetcode.Easy;

public class GcdTwoStrings {
    public static void main(String[] args) {
        System.out.println(gcdOfStrings("ABCABCABC", "ABC"));
    }
    public static String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) return "";
        int gcd = str1.length(), b = str2.length();
        while (gcd != b) if (gcd > b) gcd -= b; else b -= gcd;
        return str1.substring(0, gcd);
    }
}
