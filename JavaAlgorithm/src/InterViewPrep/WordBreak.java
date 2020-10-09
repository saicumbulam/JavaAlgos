package InterViewPrep;

import java.util.*;
import java.util.LinkedList;

public class WordBreak {

    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> dict = new ArrayList<>();
        for (String word: wordDict
             ) {
            dict.add(word);
        }
        System.out.println(Calculate(s, dict));
    }

    private static boolean Calculate(String s, List<String> dict)
    {
        int[] visited = new int[s.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);

        while (!queue.isEmpty())
        {
            int start = queue.poll();
            if (visited[start] == 0)
            {
                for (int end = start+1; end <= s.length(); end++) {
                    if (dict.contains(s.substring(start, end)))
                    {
                        if (end == s.length()) return true;
                        queue.add(end);
                    }
                }

                visited[start] = 1;
            }
        }

        return false;
    }
}
