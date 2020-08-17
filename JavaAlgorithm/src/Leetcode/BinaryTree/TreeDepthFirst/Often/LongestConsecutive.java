package Leetcode.BinaryTree.TreeDepthFirst.Often;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class LongestConsecutive {
    static int maxCount = 0;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        Calculate(root, 0, 0);
        System.out.println(maxCount);
    }

    private static void Calculate(TreeNode root, int target, int count)
    {
        if (root == null)
        {
            return;
        }

        if (target == root.getData())
        {
            count++;
        }
        else
        {
            count = 1;
        }
        maxCount = Math.max(maxCount, count);

        Calculate(root.getLeft(), root.getData()+1, count);
        Calculate(root.getRight(), root.getData()+1, count);
    }
}
