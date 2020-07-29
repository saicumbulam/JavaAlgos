package Leetcode.Medium;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

public class ValidBinarySearchTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        System.out.println(isValidBst(bst.CreateBinaryTree(), null, null));
    }

    private static boolean isValidBst(TreeNode root,
                                      Integer lowValue, Integer highValue)
    {
        if(root == null)
        {
            return true;
        }

        if (lowValue != null && root.getData() < lowValue)
        {
            return false;
        }

        if(highValue != null && root.getData() > highValue)
        {
            return false;
        }

        return isValidBst(root.getLeft(), lowValue,root.getData()) &&
                isValidBst(root.getRight(), root.getData(),highValue);
    }
}
