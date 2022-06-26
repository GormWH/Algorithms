# 206. Reverse Linked List
[Leet Code url](https://leetcode.com/problems/reverse-linked-list/)

## Description

Given the head of a singly linked list, reverse the list, and return the reversed list.

![rev1ex1](rev1ex1.jpeg)  
Example 1:

Input: head = [1,2,3,4,5]  
Output: [5,4,3,2,1]

![rev1ex2](rev1ex2.jpeg)  
Example 2:

Input: head = [1,2]  
Output: [2,1]

## Recursive Solution

1 -> 2 -> 3 -> 4 -> 5

`reverse(ListNode head, ListNode tail, ListNode current)`  

- Outermost function: `reverse(null, null, ListNode(1)`  -> `return ListNode(5), ListNode(1)`  
    - inner1: `reverse(null, null, ListNode(2)`  -> `return ListNode(5), ListNode(2)`  
         - inner2: `reverse(null, null, ListNode(3)` -> `return ListNode(5), ListNode(3)`  
            - inner3: `reverse(null, null, ListNode(4)`  -> `return ListNode(5), ListNode(4)`  
                - inner4: `reverse(null, null, ListNode(5)` -> `return ListNode(5), ListNode(5)`   

final result: `ListNode(5)` -> `ListNode(4)` -> `ListNode(3)` -> `ListNode(2)` -> `ListNode(1)`
