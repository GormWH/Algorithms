package org.suhong.leetcode.explore.linkedlist._2_two_pointer_techique.linked_list_cycle2;

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

// https://leetcode.com/problems/linked-list-cycle-ii/discuss/44781/Concise-O(n)-solution-by-using-C%2B%2B-with-Detailed-Alogrithm-Description
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        do {
            slow = slow.next;
            if (fast == null) return null;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
        } while (slow != fast);

        ListNode result = head;
        while (result != slow) {
            result = result.next;
            slow = slow.next;
        }
        return result;
    }
}