/*
Algorithm

1. Start traversing the tree from the root node.
2. If the current node itself is one of p or q, we would mark a variable mid as True.
3. If either of the left or the right branch returns True, this means one of the two nodes was found below.
4. If at any point in the traversal, any two of the three flags left, right or mid become True,
   this means we have found the lowest common ancestor for the nodes p and q.

   Time complexity and Space complexity: O(N)
* */
package Leetcode.BinaryTree.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

public class LowestCommonAncestorBinaryTree {

    static TreeNode ans = null;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Iterative(root, new TreeNode(2), new TreeNode(3)));
        System.out.println(Recursive(root, new TreeNode(2), new TreeNode(3)));
    }

    private static boolean Recursive(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
        {
            return false;
        }

        int getLeft = Recursive(root.getLeft(), p, q) ? 1 : 0;
        int getRight = Recursive(root.getRight(), p, q) ? 1 : 0;
        int mid = (root == p) || (root == q) ? 1 : 0;

        if (mid + getLeft + getRight >= 2)
        {
            ans = root;
        }

        return (mid + getLeft + getRight) > 0;
    }

    private static TreeNode Iterative(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
        {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        HashMap<TreeNode, TreeNode> parent = new HashMap<>();

        while (!parent.containsKey(p)  || !parent.containsKey(q))
        {
            TreeNode node = stack.pop();

            if (node.getLeft() != null)
            {
                parent.put(node.getLeft(), node);
                stack.push(node.getLeft());
            }
            if (node.getRight() != null)
            {
                parent.put(node.getRight(), node);
                stack.push(node.getRight());
            }
        }

        HashSet<Integer> ancestors = new HashSet<>();

        while (parent.containsKey(p))
        {
            p = parent.get(p);
            ancestors.add(p.getData());
        }

        while (!parent.containsKey(q))
        {
            q = parent.get(q);
        }

        return q;
    }
}
