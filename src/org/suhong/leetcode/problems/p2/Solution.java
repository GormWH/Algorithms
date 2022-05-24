package org.suhong.leetcode.problems.p2;

// https://leetcode.com/problems/add-two-numbers/submissions/
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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode result = new ListNode();
    ListNode current = result;

    while (true) {
      int val1 = 0;
      if (l1 != null) {
        val1 = l1.val;
        l1 = l1.next;
      }
      int val2 = 0;
      if (l2 != null) {
        val2 = l2.val;
        l2 = l2.next;
      }
      current.val += val1 + val2;
      if (current.val >= 10) {
        current.val -= 10;
        current.next = new ListNode(1);
      }

      if (l1 == null && l2 == null) {
        break;
      }

      if (current.next == null) {
        current.next = new ListNode();
      }
      current = current.next;
    }
    return result;
  }

  public static void main(String[] args) {
    Solution s = new Solution();
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(4);
    l1.next.next = new ListNode(3);

    ListNode l2 = new ListNode(5);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(4);

    ListNode result = s.addTwoNumbers(l1, l2);
    while (result != null) {
      System.out.println(result.val);
      result = result.next;
    }

  }
}


//Definition for singly-linked list.
class ListNode {
  int val;
  ListNode next;
  ListNode() {}
  ListNode(int val) { this.val = val; }
  ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
