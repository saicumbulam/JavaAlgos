package Leetcode.String.Easy.Easy;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MaximumDepthNArrayTree {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    };

    class Pair
    {
        Node node;
        int depth;

        public Pair(Node node, int depth)
        {
            this.node = node;
            this.depth = depth;
        }
    }

    class Solution {
        int maxDepth = 0;

        public int maxDepth(Node root) {
            if (root == null)
            {
                return 0;
            }
            Queue<Pair> queue = new LinkedList<>();
            queue.add(new Pair(root, 1));

            while(!queue.isEmpty())
            {
                Pair polled = queue.poll();

                if (polled.node.children.size() > 0)
                {
                    for (Node child : polled.node.children)
                    {
                        queue.add(new Pair(child, polled.depth+1));
                    }
                }
                else
                {
                    if (maxDepth < polled.depth)
                    {
                        maxDepth = polled.depth;
                    }
                }
            }

            return maxDepth;
        }
    }
}
