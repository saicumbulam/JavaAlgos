/*
Risky
* */
package Leetcode.BinaryTree.Often;

import java.util.*;

public class AllNodesDistanceK {

    class TreeNode {
        int val;
        TreeNode right, left = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    HashMap<TreeNode, TreeNode> map = new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {

        dfs(root, null);
        int dist = 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(null);
        queue.add(target);

        HashSet<TreeNode> set = new HashSet<>();
        set.add(null);
        set.add(target);

        while (!queue.isEmpty()) {
            TreeNode polled = queue.poll();
            if (polled == null) {
                if (dist == K) {
                    List<Integer> ans = new ArrayList<>();
                    for (TreeNode item : queue) {
                        ans.add(item.val);
                    }
                    return ans;
                }
                queue.add(null);
                dist++;
            } else {
                if (!set.contains(polled.left)) {
                    set.add(polled.left);
                    queue.add(polled.left);
                }

                if (!set.contains(polled.right)) {
                    set.add(polled.right);
                    queue.add(polled.right);
                }


                if (!set.contains(map.get(polled))) {
                    set.add(map.get(polled));
                    queue.add(map.get(polled));
                }
            }
        }
        return new ArrayList<>();
    }

    public void dfs(TreeNode root, TreeNode parent) {
        if (root != null) {
            map.put(root, parent);
            dfs(root.left, root);
            dfs(root.right, root);
        }
    }
}
