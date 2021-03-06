/*
Similar to problem constructing minimum height binary tree
* */
package Leetcode.BinaryTree.Alter;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class ConvertSortArrayBinaryTree {
    public static void main(String[] args) {
        int[] arr = new int[] {-10,-3,0,5,9};
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = Calculate(arr, 0, arr.length-1);
        bst.printTree(node);
    }

    public static TreeNode Calculate(int[] arr, int left, int right)
    {
        if (left <= right) // mid is calculated, so there should be <=, exactly like binary search.
            // mid is the root and recurse with mid-1 and mid+1
        {
            int mid = (right + left)/2;
            TreeNode root = new TreeNode(arr[mid]);
            root.setLeft(Calculate(arr, left, mid-1));
            root.setRight(Calculate(arr, mid+1, right));
            return root;
        }
        return null;
    }
}
