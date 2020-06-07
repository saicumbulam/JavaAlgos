package Leetcode.Medium;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharac {
    public static void main(String[] args) {
        String str = "abcabcbb";
        System.out.println(Calculate(str));
    }

    private static int Calculate(String str) {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if(map.containsKey(rightChar))
            {
                windowStart = Math.max(windowStart, map.get(rightChar)+1);
            }
            map.put(rightChar, windowEnd);
            maxLength = Math.max(maxLength, windowEnd - windowStart+1);
        }

        return maxLength;
    }
}
