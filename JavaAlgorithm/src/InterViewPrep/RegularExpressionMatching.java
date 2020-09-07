/*
There are two cases to consider:

First, the second character of p is *,
now p string can match any number of character before *.
if(isMatch(s, p.substring(2)) means we can match the remaining s string,
otherwise, we check if the first character matches or not.

Second, if the second character is not *, we need match character one by one.
* */
package InterViewPrep;

public class RegularExpressionMatching {
    public static void main(String[] args) {
        System.out.println(Calculate("aa", "a*"));
    }

    private static boolean Calculate(String s, String p) {
        if (p.isEmpty())
        {
            return s.isEmpty();
        }

        if (p.length() > 1 && p.charAt(1) == '*')
        {
            if (Calculate(s, p.substring(2)))
            {
                return true;
            }

            if (s.length() > 0 &&(p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
            {
                return Calculate(s.substring(1), p);
            }

            return false;
        }
        else
        {
            if (s.length() > 0 && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0)))
            {
                return Calculate(s.substring(1), p.substring(1));
            }
            return false;
        }
    }
}
