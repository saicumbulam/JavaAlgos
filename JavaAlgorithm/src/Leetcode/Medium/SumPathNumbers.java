package Leetcode.Medium;

import Leetcode.DataStructures.BST.TreeNode;

public class SumPathNumbers {
    private static int findRootToLeaf(TreeNode root, int pathSum)
    {
        if (root == null)
        {
            return 0;
        }

        pathSum = pathSum*10 + root.getData();

        if (root.getLeft() == null && root.getRight() == null)
        {
            return pathSum;
        }

        return findRootToLeaf(root.getLeft(), pathSum)
                + findRootToLeaf(root.getRight(), pathSum);
    }
}
