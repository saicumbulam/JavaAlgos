package Leetcode.Medium;

import Leetcode.DataStructures.BST.BinarySearchTree;
import Leetcode.DataStructures.BST.TreeNode;

public class KthSmallestBst {
    static int count = 0;
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root, 3));
    }

    private static int Calculate(TreeNode root, int k)
    {
        if(root == null)
        {
            return -1;
        }

        int result = Calculate(root.getLeft(), k);

        if(result != -1)
        {
            return result;
        }

        count++;
        if(count == k)
        {
            return root.getData();
        }

        result = Calculate(root.getRight(), k);

        if( result != -1)
        {
            return result;
        }

        return -1;
    }
}
