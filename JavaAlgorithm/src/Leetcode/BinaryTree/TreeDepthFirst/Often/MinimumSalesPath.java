package Leetcode.BinaryTree.TreeDepthFirst.Often;

import java.util.*;


public class MinimumSalesPath {
    static class Node {
        int cost;
        Node[] children;
        Node parent;

        Node(int cost) {
            this.cost = cost;
            children = null;
            parent = null;
        }
    }


    static int minLength = Integer.MAX_VALUE;
    static List<List<Integer>> result = new ArrayList<>();

    static int getCheapestCost(Node rootNode) {
        Calculate(rootNode, new ArrayList<>());
        return minLength;
    }

    private static void Calculate(Node root, List<Integer> curr)
    {
        if (root == null)
        {
            return;
        }

        curr.add(root.cost);

        if (root.children == null)
        {
            int sum = 0;
            for (int item: curr)
            {
                sum += item;
            }

            if (sum < minLength)
            {
                minLength = sum;
                result.clear();
                result.add(new ArrayList<>(curr));
            }
            else if (sum == minLength)
            {
                result.add(new ArrayList<>(curr));
            }
        }
        else
        {
            for (Node child : root.children)
            {
                Calculate(child, curr);
            }
        }

        curr.remove(curr.size()-1);
    }
    /*********************************************
     * Driver program to test above method     *
     *********************************************/

    public static void main(String[] args) {
        Node root = new Node(0);
        root.children = new Node[3];
        root.children[0] = new Node(5);
        root.children[1] = new Node(3);
        root.children[2] = new Node(6);

        root.children[0].children = new Node[1];
        getCheapestCost(root);
        System.out.println(result);

    }
}
