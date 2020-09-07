package InterViewPrep;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WordBreak2 {
    static List<List<String>> result = new ArrayList<>();

    public static void main(String[] args) {
        String s = "catsanddogs";
        //String s = "catsandog";
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
        Calculate(s, dict, 0, new ArrayList<>());
        System.out.println(result);
    }


    private static void Calculate(String s, List<String> dict, int startIdx, List<String> curr)
    {
        if (startIdx >= s.length()) return;
        
        if (startIdx == s.length()-1)
        {
            if (dict.contains(s.charAt(startIdx)))
            {
                curr.add(String.valueOf(s.charAt(startIdx)));
            }
            result.add(new ArrayList<>(curr));
            return;
        }

        for (int i = startIdx; i < s.length(); i++) {
            if (dict.contains(s.substring(startIdx, i)))
            {
                curr.add(s.substring(startIdx, i));
                Calculate(s, dict, i, curr);
                curr.remove(curr.size()-1);
            }
        }
    }

}
