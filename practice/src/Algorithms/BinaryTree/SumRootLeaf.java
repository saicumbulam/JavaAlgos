package Algorithms.BinaryTree;

public class SumRootLeaf {
    public int sumRootToLeaf(BinaryTreeNode<Integer> tree){
        return sumRootToLeafHelper(tree,0);
    }

    private int sumRootToLeafHelper(BinaryTreeNode<Integer> tree, int partialPathSum) {
        if (tree == null) {
            return 0;
        }

        partialPathSum = partialPathSum * 2 + tree.data;

        if (tree.left == null && tree.right == null) { //Leaf
            return partialPathSum;

        }

        //Non-Leaf
        return sumRootToLeafHelper(tree.left, partialPathSum) + sumRootToLeafHelper(tree.right, partialPathSum);
    }

}
