package Leetcode.Hard;

import java.util.HashMap;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        System.out.println(Calculate("passport", "ppsspt", 0, 0));
        System.out.println(CalculateStr("passport", "ppsspt", 0, 0));
        System.out.println(CalculateEff("passport", "ppsspt", 0, 0, new HashMap<>()));
    }

    private static int Calculate(String s1, String s2, int i1, int i2)
    {
        if (i1 >= s1.length() || i2 >= s2.length())
        {
            return 0;
        }

        if(s1.charAt(i1) == s2.charAt(i2))
        {
            return 1 + Calculate(s1, s2, i1+1, i2+1);
        }

        int c1 = Calculate(s1, s2, i1, i2+1);
        int c2 = Calculate(s1, s2, i1+1, i2);

        return Math.max(c1, c2);
    }


    private static String CalculateStr(String s1, String s2, int i1, int i2)
    {
        if (i1 >= s1.length() || i2 >= s2.length())
        {
            return "";
        }

        if(s1.charAt(i1) == s2.charAt(i2))
        {
            return s1.charAt(i1) + CalculateStr(s1, s2, i1+1, i2+1);
        }

        String c1 = CalculateStr(s1, s2, i1, i2+1);
        String c2 = CalculateStr(s1, s2, i1+1, i2);

        return c1.length() >  c2.length() ? c1 : c2;
    }

    private static int CalculateEff(String s1, String s2, int i1, int i2, HashMap<String, Integer> hashMap)
    {
        if (!hashMap.containsKey(i1 + "," + i2))
        {
            if (i1 >= s1.length() || i2 >= s2.length())
            {
                hashMap.put((i1 + "," + i2),0);
            }
            else if(s1.charAt(i1) == s2.charAt(i2))
            {
                hashMap.put((i1 + "," + i2), 1 + Calculate(s1, s2, i1 + 1, i2 + 1));
            }
            else
            {
                int c1 = Calculate(s1, s2, i1, i2+1);
                int c2 = Calculate(s1, s2, i1+1, i2);

                hashMap.put((i1 + "," + i2), Math.max(c1, c2));
            }
        }
        return hashMap.get(i1 + "," + i2);
    }
}
