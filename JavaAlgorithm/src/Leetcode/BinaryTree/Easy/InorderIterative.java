package Leetcode.BinaryTree.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class InorderIterative {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root));
    }

    private static List<Integer> Calculate(TreeNode root)
    {
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        while (!stack.isEmpty() || root != null)
        {
            if (root != null)
            {
                stack.push(root);
                root = root.getLeft();
                continue;
            }
            root = stack.pop();
            result.add(root.getData());
            root = root.getRight();
        }
        return result;
    }
 }
