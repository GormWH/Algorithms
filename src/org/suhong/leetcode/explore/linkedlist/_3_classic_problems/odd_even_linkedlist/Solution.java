package org.suhong.leetcode.explore.linkedlist._3_classic_problems.odd_even_linkedlist;

import org.suhong.leetcode.datastructure.ListNode;

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return head; // instant end condition
        ListNode leftTail = head;
        ListNode rightHead = head.next;
        ListNode rightTail = rightHead;

        while (rightTail != null) {
            ListNode temp = rightTail.next;
            if (temp == null) break;
            leftTail.next = temp;
            rightTail.next = temp.next;
            temp.next = rightHead;
            leftTail = temp;
            rightTail = rightTail.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(s.oddEvenList(head)); // [1,3,5,2,4]
    }
}
