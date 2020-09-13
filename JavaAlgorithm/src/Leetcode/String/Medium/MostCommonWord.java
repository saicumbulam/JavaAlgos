package Leetcode.String.Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MostCommonWord {
    public static void main(String[] args) {
        String str = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        List<String> bannedList = new ArrayList<>();
        for(String item: banned)
        {
            bannedList.add(item);
        }

        System.out.println(Calculate(str.toLowerCase(), bannedList));
    }

    private static String Calculate(String paragraph, List<String> bannedList)
    {
        int i = 0, j = 0, maxFreq = 0;
        String result = "";

        HashMap<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        while(j < paragraph.length())
        {
            while (j < paragraph.length() && Character.isLetter(paragraph.charAt(j)))
            {
                j++;
            }

            if (j - i +1 > 0)
            {
                String word = paragraph.substring(i, j);
                if(!bannedList.contains(word) && !word.equals(""))
                {
                    map.put(word, map.getOrDefault(word, 0)+1);
                    if(map.get(word) > maxFreq)
                    {
                        maxFreq = map.get(word);
                        result = word;
                    }
                }
            }

            j++;
            i = j;
        }

        return result;

    }
}
