package com.java.easy;

import com.java.comm.ListNode;

public class e203_移除链表元素 {

    /**
     * 给你一个链表的头节点 <code>head</code> 和一个整数 <code>val</code> ，请你删除链表中所有满足 <code>Node.val == val</code> 的节点，
     * 并返回 <strong>新的头节点</strong> 。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(6, node3);
        ListNode node1 = new ListNode(1, node2);
        node1.toPlainString();
        ListNode listNode = removeElements(node1, 6);
        System.out.println();
        listNode.toPlainString();
    }

    public static ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode node = dummy;
        while (node != null && node.next != null) {
            if (node.next.val == val) {
                node.next = node.next.next;
            } else {
                node = node.next;
            }
        }
        return dummy.next;
    }
}
