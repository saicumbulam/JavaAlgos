package Leetcode.TreeBreadthFirst.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelorderTraversal {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(traversal(node));
    }

    private static List<List<Integer>> traversal(TreeNode root)
    {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode polled = queue.poll();
                currentLevel.add(polled.getData());

                if(polled.getLeft() != null)
                {
                    queue.add(polled.getLeft());
                }
                if(polled.getRight() != null)
                {
                    queue.add(polled.getRight());
                }
            }
            result.add(currentLevel);
        }
        return result;
    }

}
