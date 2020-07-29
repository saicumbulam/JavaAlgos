/*
Time complexity: o(n^2)
* */
package Leetcode.String.Easy.Easy;

import java.util.ArrayList;
import java.util.List;

public class StringSegmentation {
    public static void main(String[] args) {
        String str = "applepie";
        List<String> dict = new ArrayList<>();
        dict.add("apple");
        dict.add("pear");
        dict.add("pier");
        dict.add("pie");
        System.out.println(Calculate(str, dict, 0));
    }

    private static boolean Calculate(String str, List<String> dict, int start)
    {
        //Equal to shld be there to return true to notify the end of string
        if (start == str.length())
        {
            return true;
        }

        // <= should be present to indicate the substring operation
        for (int end = start+1; end <= str.length(); end++) {
            if (dict.contains(str.substring(start, end)) && Calculate(str,dict, end))
            {
                return true;
            }
        }
        return false;
    }
}
