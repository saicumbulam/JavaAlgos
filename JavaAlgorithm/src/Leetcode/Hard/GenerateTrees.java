/*
Problem:
Given a number ‘n’, write a function to return the count of
structurally unique Binary Search Trees (BST)
that can store values 1 to ‘n’.

See comments for pseudocode. Basic idea is to keep start and end.
generate tree from lefttree and rightree
* */

package Leetcode.Hard;

import Leetcode.BinarySearch.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class GenerateTrees {
    public static void main(String[] args) {
        System.out.println(Calculate(3).size());
    }

    private static List<TreeNode> Calculate(int n)
    {
        if(n <= 0)
        {
            return new ArrayList<>();
        }
        // start and end pointers=> 1 and n
        return GenerateTree(1, n);
    }

    private static List<TreeNode> GenerateTree(int start, int end)
    {
        List<TreeNode> result = new ArrayList<>();
        // if start > end , put null in result
        if (start > end)
        {
            result.add(null);
            return result;
        }

        // generate left and right tree and put the root created into result
        for (int i = start; i <= end ; i++) {
            List<TreeNode> leftTrees = GenerateTree(start, i-1);
            List<TreeNode> rightTrees = GenerateTree(i+1, end);
            for (TreeNode leftTree: leftTrees
                 ) {
                for (TreeNode rightTree: rightTrees
                     ) {
                    TreeNode root = new TreeNode(i);
                    root.setLeft(leftTree);
                    root.setRight(rightTree);
                    result.add(root);
                }
            }

        }

        return result;
    }
}
