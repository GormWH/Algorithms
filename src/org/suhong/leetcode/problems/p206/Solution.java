package org.suhong.leetcode.problems.p206;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return head;
        ListNode[] result = new ListNode[2];
        return reverseListRecursive(result, head)[0];
    }

    private ListNode[] reverseListRecursive(ListNode[] headAndTail, ListNode listNode) {
        if (listNode.next == null) {
            headAndTail[0] = listNode;
            headAndTail[1] = listNode;
            return headAndTail;
        }
        headAndTail = reverseListRecursive(headAndTail, listNode.next);
        headAndTail[1].next = new ListNode(listNode.val);
        headAndTail[1] = headAndTail[1].next;
        return headAndTail;
    }


    public static void main(String[] args) {
        Solution s = new Solution();

        ListNode listNode1 = new ListNode(new int[]{1,2,3,4,5});
        printListNode(listNode1, "listNode1");
        ListNode result1 = s.reverseList(listNode1);
        printListNode(result1, "result1");
    }

    public static void printListNode(ListNode head, String name) {
        System.out.println("========" + name + "========");
        while (head != null) {
            System.out.print(head.val + ", ");
            head = head.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode(int[] array) {
        int pointer = 0;
        this.val = array[pointer++];
        this.next = new ListNode(array, pointer);
    }

    ListNode(int[] array, int pointer) {
        this.val = array[pointer++];
        if (pointer != array.length) {
            this.next = new ListNode(array, pointer);
        }
    }
}