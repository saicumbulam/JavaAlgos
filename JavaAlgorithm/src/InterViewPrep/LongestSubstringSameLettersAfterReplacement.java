package InterViewPrep;

import java.util.HashMap;

public class LongestSubstringSameLettersAfterReplacement {
    public static void main(String[] args) {
        String str ="abbcb";
        int k=1;
        System.out.println(Calculate(str, k));
    }

    private static int Calculate(String str, int k)
    {
        int windowStart = 0, maxLength = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
            int maxFreq = map.get(rightChar);

            if ((windowEnd - windowStart+1 - maxFreq) > k)
            {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar))
                {
                    map.put(leftChar, map.get(leftChar)-1);
                    if (map.get(leftChar) == 0)
                    {
                        map.remove(leftChar);
                    }
                }
            }

            maxLength = Math.max(maxLength, windowEnd - windowStart+1);
        }

        return maxLength;
    }
}
