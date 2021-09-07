package com.java.easy;

import com.java.comm.ListNode;

public class e83_删除排序链表中的重复元素 {

    /**
     * <strong>输入：</strong>head = [1,1,2]
     * <strong>输出：</strong>[1,2]
     *
     * <strong>输入：</strong>head = [1,1,1,2,3,3]
     * <strong>输出：</strong>[1,2,3]
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node6 = new ListNode(3,null);
        ListNode node5 = new ListNode(3, node6);
        ListNode node4 = new ListNode(2, node5);
        ListNode node3 = new ListNode(1, node4);
        ListNode node2 = new ListNode(1, node3);
        ListNode node1 = new ListNode(1, node2);

        node1.toPlainString();
        deleteDuplicates(node1);
        System.out.println();
        node1.toPlainString();

        ListNode node61 = new ListNode(0,null);
        ListNode node51 = new ListNode(0, node61);
        ListNode node41 = new ListNode(0, node51);
        ListNode node31 = new ListNode(0, node41);
        ListNode node21 = new ListNode(0, node31);
        ListNode node11 = new ListNode(0, node21);

        System.out.println();
        node11.toPlainString();
        deleteDuplicates(node11);
        System.out.println();
        node11.toPlainString();
    }

    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dumy = new ListNode(-101);
        dumy.next = head;
        ListNode curr = dumy;
        Integer val = curr.val;
        while (null != curr.next) {
            ListNode node = curr.next;
            if (val != node.val) {
                val = node.val;
                curr = node;
                continue;
            }

            curr.next = curr.next.next;
        }
        return dumy.next;
    }
}
