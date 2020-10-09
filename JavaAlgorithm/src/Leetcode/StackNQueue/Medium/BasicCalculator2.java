/*
Risky
* */
package Leetcode.StackNQueue.Medium;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        String expr = "3+2*2";
        //String expr = "3/2";
        //String expr = " 3+5 / 2 ";
        System.out.println(EvaluateReversePolishNotation(expr));
    }

    private static int EvaluateReversePolishNotation(String s) {
        if (s == null || s.length() == 0)
        {
            return 0;
        }

        int value = 0;
        char sign = '+';
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < s.length(); i++)
        {
            char c = s.charAt(i);
            if (c != ' ' && Character.isDigit(c))
            {
                value = value*10 + s.charAt(i) - '0';
            }
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1) 
                // else if should not be put here. the second condition needs to be executed at all cost
            {
                if(sign == '+'){
                    stack.push(value);
                }
                if(sign == '-'){
                    stack.push(-value);
                }
                if(sign == '*'){
                    stack.push(stack.pop()*value);
                }
                if(sign == '/'){
                    stack.push(stack.pop()/value);
                }
                sign = c;
                value = 0;
            }
        }

        int res = 0;
        for(Integer i: stack){
            res += i;
        }
        return res;
    }
}
