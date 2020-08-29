package Leetcode.SlidingWindow.Medium;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtleastKRepeatingCharacters {
    public static void main(String[] args) {
        String str = "aaabb";
        int k = 3;
        System.out.println(Calculate(str, k));
    }

    private static int Calculate(String str, int k)
    {
        if (str == null || str.length() == 0) return 0; //prevent infinte loop, like a base case
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (char c: str.toCharArray()) {
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
        }

        boolean isRepeat = true;

        for (Map.Entry<Character,Integer> map: hashMap.entrySet()) {
            if(map.getValue() < k)
            {
                isRepeat = false;
                break;
            }
        }

        if(isRepeat)
        {
            return str.length();
        }

        int maxLength = 0, start = 0, curr = 0;

        while (curr < str.length())
        {
            if(hashMap.get(str.charAt(curr)) < k)
            {
                maxLength = Math.max(maxLength,
                        Calculate(str.substring(start, curr), k));

                start = curr+1;
            }
            curr++;
        }

        maxLength = Math.max(maxLength, Calculate(str.substring(start), k));

        return maxLength;
    }
}
