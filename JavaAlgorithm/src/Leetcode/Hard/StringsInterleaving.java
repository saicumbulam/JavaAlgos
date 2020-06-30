package Leetcode.Hard;

import java.util.HashMap;

public class StringsInterleaving {
    public static void main(String[] args) {
        System.out.println(Calculate("abd", "cef", "abcdef", 0, 0, 0));
        System.out.println(Calculate("abd", "cef", "adcbef", 0, 0, 0));
    }

    private static boolean Calculate(String m, String n, String pattern, int mIndex, int nIndex, int pIndex)
    {
        if (mIndex >= m.length() && nIndex >= n.length() && pIndex >= pattern.length())
        {
            return true;
        }

        if (pIndex >= pattern.length())
        {
            return false;
        }

        boolean b1 = false, b2 = false;

        if (mIndex < m.length() && m.charAt(mIndex) == pattern.charAt(pIndex))
        {
            b1 = Calculate(m,n,pattern, mIndex+1, nIndex, pIndex+1);
        }

        if (nIndex < n.length() && n.charAt(nIndex) == pattern.charAt(pIndex))
        {
            b2 = Calculate(m,n,pattern, mIndex, nIndex+1, pIndex+1);
        }

        return b1 || b2;
    }
}
