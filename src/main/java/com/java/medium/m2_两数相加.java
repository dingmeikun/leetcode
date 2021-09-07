package com.java.medium;

import com.java.comm.ListNode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class m2_两数相加 {

    public static void main(String[] args) {
        /*ListNode l1 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        l1.next = node2;
        node2.next = node3;

        ListNode l2 = new ListNode(5);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(4);
        l2.next = node4;
        node4.next = node5;*/

        ListNode l1 = new ListNode(9);
        ListNode node2 = new ListNode(9);
        ListNode node3 = new ListNode(9);
        ListNode node31 = new ListNode(9);
        ListNode node32 = new ListNode(9);
        ListNode node33 = new ListNode(9);
        ListNode node34 = new ListNode(9);
        l1.next = node2;
        node2.next = node3;
        node3.next = node31;
        node31.next = node32;
        node32.next = node33;
        node33.next = node34;

        ListNode l2 = new ListNode(9);
        ListNode node4 = new ListNode(9);
        ListNode node5 = new ListNode(9);
        ListNode node6 = new ListNode(9);
        l2.next = node4;
        node4.next = node5;
        node5.next = node6;

        ListNode listNode1 = addTwoNumbers1(l1, l2);
        ListNode listNode = addTwoNumbers(l1, l2);
        listNode1.toPlainString();
        System.out.println();
        listNode.toPlainString();
    }

    /**
     * <strong>输入：</strong>l1 = [2,4,3], l2 = [5,6,4]
     * <strong>输出：</strong>[7,0,8]
     * <strong>解释：</strong>342 + 465 = 807.
     */
    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode tmp = new ListNode(0);
        ListNode ans = tmp;

        int up = 0, curr;
        while (l1 != null || l2 != null || up != 0) {

            int sum = 0;
            if (l1 != null) {
                sum+=l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum+=l2.val;
                l2 = l2.next;
            }

            sum += up;
            up = sum / 10;
            curr = sum % 10;

            ListNode node = new ListNode(curr);
            ans.next = node;
            ans = ans.next;
        }
        return tmp.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(0);
        ListNode l = sentinel;

        int curr = 0, carry = 0;
        // 注意 不要提前 比如l1.next != null 这类的 没必要
        while(l1 != null || l2 != null || carry != 0){

            int sum = 0;
            // 这里很巧妙 因为把l1是否为null 和我产生新节点这件事解耦了
            // 这样不用讨论 之后哪个更长的相应的细节处理 事实证明这些细节处理非常恶心
            // 以至于他们更愿意去补齐：）使两者一样长 也不愿意处理那些细节。。
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }

            sum += carry;
            curr = sum % 10;
            carry = sum / 10;
            // 有值生成 才new 否则你末尾会很尴尬的多个0
            // 这点由机制决定我们循环末尾 l是站在最后一位有值的地方 然后等待下一步
            l.next = new ListNode(curr);
            l = l.next;

        }

        return sentinel.next;
    }
}
