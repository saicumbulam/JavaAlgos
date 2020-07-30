package Leetcode.String.Easy.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class MaximumDepthBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        bst.printTree(root);
        System.out.println(MaxDepth(root));
    }

    private static int MaxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return 1 + Math.max(MaxDepth(root.getLeft()), MaxDepth(root.getRight()));
    }
}
