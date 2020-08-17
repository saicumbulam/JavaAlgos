package Leetcode.BinaryTree.Often;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreePreorderInorder {
    static int[] inorderArray;
    static int[] preorderArray;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int preOrderInx;

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        BinarySearchTree bst = new BinarySearchTree();
        bst.printTree(Calculate(inorder, preorder));
    }

    private static TreeNode Calculate(int[] inorder, int[] preorder)
    {
        inorderArray = inorder;
        preorderArray = preorder;

        int count = 0; // you missed this earlier. Watch out
        for (int item: inorderArray) {
            map.put(item, count++);
        }

        return Construct(0, inorderArray.length);
    }

    private static TreeNode Construct(int left, int right)
    {
        if (left == right) {
            return null;
        }

        int val = preorderArray[preOrderInx++];
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        root.setLeft(Construct(left, index));
        root.setRight(Construct(index+1, right));
        return root;

    }
}
