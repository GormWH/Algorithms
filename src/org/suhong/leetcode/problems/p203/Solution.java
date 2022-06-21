package org.suhong.leetcode.problems.p203;

// https://leetcode.com/problems/remove-linked-list-elements/
class Solution {

    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(-val, head); // 맨 앞에 더미 노드 추가
        ListNode prev = result;

        while (head != null) {
            if (head.val == val) {
                prev.next = head.next;
            } else {
                prev = head;
            }
            head = head.next;
        }

        return result.next;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int val1 = 6;
        ListNode listNode1 =
                new ListNode(1,
                        new ListNode(2,
                                new ListNode(6,
                                        new ListNode(3,
                                                new ListNode(4,
                                                        new ListNode(5,
                                                                new ListNode(6)))))));
        int val2 = 7;
        ListNode listNode2 = new ListNode(7,
                new ListNode(7,
                        new ListNode(7,
                                new ListNode(7,
                                        new ListNode(5,
                                                new ListNode(7,
                                                        new ListNode(7)))))));
        int val3 = 1;
        ListNode listNode3 = null;

        s.printListNode(s.removeElements(listNode1, 6));
        s.printListNode(s.removeElements(listNode2, 7));
        s.printListNode(s.removeElements(listNode3, 1));
    }

    private void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
