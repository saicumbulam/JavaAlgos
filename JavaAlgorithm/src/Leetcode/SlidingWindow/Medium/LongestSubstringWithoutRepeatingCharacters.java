package Leetcode.Medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(Calculate(str));
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
}
