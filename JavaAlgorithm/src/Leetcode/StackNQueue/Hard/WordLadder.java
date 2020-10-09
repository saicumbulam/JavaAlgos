/*
Time complexity: O(MN) where M is the length of words and N is the number of words
Spce complexity: O(MN)
* */
package Leetcode.StackNQueue.Hard;

import javafx.util.Pair;

import java.util.*;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(Calculate(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));

        HashMap<String, List<String>> map = new HashMap<>();
        CalculateStr(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList)), map);
        List<List<String>> result = new ArrayList<>();
        Dfs(beginWord, endWord, map, new ArrayList<>(), result);
        System.out.println(result);
    }

    private static void Dfs(String beginWord, String endWord,
                            HashMap<String, List<String>> map,
                            List<String> curr, List<List<String>> result) {

        // base case end the recursion
        if (beginWord.equals(endWord))
        {
            result.add(new ArrayList<>(curr));
            return;
        }
        // to add the base word.
        if (curr.isEmpty())
        {
            curr.add(beginWord);
        }
        for (String word: map.get(beginWord)) {
            curr.add(word);
            Dfs(word, endWord, map, curr, result);
            curr.remove(curr.size()-1);
        }
    }

    private static void CalculateStr(String beginWord, String endWord,
                                                   List<String> wordList,
                                                   HashMap<String, List<String>> map) {
        if (!wordList.contains(endWord))
        {
            return;
        }

        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int level = 1;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                List<String> list = new ArrayList<>();
                String polled = queue.poll();
                char[] wordChars = polled.toCharArray();

                for (int j = 0; j < wordChars.length; j++) {
                    char Char = polled.charAt(j);
                    for (char k = 'a'; k < 'z'; k++) {
                        //forgot this. remember to code
                        if (k == Char)
                        {
                            continue;
                        }
                        wordChars[j] = k;
                        String newWord = String.valueOf(wordChars);
                        if (newWord.equals(endWord))
                        {
                            if (!map.containsKey(polled))
                            {
                                map.put(polled, new ArrayList<>());
                            }

                            map.get(polled).add(endWord);

                            break;
                        }
                        else
                        {
                            if(wordList.contains(newWord))
                            {
                                queue.add(newWord);
                                wordList.remove(newWord);
                                if (!map.containsKey(polled))
                                {
                                    map.put(polled, new ArrayList<>());
                                }
                                map.get(polled).add(newWord);
                            }
                        }
                    }
                    wordChars[j] = Char;
                }
                level++;
            }
        }
    }

    private static int Calculate(String beginWord, String endWord, List<String> wordList )
    {
        HashMap<String, List<String>> map = new HashMap<>();

        for (String word: wordList)
        {
            for (int i = 0; i < word.length(); i++)
            {
                String newWord = word.substring(0,i) + '*' + word.substring(i+1);
                if (!map.containsKey(newWord))
                {
                    map.put(newWord, new ArrayList<>());
                }
                map.get(newWord).add(word);
            }
        }


        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        HashSet<String> set = new HashSet<>();

        queue.add(new Pair(beginWord, 1));
        set.contains(beginWord);

        while(!queue.isEmpty())
        {
            Pair<String, Integer> polled = queue.poll();
            String word = polled.getKey();
            int level = polled.getValue();

            for(int i = 0; i < beginWord.length(); i++)
            {
                String newWord = word.substring(0, i) + '*' + word.substring(i+1);

                if (!map.containsKey(newWord)) continue;
                for(String item : map.get(newWord))
                {
                    if (item.equals(endWord))
                    {
                        return level+1;
                    }

                    if (!set.contains(item))
                    {
                        set.add(item);
                        queue.add(new Pair(item, level+1));
                    }
                }
            }
        }

        return -1;
    }
}
