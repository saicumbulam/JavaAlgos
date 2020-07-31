/*
Time complexity: O(MN) where M is the length of words and N is the number of words
Spce complexity: O(MN)
* */
package Leetcode.Hard;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot","dot","dog","lot","log","cog"};
        System.out.println(Calculate(beginWord, endWord, new ArrayList<>(Arrays.asList(wordList))));
    }

    private static int Calculate(String beginWord, String endWord, List<String> wordList )
    {
        if (!wordList.contains(endWord))
        {
            return -1;
        }

        int level = 0;
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
