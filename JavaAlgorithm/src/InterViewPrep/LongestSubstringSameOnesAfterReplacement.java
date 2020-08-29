package InterViewPrep;

import java.util.HashMap;

public class LongestSubstringSameOnesAfterReplacement {
    public static void main(String[] args) {
        int[] arr = {0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};
        int k=2;
        System.out.println(Calculate(arr, k));
    }

    private static int Calculate(int[] arr, int k)
    {
        int windowStart = 0, maxLength = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            int rightChar = arr[windowEnd];
            map.put(rightChar, map.getOrDefault(rightChar, 0)+1);
            int maxFreq = map.get(rightChar);

            if ((windowEnd - windowStart+1 - maxFreq) > k)
            {
                int leftChar = arr[windowStart++];
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
