package com.java.easy;

import com.java.comm.ListNode;

import java.util.ArrayList;
import java.util.List;

public class e21_合并两个有序链表 {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n11 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);

        ListNode l1 = n1;
        n1.setNext(n2);
        n2.setNext(n4);

        ListNode l2 = n11;
        n11.setNext(n3);
        n3.setNext(n4);

        List<Integer> real = mergeTwoLists(l1, l2);
        System.out.println(real.toString());
    }

    public static List<Integer> mergeTwoLists(ListNode l1, ListNode l2) {
        List<Integer> real = new ArrayList<>();
        ListNode prev = new ListNode();
        while (l1 != null && l2 != null) {
            if (l1.getVal() <= l2.getVal()) {
                prev.setNext(l1);
                l1 = l1.getNext();
            } else {
                prev.setNext(l2);
                l2 = l2.getNext();
            }
            real.add(prev.getNext().getVal());
        }

        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的链表即可
        real.add(l1 == null ? l2.getVal() : l1.getVal());

        return real;
    }
}
