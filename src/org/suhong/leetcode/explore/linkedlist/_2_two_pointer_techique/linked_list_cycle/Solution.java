package org.suhong.leetcode.explore.linkedlist._2_two_pointer_techique.linked_list_cycle;

import org.suhong.leetcode.datastructure.ListNode;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode fast = head;
        ListNode slow = head;
        while (true) {
            if (fast.next == null) return false;
            fast = fast.next;
            if (fast.next == null) return false;
            fast = fast.next;
            slow = slow.next;
            if (slow == fast) break;
        }
        return true;
    }
}
