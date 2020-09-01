package InterViewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak {

    public static void main(String[] args) {
        //String s = "leetcode";
        //String[] wordDict = {"leet", "code"};
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";
        String[] wordDict = {"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> dict = new ArrayList<>();
        for (String word: wordDict
             ) {
            dict.add(word);
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        System.out.println(Calculate(s, dict, 0, map));
    }

    private static boolean Calculate(String str, List<String> dict, int start, HashMap<Integer, Boolean> map)
    {
        if(map.containsKey(start))
        {
            return map.get(start);
        }

        boolean result = false;
        if(start == str.length())
        {
            result = true;
        }
        else
        {
            for (int i = start; i < str.length(); i++) {
                String firstWord = str.substring(start, i+1); //0,1,2,3 => leet
                if (dict.contains(firstWord) && Calculate(str, dict, i+1, map))
                {
                    result = true;
                }
            }
        }
        map.put(start, result);
        return map.get(start);
    }
}
