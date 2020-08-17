package Leetcode.BinaryTree.Often;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode node = bst.CreateBinaryTree();
        System.out.println(traversal(node));
    }

    private static List<Integer> traversal(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        if(root == null)
        {
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null)
        {
            if(root != null)
            {
                stack.push(root);
                root = root.getLeft();
                continue;
            }

            result.add(stack.peek().getData());
            root = stack.pop().getRight();
        }
        return result;
    }
}
