package Leetcode.BinaryTree.Often;

import Leetcode.BinaryTree.BST.TreeNode;

public class FindClosestValueBST {
    public static int findClosestValueInBst(TreeNode tree, int target) {
        return Calculate(tree, target, tree.data);
    }

    private static int Calculate(TreeNode tree, int target, int closest)
    {
        TreeNode currentNode = tree;
        while (currentNode != null)
        {
            if (Math.abs(target - closest) > Math.abs(target - currentNode.data))
            {
                closest = currentNode.data;
            }

            if (currentNode.data < target)
            {
                currentNode = currentNode.right;
            }
            else if (currentNode.data > target)
            {
                currentNode = currentNode.left;
            }
            else
            {
                break;
            }
        }

        return closest;
    }
}
