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
    private static TreeNode flattenTree(TreeNode node) {

        // Handle the null scenario
        if (node == null) {
            return null;
        }

        // For a leaf node, we simply return the
        // node as is.
        if (node.getLeft() == null && node.getRight() == null) {
            return node;
        }

        //Recursively flatten the left subtree
        TreeNode leftTail = flattenTree(node.getLeft());

        // Recursively flatten the right subtree
        TreeNode rightTail = flattenTree(node.getRight());

        // If there was a left subtree, we shuffle the connections
        // around so that there is nothing on the left side
        // anymore.
        if (leftTail != null) {
            leftTail.setRight(node.getRight());
            node.setRight(node.getLeft());
            node.setLeft(null);
        }

        // We need to return the "rightmost" node after we are
        // done wiring the new connections.
        return rightTail == null ? leftTail : rightTail;
    }

    public static void flatten(TreeNode root) {

        flattenTree(root);
    }
}
