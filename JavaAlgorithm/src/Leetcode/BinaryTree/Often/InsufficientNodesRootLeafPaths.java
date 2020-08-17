package Leetcode.BinaryTree.Often;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

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

    private static int Calculate(TreeNode root, int sum, int limit) {
        if (root == null) return Integer.MIN_VALUE; // no path
        if (root.left == null && root.right == null) // leaf node
            return root.data + sum;
        int leftSum = Calculate(root.left, root.data + sum, limit); // get the left path sum
        if (leftSum < limit) root.left = null; // cut the left path
        int rightSum = Calculate(root.right, root.data + sum, limit); // get the right path sum
        if (rightSum < limit) root.right = null; // cut the right path
        return Math.max(leftSum, rightSum);
    }
}
