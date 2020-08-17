package Leetcode.BinaryTree.BreadthFirst.Alter;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectAllSiblings {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        public TreeNode(int val)
        {
            this.val = val;
        }
    }

    private static TreeNode Calculate(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        TreeNode currentNode = null;

        while (!queue.isEmpty()) {

            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();

                if (currentNode == null)
                {
                    currentNode = polled;
                }
                else
                {
                    currentNode.next = polled;
                }
                if(polled.left != null)
                {
                    queue.add(polled.left);
                }
                if(polled.right != null)
                {
                    queue.add(polled.right);
                }
            }
        }
        return root;
    }

}
