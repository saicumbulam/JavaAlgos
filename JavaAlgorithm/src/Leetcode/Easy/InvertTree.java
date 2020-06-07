package Leetcode.Easy;

import Leetcode.DataStructures.BST.BinarySearchTree;
import Leetcode.DataStructures.BST.TreeNode;

public class InvertTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        root = Calculate(root);
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
}
