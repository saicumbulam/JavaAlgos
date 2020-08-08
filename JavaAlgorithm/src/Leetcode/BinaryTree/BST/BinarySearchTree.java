package Leetcode.BinaryTree.BST;

public class BinarySearchTree {
    TreeNode root;

    public BinarySearchTree() {}
    public BinarySearchTree(int value)
    {
        root = new TreeNode(value);
    }
    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public boolean isEmpty()
    {
        return root == null;
    }

    public boolean add(int value)
    {
        if (isEmpty())
        {
            root = new TreeNode(value);
            return true;
        }

        TreeNode currentNode = root;

        while (currentNode != null)
        {
            TreeNode leftChild = currentNode.getLeft();
            TreeNode rightChild = currentNode.getRight();

            if (currentNode.getData() < value)
            {
                if (rightChild == null)
                {
                    rightChild = new TreeNode(value);
                    currentNode.setRight(rightChild);
                    return true;
                }
                currentNode = currentNode.getRight();
            }
            else
            {
                if (leftChild == null)
                {
                    leftChild = new TreeNode(value);
                    currentNode.setLeft(leftChild);
                    return true;
                }
                currentNode = currentNode.getLeft();
            }
        }

        return false;
    }

    public void printTree(TreeNode root)
    {
        TreeNode currentNode = root;
        if  (currentNode == null)
        {
            return;
        }
        System.out.println(currentNode.getData() + ",");
        printTree(currentNode.getLeft());
        printTree(currentNode.getRight());
    }

    public TreeNode search (int value)
    {
        if (isEmpty())
        {
            return null;
        }

        TreeNode currentNode = root;
        while (currentNode != null)
        {
            if (currentNode.getData() < value)
            {
                currentNode = currentNode.getRight();
            }
            else if (currentNode.getData()  > value)
            {
                currentNode = currentNode.getLeft();
            }
            else
            {
                return currentNode;
            }
        }

        return null;
    }

    public boolean delete(int value, TreeNode currentNode)
    {
        if (root == null)
        {
            return false;
        }

        TreeNode parent = null;
        while (currentNode != null &&
                (currentNode.getData() != value))
        {
            parent = currentNode;
            if (currentNode.getData() < value)
            {
                currentNode = currentNode.getRight();
            }
            else
            {
                currentNode = currentNode.getLeft();
            }
        }

        if(currentNode != null)
        {
            return false;
        }
        else if (currentNode.getLeft() == null && currentNode.getRight() == null)
        {
            if (root.getData() == currentNode.getData())
            {
                setRoot(null);
                return true;
            }
            else if (currentNode.getData() < parent.getData())
            {
                parent.setLeft(null);
            }
            else
            {
                parent.setRight(null);
            }
        }
        else if (currentNode.getLeft() == null)
        {
            if(root.getData() == currentNode.getData())
            {
                setRoot(currentNode.getRight());
            }
            else if (currentNode.getData() < parent.getData())
            {
                parent.setLeft(currentNode.getRight());
            }
            else
            {
                parent.setRight(currentNode.getRight());
            }
        }
        else if (currentNode.getRight() == null)
        {
            if(root.getData() == currentNode.getData())
            {
                setRoot(currentNode.getLeft());
            }
            else if (currentNode.getData() < parent.getData())
            {
                parent.setLeft(currentNode.getLeft());
            }
            else
            {
                parent.setRight(currentNode.getLeft());
            }
        }
        else
        {
            TreeNode temp = leastNode(currentNode.getRight()); //get the least node
            int tobe = temp.getData();
            delete(tobe, root); //delete the least node from the root
            currentNode.setData(tobe); // set the current node data as the least data
            return true;
        }
        return false;
    }

    private TreeNode leastNode(TreeNode currentNode)
    {
        TreeNode temp = currentNode;
        while (temp.getLeft() != null)  // least node should be as a parent. So getleft should be there
        {
            temp = temp.getLeft();
        }
        return temp;
    }

    public void printTree2D(TreeNode node, int height)
    {
        Printer2D(node, 0, height);
    }

    private void Printer2D(TreeNode root, int space, int height)
    {
        if(root == null)
        {
            return;
        }

        space += height;

        Printer2D(root.getLeft(), space, height);
        System.out.println();

        for (int i = height; i < space; i++) {
            System.out.print(' ');
        }

        System.out.print(root.data);

        System.out.println();
        Printer2D(root.getRight(), space, height);
    }

    public TreeNode CreateBinaryTree()
    {
        root = null;
        add(2);
        add(1);
        add(4);
        add(6);
        add(8);
        add(10);
        add(9);
        return root;

    }

    public TreeNode CreateBinaryTree(int[] arr)
    {
        root = null;
        for (int i = 0; i < arr.length; i++) {
            add(arr[i]);
        }
        return root;

    }
}
