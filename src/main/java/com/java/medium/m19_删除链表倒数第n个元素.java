package com.java.medium;

import com.java.comm.ListNode;

public class m19_删除链表倒数第n个元素 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.toPlainString();
        ListNode listNode = removeNthFromEnd1(node1, 2);
        System.out.println();
        listNode.toPlainString();
    }

    /**
     * m19_删除链表倒数第n个元素，其实也就是：删除第：L - n + 1
     *
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode curr = dummy;
        int length = getLength(head);
        for (int i = 1; i < length - n + 1; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        int i = 1;
        ListNode node = new ListNode();
        node.next = head;
        ListNode curr = node;
        int length = getLength(head);
        while (i != (length - n + 1)) {
            curr = curr.next;
            i++;
        }
        curr.next = curr.next.next;
        return node.next;
    }

    public static int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            head = head.next;
            length ++;
        }
        return length;
    }
}
