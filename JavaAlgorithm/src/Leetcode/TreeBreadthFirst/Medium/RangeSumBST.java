package Leetcode.TreeBreadthFirst.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RangeSumBST {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        bst.printTree2D(node, 3);
        System.out.println("---------------------");
        System.out.println(Calculate(node, 4, 10));
    }

    private static int Calculate(TreeNode root, int p, int q) {
        int result = 0;
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode polled = queue.poll();
                if (polled.getData() >= p && polled.getData() <= q)
                {
                    result += polled.getData();
                }
                if(polled.getLeft() != null && polled.getData() > p)
                {
                    queue.add(polled.getLeft());
                }
                if(polled.getRight() != null && polled.getData() < q)
                {
                    queue.add(polled.getRight());
                }
            }
        }
        return result;
    }
}
