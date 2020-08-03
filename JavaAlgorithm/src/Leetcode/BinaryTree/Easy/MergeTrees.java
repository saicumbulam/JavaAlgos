package Leetcode.BinaryTree.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

public class MergeTrees {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        bst.printTree2D(root, 3);
        System.out.println("----------------------------");
        TreeNode cal = Calculate(root, root);
        bst.printTree2D(root, 3);
    }

    private static TreeNode Calculate(TreeNode root1, TreeNode root2)
    {
        if (root1 == null && root2 == null)
        {
            return null;
        }
        if (root1 == null || root2 == null)
        {
            return root1 == null ? root2:root1;
        }

        root1.data += root2.data;
        root1.left = Calculate(root1.left, root2.left);
        root1.right = Calculate(root1.right, root2.right);
        return root1;
    }
}
