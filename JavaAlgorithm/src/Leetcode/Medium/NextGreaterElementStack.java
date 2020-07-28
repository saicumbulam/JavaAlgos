/*
Time complexity: o(n^2)
* */
package Leetcode.Medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class NextGreaterElementStack {
    public static void main(String[] args) {
        int[] arr = new int[] {4,6,3,2,8,1};
        System.out.println(Calculate(arr));
    }

    private static List<Integer> Calculate(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = arr.length-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] > stack.peek())
            {
                stack.pop();
            }
            result.add(0, stack.isEmpty() ? -1 : stack.peek());
            stack.push(arr[i]);
        }

        return result;
    }
}
