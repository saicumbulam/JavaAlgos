package InterViewPrep;

import java.util.Stack;

public class MaximalRectangle {
    public static void main(String[] args) {
        char[][] arr = {
                {'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}
        };
        System.out.println(Calculate(arr));
    }

    private static int Calculate(char[][] arr)
    {
        int[] dp = new int[arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j] == '1')
                {
                    dp[j] += 1;
                }
            }
        }

        int maxArea = CalculateHisto(dp);
        return maxArea;
    }

    private static int CalculateHisto(int[] arr)
    {
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);

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
