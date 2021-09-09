package com.java.medium;

import com.java.comm.ListNode;

public class 链表反转 {

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);

        node1.toPlainString();
        ListNode newNode = reverseList1(node1);
        System.out.println();
        newNode.toPlainString();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode newHead = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newHead.next;
            newHead.next = head;
            head = next;
        }
        return newHead.next;
    }

    public static ListNode reverseList1(ListNode head) {
        ListNode newNode = new ListNode(-1);
        while (head != null) {
            ListNode next = head.next;
            head.next = newNode.next;
            newNode.next = head;
            head = next;
        }
        return newNode.next;
    }
}
