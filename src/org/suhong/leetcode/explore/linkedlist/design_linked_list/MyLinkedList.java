package org.suhong.leetcode.explore.linkedlist.design_linked_list;

class MyLinkedList {

    Node head;
    Node tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.val;
    }

    public void addAtHead(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node newHead = new Node(val);
            newHead.next = head;
            head.prev = newHead;
            head = newHead;
        }
        size++;
        // size--??;
    }

    public void addAtTail(int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node newTail = new Node(val);
            newTail.prev = tail;
            tail.next = newTail;
            tail = newTail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (size == 0) {
            head = new Node(val);
            tail = head;
        } else {
            Node newNode = new Node(val);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            if (current.prev != null) {
                current.prev.next = newNode;
            }
            newNode.next = current;
            current.prev = newNode;
        }
        size++;
    }

    public void deleteAtIndex(int index) {
        Node target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        if (target.prev != null) {
            target.prev.next = target.next;
        }
        if (target.next != null) {
            target.next.prev = target.prev;
        }
        size--;
    }
}

class Node {
    int val;
    Node next;
    Node prev;

    public Node(int val) {
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
