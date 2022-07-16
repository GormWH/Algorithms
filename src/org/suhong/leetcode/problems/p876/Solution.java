package org.suhong.leetcode.problems.p876;

import org.suhong.leetcode.datastructure.ListNode;

import java.util.List;

// https://leetcode.com/problems/middle-of-the-linked-list/
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode pre = new ListNode(0, head);
        ListNode answer = pre;
        boolean one = true;
        while (pre != null) {
            pre = pre.next;
            one = true;
            if (pre != null) {
                pre = pre.next;
                answer = answer.next;
                one = false;
            }
        }
        return one ? answer.next : answer;
    }
}
