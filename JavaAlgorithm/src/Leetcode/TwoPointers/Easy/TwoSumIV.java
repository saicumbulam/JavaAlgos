package Leetcode.String.Easy.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.HashSet;

public class TwoSumIV {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(findTarget(root, 100));
    }

    public static boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        return find(root, k, set);
    }

    private static boolean find(TreeNode root, int k, HashSet<Integer> set)
    {
        if(root == null)
        {
            return false;
        }

        if(set.contains(k - root.getData()))
        {
            return true;
        }
        set.add(root.getData());

        return find(root.getLeft(), k, set) || find (root.getRight(), k , set);
    }
}
