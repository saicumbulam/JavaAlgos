package Leetcode.BinaryTree.TreeDepthFirst.Often;

import Leetcode.BinaryTree.BST.TreeNode;

public class CountPathSum {
    int count = 0;

    private int pathSum(TreeNode root, int sum)
    {
        if (root == null)
        {
            return count;
        }
        Calculate(root, sum);
        Calculate(root.getLeft(), sum);
        Calculate(root.getRight(), sum);
        return count;
    }

    private void Calculate(TreeNode root, int sum)
    {
        if (root == null)
        {
            return;
        }

        if (root.getData() == sum)
        {
            count++;
        }
        if (root.getLeft() == null && root.getRight() == null)
        {
            return;
        }
        Calculate(root.getLeft(), sum-root.getData());
        Calculate(root.getRight(), sum-root.getData());
    }

}
