package Leetcode.Medium;

import Leetcode.BinarySearch.BST.TreeNode;

import java.util.*;

public class FindBoundary {
    private static List<TreeNode> Calculate(TreeNode root)
    {
        List<TreeNode> result = new ArrayList<>();
        if (root == null)
        {
            return result;
        }
        List<TreeNode> leftView = new ArrayList<>();
        List<TreeNode> rightView = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty())
        {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();

                if (currentNode.getRight() == null && currentNode.getRight() == null)
                {
                    continue;
                }
                else if (i == levelSize-1)
                {
                    rightView.add(currentNode);
                }
                else if (i == 0)
                {
                    leftView.add(currentNode);
                }
                if (currentNode.getLeft() != null)
                {
                    queue.add(currentNode.getLeft());
                }
                if (currentNode.getRight() != null)
                {
                    queue.add(currentNode.getRight());
                }
            }
        }
        return new ArrayList<TreeNode>()
        {
            {
                addAll(leftView);
                addAll(rightView);
                addAll(Dfs(root));
            }


        };
    }

    private static List<TreeNode> Dfs(TreeNode root) {
        List<TreeNode> leaves = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty())
        {
            TreeNode currentNode = stack.pop();
            if (currentNode.getLeft() == null && currentNode.getRight() == null)
            {
                leaves.add(currentNode);
            }

            if (currentNode.getRight() != null)
            {
                stack.push(currentNode.getRight());
            }
            if(currentNode.getLeft() != null)
            {
                stack.push(currentNode.getLeft());
            }
        }
        return leaves;
    }
}
