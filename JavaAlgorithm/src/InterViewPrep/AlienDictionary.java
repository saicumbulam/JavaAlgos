package InterViewPrep;

import java.util.*;
import java.util.LinkedList;

public class AlienDictionary {
    public static void main(String[] args) {
        String[] str = { "wrt", "wrf", "er", "ett", "rftt" };
        System.out.println(Calculate(str));
    }

    private static String Calculate(String[] strs) {
        StringBuilder result = new StringBuilder();
        HashMap<Character, List<Character>> graph = new HashMap<>();
        HashMap<Character, Integer> inDegree = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            for (char c : strs[i].toCharArray()
            ) {
                graph.putIfAbsent(c, new ArrayList<>());
                inDegree.putIfAbsent(c, inDegree.getOrDefault(c, 0) + 1);
            }
        }


        for (int i = 1; i < strs.length; i++) {
            String w1 = strs[i - 1], w2 = strs[i];

            for (int j = 0; j < Math.min(w1.length(), w2.length()); j++) {
                char parent = w1.charAt(j), child = w2.charAt(j);
                if (parent != child) {
                    graph.get(parent).add(child);
                    inDegree.put(child, inDegree.get(child) + 1);
                    break;
                }
            }
        }


        Queue<Character> queue = new LinkedList<>();
        for (Map.Entry<Character, Integer> map : inDegree.entrySet()) {
            if (map.getValue() == 1) {
                queue.add(map.getKey());
            }
        }

        while (!queue.isEmpty()) {
            Character vertex = queue.poll();
            result.append(vertex);
            List<Character> children = graph.get(vertex);
            for (Character child : children
            ) {
                inDegree.put(child, inDegree.get(child) - 1);
                if (inDegree.get(child) == 1) {
                    queue.add(child);
                }
            }
        }

        return result.toString();
    }
}
