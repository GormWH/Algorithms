package org.suhong.leetcode.explore.linkedlist.design_linked_list;

class MyLinkedList {

    ListNode head;

    public MyLinkedList() {}

    public int get(int index) {
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            if (current == null) return -1;
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {

    }

    public void addAtTail(int val) {

    }

    public void addAtIndex(int index, int val) {

    }

    public void deleteAtIndex(int index) {

    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
