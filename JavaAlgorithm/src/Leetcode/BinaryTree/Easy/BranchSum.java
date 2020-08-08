package Leetcode.BinaryTree.Easy;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSum {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree(1);
        List<Integer> values = Arrays.asList(2, 3, 4, 5, 6, 7, 8, 9, 10);
        for (int item: values
             ) {
            bst.add(item);
        }
        System.out.println(branchSums(bst.getRoot()));
    }

    public static List<Integer> branchSums(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        //Calculate(root, result,0);
        Calculate(root, result, new ArrayList<>());
        return result;
    }

    private static void Calculate(TreeNode root, List<Integer> result, int sum)
    {
        if (root == null)
        {
            return;
        }

        int newSum = sum + root.data;

        if (root.left == null && root.right == null)
        {
            result.add(newSum);
            return;
        }
        Calculate(root.left, result, newSum);
        Calculate(root.right, result, newSum);

    }

    private static void Calculate(TreeNode root, List<Integer> result, List<Integer> curr)
    {
        if (root == null)
        {
            return;
        }


        if (root.left == null && root.right == null)
        {
            System.out.println(curr);
            int sum = 0;
            for (int item: curr)
            {
                sum += item;
            }
            result.add(sum+root.data);
            return;
        }
        else
        {
            curr.add(root.data);
            Calculate(root.left, result, curr);
            Calculate(root.right, result, curr);
        }


        curr.remove(curr.size()-1);

    }
}
