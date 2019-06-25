package Algorithms.BinaryTree;

import Algorithms.Stack.genericStack;

public class InorderTraversal {
    public void  InOrder(BinaryTreeNode<Integer> root){

        // return if the curren node is empty
        if (root == null) {
            return;
        }

        // Traverse the left subtree
        InOrder(root.left);

        //Display the data part of the root(current node)
        System.out.println(root.data + " ");

        //Traver the right subtree
        InOrder(root.right);

    }

    public void InorderIterative(BinaryTreeNode<Integer> root){
        // create an empty stack
        genericStack<BinaryTreeNode<Integer>> stack = new genericStack<>();

        //start from the root node
        BinaryTreeNode<Integer> curr = root;

        while(!stack.isEmpty() || curr != null){

            // if current node is not null, push it to stack and move to its left child
            if (curr != null) {
                stack.push(curr);
                curr = curr.left;
            } else {
                // else if current node is null, we pop an element from stack, print it
                // and finally set current node to its right child
                curr = stack.pop();
                System.out.println(curr.data + " ");
                curr = curr.right;

            }
        }
    }
}
