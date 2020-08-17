package Leetcode.Hash.Often;

import java.util.HashMap;
import java.util.Map;

public class TraceCompletePath {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("NewYork", "Chicago");
        map.put("Boston", "Texas");
        map.put("Missouri", "NewYork");
        map.put("Texas", "Missouri");
        System.out.println(Calculate(map));
    }

    private static String Calculate(HashMap<String, String> map)
    {
        HashMap<String, String> reverseMap = new HashMap<>();

        for (Map.Entry<String, String> entry: map.entrySet()
             ) {
            reverseMap.put(entry.getValue(), entry.getKey());
        }

        int count = 0;
        String from = "";

        for (Map.Entry<String, String> entry: map.entrySet()
             ) {
            if (!reverseMap.containsKey(entry.getKey()))
            {
                count++;
                from = entry.getKey();
            }
        }

        if (count > 1)
        {
            return null;
        }
        StringBuilder result = new StringBuilder();
        String to = map.get(from);

        while (to != null)
        {
            result.append(String.format(" %s --> %s", from, to));
            from = to;
            to = map.get(from);
        }

        return result.toString();
    }
}
