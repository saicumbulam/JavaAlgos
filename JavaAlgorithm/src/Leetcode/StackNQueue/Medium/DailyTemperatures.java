package Leetcode.Medium;

import java.util.Stack;

public class DailyTemperatures {
    public static void main(String[] args) {
        Calculate(new int[] {73,74,75,71,69,72,76,73});
    }

    public static int[] Calculate(int[] T) {
        int[] ans = new int[T.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = T.length - 1; i >= 0; i--)
        {
            while(!stack.isEmpty() && T[i] >= T[stack.peek()])
            {
                stack.pop();
            }
            ans[i] = stack.isEmpty() ? 0 : stack.peek()-i;
            stack.push(i);
        }

        return ans;
    }
}
