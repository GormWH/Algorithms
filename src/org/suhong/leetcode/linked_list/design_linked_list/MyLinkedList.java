package org.suhong.leetcode.linked_list.design_linked_list;

public class MyLinkedList {

    private Node head;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }

    public int get(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getVal();
    }

    public void addAtHead(int val) {
        Node prevHead = this.head;
        Node newHead = new Node(val);
        this.head = newHead;
        newHead.setNext(prevHead);
        this.size++;
    }

    public void addAtTail(int val) {
        Node current = this.head;
        for (int i = 0; i < size; i++) {
            current = current.getNext();
        }
        current.setNext(new Node(val));
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        Node newNode = new Node(val);
        Node current = this.head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

    }

    public void deleteAtIndex(int index) {
        Node current = this.head;
        for (int i = 0; i < index; i++) {

        }
    }
}

class Node {
    private int val;
    private Node next;

    public Node(int val) {
        this.val = val;
        this.next = null;
    }

    public void setVal(int val) {
        this.val = val;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public int getVal() {
        return this.val;
    }
    public Node getNext() {
        return this.next;
    }
}

/*
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
