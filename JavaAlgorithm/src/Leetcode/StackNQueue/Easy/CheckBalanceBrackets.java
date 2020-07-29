package Leetcode.String.Easy.Easy;

import java.util.Stack;

public class CheckBalanceBrackets {
    public static void main(String[] args) {
        String str = "{[({})]}";
        System.out.println(Calculate(str));
    }

    private static boolean Calculate(String str)
    {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '}' || ch == ']' || ch == ')')
            {
                if (stack.isEmpty())
                {
                    return false;
                }

                if ((ch == '}' && stack.pop() != '{') ||
                        (ch == ']' && stack.pop() != '[') ||
                        (ch == ')' && stack.pop() != '('))
                {
                    return false;
                }
            }
            else
            {
                stack.push(ch);
            }
        }

        if (!stack.isEmpty())
        {
            return false;
        }
        return true;
    }
}
