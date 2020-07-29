package Leetcode.Hard;

import Leetcode.BinarySearch.BST.BinarySearchTree;
import Leetcode.BinarySearch.BST.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SerializeDeserializeBinaryTree {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(serialize(root));
        System.out.println("-----------------");
        bst.printTree(deserialize(serialize(root)));
    }

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        StringBuilder result = new StringBuilder();
        if (root == null)
        {
            result.append("null,");
        }
        else
        {
            result.append(root.getData()).append(",");
            result.append(serialize(root.getLeft()));
            result.append(serialize(root.getRight()));
        }

        return result.toString();
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        String[] split = data.split(",");
        List<String> list = new ArrayList<>(Arrays.asList(split));
        return rdeserialize(list);
    }

    public static TreeNode rdeserialize(List<String> list)
    {
        if(list.get(0).equals("null"))
        {
            list.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(list.get(0)));
        list.remove(0);
        root.setLeft(rdeserialize(list));
        root.setRight(rdeserialize(list));
        return root;
    }
}
