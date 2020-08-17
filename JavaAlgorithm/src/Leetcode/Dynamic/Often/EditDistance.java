/*
Input: s1 = "passpot"
       s2 = "ppsspqrt"
Output: 3
Explanation: Replace 'a' with 'p', 'o' with 'q', and insert 'r'.

Time complexity without memo = o(3^(m+n))
Time complexity = o(m+n)
space complexity = o(m+n)
* */
package Leetcode.Dynamic.Often;

public class EditDistance {
    public static void main(String[] args) {
        String s1 = "abc", s2 = "yabd";
        System.out.println(Calculate(s1, s2, 0, 0));
    }

    private static int Calculate(String s1, String s2, int i1 , int i2)
    {
        if (i1 >= s1.length())
        {
            return s2.length()-i2;
        }
        if (i2 >= s2.length())
        {
            return s1.length()-i1;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            return Calculate(s1, s2, i1+1, i2+1);
        }

        int c1 = 1 + Calculate(s1, s2, i1+1, i2);
        int c2 = 1 + Calculate(s1, s2, i1, i2+1);
        int c3 = 1+ Calculate(s1, s2, i1+1, i2+1);

        return Math.min(c1, Math.min(c2, c3));
    }
}
