package Leetcode.SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtleastKRepeatingCharacters {
    public static void main(String[] args) {
        String str = "aaabb";
        int k = 3;
        System.out.println(Calculate(str, k));
    }

    private static int Calculate(String s, int k)
    {
        if (s == null || s.length() == 0) return 0;
        HashMap<Character, Integer> hashMap = new HashMap<>();

        // record the frequency of each character
        for (Character c: s.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);
        }

        boolean flag = true;

        for (Map.Entry<Character, Integer> entry: hashMap.entrySet()) {
            // If we find any character which appears less than K times in string.
            if (entry.getValue() < k){
                flag = false;
            }
        }

        // return the length of string if this string is a valid string
        // Valid meaning count of all characters appearing in string is greater than K
        if (flag == true){
            return s.length();
        }

        int result = 0;
        int start = 0, cur = 0;

        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (hashMap.get(s.charAt(cur)) < k) {
                // Split the string and recurse over the left part from start till current
                // and keep the maximum count
                result = Math.max(result, Calculate(s.substring(start, cur), k));
                // set start to curr+1 and now process the right substring
                start = cur + 1; // to avoid the low frequency character and move on to next
            }
            // keep incrementing the right pointer.
            cur++;
        }

        result = Math.max(result, Calculate(s.substring(start), k));
        return result;
    }
}
