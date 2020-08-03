package Leetcode.Dynamic.Hard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class PalindromePairs {
    public static void main(String[] args) {
        System.out.println(palindromePairs(new String[] {"abcd","dcba","lls","s","sssll"}));
    }

    public static List<List<Integer>> palindromePairs(String[] words) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for(int i = 0; i < words.length; i++)
        {
            hashMap.put(words[i], i);
        }

        List<List<Integer>> result = new ArrayList<>();

        for( String word : hashMap.keySet())
        {
            int currentWordIndex = hashMap.get(word);
            String reversedWord = new StringBuilder(word).reverse().toString();

            if (hashMap.containsKey(reversedWord) && hashMap.get(reversedWord) != currentWordIndex)
            {
                result.add(Arrays.asList(currentWordIndex, hashMap.get(reversedWord)));
            }

            for(String suffix: allValidSuffixes(word))
            {
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                if (hashMap.containsKey(reversedSuffix))
                {
                    result.add(Arrays.asList(hashMap.get(reversedSuffix), currentWordIndex));
                }
            }

            for (String prefix: allValidPrefixes(word))
            {
                String reversedPrefix = new StringBuilder(prefix).reverse().toString();
                if (hashMap.containsKey(reversedPrefix))
                {
                    result.add(Arrays.asList(currentWordIndex, hashMap.get(reversedPrefix)));
                }
            }
        }

        return result;
    }


    private static boolean isPlaindrome(String word, int left, int right)
    {
        while(left < right)
        {
            if (word.charAt(left) != word.charAt(right))
            {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }


    private static List<String> allValidPrefixes(String word)
    {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++)
        {
            if (isPlaindrome(word, i, word.length()-1))
            {
                result.add(word.substring(0,i));
            }
        }
        return result;
    }


    private static List<String> allValidSuffixes(String word)
    {
        List<String> result = new ArrayList<>();
        for(int i = 0; i < word.length(); i++)
        {
            if (isPlaindrome(word, 0, i))
            {
                result.add(word.substring(i+1, word.length()));
            }
        }
        return result;
    }
}
