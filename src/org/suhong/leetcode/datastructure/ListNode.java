package org.suhong.leetcode.datastructure;

public class ListNode {
    public int val;
    public ListNode next;
    public ListNode() {}
    public ListNode(int val) { this.val = val; }
    public ListNode(int val, ListNode next) { this.val = val; this.next = next; }

    public String toString() {
        StringBuilder builder = new StringBuilder();
        ListNode current = this;
        builder.append('[');
        while (current != null) {
            builder.append(current.val);
            builder.append(',');
            current = current.next;
        }
        builder.deleteCharAt(builder.length()-1);
        builder.append(']');
        return builder.toString();
    }
}
