package com.java.easy;

import com.java.comm.ListNode;

import java.util.HashSet;
import java.util.Set;

public class e141_环形链表 {

    public static void main(String[] args) {
        ListNode head5 = new ListNode(5, null);
        ListNode head4 = new ListNode(4, head5);
        ListNode head3 = new ListNode(3, head4);
        ListNode head2 = new ListNode(2, head3);
        ListNode head1 = new ListNode(1, head2);
        head5.next = head2;
        System.out.println(hasCycle1(head1));

        ListNode head21 = new ListNode(2, null);
        ListNode head11 = new ListNode(1, head21);
        System.out.println(hasCycle1(head11));;
    }

    /**
     * 使用哈希：就是使用哈希表保存这些已经遍历的节点，如果有环链肯定还会再次装载某些节点，如果没有则直接结束了
     *
     * @param head
     * @return
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            head = head.next;
            if (!set.add(head)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 使用双指针：约定一个快慢指针，给定不同的起始位置和执行步长
     *
     *      如果是环形链表：则快慢指针一定会无线循环下去，而且快慢指针一定会相遇，则相遇时直接结束且返回true
     *      如果不是环形链表：则快慢指针有执行边界，也就是遍历到链表的尾结点时结束！
     * @param head
     * @return
     */
    public static boolean hasCycle1(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while(slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
