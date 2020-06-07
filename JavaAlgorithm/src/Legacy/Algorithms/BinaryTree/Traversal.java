package Legacy.Algorithms.BinaryTree;

public class Traversal {
    public void treeTraversal ( BinaryTreeNode <Integer> root) {
        if (root != null) {
            // Preorder : Processes the root before the traversals of left and right children.
            System.out.println(" Preorder : " + root. data);
            treeTraversal (root .left) ;

            // Inorder: Processes the root after the traversal of left child and
            // before the traversal of right child.
            System.out.println(" Inorder : " + root. data);
            treeTraversal (root . right) ;

            // Postorder : Processes the root after the traversals of left and right
            // children.
            System.out.println (" Postorder : " + root. data);
        }
    }
}
