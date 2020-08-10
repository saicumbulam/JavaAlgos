package Leetcode.LinkedList.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class FlattenBinaryTreeLinkedList {

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree(new int[]{2,1,3});
        bst.printTree2D(root, 3);
        flatten(root);
        bst.printTree2D(root, 3);
    }
    private static TreeNode flattenTree(TreeNode root) {

        // Handle the null scenario
        if (root == null) {
            return null;
        }

        // For a leaf node, we simply return the
        // node as is.
        if (root.getLeft() == null && root.getRight() == null) {
            return root;
        }

        //Recursively flatten the left subtree
        TreeNode leftTail = flattenTree(root.getLeft());

        // Recursively flatten the right subtree
        TreeNode rightTail = flattenTree(root.getRight());

        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }

        // We need to return the "rightmost" node after we are
        // done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }

    public static void flatten(TreeNode root) {

        flattenTree(root);
    }
}
