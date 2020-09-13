package Leetcode.BinaryTree.TreeDepthFirst.Often;

import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSum {
    static List<List<Integer>> allPaths = new ArrayList<>();

    private static List<List<Integer>> findPaths(TreeNode root, int sum)
    {
        findPathsRecursive(root, sum, new ArrayList<>());
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, int sum,
                                           List<Integer> curr)
    {
        if(root == null) return;

        curr.add(root.data);

        if(root.data == sum && root.left == null && root.right == null)
        {
            allPaths.add(new ArrayList<>(curr));
        }
        else
        {
            findPathsRecursive(root.left, sum- root.data, curr);
            findPathsRecursive(root.right, sum- root.data, curr);
        }
        curr.remove(curr.size()-1);
    }
}
