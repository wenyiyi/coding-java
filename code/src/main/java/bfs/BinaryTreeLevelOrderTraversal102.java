package bfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;


/*
*
* https://leetcode.com/problems/binary-tree-level-order-traversal/?utm_source=chatgpt.com
*Given the root of a binary tree, return the level order traversal of its nodes' values.
* (i.e., from left to right, level by level).
*
* Input: root = [3,9,20,null,null,15,7]
  Output: [[3],[9,20],[15,7]]
*
* */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class BinaryTreeLevelOrderTraversal102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // 又忘记判断null的习惯了吗！！！
        if (root == null) {
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);

        List<List<Integer>> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            // 固定当前层
            int currQueueSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < currQueueSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            result.add(level);
        }
        return result;
    }
}

















