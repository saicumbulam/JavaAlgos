package Leetcode.Easy;

import java.util.HashMap;

public class ValidAnangram {
    public static void main(String[] args) {
        System.out.println(Calculate("anagram", "nagaram"));
    }

    public static boolean Calculate(String str1, String str2)
    {
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c : str1.toCharArray())
        {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : str2.toCharArray())
        {
            if (!map.containsKey(c))
            {
                return false;
            }
            map.put(c, map.get(c) -1);
            if (map.get(c) == 0)
            {
                map.remove(c);
            }
        }
        if (map.size() == 0)
        {
            return true;
        }
        return false;
    }
}
