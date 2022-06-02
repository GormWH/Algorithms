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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = new ListNode();
        ListNode current = result;
        ListNode left = list1;
        ListNode right = list2;
        if (left == null && right == null) {
            return result;
        }
        if (left == null) {
            current.val = right.val;
            right = right.next;
        } else if (right == null){
            current.val = left.val;
            left = left.next;
        } else {
            if (left.val < right.val) {
                current.val = left.val;
                left = left.next;
            } else {
                current.val = right.val;
                right = right.next;
            }
        }
        while (true) {

            if (left == null && right == null) {
                break;
            }
            current.next = new ListNode();
            current = current.next;
            if (left == null) {
                current.val = right.val;
                right = right.next;
            } else if (right == null){
                current.val = left.val;
                left = left.next;
            } else {
                if (left.val < right.val) {
                    current.val = left.val;
                    left = left.next;
                } else {
                    current.val = right.val;
                    right = right.next;
                }
            }
        }
        return result;
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