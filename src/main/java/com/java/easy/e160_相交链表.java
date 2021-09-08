package com.java.easy;

import com.java.comm.ListNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class e160_相交链表 {

    /**
     * 判断是否存在相交链表，并且输出相交的节点ListNode
     *
     * 输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
     * 输出：Intersected at '8'
     * 解释：相交节点的值为 8 （注意，如果两个链表相交则不能为 0）。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node4 = new ListNode(5, null);
        ListNode node3 = new ListNode(4, node4);
        ListNode node2 = new ListNode(3, node3);
        ListNode node1 = new ListNode(2, node2);
        ListNode root1 = new ListNode(1, node1);

        ListNode root2 = new ListNode(0, node4);

        System.out.println(getIntersectionNode(root1, root2));
        System.out.println(getIntersectionNode1(root1, root2));
    }

    /**
     * 哈希法
     *
     *  使用哈希结构，将数据暂存起来，再去判断是否存在
     *
     *  输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
     *  输出：Intersected at '8'
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }

        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    /**
     * 双指针：采取循环遍历两个链表，直至他们有相同的节点
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }

        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }
}
