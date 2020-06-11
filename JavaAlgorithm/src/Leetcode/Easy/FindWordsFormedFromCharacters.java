package Leetcode.Easy;

import java.util.HashMap;

public class FindWordsFormedFromCharacters {
    public static void main(String[] args) {
        String[] words = {"hello","world","leetcode"};
        String chars = "welldonehoneyr";
        System.out.println(Calculate(words, chars));
    }

    private static int Calculate(String[] words, String chars)
    {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char ch: chars.toCharArray())
        {
            hashMap.put(ch, hashMap.getOrDefault(ch,0)+1);
        }
        int count = 0;

        for (String str: words
             ) {
            HashMap<Character, Integer> seen = new HashMap<>(hashMap);
            char[] strChars = str.toCharArray();
            boolean flag = true;

            for (int i = 0; i < strChars.length; i++) {
                if(!seen.containsKey(str.charAt(i)))
                {
                    flag = false;
                    break;
                }
                else
                {
                    seen.put(str.charAt(i), seen.get(str.charAt(i))-1);
                    if (seen.get(str.charAt(i)) == 0)
                    {
                        seen.remove(str.charAt(i));
                    }
                }
            }

            if(flag)
            {
                count += str.length();
            }
        }
        return count;
    }
}
