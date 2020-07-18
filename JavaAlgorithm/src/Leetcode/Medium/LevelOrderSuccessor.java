package Leetcode.Medium;

import Leetcode.DataStructures.BST.TreeNode;


import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderSuccessor {
    private static TreeNode findSucessor(TreeNode root, int key)
    {
        if (root == null)
        {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            TreeNode currentNode = queue.poll();
            if (currentNode.getLeft() != null)
            {
                queue.add(currentNode.getLeft());
            }
            if (currentNode.getRight() != null)
            {
                queue.add(currentNode.getRight());
            }

            if (currentNode.getData() == key)
            {
                break;
            }
        }

        return queue.peek();
    }
}
