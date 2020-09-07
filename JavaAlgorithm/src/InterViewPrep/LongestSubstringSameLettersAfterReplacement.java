package InterViewPrep;

import java.util.HashMap;

public class LongestSubstringSameLettersAfterReplacement {
    public static void main(String[] args) {
        String str ="AABABBA";
        int k=1;
        System.out.println(Calculate(str, k));
    }

    private static int Calculate(String str, int k)
    {
        int windowStart = 0, maxLength = 0, maxRepeatLetters = 0;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0) + 1);
            maxRepeatLetters = Math.max(maxRepeatLetters, map.get(rightChar));

            // if the current window is greater than k
            // reduce window based on k
            if (windowEnd - windowStart + 1 - maxRepeatLetters > k)
            {
                char leftChar = str.charAt(windowStart++);
                map.put(leftChar , map.get(leftChar)-1);
            }

            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
        }

        return maxLength;
    }
}
