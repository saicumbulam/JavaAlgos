/*
Time complexity: O(MN) where M is the length of words and N is the number of words
Spce complexity: O(MN)
* */
package Leetcode.StackNQueue.Hard;

import java.util.*;
import java.util.Queue;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        //System.out.println(Calculate(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));

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
        if (!wordList.contains(endWord))
        {
            return -1;
        }

        int level = 1;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
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
                            return level+1;
                        }
                        else
                        {
                            if(wordList.contains(newWord))
                            {
                                queue.add(newWord);
                                wordList.remove(newWord);
                            }
                        }
                    }
                    wordChars[j] = Char;
                }
            }
            level++;
        }
        return 0;
    }
}
