package com.java.easy;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Collection -> Queue -> Dequeue -> LinkedList | ArrayDequeue
 *
 *  Dequeue是Queue的子接口，是一个双端队列，可在头尾插入删除元素(可作为栈使用)，而Queue就是简单的FIFO队列
 *
 */
public class e155_最小栈 {

    static Deque<Integer> minStack;
    static Deque<Integer> stack;

    /**
     * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
     *
     * 输入：
     * ["MinStack","push","push","push","getMin","pop","top","getMin"]
     * [[],[-2],[0],[-3],[],[],[],[]]
     *
     * 输出：
     * [null,null,null,null,-3,null,0,-2]
     *
     * 解释：
     * MinStack minStack = new MinStack();
     * minStack.push(-2);
     * minStack.push(0);
     * minStack.push(-3);
     * minStack.getMin();   --> 返回 -3.
     * minStack.pop();
     * minStack.top();      --> 返回 0.
     * minStack.getMin();   --> 返回 -2.
     *
     * @param args
     */
    public static void main(String[] args) {
        e155_最小栈 minStack = new e155_最小栈();
        minStack.push(-3);
        minStack.push(0);
        minStack.push(-2);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public e155_最小栈() {
        minStack = new LinkedList();
        stack = new LinkedList();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val<=minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        if (stack.pop().equals(minStack.peek())) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
