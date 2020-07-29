/*
use stack to load the words in the string.
words can be formed by iterating each characters in a while loop
* */
package Leetcode.Medium;

import java.util.Stack;

public class ReverseWordsString {
    public static void main(String[] args) {
        System.out.println(reverseWords("a good   example"));
    }

    public static String reverseWords(String s) {
        String trim = s.trim();

        int i = 0;

        StringBuilder result = new StringBuilder();
        Stack<String> stack = new Stack<>();

        while (true)
        {
            StringBuilder word = new StringBuilder();

            while (i < trim.length() && trim.charAt(i) != ' ')
            {
                word.append(String.valueOf(trim.charAt(i++)));
            }

            if (word.length() > 0)
            {
                stack.push(word.toString());
            }

            if (i >= trim.length() - 1)
            {
                break;
            }
            else if (trim.charAt(i) == ' ' && !stack.peek().equals(" "))
            {
                stack.push(String.valueOf(' '));
            }

            i++;
        }

        while (!stack.isEmpty())
        {
            result.append(stack.pop());
        }

        return result.toString();
    }
}
