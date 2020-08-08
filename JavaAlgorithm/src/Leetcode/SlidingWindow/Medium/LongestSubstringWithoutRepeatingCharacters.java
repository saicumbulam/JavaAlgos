package Leetcode.Medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(Calculate(str));
        System.out.println(CalculateStr(str));
    }

    private static int Calculate(String str)
    {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length();
             windowEnd++) {

            char rightChar = str.charAt(windowEnd);

            if (hashMap.containsKey(rightChar))
            {
                windowStart = Math.max(windowStart, hashMap.get(rightChar) + 1);
            }
            hashMap.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }

        return maxLength;
    }

    private static String CalculateStr(String str)
    {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++)
        {
            char rightChar = str.charAt(windowEnd);
            if (map.containsKey(rightChar))
            {
                windowStart = Math.max(windowStart, map.get(rightChar)+1);
            }

            map.put(rightChar, windowEnd);
            if (maxLength <  windowEnd - windowStart + 1)
            {
                maxLength =  windowEnd - windowStart + 1;
                result[0] = windowStart;
                result[1] = windowEnd+1;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return str.substring(result[0], result[1]);
    }
}
