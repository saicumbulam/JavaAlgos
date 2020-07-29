package Leetcode.Medium;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

public class LowestCommonAncestor {
    static TreeNode ans = null;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root, root, root));
    }

    private static boolean Calculate(TreeNode root, TreeNode p, TreeNode q)
    {
        if (root == null)
        {
            return false;
        }

        int right = Calculate(root.getRight(), p, q) ? 1 : 0;
        int left = Calculate(root.getLeft(), p, q) ? 1 : 0;
        int mid = ((root == p) || (root == q)) ? 1 : 0;

        if ((mid + left + right) >= 2)
        {
            ans = root;
        }

        return (mid + left + right) > 0;
    }
}
