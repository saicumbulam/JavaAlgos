package Leetcode.BinaryTree.TreeDepthFirst.Often;

import Leetcode.BinaryTree.BST.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class AllPathsSum {
    private static List<List<Integer>> findPaths(TreeNode root, int sum)
    {
        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> currentPath = new ArrayList<>();
        findPathsRecursive(root, sum, currentPath, allPaths);
        return allPaths;
    }

    private static void findPathsRecursive(TreeNode root, int sum,
                                           List<Integer> currentPath,
                                           List<List<Integer>> allPaths)
    {
        if (root == null)
        {
            return;
        }

        currentPath.add(root.getData());

        // new ArrayList should come to avoid memory reference
        if (root.getLeft() == null && root.getRight() == null
         && root.getData() == sum)
        {
            allPaths.add(new ArrayList<>(currentPath));
        }
        else
        {
            findPathsRecursive(root.getLeft(), sum - root.getData(), currentPath, allPaths);
            findPathsRecursive(root.getRight(), sum - root.getData(), currentPath, allPaths);

        }

        currentPath.remove(currentPath.size()-1);
    }
}
