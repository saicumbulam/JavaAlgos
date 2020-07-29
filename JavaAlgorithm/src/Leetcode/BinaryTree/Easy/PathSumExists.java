package Leetcode.String.Easy.Easy;

import Leetcode.BinarySearch.BST.TreeNode;

public class PathSumExists {
    private static boolean hasPath(TreeNode root, int sum)
    {
        if (root == null)
        {
            return false;
        }

        if (root.getData() == sum && root.getLeft() == null && root.getRight() == null)
        {
            return true;
        }

        return hasPath(root.getLeft(), sum - root.getData())
                || hasPath(root.getRight(), sum - root.getData());
    }
}
