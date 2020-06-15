package Leetcode.Hard;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FindNumberSmallerElementsRight {
    static class Node
    {
        Node left;
        Node right;
        int count;
        int value;

        public Node(int value) {
           this(value, 1);
        }

        Node(int val, int count) {
            this.value = val;
            this.count = count;
            this.left = null;
            this.right = null;
        }
    }

    static int addTree(Node head, int number)
    {
        if (number > head.value)
        {
            if (head.right == null)
            {
                head.right = new Node(number);
                return head.count;
            }
            else
            {
                return head.count + addTree(head.right, number);
            }
        }
        else
        {
            head.count++;
            if (head.left == null)
            {
                head.left = new Node(number);
                return 0; // becoz we need the right elements
            }
            else
            {
                return addTree(head.left, number);
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Calculate(new int[] {5,2,6,1}));
    }

    private static List<Integer> Calculate(int[] arr)
    {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0)
        {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        stack.push(0); // for the last emenet in the resultant list

        Node head = new Node(arr[n-1]);

        for (int i = n-2; i >= 0; i--) {
            stack.push(addTree(head, arr[i]));
        }

        while (stack.size() > 0)
        {

            result.add(stack.pop());
        }

        return result;
    }
}
