package Leetcode.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.Stack;

public class InorderSucessorBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(Calculate(node, new TreeNode(3)).getData());
    }

    private static TreeNode Calculate(TreeNode root, TreeNode p)
    {
        if (root == null)
        {
            return null;
        }

        Stack<TreeNode> stack = new Stack<>();
        int prev = Integer.MIN_VALUE;

        while (!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.getLeft();
                continue;
            }

            root = stack.pop();
            if (prev == p.getData())
            {
                return root;
            }
            prev = root.getData();
            root = root.getRight();
        }
        return null;
    }
}
