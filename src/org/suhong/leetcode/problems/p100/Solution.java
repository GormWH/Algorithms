package org.suhong.leetcode.problems.p100;

import org.suhong.leetcode.datastructure.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        if (!isSameTree(p.left, q.left)) return false;
        return isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode node1 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node2 = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode node3 = new TreeNode(1, new TreeNode(3), new TreeNode(2));

        TreeNode node4 = new TreeNode(1, new TreeNode(1), null);
        TreeNode node5 = new TreeNode(1, null, new TreeNode(1));

        System.out.println(s.isSameTree(node1, node2)); // true
        System.out.println(s.isSameTree(node1, node3)); // false
        System.out.println(s.isSameTree(node4, node5)); // false
    }
}
