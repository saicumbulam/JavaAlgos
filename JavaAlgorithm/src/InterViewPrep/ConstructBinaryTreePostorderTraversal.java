package InterViewPrep;

import Leetcode.BinaryTree.BST.BinarySearchTree;
import Leetcode.BinaryTree.BST.TreeNode;

import java.util.HashMap;

public class ConstructBinaryTreePostorderTraversal {
    static int[] inorderArray;
    static int[] postorderArray;
    static HashMap<Integer, Integer> map = new HashMap<>();
    static int postOrderInx;

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] postorder = {9,15,7,20,3};

        BinarySearchTree bst = new BinarySearchTree();
        bst.printTree(Calculate(inorder, postorder));
    }

    private static TreeNode Calculate(int[] inorder, int[] preorder)
    {
        inorderArray = inorder;
        postorderArray = preorder;
        postOrderInx = postorderArray.length-1;
        int count = 0; // you missed this earlier. Watch out
        for (int item: inorderArray) {
            map.put(item, count++);
        }

        return Construct(0, inorderArray.length);
    }

    private static TreeNode Construct(int left, int right)
    {
        if (left == right) {
            return null;
        }

        int val = postorderArray[postOrderInx--];
        int index = map.get(val);
        TreeNode root = new TreeNode(val);
        root.right = Construct(index+1, right);
        root.left = Construct(left, index);
        return root;

    }
}
