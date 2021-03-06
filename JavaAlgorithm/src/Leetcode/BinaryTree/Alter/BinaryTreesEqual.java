package Leetcode.BinaryTree.Alter;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class BinaryTreesEqual {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root, root));
    }

    private static boolean Calculate(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return true;
        }

        if (root1 == null || root2 == null)
        {
            return false;
        }

        return (root1.getData() == root2.getData()) && Calculate(root1.getLeft(), root2.getLeft())
                && Calculate(root1.getRight(), root2.getRight());
    }
}
