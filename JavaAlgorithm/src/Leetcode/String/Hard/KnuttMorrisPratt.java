package Leetcode.String.Hard;

import java.util.Arrays;

public class KnuttMorrisPratt {
    public static void main(String[] args) {
        String str = "aefoaefcdaefcdaed";
        String subStr = "aefcdaed";
        int[] pattern = BuildPattern(subStr);
        System.out.println(Calculate(str, subStr, pattern));
    }

    private static boolean Calculate(String str, String subStr, int[] pattern) {
        int i = 0, j = 0;

        while (i + subStr.length() - j <= str.length())
        {
            if (str.charAt(i) == subStr.charAt(j))
            {
                if (j == subStr.length()-1)
                {
                    return true;
                }
                i++;
                j++;
            }
            else if (j > 0)
            {
                j = pattern[j-1]+1;
            }
            else
            {
                i++;
            }
        }
        return false;
    }

    private static int[] BuildPattern(String subStr) {
        int[] pattern = new int[subStr.length()];
        Arrays.fill(pattern, -1);
        int j = 0;
        int i = 1;

        while ( i < subStr.length()) {
            if (subStr.charAt(i) == subStr.charAt(j))
            {
                pattern[i] = j;
                i++;
                j++;
            }
            else if (j > 0)
            {
                j = pattern[j-1] + 1;
            }
            else
            {
                i++;
            }
        }

        return pattern;
    }



}
