package org.suhong.leetcode.explore.linkedlist._5_conclusion.multilevel_linkedlist;

import java.util.Stack;

/*
// Definition for a Node.
 */
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};


class Solution {
    public Node flatten(Node head) {
        Stack<Node> nodeStack = new Stack<>();
        Node current = head;
        while (current != null) {
            if (current.child != null) {
                if (current.next != null) {
                    nodeStack.push(current.next);
                }
                current.next = current.child;
                current.child.prev = current;
                current.child = null;
            } else if (current.next == null && !nodeStack.isEmpty()) {
                current.next = nodeStack.pop();
                current.next.prev = current;
            }
            current = current.next;
        }
        return head;
    }
}