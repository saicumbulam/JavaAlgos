package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;

public class FindLetterCasePermutation {
    public static void main(String[] args) {
        System.out.println(Calculate("ad52"));
    }

    private static List<String> Calculate(String str)
    {
        List<String> result = new ArrayList<>();
        result.add(str);

        for (int i = 0; i < str.length(); i++) {
            // Check to see if its a letter.
            if(Character.isLetter(str.charAt(i)))
            {
                int n = result.size();
                // < n. if its <= n then duplicates will come
                for (int j = 0; j < n; j++) {
                    char[] strArray = result.get(j).toCharArray();
                    if(Character.isUpperCase(strArray[i]))
                    {
                        strArray[i] = Character.toLowerCase(strArray[i]);
                    }
                    else
                    {
                        strArray[i] = Character.toUpperCase(strArray[i]);
                    }
                    result.add(String.valueOf(strArray));
                }
            }
        }
        return result;
    }
}
