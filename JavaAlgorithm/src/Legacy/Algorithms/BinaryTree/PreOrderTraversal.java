package Legacy.Algorithms.BinaryTree;

import Legacy.Algorithms.Stack.genericStack;

public class PreOrderTraversal {
    public void preorder(BinaryTreeNode<Integer> root){

        // return if the current node is empty
        if (root == null) {
            return;
        }

        //Display the data part of the root
        System.out.println(root.data + " ");

        //Traverse the left subtree
        preorder(root.left);

        //Traverse the right subtree
        preorder(root.right);
    }


    public void preorderIterative(BinaryTreeNode<Integer> root){

        // return if tree is empty
        if (root == null) {
            return;
        }

        // create an empty stack and push root node
        genericStack<BinaryTreeNode<Integer>> stack = new genericStack<BinaryTreeNode<Integer>>();
        stack.push(root);

        // run till stack is not empty
        while (!stack.isEmpty()){

            //pop a node from the stack and print it
            BinaryTreeNode<Integer> curr = stack.pop();

            System.out.println(curr.data + " ");

            // push right child of popped node to the stack
            if (curr.right != null) {
                stack.push(curr.right);
            }

            // push left child of popped node to the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            // important note - right child is pushed first so that left child
            // is processed first (FIFO order)
        }
    }
}
