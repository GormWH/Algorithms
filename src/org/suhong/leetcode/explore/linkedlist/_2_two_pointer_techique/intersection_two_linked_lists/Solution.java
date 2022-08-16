package org.suhong.leetcode.explore.linkedlist._2_two_pointer_techique.intersection_two_linked_lists;

import org.suhong.leetcode.datastructure.ListNode;

class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lengthA = 1;
        ListNode pointerA = headA;
        while (pointerA.next != null) {
            pointerA = pointerA.next;
            lengthA++;
        }


        int lengthB = 1;
        ListNode pointerB = headB;
        while (pointerB.next != null) {
            pointerB = pointerB.next;
            lengthB++;
        }

        if (pointerA != pointerB) {
            return null; // there is no intersection node
        }

        pointerA = headA;
        pointerB = headB;

        int gap = lengthA - lengthB;
        if (lengthA < lengthB) {
            gap = -gap;
            for (int i = 0; i < gap; i++) {
                pointerB = pointerB.next;
            }
        } else {
            for (int i = 0; i < gap; i++) {
                pointerA = pointerA.next;
            }
        }

        ListNode result = null;
        while (pointerA!= null && pointerA != pointerB) {
            pointerA = pointerA.next;
            pointerB = pointerB.next;
        }
        return pointerA;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode intersection = new ListNode(8);

        ListNode A = new ListNode(4, new ListNode(1, intersection));
        ListNode B = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));

        System.out.println(s.getIntersectionNode(A,B).val); // 8
    }
}
