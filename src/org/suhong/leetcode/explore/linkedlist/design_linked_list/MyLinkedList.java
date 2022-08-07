package org.suhong.leetcode.explore.linkedlist.design_linked_list;

class MyLinkedList {

    ListNode head;
    int size;

    public MyLinkedList() {
        size = 0;
    }

    public int get(int index) {
        if (index >= size) return -1;
        ListNode current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            addAtHead(val);
            return;
        }
        ListNode newNode = new ListNode(val);
        ListNode current = head;
        for (int i = 0; i < size - 1; i++) {
            current = current.next;
        }
        current.next = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == 0) {
            addAtHead(val);
        } else if (index == size) {
            addAtTail(val);
        }else {
            ListNode newNode = new ListNode(val);
            ListNode current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public void deleteAtIndex(int index) {
        if (index == 0) {
            deleteAtHead();
            return;
        }
        if (index == size - 1) {
            deleteAtTail();
            return;
        }
        if (index >= size) {
            return;
        }
        ListNode current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        if (index < size - 1) {
            current.next = current.next.next;
        } else {
            current.next = null;
        }
        size--;
    }

    private void deleteAtHead() {
        head = head.next;
        size--;
    }

    private void deleteAtTail() {
        ListNode current = head;
        for (int i = 0; i < size-1; i++) {
            current = current.next;
        }
        current.next = null;
        size--;
    }

    public String toString() {
        ListNode current = head;
        StringBuilder builder = new StringBuilder();
        builder.append('[');
        for (int i = 0; i < size; i++) {
            builder.append(current.val);
            current = current.next;
        }
        builder.append(']');
        return builder.toString();
    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtTail(1);
        list.addAtTail(2);
        list.addAtTail(3);
        list.addAtTail(4);
        list.addAtTail(5);
        System.out.println(list);

        list.deleteAtIndex(0);
        System.out.println(list);
        list.deleteAtIndex(2);
        System.out.println(list);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(3));
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
