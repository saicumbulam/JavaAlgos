package Leetcode.Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

public class LetterCombinationPhoneNumber {
    public static void main(String[] args) {
        String digit = "23";

        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("2", "abc");
        hashMap.put("3", "def");
        hashMap.put("4", "ghi");
        hashMap.put("5", "jkl");
        hashMap.put("6", "mno");
        hashMap.put("7", "pqrs");
        hashMap.put("8", "tuv");
        hashMap.put("9", "wxyz");
        List<String> result = new ArrayList<>();

        if (digit == null || digit.length() == 0)
        {
            System.out.println(result);
        }

        Calculate(hashMap,"",result,digit);
        System.out.println(result);
    }

    private static void Calculate(HashMap<String, String> hashMap,
                                  String combination, List<String> result,
                                  String digit)
    {
        if (digit.length() == 0)
        {
            result.add(combination);
            return;
        }

        String nextDigit = digit.substring(0,1);
        String letters = hashMap.get(nextDigit);
        for (char letter: letters.toCharArray()
             ) {
            Calculate(hashMap,
                    combination + String.valueOf(letter), result, digit.substring(1));
        }
    }
}
