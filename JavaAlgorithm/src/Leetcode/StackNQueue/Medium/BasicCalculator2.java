/*
Risky
* */
package Leetcode.StackNQueue.Medium;

import java.util.Stack;

public class BasicCalculator2 {
    public static void main(String[] args) {
        //String expr = "3+2*2";
        //String expr = "3/2";
        String expr = " 3+5 / 2 ";
        String calculatePostFix = CalculatePostFix(expr);
        System.out.println(EvaluateReversePolishNotation(calculatePostFix));
    }

    private static int EvaluateReversePolishNotation(String str) {
        Stack<Integer> stack = new Stack<>();

        for (char c: str.toCharArray()
             ) {
            if (Character.isDigit(c))
            {
                stack.push(Character.getNumericValue(c));
            }
            else
            {
                int result = 0;
                int num1 = stack.pop();
                int num2 = stack.pop();

                switch (c)
                {
                    case '+':
                        result = num1+num2;
                        break;
                    case '-':
                        result = num2-num1;
                        break;
                    case '/':
                        result = num2/num1;
                        break;
                    case '*':
                        result = num1*num2;
                        break;
                }

                stack.push(result);
            }
        }

        return stack.peek();
    }

    private static String CalculatePostFix(String str)
    {
        Stack<Character> stack = new Stack<>();
        StringBuilder strBuilder = new StringBuilder();

        for (char c: str.toCharArray())
        {
            if (Character.isDigit(c))
            {
                strBuilder.append(c);
            }
            else if (c != ' ')
            {
                //* & (+,-) => pop the *
                while (!stack.isEmpty() && precedence(stack.peek(), c))
                {
                    strBuilder.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
        {
            strBuilder.append(stack.pop());
        }
        return strBuilder.toString();
    }

    private static boolean precedence(Character op1, Character op2)
    {
        if (op1 == '*' || op1 == '/' )
        {
            return true;
        }

        if (op1 == '+' || op1 == '-')
        {
            if (op2 == '+' || op2 == '-')
            {
                return true;
            }
        }
        return false;
    }
}
