package Leetcode.BinaryTree.TreeDepthFirst.Medium;

import Leetcode.BinaryTree.BST.TreeNode;

public class PathWithGivenSequence {
    private static boolean findPath(TreeNode root, int[] sequence, int seqIdx)
    {
        if (root == null)
        {
            return false;
        }

        if (seqIdx >= sequence.length ||
        root.getData() != sequence[seqIdx])
        {
            return false;
        }

        if (seqIdx == sequence.length-1 && root.getLeft() == null
                && root.getRight() == null)
        {
            return true;
        }

        return findPath(root.getRight(), sequence, seqIdx+1)
                || findPath(root.getLeft(), sequence, seqIdx+1);
    }
}
