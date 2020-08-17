package Leetcode.BinaryTree.BreadthFirst.Alter;

import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumofAllNodeDepths {
    public static int nodeDepths(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        int level = 0;
        int su = 0;

        while (!queue.isEmpty())
        {
            int size = queue.size();

            for (int i = 0; i< size; i++)
            {
                TreeNode polled = queue.poll();
                su += level;

                if (polled.left != null)
                {
                    queue.add(polled.left);
                }
                if (polled.right != null)
                {
                    queue.add(polled.right);
                }
            }

            level += 1;
        }

        return su;
    }
}
