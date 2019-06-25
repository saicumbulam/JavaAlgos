package Algorithms.BinaryTree;

public class HeightBinaryTree {
    private static HeightBinaryTree hst = new HeightBinaryTree();

    public int height(BinaryTreeNode<Integer> root){

        //Base case: empty tree has height 0
        if (root == null) {
           return 0;
        }

        // recur for left and right of the subtree and calculate maximum
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = null;
        root = new BinaryTreeNode<Integer>(15);
        root.left = new BinaryTreeNode<Integer>(10);
        root.right = new BinaryTreeNode<Integer>(20);
        root.left.left = new BinaryTreeNode<Integer>(12);
        root.left.right = new BinaryTreeNode<Integer>(16);
        root.right.left = new BinaryTreeNode<Integer>(15);
        root.right.right = new BinaryTreeNode<Integer>(15);

        System.out.println(" The height of binary tree is " + hst.height(root));
    }
}
