package InterViewPrep;

import java.util.HashMap;

public class PermutationString {
    public static void main(String[] args) {
        String str="bcdxabcdy";
        String pattern="bcdyabcdx";
        System.out.println(Calculate(str, pattern));
    }

    private static boolean Calculate(String str, String pattern)
    {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c: pattern.toCharArray()
             ) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int matched = 0, windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            char rightChar = str.charAt(windowEnd);

            if (map.containsKey(rightChar))
            {
                map.put(rightChar, map.get(rightChar) - 1);
                if (map.get(rightChar) == 0)
                {
                    matched++;
                }
            }

            if (matched == map.size())
            {
                return true;
            }

            if (windowEnd >= pattern.length()-1)
            {
                char leftChar = str.charAt(windowStart++);
                if (map.containsKey(leftChar))
                {
                    if (map.get(leftChar) == 0)
                    {
                        matched++;
                    }
                    map.put(leftChar, map.get(leftChar)+1);
                }
            }
        }

        return false;
    }
}
