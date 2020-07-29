package Leetcode.String.Easy.Easy;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class SecondMinimumNodeBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(Calculate(node));
    }

    public static void dfs(TreeNode root, Set<Integer> uniques) {
        if (root != null) {
            uniques.add(root.getData());
            dfs(root.getLeft(), uniques);
            dfs(root.getRight(), uniques);
        }
    }
    public static int Calculate(TreeNode root) {
        Set<Integer> uniques = new HashSet<Integer>();
        dfs(root, uniques);

        int min1 = root.getData();
        long ans = Long.MAX_VALUE;
        for (int v : uniques) {
            if (min1 < v && v < ans) ans = v;
        }
        return ans < Long.MAX_VALUE ? (int) ans : -1;
    }
}
