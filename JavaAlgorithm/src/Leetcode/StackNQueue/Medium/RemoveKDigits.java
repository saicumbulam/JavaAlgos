package Leetcode.StackNQueue.Medium;

import java.util.LinkedList;
import java.util.Stack;

public class RemoveKDigits {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(Calculate(num, k));
    }

    public static String Calculate(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char c : num.toCharArray()) {
            while (!stack.isEmpty() && k > 0 && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        while (k > 0) {
            stack.pop();
            k--;
        }

        boolean leadingZero = true;
        StringBuilder result = new StringBuilder();
        for (char item : stack) {
            if (leadingZero && item == '0') {
                continue;
            }
            leadingZero = false;
            result.append(item);
        }

        if (result.length() == 0) {
            return "0";
        }

        return result.toString();
    }
}
