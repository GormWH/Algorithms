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
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
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

    // solution with no extra space
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode result = null;
        ListNode base = null;
        ListNode extra = null;

        if (list1.val < list2.val) {
            result = list1;
            base = list1;
            extra = list2;
        } else {
            result = list2;
            base = list2;
            extra = list1;
        }

        while (base.next != null || extra != null) {
            if (base.next == null) {
                base.next = extra;
                return result;
            }
            if (extra == null) {
                return result;
            }
            if (base.next.val < extra.val) {
                base = base.next;
            } else {
                ListNode temp = base.next;
                base.next = new ListNode(extra.val, temp);
                extra = extra.next;
                base = base.next;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode listNode11 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode listNode12 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode21 = null;
        ListNode listNode22 = null;
        ListNode listNode31 = null;
        ListNode listNode32 = new ListNode(0);

        System.out.println("======================");
        ListNode result1 = s.mergeTwoLists2(listNode11, listNode12);
        while (result1 != null) {
            System.out.println(result1.val);
            result1 = result1.next;
        }

        System.out.println("======================");
        ListNode result2 = s.mergeTwoLists2(listNode21, listNode22);
        while (result2 != null) {
            System.out.println(result2.val);
            result2 = result2.next;
        }

        System.out.println("======================");
        ListNode result3 = s.mergeTwoLists2(listNode31, listNode32);
        while (result3 != null) {
            System.out.println(result3.val);
            result3 = result3.next;
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