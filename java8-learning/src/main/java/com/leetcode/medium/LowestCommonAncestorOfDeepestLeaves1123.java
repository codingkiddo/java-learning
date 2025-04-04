package com.leetcode.medium;

import com.example.ds.TreeNode;

public class LowestCommonAncestorOfDeepestLeaves1123 {
	TreeNode res;
    int maxDepth = -1;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    private int dfs(TreeNode node, int depth) {
        if (node == null) {
            maxDepth = Math.max(maxDepth, depth);
            return depth;
        }

        int left = dfs(node.getLeft(), depth + 1);
        int right = dfs(node.getRight(), depth + 1);
        if (left == right && left == maxDepth)
            res = node;
        return Math.max(left, right);
    }
}
