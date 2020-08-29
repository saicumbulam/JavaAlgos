package InterViewPrep;

import java.util.HashMap;
import java.util.Map;

public class ExpressiveWords {
    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = { "hello", "hi", "helo"};
        System.out.println(Calculate(s, words));
    }

    private static int Calculate(String str, String[] words)
    {
        int count = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for (char c: str.toCharArray()
             ) {
            map.put(c, map.getOrDefault(c, 0) +1);
        }

        for (Map.Entry<Character, Integer> item: map.entrySet()) {
            if (item.getValue() %3 == 0)
            {
                item.setValue(item.getValue()/3);
            }
        }

        for (String word: words
             ) {
            count += runLength(map, word);
        }
        return count;
    }

    private static int runLength(HashMap<Character, Integer> map, String word)
    {
        HashMap<Character, Integer> newMap = new HashMap<>(map);
        for (char c: word.toCharArray()
             ) {
            if (newMap.containsKey(c))
            {
                newMap.put(c, newMap.get(c)-1);
                if (newMap.get(c) == 0)
                {
                    newMap.remove(c);
                }
            }
            else
            {
                return 0;
            }
        }
        if (newMap.size() == 0)
        {
            return 1;
        }
        return 0;
    }
}
