package Leetcode.SlidingWindow.Medium;

import java.util.HashMap;

public class MinimumWindowSubstring {
    public static void main(String[] args) {
        //String s = "ADOBECODEBANC", t = "ABC";
        //String s = "BBBANC", t = "ABC";
        String s = "abcdebdde", t = "bde";
        System.out.println(Calculate(s, t));
    }

    private static String Calculate(String s, String t)
    {
        if (s.equals(t))
        {
            return s;
        }

        int windowStart = 0, subStrStart = 0, minLength = s.length()+1, matched = 0;

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: t.toCharArray()
             ) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);

            if (map.containsKey(rightChar))
            {
                map.put(rightChar, map.get(rightChar)-1);
                if (map.get(rightChar) >= 0)
                {
                    matched++;
                }
            }

            while (matched == t.length())
            {
                if (minLength > windowEnd - windowStart + 1)
                {
                    minLength = windowEnd - windowStart + 1;
                    subStrStart = windowStart;

                }
                char leftChar = s.charAt(windowStart++);
                if (map.containsKey(leftChar))
                {
                    if (map.get(leftChar) == 0)
                    {
                        matched--;
                    }
                    map.put(leftChar, map.get(leftChar) + 1);
                }
            }
        }

        if (minLength > s.length())
        {
            return "";
        }
        return s.substring(subStrStart, subStrStart+minLength);
    }
}
