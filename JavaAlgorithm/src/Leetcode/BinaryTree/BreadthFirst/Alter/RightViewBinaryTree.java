package Leetcode.BinaryTree.BreadthFirst.Alter;

import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree {
    private static List<TreeNode> traverse(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (i == levelSize-1)
                {
                    result.add(currentNode);
                }
                if (currentNode.getLeft() != null)
                {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null)
                {
                    queue.add(currentNode.getRight());
                }
            }
        }
        return result;
    }
}
