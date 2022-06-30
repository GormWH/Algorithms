package org.suhong.leetcode.problems.p94;

import org.suhong.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

// https://leetcode.com/problems/binary-tree-inorder-traversal/
class Solution {

    List<Integer> result = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root != null) {
            inorderTraversalSub(root);
        }
        return result;
    }

    private void inorderTraversalSub(TreeNode root) {
        if (root.left != null) {
            inorderTraversalSub(root.left);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversalSub(root.right);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(1, null, new TreeNode(2 , new TreeNode(3), null));
        System.out.println(s.inorderTraversal(root1));
    }
}

