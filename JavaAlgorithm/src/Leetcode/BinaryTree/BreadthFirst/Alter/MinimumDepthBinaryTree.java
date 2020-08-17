package Leetcode.BinaryTree.BreadthFirst.Alter;

import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumDepthBinaryTree {
    private static int findDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        int minimumDepth = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            minimumDepth++;

            if (root.getLeft() == null && root.getRight() == null)
            {
                return minimumDepth;
            }

            if (root.getLeft() != null)
            {
                queue.add(root.getLeft());
            }
            if (root.getRight() != null)
            {
                queue.add(root.getRight());
            }
        }

        return minimumDepth;
    }
}
