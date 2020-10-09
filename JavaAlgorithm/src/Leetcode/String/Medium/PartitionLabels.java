/*
Done
* */
package Leetcode.String.Medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PartitionLabels {
    public static void main(String[] args) {
        System.out.println(Calculate("ababcbacadefegdehijhklij"));
    }

    private static List<Integer> Calculate(String S) {
        List<Integer> result = new ArrayList<>();

        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < S.length(); i++)
        {
            map.put(S.charAt(i), i);
        }

        int startIdx = 0;
        int endIdx = 0;

        for (int i = 0; i < S.length() ; i++)
        {
            char c = S.charAt(i);
            if (map.containsKey(c))
            {
                endIdx = Math.max(endIdx, map.get(c));
            }

            if (i == endIdx)
            {
                endIdx++;
                result.add(endIdx - startIdx);
                startIdx = endIdx;
            }
        }

        return result;
    }
}
