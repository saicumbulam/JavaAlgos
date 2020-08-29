package InterViewPrep;

import java.util.HashMap;

public class MinimumWindowSubsequence {
    public static void main(String[] args) {
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
        String result = "";

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
                //System.out.println(s.substring(windowStart, windowEnd+1));
                boolean isOrdered = CheckOrders(s.substring(windowStart, windowEnd+1), t);
                if (isOrdered && minLength > windowEnd - windowStart + 1)
                {
                    minLength = windowEnd - windowStart + 1;
                    result = s.substring(windowStart, windowEnd+1);
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

        return result;
    }

    private static boolean CheckOrders(String str ,String t)
    {
        int i = 0, j = 0;
        while (j < str.length() && i < t.length()){
            if (t.charAt(i) == str.charAt(j))
            {
                i++;
                j++;
            }
            else
            {
                j++;
            }
        }

        if (i == t.length())
        {
            return true;
        }
        return false;
    }
}
