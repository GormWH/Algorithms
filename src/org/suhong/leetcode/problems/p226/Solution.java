package org.suhong.leetcode.problems.p226;

import org.suhong.leetcode.datastructure.TreeNode;

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTreeSub(root);
        return root;
    }

    private void invertTreeSub(TreeNode root) {
        if (root.left != null) {
            invertTreeSub(root.left);
        }
        if (root.right != null) {
            invertTreeSub(root.right);
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}
