package org.suhong.leetcode.explore.linkedlist._3_classic_problems.reverse;

import org.suhong.leetcode.datastructure.ListNode;

public class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode temp = head.next;
        ListNode newHead = head;
        while (temp != null) {
            head.next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = head.next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));

        System.out.println(head1);
        System.out.println(s.reverseList(head1));

        ListNode head2 = new ListNode(1);

        System.out.println(s.reverseList(head2));
    }
}
