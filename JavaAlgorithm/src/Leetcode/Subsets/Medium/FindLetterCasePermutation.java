/*
output: [ad52, Ad52, aD52, AD52]
* */
package Leetcode.Subsets.Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindLetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(Calculate("ad52"));
    }

    private static List<String> Calculate(String str)
    {
        List<String> result = new ArrayList<>();
        result.add(str);

        for (int i = 0; i < str.length(); i++) {
            if(!Character.isDigit(str.charAt(i)))
            {
                int n = result.size();
                for (int j = 0; j < n; j++) {
                    String polled = result.get(j);
                    char[] charArray = polled.toCharArray();

                    if(Character.isUpperCase(charArray[i]))
                    {
                        charArray[i] = Character.toLowerCase(charArray[i]);
                    }
                    else
                    {
                        charArray[i] = Character.toUpperCase(charArray[i]);
                    }

                    polled = String.valueOf(charArray);

                    result.add(polled);
                }
            }
        }
        return result;
    }
}
