package Leetcode.BinaryTree.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class LowestCommonAncestorBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root, new TreeNode(3), new TreeNode(2)));
    }

    private static TreeNode Calculate(TreeNode root, TreeNode p, TreeNode q)
    {
        if (p.getData() < root.getData() && q.getData() < root.getData())
        {
            return Calculate(root.getLeft(), p, q);
        }
        if (p.getData() > root.getData() && q.getData() > root.getData())
        {
            return Calculate(root.getRight(), p, q);
        }
        else
        {
            return root;
        }
    }

}
