package Leetcode.String.Medium;

import java.util.HashMap;

public class FindReplaceString {
    public static void main(String[] args) {
        String S = "abcd";
        int[] indexes = {0,2};
        String[] sources = {"a","cd"};
        String[] targets = {"eee","ffff"};
        System.out.println(Calculate(S, indexes, sources, targets));
    }

    public static String Calculate(String s, int[] indexes, String[] sources, String[] targets) {
        HashMap<Integer, String[]> map = new HashMap<>();

        for (int i = 0; i < indexes.length; i++) {
            map.put(indexes[i], new String[]{sources[i], targets[i]});
        }

        StringBuilder str = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (map.containsKey(i))
            {
                int j = i + map.get(i)[0].length();
                if ( j <= s.length() && s.substring(i, j).equals(map.get(i)[0]))
                {
                    str.append(map.get(i)[1]);
                    i += map.get(i)[0].length();
                }
                else
                {
                    i++;
                }
            }
            else
            {
                str.append(s.charAt(i));
                i++;
            }
        }

        return str.toString();
    }

}
