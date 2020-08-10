package Leetcode.BinaryTree.BreadthFirst.Easy;

import java.util.LinkedList;
import java.util.Queue;

public class PopulatingNextPointer {
    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }
    }

    public static void main(String[] args) {
        Node root = new Node();
        System.out.println(Calculate(root));
    }

    private static Node Calculate(Node root)
    {
        if (root == null)
        {
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty())
        {
            Node prev = null;
            int n = queue.size();

            for (int i = 0; i < n; i++) {
                Node polled = queue.poll();

                if(prev != null)
                {
                    prev.next = polled;
                }
                prev = polled;

                if (polled.left != null)
                {
                    queue.add(polled.left);
                }
                if(polled.right != null)
                {
                    queue.add(polled.right);
                }
            }
        }

        return root;
    }
}
