package Algorithms.BinaryTree;

public class BinaryTreesIdentical {
    private static BinaryTreesIdentical identical = new BinaryTreesIdentical();

    // Recursive function to check if two given binary trees are identical or not
    public boolean isIdentical(BinaryTreeNode<Integer> x, BinaryTreeNode<Integer> y){
        // if both trees are empty, return true
        if (x == null && y== null) {
            return true;
        }

        // if both trees are non-empty and value of their root node matches
        // recur for their left and right sub tree

        return (x != null && y != null) && (x.data == y.data) &&
                isIdentical(x.left,  y.left) && isIdentical(x.right, y.right);
    }

    public static void main(String[] args) {
        // construct the first tree
        BinaryTreeNode<Integer> x = new BinaryTreeNode<Integer>(15);
        x.left = new BinaryTreeNode<Integer>(10);
        x.right = new BinaryTreeNode<Integer>(20);
        x.left.left = new BinaryTreeNode<Integer>(8);
        x.left.right = new BinaryTreeNode<Integer>(12);
        x.right.left = new BinaryTreeNode<Integer>(16);
        x.right.right = new BinaryTreeNode<Integer>(25);

        // construct the first tree
        BinaryTreeNode<Integer> y = new BinaryTreeNode<Integer>(15);
        y.left = new BinaryTreeNode<Integer>(10);
        y.right = new BinaryTreeNode<Integer>(20);
        y.left.left = new BinaryTreeNode<Integer>(8);
        y.left.right = new BinaryTreeNode<Integer>(12);
        y.right.left = new BinaryTreeNode<Integer>(16);
        y.right.right = new BinaryTreeNode<Integer>(25);

        if (identical.isIdentical(x, y)) {
            System.out.println("Given binary trees are identical");
        } else {
            System.out.println("Given binary trees are not identical");
        }
    }
}
