package InterViewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        //String s = "catsanddogs";
        String s = "catsandog";
        //String[] wordDict = {"cat", "cats", "and", "sand", "dog"};
        //String s = "pineapplepenapple";
        //String[] wordDict = {"apple", "pen", "applepen", "pine", "pineapple"};
        String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        List<String> dict = new ArrayList<>();
        for (String word: wordDict
        ) {
            dict.add(word);
        }
        HashMap<Integer, Boolean> map = new HashMap<>();
        Calculate(s, dict, 0, map, new ArrayList<>());
        System.out.println(result);
    }

    private static void Calculate(String str, List<String> dict,
                                          int start, HashMap<Integer,
            Boolean> map, List<String> curr)
    {
        if (start == str.length()-1)
        {
            if (dict.contains(str.charAt(start)))
            {
                curr.add(String.valueOf(str.charAt(start)));
            }
        }

        if (start >= str.length()-1)
        {
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = start; i <= str.length(); i++) {
            String firstWord = str.substring(start, i);
            if (dict.contains(firstWord)) {
                curr.add(firstWord);
                Calculate(str, dict, i, map, curr);
                curr.remove(curr.size() - 1);
            }
        }
    }
}
