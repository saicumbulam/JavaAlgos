package Legacy.Algorithms.BinaryTree;

import Legacy.Algorithms.Stack.genericStack;

public class PostOrderTraversal {
    public void postorder(BinaryTreeNode<Integer> treeNode){
        // return if the current node is empty
        if (treeNode == null) {
            return;
        }

        // Traverse the left subtree
        postorder(treeNode.left);

        //Traverse the right subtree
        postorder(treeNode.right);

        //Display the data part of the root
        System.out.println(treeNode.data + " ");

    }

    public void postorderIterative(BinaryTreeNode<Integer> treeNode) {
        //create an empty stack and push root node
        genericStack<BinaryTreeNode<Integer>> stack = new genericStack<>();
        stack.push(treeNode);

        // create another stack to store post-order traversal
        genericStack<BinaryTreeNode<Integer>> out = new genericStack<>();

        while (!stack.isEmpty()){

            // we pop a node from stack and push the data to output stack
            BinaryTreeNode<Integer> curr = stack.pop();
            out.push(curr);

            // push left and right child popped node to the stack
            if (curr.left != null) {
                stack.push(curr.left);
            }

            if (curr.right != null) {
                stack.push(curr.right);
            }

            while (!out.isEmpty()){
                System.out.println(out.pop() + " ");
            }
        }

    }


}
