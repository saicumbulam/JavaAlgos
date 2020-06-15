package Leetcode.Medium;

import Leetcode.DataStructures.BST.BinarySearchTree;
import Leetcode.DataStructures.BST.TreeNode;

public class InsufficientNodesRootLeafPaths {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree(new int[]{1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14});
        int limit = 1;
        int value = Calculate(root, 0, limit);
        if (value < limit)
        {
            System.out.println("null");
        }
        else
        {
            System.out.println(root.getData());
        }
    }

    private static int Calculate(TreeNode root, int sum, int target) {
        if (root == null)
        {
            return Integer.MIN_VALUE;
        }

        if (root.getLeft() == null && root.getRight() == null)
        {
            return sum + root.getData();
        }

        int leftSum = Calculate(root.getLeft(), sum + root.getData(), target);
        if (leftSum < target)
        {
            root.setLeft(null);
        }
        int rightSum = Calculate(root.getRight(), sum + root.getData(), target);
        if (rightSum < target)
        {
            root.setRight(null);
        }
        return Math.max(leftSum, rightSum);
    }
}
