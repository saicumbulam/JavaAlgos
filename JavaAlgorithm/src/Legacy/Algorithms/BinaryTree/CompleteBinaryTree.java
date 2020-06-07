package Legacy.Algorithms.BinaryTree;

class Node{
    public int iData;
    public double dData;
    public Node leftChild;
    public Node rightChild;

    public void display(){
        System.out.println('{' + iData + "," + dData);
    }
}

class Tree{
    private Node root;

    public Tree(){
        root = null;
    }

    public Node find(int key) // find node with given key
    { // (assumes non-empty tree)
        Node current = root; // start at root
        while(current.iData != key) // while no match,
        {
            if(key < current.iData) // go left?
                current = current.leftChild;
            else // or go right?
                current = current.rightChild;
            if(current == null) // if no child,
                return null; // didn’t find it
        }
        return current; // found it
    } // end find()


    public void insert(int id, double data){
        Node newnode = new Node();
        newnode.iData = id;
        newnode.dData = data;
        if (root == null) {
            root = newnode;
        } else {
            Node current = root;
            Node parent;
            while (true){
                parent = current;
                if (id < current.iData) {
                    current = current.leftChild;
                    if (current == null) {
                        parent.leftChild = current;
                        return;
                    }
                } else {
                    current = current.rightChild;
                    if (current == null) {
                        parent.rightChild = current;
                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int key){
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;

        while(current.iData != key) {   // search for node
            parent = current;
            if (key < current.iData) {    // go left
                isLeftChild = true;
                current = current.leftChild;
            } else {                             // go right
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {             // if it couldn't be found
                return false;
            }
        }
            // if no children, simply delete it
            if (current.rightChild == null && current.leftChild == null) {
                if (current == null) {
                    root = null;
                } else if (isLeftChild) {
                    current.leftChild = null;
                } else {
                    current.rightChild = null;
                }
            }
            // if no right child, replace with left subtree
            else if (current.rightChild == null){
                if (current == null) {
                    root = current.leftChild;
                } else if(isLeftChild){
                    parent.leftChild = current.leftChild;
                } else {
                    parent.rightChild = current.leftChild;
                }
            }
            // if no left child, replace with right subtree
            else if (current.leftChild == null){
                if (current == null) {
                    root = current.rightChild;
                } else if(isLeftChild){
                    parent.leftChild = current.rightChild;
                } else {
                    parent.rightChild = current.rightChild;
                }
            } else // two children, so replace with inorder successor
            { // get successor of node to delete (current)
                Node successor = getSuccessor(current);

                // connect parent of current to successor instead
                if (current == root) {
                    root = successor;
                } else if (isLeftChild) {
                    parent.leftChild = successor;
                } else {
                    parent.rightChild = successor;
                }
                // connect successor to current’s left child
                 successor.leftChild = current.leftChild;
            } // end else two children
         // (successor cannot have a left child)
        return true;
    }

    // returns node with next-highest value after delNode
    // goes to right child, then right child’s left descendents
    private Node getSuccessor(Node delNode)
    {
        Node successorParent = delNode;
        Node successor = delNode;
        Node current = delNode.rightChild; // go to right child

        while(current != null) // until no more
        { // left children,
            successorParent = successor;
            successor = current;
            current = current.leftChild; // go to left child
        }
        // if successor not
        if(successor != delNode.rightChild) // right child,
        { // make connections
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = delNode.rightChild;
        }
        return successor;
    }
}


public class CompleteBinaryTree {
}
