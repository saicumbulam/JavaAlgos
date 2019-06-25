package Algorithms.BinaryTree;

public class PathSum {
    // check if a roots path has a target sum
    public boolean hasPathSum(BinaryTreeNode<Integer> tree, int targetSum){
        return hasPathSumHelper(tree, 0, targetSum);
    }

    private boolean hasPathSumHelper(BinaryTreeNode<Integer> treeNode, int partialPathSum, int targetSum){
        if (treeNode == null) {
            return false;
        }

        partialPathSum += treeNode.data;

        if (treeNode.left == null && treeNode.right == null) { // Leaf
            return partialPathSum == targetSum;
        }

        //Non-Leaf
        return hasPathSumHelper(treeNode.left, partialPathSum, targetSum) ||
                hasPathSumHelper(treeNode.right, partialPathSum, targetSum);
    }
}
