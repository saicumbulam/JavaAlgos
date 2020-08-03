package Leetcode.BinaryTree.BST;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }

    public String toString()
    {
        StringBuilder str = new StringBuilder();

        str.append("val:").append(data);
        str.append(" left:").append(left == null ? "null" : left.data);
        str.append(" right:").append(right == null ? "null" : right.data);
        return str.toString();
    }
}

