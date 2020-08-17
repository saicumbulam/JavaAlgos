package Leetcode.BinaryTree.BreadthFirst.Alter;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class SumLeftLeaves {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(Calculate(node));
    }

    private static int Calculate(TreeNode root)
    {
        int result = 0;
        if(root == null)
        {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();

                if (polled.getLeft() != null)
                {
                    if (polled.getLeft().getLeft() == null &&
                            polled.getLeft().getLeft() == null)
                    {
                        result += polled.getLeft().getData();
                    }
                    queue.add(polled.getLeft());
                }

                if (polled.getRight() != null)
                {
                    queue.add(polled.getLeft());
                }
            }
        }

        return result;
    }
}
