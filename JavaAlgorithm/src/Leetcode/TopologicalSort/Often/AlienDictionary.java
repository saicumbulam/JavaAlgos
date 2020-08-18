package Leetcode.TopologicalSort.Often;

import java.util.*;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] words = {"ba", "bc", "ac", "cab"};
        System.out.println(Calculate(words));
    }

    private static String Calculate(String[] words) {
        if (words == null || words.length==0)
        {
            return "";
        }

        HashMap<Character, Integer> inDegree = new HashMap<>();
        HashMap<Character, List<Character>> graph = new HashMap<>();

        for (String word: words
             ) {
            for (char character: word.toCharArray()
                 ) {
                inDegree.put(character, 0);
                graph.put(character, new ArrayList<>());
            }
        }

        for (int i = 0; i < words.length-1; i++) {
            String w1 = words[i], w2 = words[i+1];
            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);

                if (parent != child)
                {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child)+1);
                    break;
                }
            }
        }

        Queue<Character> sources = new LinkedList<>();
        for (Map.Entry<Character, Integer> entry: inDegree.entrySet()
             ) {
            if (entry.getValue() == 0)
            {
                sources.add(entry.getKey());
            }
        }

        StringBuilder sortedOrder = new StringBuilder();
        while (!sources.isEmpty())
        {
            char vertex = sources.poll();
            sortedOrder.append(vertex);
            List<Character> children = graph.get(vertex);
            for (char child: children
                 ) {
                inDegree.put(child, inDegree.get(child)-1);
                if (inDegree.get(child) == 0)
                {
                    sources.add(child);
                }
            }
        }

        if (sortedOrder.length() != inDegree.size())
        {
            return "";
        }
        return sortedOrder.toString();
    }


}
