package Leetcode.Medium;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigZagLevelOrderTraversal {
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
        boolean leftRight = false;

        while (!queue.isEmpty())
        {
            int n = queue.size();
            List<Integer> currentLevel = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode polled = queue.poll();
                if(leftRight)
                {
                    currentLevel.add(polled.getData());
                }
                else
                {
                    currentLevel.add(0, polled.getData());
                }


                if(polled.getLeft() != null)
                {
                    queue.add(polled.getLeft());
                }
                if(polled.getRight() != null)
                {
                    queue.add(polled.getRight());
                }
            }
            leftRight = !leftRight;
            result.add(currentLevel);
        }
        return result;

    }
}
