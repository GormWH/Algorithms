package org.suhong.leetcode.explore.linkedlist._2_two_pointer_techique.intersection_two_linked_lists;

import org.suhong.leetcode.datastructure.ListNode;

public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode intersection = new ListNode(8);

        ListNode A = new ListNode(4, new ListNode(1, intersection));
        ListNode B = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));

        System.out.println(s.getIntersectionNode(A,B).val); // 8
    }
}
