package InterViewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordConcatenation {
    public static void main(String[] args) {
        //String str ="catfoxcat";
        String str ="catcatfoxfox";
        String[] words={"cat", "fox"};
        List<String> wordList = new ArrayList<>();
        for (String word: words
             ) {
            wordList.add(word);
        }

        System.out.println(Calculate(str, wordList));
    }

    private static List<Integer> Calculate(String str, List<String> wordList)
    {
        List<Integer> result = new ArrayList<>();

        int wordLen = wordList.get(0).length();

        int wordCount = 0;

        HashMap<String, Integer> map = new HashMap<>();
        for (String item: wordList
             ) {
            wordCount++;
            map.put(item, map.getOrDefault(item, 0)+1);
        }

        for (int windowEnd = 0; windowEnd < str.length(); windowEnd += wordLen) {
            int foundWords = 0;
            HashMap<String, Integer> seen = new HashMap<>();

            String firstWord = str.substring(windowEnd, windowEnd + wordLen);
            if (map.containsKey(firstWord))
            {
                seen.put(firstWord, seen.getOrDefault(firstWord, 0) + 1);
                foundWords++;
                int nextIndex = windowEnd+wordLen;

                while ((nextIndex + wordLen) <= str.length()) {
                    String word = str.substring(nextIndex, nextIndex+ wordLen);
                    if (map.containsKey(word))
                    {
                        seen.put(word, seen.getOrDefault(word, 0) + 1);
                        foundWords++;
                    }
                    else
                    {
                        break;
                    }
                    if (seen.get(word) > map.get(word))
                    {
                        break;
                    }
                    if (foundWords == wordCount)
                    {
                        result.add(windowEnd);
                        break;
                    }

                    nextIndex += wordLen;
                }
            }
        }
        return result;
    }
}
