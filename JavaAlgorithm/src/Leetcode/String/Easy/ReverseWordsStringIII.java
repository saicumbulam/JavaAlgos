package Leetcode.String.Easy;

public class ReverseWordsStringIII {
    public static void main(String[] args) {
        String str = "Let's take LeetCode contest";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String s) {
        int j = 0;

        StringBuilder result = new StringBuilder();
        while ( j < s.length())
        {
            StringBuilder word = new StringBuilder();
            while (j < s.length() && s.charAt(j) != ' ')
            {
                word.append(s.charAt(j));
                j++;
            }

            if (word.length() > 0)
            {
                result.append(word.reverse().toString());
            }

            if(j < s.length() && s.charAt(j) == ' ')
            {
                result.append(' ');
            }

            j++;
        }

        return result.toString();
    }
}
