package Leetcode.Hash.Often;

import java.util.HashMap;

public class FirstUniqueCharacterString {
    public static void main(String[] args) {
        String str = "leetcode";

        HashMap<Character, Integer> map = new HashMap<>();

        for (char c : str.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < str.length(); i++) {
            if (map.get(str.charAt(i)) == 1)
            {
                System.out.println("Result = " + i);
                break;
            }
        }
    }
}
