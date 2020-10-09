package InterViewPrep;

import java.util.Stack;

public class LargestRectangleHistogram {
    public static void main(String[] args) {
        int[] arr = {2,1,5,6,2,3};
        System.out.println(Calculate(arr));
    }

    private static int Calculate(int[] arr)
    {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

        int maxArea = 0;

        for (int i = 0; i < arr.length; i++) {
            while (stack.peek() != -1 && arr[stack.peek()] >= arr[i])
            {
                maxArea = Math.max(maxArea, arr[stack.pop()] * (i - stack.peek()-1));
            }
            stack.push(i);
        }

        while (stack.peek() != -1)
        {
            maxArea = Math.max(maxArea, arr[stack.pop()] * (arr.length - stack.peek()-1));
        }

        return maxArea;
    }
}
