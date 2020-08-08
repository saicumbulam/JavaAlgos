package Leetcode.Dynamic.Medium;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {
    public static void main(String[] args) {
        String str = "leetcode";
        String[] wordDict = {"leet", "code"};
        List<String> wordDictList = new ArrayList<>();
        for (String item: wordDict
             ) {
            wordDictList.add(item);
        }
        System.out.println(Calculate(str, wordDictList,
                new Boolean[str.length()], 0));
    }

    private static boolean Calculate(String str, List<String> wordDict,
                                     Boolean[] memo, int start)
    {
        if(start == str.length())
        {
            return true;
        }
        if(memo[start] != null)
        {
            return memo[start];
        }

        for (int end = start; end <= str.length() ; end++) {
            if(wordDict.contains(str.substring(start, end)) &&
                    Calculate(str, wordDict, memo, end))
            {
                memo[start] = true;
                return true;
            }
        }

        memo[start] = false;
        return false;
    }
}
