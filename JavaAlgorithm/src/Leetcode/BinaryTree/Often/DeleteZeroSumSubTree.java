package Leetcode.BinaryTree.Often;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.TreeMap;

public class DeleteZeroSumSubTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root));
    }

    private static TreeNode Calculate(TreeNode root)
    {
        if (root == null)
        {
            return null;
        }
        if (DeleteSubTree(root) == 0)
        {
            root = null;
        }

        return root;

    }

    private static int DeleteSubTree(TreeNode root) {
        if (root == null)
        {
            return 0;
        }

        int sumLeft = DeleteSubTree(root.getLeft());
        int sumRight = DeleteSubTree(root.getLeft());

        if (sumLeft == 0)
        {
            root.setLeft(null);
        }
        if (sumRight == 0)
        {
            root.setRight(null);
        }
        return root.getData() + sumLeft + sumRight;
    }
}
