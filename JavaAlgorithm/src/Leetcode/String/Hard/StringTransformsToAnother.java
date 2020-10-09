/*
Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero or more conversions.

In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.

Return true if and only if you can transform str1 into str2

Time complexity o(n)
space: o(n)
* */
package Leetcode.String.Hard;

import java.util.HashMap;
import java.util.HashSet;

public class StringTransformsToAnother {
    public static void main(String[] args) {
        String str1 = "aabcc", str2 = "ccdee";
        System.out.println(Calculate(str1, str2));
    }

    private static boolean Calculate(String str1, String str2)
    {
        if(str1.equals(str2))
        {
            return true;
        }

        HashMap<Character, Character> map = new HashMap<>();
        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            char c2 = str2.charAt(i);

            if(map.containsKey(c1) && map.get(c1) != c2)
            {
                return false;
            }
            map.put(c1, c2);
            set.add(c2);
        }

        if(set.size() == 26)
        {
            return false;
        }
        return true;
    }
}
