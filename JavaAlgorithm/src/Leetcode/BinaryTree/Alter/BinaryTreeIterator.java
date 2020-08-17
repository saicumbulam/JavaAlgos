package Leetcode.BinaryTree.Alter;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeIterator {
    static List<Integer> array = new ArrayList<>();
    static int index = 0;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        Inorder(root);
        System.out.println(hasNext());
        System.out.println(Next());

    }

    private static void Inorder(TreeNode root) {
        if (root == null)
        {
            return;
        }
        Inorder(root.getLeft());
        array.add(root.getData());
        Inorder(root.getRight());
    }

    private static int Next()
    {
        if (!hasNext())
        {
            return -1;
        }
        return array.get(index++);
    }

    private static boolean hasNext()
    {
        if (index >= array.size())
        {
            return false;
        }
        return true;
    }
}
