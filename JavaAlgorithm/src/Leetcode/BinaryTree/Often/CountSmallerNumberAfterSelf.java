/*
Problem: Count of small numbers after self
Input: [5,2,6,1]
Output: [2,1,1,0]

Time complexity: o(n log n)
space complexity: o(n)

See the comments
* */
package Leetcode.BinaryTree.Often;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CountSmallerNumberAfterSelf {
    // 1. BST tree node defined
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

    static int addTree(Node root, int value)
    {
        // 5. if value greater than root, create right
        if (value > root.value)
        {
            if (root.right == null)
            {
                root.right = new Node(value);
                return root.count;
            }
            else
            {
                return root.count + addTree(root.right, value);
            }
        }
        else
        {
            root.count++;
            if (root.left == null)
            {
                root.left = new Node(value);
                return 0; // this is the smallest. only right nodes can return
            }
            else
            {
                return addTree(root.left, value);
            }
        }
    }

    public static void main(String[] args)
    {
        System.out.println(Calculate(new int[] {5,2,6}));
    }

    private static List<Integer> Calculate(int[] arr)
    {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        if (n == 0)
        {
            return result;
        }

        // 2. 0 added at result for output
        result.add(0); // for the last emenet in the resultant list

        // 3. Define root from n-1
        Node root = new Node(arr[n-1]);

        // 4. Add elements in binary tree and store result.
        for (int i = n-2; i >= 0; i--) {
            result.add(0, addTree(root, arr[i]));
        }
        return result;
    }
}
