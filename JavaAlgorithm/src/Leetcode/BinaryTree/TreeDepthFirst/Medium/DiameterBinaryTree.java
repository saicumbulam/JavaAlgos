package Leetcode.BinaryTree.TreeDepthFirst.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class DiameterBinaryTree {
    static int maxDiameter = 1;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        Calculate(root);
        System.out.println(maxDiameter - 1);
    }

    private static int Calculate(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int left = Calculate(root.getLeft());
        int right = Calculate(root.getRight());

        int diameter = left + right + 1;

        if (diameter > maxDiameter)
        {
            maxDiameter = diameter;
        }


        return Math.max(left, right) + 1;
    }
}
