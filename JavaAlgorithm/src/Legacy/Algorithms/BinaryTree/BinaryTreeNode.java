package Legacy.Algorithms.BinaryTree;

public class BinaryTreeNode<T> {
    public T data;
    public BinaryTreeNode <T> left, right;

    public BinaryTreeNode (T value){
        this.data = value;
    }
}
