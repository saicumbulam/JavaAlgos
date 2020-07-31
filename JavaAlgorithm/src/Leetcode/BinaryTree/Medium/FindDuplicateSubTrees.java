package Leetcode.BinaryTree.Medium;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FindDuplicateSubTrees {
    static List<TreeNode> result = new ArrayList<>();
    static HashMap<String, Integer> hashMap = new HashMap<>();

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        Calculate(root);
    }

    private static String Calculate(TreeNode root) {
        if(root == null)
        {
            return "null";
        }

        String val = root.getData() + "," + Calculate(root.getLeft()) + "," + Calculate(root.getRight());
        hashMap.put(val, hashMap.getOrDefault(val, 0) + 1);
        if (hashMap.get(val) == 2)
        {
            result.add(root);
        }
        return val;
    }
}
