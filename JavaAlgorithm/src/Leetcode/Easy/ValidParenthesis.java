package Leetcode.Easy;

import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String str = "()[]{}";

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char item = str.charAt(i);
            if (item == '}' || item == ']' || item == ')')
            {
                if(stack.isEmpty())
                {
                    System.out.println(false);
                    break;
                }
                //remember the & condition before the pop operation
                if((item == '}' && stack.pop() != '{') ||
                        (item == ')' && stack.pop() != '(') ||
                        (item == ']' && stack.pop() != '['))
                {
                    System.out.println(false);
                    break;
                }
            }
            else
            {
                stack.push(item);
            }
        }

        if(!stack.isEmpty())
        {
            System.out.println(false);
        }

        System.out.println(true);

    }
}
