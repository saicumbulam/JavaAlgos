package Leetcode.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindAnagramIndices {
    public static void main(String[] args) {
        String s = "cbaebabacd",  p= "abc";
        System.out.println(Calculate(s,p));
    }

    private static List<Integer> Calculate(String s, String p)
    {
        List<Integer> result = new ArrayList<>();
        int windowStart = 0;
        int matched = 0;

        HashMap<Character, Integer> charMap = new HashMap();
        for (char item: p.toCharArray()) {
            charMap.put(item, charMap.getOrDefault(item, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char rightChar = s.charAt(windowEnd);
            if (charMap.containsKey(rightChar))
            {
                charMap.put(rightChar, charMap.get(rightChar) - 1);
                if (charMap.get(rightChar) == 0)
                {
                    matched++;
                }
            }

            if (matched == charMap.size())
            {
                result.add(windowStart);
            }

            if (windowEnd >= p.length()-1)
            {
                char leftChar = s.charAt(windowStart++);
                if (charMap.containsKey(leftChar))
                {
                    if (charMap.get(leftChar) == 0)
                    {
                        matched--;
                    }
                    charMap.put(leftChar, charMap.get(leftChar) + 1);
                }
            }
        }

        return result;
    }
}
