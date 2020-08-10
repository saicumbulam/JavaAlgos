package Leetcode.BinaryTree.BreadthFirst.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;
import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepthBinaryTree {
    private static int count = 0;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        bst.printTree2D(root, 3);
        System.out.println("--------------------");
        //System.out.println(MaxDepth(root));
        MaxDepthIterative(root);
        System.out.println(count);
    }

    private static int MaxDepth(TreeNode root)
    {
        if (root == null)
        {
            return 0;
        }
        return 1 + Math.max(MaxDepth(root.getLeft()), MaxDepth(root.getRight()));
    }

    static class Pair
    {
        TreeNode node;
        int depth;

        public Pair(TreeNode node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }

    private static void MaxDepthIterative(TreeNode root)
    {
        if (root == null)
        {
            return;
        }
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 1));
        while (!queue.isEmpty())
        {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                Pair polled = queue.poll();
                TreeNode polledNode = polled.node;

                if (polledNode.getRight() == null && polledNode.getLeft() == null)
                {
                    count = Math.max(count, polled.depth);
                }

                if (polledNode.getLeft() != null)
                {
                    queue.add(new Pair(polledNode.getLeft(), polled.depth+1));
                }
                if (polledNode.getRight() != null)
                {
                    queue.add(new Pair(polledNode.getRight(), polled.depth+1));
                }

            }
        }
    }
}
