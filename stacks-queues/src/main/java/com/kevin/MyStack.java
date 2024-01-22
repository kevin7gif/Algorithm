package com.kevin;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225、用队列实现栈
 * @author kevin
 * @version 1.0
 * @date 2024-01-22 16:59
 */
public class MyStack {
    /**
     * 请你仅使用两个队列实现一个后入先出（LIFO）的栈，并支持普通栈的全部四种操作（push、top、pop 和 empty）。
     * 实现 MyStack 类：
     * void push(int x) 将元素 x 压入栈顶。
     * int pop() 移除并返回栈顶元素。
     * int top() 返回栈顶元素。
     * boolean empty() 如果栈是空的，返回 true ；否则，返回 false 。
     */
    Queue<Integer> queue1;// 和栈中元素保持一致的队列
    Queue<Integer> queue2;// 辅助队列
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    public void push(int x) {
        // 先将元素入队，再将队列1中的元素全部入队2，再将x入队2
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        // 交换队列
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    public int pop() {
        return queue1.poll();
    }
    public int top() {
        return queue1.peek();
    }
    public boolean empty() {
        return queue1.isEmpty();
    }

}
