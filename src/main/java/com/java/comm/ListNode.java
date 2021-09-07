package com.java.comm;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ListNode {

    public Integer val;

    public ListNode next;

    public ListNode() {
    }

    public ListNode(Integer val) {
        this.val = val;
    }

    public ListNode(Integer val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    /*@Override
    public String toString() {
        return "" + toPlainString();
    }*/

    public void toPlainString() {
        ListNode head = this;
        if (head == null) {
            return;
        }

        while (head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
