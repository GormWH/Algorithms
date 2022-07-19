package org.suhong.leetcode.problems.p101;

import org.suhong.leetcode.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/symmetric-tree/
public class Solution {
    public boolean isSymmetric(TreeNode root) {
        return isSymmetricSub(root.left, root.right);
    }

    private boolean isSymmetricSub(TreeNode left, TreeNode right) {
        if (left == null || right == null) {
            return left == null && right == null;
        }
        if (left.val != right.val) return false;
        if (!isSymmetricSub(left.left, right.right)) return false;
        return isSymmetricSub(left.right, right.left);
    }

    public static void main(String[] args) {

    }
}
