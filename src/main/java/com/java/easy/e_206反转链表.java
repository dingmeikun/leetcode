package com.java.easy;

import com.java.comm.ListNode;

public class e_206反转链表 {

    public static void main(String[] args) {
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node1.toPlainString();
        ListNode listNode = reverseList(node1);
        System.out.println();
        listNode.toPlainString();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode();
        while (head != null) {
            ListNode next = head.next;
            head.next = dummy.next;
            dummy.next = head;
            head = next;
        }
        return dummy.next;
    }
}
