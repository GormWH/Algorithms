package org.suhong.leetcode.explore.linkedlist._3_classic_problems.palindrome;

import org.suhong.leetcode.datastructure.ListNode;

class Solution {
    /*
    "fast" traverse 2 nodes at each step while slow traverse 1 node at each step
    when "fast" arrives the end node "slow" is right at the middle node
    if "slow" has been reversing each node it traversed, left and right half of the linked list would be the same
     */
    public boolean isPalindrome(ListNode head) {
        if (head.next == null) return true;

        ListNode dummyHead = new ListNode(0, head);
        ListNode fast = head;
        ListNode slow = head;
        boolean ignoreFirstNode = false;
        while (true) {
            fast = fast.next;
            if (fast == null) {
                ignoreFirstNode = true;
                break;
            }
            fast = fast.next;
            if (fast == null) {
                break;
            }
            ListNode temp = slow.next;
            slow.next = temp.next;
            temp.next = dummyHead.next;
            dummyHead.next = temp;
        }

        ListNode checker = dummyHead.next;
        if (ignoreFirstNode) checker = checker.next;
        slow = slow.next;
        while (slow != null) {
            if (slow.val != checker.val) return false;
            slow = slow.next;
            checker = checker.next;
        }

        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        ListNode head2 = new ListNode(1, new ListNode(2));
        ListNode head3 = new ListNode(1, new ListNode(2, new ListNode(3,new ListNode(2, new ListNode(1)))));

        System.out.println(s.isPalindrome(head1)); // true
        System.out.println(s.isPalindrome(head2)); // false
        System.out.println(s.isPalindrome(head3)); // true
    }
}
