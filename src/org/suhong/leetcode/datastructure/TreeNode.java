package org.suhong.leetcode.datastructure;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        List<TreeNode> treeNodes = new ArrayList<>();
        treeNodes.add(this);
        while (true) {
            List<TreeNode> nextNodes = new ArrayList<>();
            builder.append("[");
            for (int i = 0; i < treeNodes.size(); i++) {
                TreeNode current = treeNodes.get(i);
                builder.append(current.val + ", ");
                if (current.left != null) {
                    nextNodes.add(current.left);
                }
                if (current.right != null) {
                    nextNodes.add(current.right);
                }
            }
            builder.append("]\n");
            if (nextNodes.size() == 0) break;
            treeNodes = nextNodes;
        }
        return builder.toString();
    }
}
