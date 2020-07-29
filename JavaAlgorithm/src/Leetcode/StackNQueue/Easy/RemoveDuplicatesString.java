package Leetcode.String.Easy.Easy;

import java.util.Stack;

public class RemoveDuplicatesString {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("abbaca"));
    }

    public static String removeDuplicates(String S) {

        Stack<Character> stack = new Stack<>();

        for (char c:  S.toCharArray())
        {
            if  (!stack.isEmpty() && stack.peek() == c)
            {
                stack.pop();
            }
            else
            {
                stack.push(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty())
        {
            result.insert(0, stack.pop());
        }

        return result.toString();
    }
}
