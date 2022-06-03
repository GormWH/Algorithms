package org.suhong.leetcode.problems.p21;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    // initial solution
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        ListNode result = new ListNode();
        ListNode current = result;
        while (list1 != null || list2 != null) {
            current.next = new ListNode();
            current = current.next;
            if (list1 == null) {
                current.val = list2.val;
                list2 = list2.next;
            } else if (list2 == null) {
                current.val = list1.val;
                list1 = list1.next;
            } else if (list1.val < list2.val) {
                current.val = list1.val;
                list1 = list1.next;
            } else {
                current.val = list2.val;
                list2 = list2.next;
            }
        }
        return result.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode listNode1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode result = s.mergeTwoLists(listNode1, listNode2);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}