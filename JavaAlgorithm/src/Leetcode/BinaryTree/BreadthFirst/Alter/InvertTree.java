/*
problem:
Mirror image of binary tree

Time complexity : O(N)
space complexity is o(h)

pseudocode:
1. Recurse for left and the right.
2. switch the left and right of the root using temp
   and return root
*/
package Leetcode.BinaryTree.BreadthFirst.Alter;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        root = invertTree(root);
        bst.printTree2D(root, 5);
    }

    private static TreeNode Calculate(TreeNode root)
    {
        if(root == null)
        {
            return null;
        }

        Calculate(root.getLeft());
        Calculate(root.getRight());

        TreeNode temp = root.getLeft();
        root.setLeft(root.getRight());
        root.setRight(temp);
        return root;
    }

    // iTERATIVE solution
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode current = queue.poll();
                TreeNode temp = current.left;
                current.left = current.right;
                current.right = temp;
                if (current.getLeft() != null) queue.add(current.getLeft());
                if (current.getRight() != null) queue.add(current.getRight());
            }
        }
        return root;
    }

}
