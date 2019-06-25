package Algorithms.Array;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class RunLengthEncoding {
    private static String runLengthCalc(char[] array){
        LinkedHashMap<Character, Integer> hash = new LinkedHashMap<>();

        for (int i = 0; i < array.length; i++) {
            if (hash.containsKey(array[i])) {
                hash.put(array[i], hash.get(array[i])+1);
            } else {
                hash.put(array[i], 1);
            }
        }
        String s = "";
        for (Character item: hash.keySet()
             ) {
            int value = hash.get(item);
            s += item;
            s += hash.get(item);

        }
        return s.toString();
    }

    public static void main(String[] args) {
        String s = "wwwwaaadexxxxxx";
        System.out.println(runLengthCalc(s.toCharArray()));
    }
}
