package Leetcode.Easy;

import Leetcode.DataStructures.BST.BinarySearchTree;
import Leetcode.DataStructures.BST.TreeNode;
import sun.reflect.generics.tree.Tree;

public class PathSumIII {
    private static int count = 0;

    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();
        TreeNode root = bst.CreateBinaryTree();
        System.out.println(Calculate(root, 8));
    }

    private static int Calculate(TreeNode root, int sum)
    {
        if (root == null)
        {
            return 0;
        }

        hasPathSum(root, sum);
        Calculate(root.getLeft(), sum);
        Calculate(root.getRight(), sum);
        return count;
    }

    private static void hasPathSum(TreeNode root, int sum)
    {
        if (root == null)
        {
            return;
        }

        if (root.getData() == sum)
        {
            count++;
        }

        if (root.getRight() == null && root.getLeft() == null)
        {
            return;
        }

        hasPathSum(root.getLeft(), sum - root.getData());
        hasPathSum(root.getRight(), sum - root.getData());

    }
}
