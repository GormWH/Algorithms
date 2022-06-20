package org.suhong.leetcode.problems.p206;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode list = new ListNode();
//        ListNode current = list;
        ListNode[] result = new ListNode[2];
        list = addListNode(result, head)[0];


        return list;
    }

    private ListNode[] addListNode(ListNode[] startEnd, ListNode listNode) {
        if (listNode.next == null) {
            startEnd[0] = new ListNode(listNode.val);
            startEnd[1] = startEnd[0];
            return startEnd;
        }

        startEnd[1].next = new ListNode(listNode.val);
        startEnd[1] = startEnd[1].next;
        return addListNode(startEnd, listNode.next);
    }


}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}