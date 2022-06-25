package org.suhong.leetcode.problems.p206;

import java.util.Stack;

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode[] result = new ListNode[2];
        return addListNode(result, head)[0];
    }

    private ListNode[] addListNode(ListNode[] startEnd, ListNode listNode) {
        if (listNode.next == null) {
            startEnd[0] = new ListNode(listNode.val);
            startEnd[1] = startEnd[0];
            return startEnd;
        }

        startEnd[1].next = new ListNode(listNode.val);
        startEnd[1] = startEnd[1].next;
        return addListNode(startEnd, listNode.next);
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(new int[]{1,2,3,4,5});
        printListNode(listNode1, "listNode1");
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