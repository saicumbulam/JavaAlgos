/*
Risky
* */
package Leetcode.String.Medium;

import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(Calculate(str));
    }

    private static String Calculate(String str)
    {
        Stack<StringBuilder> builder = new Stack<>();
        builder.push(new StringBuilder());
        Stack<Integer> timer = new Stack<>();
        int times = 0;

        for (int i = 0; i < str.length(); i++) {
            char curr = str.charAt(i);
            if (curr == '[')
            {
                timer.push(times);
                builder.push(new StringBuilder());
                times = 0;
            }
            else if (curr == ']')
            {
                String ctr = builder.pop().toString();
                int n = timer.pop();
                StringBuilder sb = builder.peek();
                for (int j = 0; j < n; j++) {
                    sb.append(ctr);
                }
            }
            else if (Character.isDigit(curr))
            {
                times = times*10 + Character.getNumericValue(curr);
            }
            else
            {
                builder.peek().append(curr);
            }
        }
        return builder.peek().toString();
    }
}
