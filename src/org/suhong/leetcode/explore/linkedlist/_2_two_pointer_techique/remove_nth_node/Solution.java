package org.suhong.leetcode.explore.linkedlist._2_two_pointer_techique.remove_nth_node;

import org.suhong.leetcode.datastructure.ListNode;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            size++;
        }
        if (n == size) return head.next;

        size = size - n;
        current = new ListNode(0, head);
        for (int i = 0; i < size; i++) {
            current = current.next;
        }
        if (n == 1) {
            current.next = null;
        } else {
            current.next = current.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        System.out.println(listNode1);
        System.out.println(s.removeNthFromEnd(listNode1, 2));

    }
}
