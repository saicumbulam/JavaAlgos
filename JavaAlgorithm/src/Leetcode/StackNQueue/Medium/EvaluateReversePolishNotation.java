package Leetcode.Medium;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
        String[] strs = {"2", "1", "+", "3", "*"};
        System.out.println(Calculate(strs));
    }

    private static int Calculate(String[] strs)
    {
        Stack<Integer> stack = new Stack<>();

        for (String item: strs
             ) {
            if ("+/*-".contains(item))
            {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                switch (item)
                {
                    case "+":
                        result = num1 + num2;
                        break;
                    case "-":
                        result = num1 - num2;
                        break;
                    case "*":
                        result = num1*num2;
                        break;
                    case "/":
                        result = num1/num2;
                        break;
                }
                stack.push(result);
            }
            else
            {
                stack.push(Integer.parseInt(item));
            }
        }

        return stack.peek();
    }
}
