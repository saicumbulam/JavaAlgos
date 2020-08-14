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

    public static String Calculate(String S, int[] indexes, String[] sources, String[] targets) {
        StringBuilder result = new StringBuilder();

        HashMap<Character, Element> map = new HashMap<>();

        for (int i = 0; i < indexes.length; i++)
        {
            map.put(sources[i].charAt(0), new Element(indexes[0], sources[i], targets[i]));
        }

        int i = 0;

        while (i < S.length())
        {
            if (i < S.length() && map.containsKey(S.charAt(i)))
            {
                Element ele = map.get(S.charAt(i));
                int count = 0;

                while (i < S.length() && count < ele.len())
                {
                    i++;
                    count++;
                }

                if (count == ele.len())
                {
                    result.append(ele.target);
                }
                else
                {
                    result.append(S.charAt(i));
                }
            }
            else
            {
                result.append(S.charAt(i));
            }

            i++;
        }

        return result.toString();
    }

    static class Element
    {
        int index = 0;
        String source = null;
        String target = null;

        public Element(int index, String source, String target)
        {
            this.index = 0;
            this.source = source;
            this.target = target;
        }

        public int len()
        {
            return source.length()-1;
        }
    }
}
