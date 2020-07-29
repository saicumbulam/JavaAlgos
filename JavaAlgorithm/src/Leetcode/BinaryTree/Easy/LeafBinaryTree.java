/*
Time complexity: o(n)
space complexity: o(n)
* */
package Leetcode.String.Easy.Easy;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class LeafBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        List<Integer> result = new ArrayList<>();
        getleaves(root, result);
        bst.printTree2D(root, 5);
        System.out.println(result);
    }

    private static void getleaves(TreeNode root, List<Integer> result) {
        if (root == null)
        {
            return;
        }
        if (root.getLeft() == null && root.getRight() == null)
        {
            result.add(root.getData());
        }
        else
        {
            getleaves(root.getLeft(), result);
            getleaves(root.getRight(), result);
        }
    }
}
