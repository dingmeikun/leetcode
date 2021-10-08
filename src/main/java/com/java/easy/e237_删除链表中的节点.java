package com.java.easy;

import com.java.comm.ListNode;

public class e237_删除链表中的节点 {

    /**
     * 请编写一个函数，使其可以删除某个链表中给定的（非末尾）节点。传入函数的唯一参数为 要被删除的节点 。
     *
     * 输入：head = [4,5,1,9], node = 5
     * 输出：[4,1,9]
     * 解释：给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     *
     * 提示：
     *
     * 链表至少包含两个节点。
     * 链表中所有节点的值都是唯一的。
     * 给定的节点为非末尾节点并且一定是链表中的一个有效节点。
     * 不要从你的函数中返回任何结果。
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node6 = new ListNode(6,null);
        ListNode node5 = new ListNode(5, node6);
        ListNode node4 = new ListNode(4, node5);
        ListNode node3 = new ListNode(3, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        node1.toPlainString();
        deleteNode(node1);
        node1.toPlainString();
    }

    /**
     * 题目没有给出head节点，也就是说需要原地删除给定的节点node
     *
     *  一般情况下，我们不知道node的上一个节点，如果采取：preNode.next = node.next 或者：preNode.next = preNode.next.next就很好删除。
     *
     *  在本题中，我们需要换一种思路，就是针对当前节点node的下一个节点做文章：
     *
     *      1.把下一个节点的值，赋予给当前node.val
     *      2.删除下一个节点。
     *
     *      可以很巧妙的把当前节点删除了！！！
     *
     * @param node 指定需要删除的节点
     */
    public static void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
