package org.suhong.leetcode.explore.linkedlist._5_conclusion.copy_list_random_pointer;

import java.util.HashMap;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}


class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) return null;

        HashMap<Node,Node> nodeMap = new HashMap<>();

        Node original = head;
        Node result = new Node(original.val);
        Node copy = result;
        nodeMap.put(original, copy);

        do {
            if (original.next != null) {
                if (nodeMap.containsKey(original.next)) {
                    copy.next = nodeMap.get(original.next);
                } else {
                    copy.next = new Node(original.next.val);
                    nodeMap.put(original.next, copy.next);
                }
            }

            if (original.random != null) {
                if (nodeMap.containsKey(original.random)) {
                    copy.random = nodeMap.get(original.random);
                } else {
                    copy.random = new Node(original.random.val);
                    nodeMap.put(original.random, copy.random);
                }
            }

            original = original.next;
            copy = copy.next;
        } while (original != null);
        return result;
    }
}
