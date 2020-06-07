package Leetcode.Hard;

import Leetcode.DataStructures.BST.BinarySearchTree;
import Leetcode.DataStructures.BST.TreeNode;

public class BinaryTreeMaximumPath {
    static int globalMaximum = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(MaximumPath(node));
    }

    private static int MaximumPath(TreeNode root)
    {
        Calculate(root);
        return globalMaximum;
    }

    private static int Calculate(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }

        int leftSum = Calculate(root.getLeft());
        int rightSum = Calculate(root.getRight());

        leftSum = Math.max(leftSum, 0);
        rightSum = Math.max(rightSum, 0);

        int currentMax = leftSum + rightSum + root.getData();
        if (currentMax > globalMaximum)
        {
            globalMaximum = currentMax;
        }
        return Math.max(leftSum, rightSum) + root.getData();

    }
}
