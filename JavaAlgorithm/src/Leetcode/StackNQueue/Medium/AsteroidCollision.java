/*
Input:
asteroids = [5, 10, -5]
Output: [5, 10]
Explanation:
The 10 and -5 collide resulting in 10.  The 5 and 10 never collide.

Input:
asteroids = [8, -8]
Output: []
Explanation:
The 8 and -8 collide exploding each other.

Input:
asteroids = [10, 2, -5]
Output: [10]
Explanation:
The 2 and -5 collide resulting in -5.  The 10 and -5 collide resulting in 10.

1. push the item >= 0 to stack
2. if item < 0, remove stack items which has peek > 0 and peek < Math.abs(item). while loop
3. if peek == abs(item) remove the peek
4. if stack empty or peek < 0, then insert item in stack
* */

package Leetcode.StackNQueue.Medium;

import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] arr = new int[]{5, 10, -5};
        for (int item: Calculate(arr))
        {
            System.out.println(item);
        };
    }

    private static int[] Calculate(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < asteroids.length; i++)
        {
            if (asteroids[i] > 0)
            {
                stack.push(asteroids[i]);
            }
            else
            {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroids[i]))
                {
                    stack.pop();
                }

                if (stack.isEmpty() || stack.peek() < 0)
                {
                    stack.push(asteroids[i]);
                }
                else if (stack.peek() == Math.abs(asteroids[i]))
                {
                    stack.pop();
                }
            }

        }

        int[] result = new int[stack.size()];
        for (int i = result.length-1; i >= 0; i--)
        {
            result[i] = stack.pop();
        }

        return result;
    }
}
