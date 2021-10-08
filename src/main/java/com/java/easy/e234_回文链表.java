package com.java.easy;

import com.java.comm.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class e234_回文链表 {

    /**
     * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
     *
     * 输入：head = [1,2,2,1]
     * 输出：true
     *
     * 输入：head = [1,2]
     * 输出：false
     *
     * @param args
     */
    public static void main(String[] args) {
        ListNode node4 = new ListNode(1, null);
        ListNode node3 = new ListNode(2, node4);
        ListNode node2 = new ListNode(2, node3);
        ListNode node1 = new ListNode(1, node2);
        //System.out.println(isPalindrome(node1));
        //node2.next = null;
        //System.out.println(isPalindrome(node1));

        System.out.println(isPalindrome1(node1));
        node2.next = null;
        System.out.println(isPalindrome1(node1));
    }

    /**
     * 判断是否为回文，可以使用栈的结构，先进后出，与原链表排列一致
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null) {
            return false;
        }
        StringBuffer sb = new StringBuffer(Integer.toString(head.val));
        ListNode tmp = head;
        Stack<Integer> stack = new Stack<>();
        stack.push(head.val);
        while (tmp != null && tmp.next != null) {
            ListNode next = tmp.next;
            stack.push(next.val);
            sb.append(next.val);
            tmp = next;
        }

        StringBuffer sb1 = new StringBuffer();
        while (!stack.empty()) {
            sb1.append(stack.pop());
        }
        return sb.toString().equals(sb1.toString());
    }

    /**
     * 这里可以将链表转化为数组，或者List集合，再去判断是否为回文(双指针判断左右是否相等)
     *
     * @param head
     * @return
     */
    public static boolean isPalindrome1(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.val);
            node = node.next;
        }

        int l = 0, r = list.size() - 1;
        while (l <= r) {
            if (!list.get(l).equals(list.get(r))) { // aba abba
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}
