package Leetcode.String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostCommonWord {
    public static void main(String[] args) {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(Calculate(str.toLowerCase(), banned));
    }

    private static String Calculate(String str, String[] banned)
    {
        String ans = "";
        int ansCount = 0;
        List<String> bann = new ArrayList<>(Arrays.asList(banned));
        HashMap<String, Integer> map = new HashMap<>();
        String word = "";

        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)))
            {
                word += str.charAt(i);
            }
            else if (word.length() > 0)
            {
                if (!bann.contains(word))
                {
                    map.put(word, map.getOrDefault(word, 0) + 1);
                    if (map.get(word) > ansCount)
                    {
                        ans = word;
                        ansCount = map.get(word);
                    }
                }
                word = "";
            }
        }


        if (!word.equals("") && !bann.contains(word))
        {
            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > ansCount)
            {
                ansCount = map.get(word);
                ans = word;
            }
        }

        return ans;
    }
}
