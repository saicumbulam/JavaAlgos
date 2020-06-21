package Leetcode.Hard;

import java.util.HashMap;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        String s1 = "abdca", s2 = "cbda";
        System.out.println(CalculateInt(s1, s2,0,0,0));
        HashMap<String, Integer> map = new HashMap<>();
        System.out.println(CalculateIntEff(s1, s2,0,0,0, map));
        System.out.println(CalculateIntStr(s1, s2,0,0,"", new HashMap<>()));
        System.out.println(CalculateStr(s1, s2,0,0,""));
    }

    private static int CalculateInt(String s1, String s2, int i1, int i2, int count)
    {
        if (i1 >= s1.length() || i2 >= s2.length())
        {
            return count;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            count = CalculateInt(s1, s2, i1+1, i2+1, count+1);
        }

        int c1 = CalculateInt(s1, s2, i1+1, i2,0);
        int c2 = CalculateInt(s1, s2, i1, i2+1,0);
        return Math.max(count, Math.max(c1, c2));
    }


    private static String CalculateStr(String s1, String s2, int i1, int i2, String curr)
    {
        if (i1 >= s1.length() || i2 >= s2.length())
        {
            return curr;
        }

        if (s1.charAt(i1) == s2.charAt(i2))
        {
            curr = CalculateStr(s1, s2, i1+1, i2+1, curr+ s1.charAt(i1));
        }

        String c1 = CalculateStr(s1, s2, i1+1, i2,"");
        String c2 = CalculateStr(s1, s2, i1, i2+1,"");

        if (c1.length() > c2.length())
        {
            return  curr.length() > c1.length() ? curr : c1;
        }
        else
        {
            return curr.length() > c2.length() ? curr : c2;
        }
    }

    private static int CalculateIntEff(String s1, String s2, int i1, int i2, int count, HashMap<String, Integer> map)
    {
        if (!map.containsKey(i1 + "," + i2))
        {
            if (i1 >= s1.length() || i2 >= s2.length())
            {
                map.put((i1 + "," + i2), count);
            }
            else
            {
                if (s1.charAt(i1) == s2.charAt(i2))
                {
                    count = CalculateIntEff(s1, s2, i1+1, i2+1, count+1, map);
                }

                int c1 = CalculateIntEff(s1, s2, i1+1, i2,0, map);
                int c2 = CalculateIntEff(s1, s2, i1, i2+1,0, map);
                map.put((i1 + "," + i2), Math.max(count, Math.max(c1, c2)));
            }
        }
        return map.get(i1 + "," + i2);
    }

    private static String CalculateIntStr(String s1, String s2, int i1, int i2, String count, HashMap<String, String> map)
    {
        if (!map.containsKey(i1 + "," + i2))
        {
            if (i1 >= s1.length() || i2 >= s2.length())
            {
                map.put((i1 + "," + i2), count);
            }
            else
            {
                if (s1.charAt(i1) == s2.charAt(i2))
                {
                    count = CalculateIntStr(s1, s2, i1+1, i2+1, count+s1.charAt(i1), map);
                }

                String c1 = CalculateIntStr(s1, s2, i1+1, i2,"", map);
                String c2 = CalculateIntStr(s1, s2, i1, i2+1,"", map);

                if (c1.length() > c2.length())
                {
                    map.put((i1 + "," + i2), count.length() > c1.length() ? count : c1);
                }
                else
                {
                    map.put((i1 + "," + i2), count.length() > c2.length() ? count : c2);
                }
            }

        }
        return map.get(i1 + "," + i2);
    }
}
