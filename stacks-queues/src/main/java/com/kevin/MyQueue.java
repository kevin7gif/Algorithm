package com.kevin;

import java.util.Stack;

/**
 * 232：用栈实现队列
 * @author kevin
 * @version 1.0
 * @date 2024-01-22 15:14
 */
public class MyQueue {
    /**
     * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
     * 实现 MyQueue 类：
     * void push(int x) 将元素 x 推到队列的末尾
     * int pop() 从队列的开头移除并返回元素
     * int peek() 返回队列开头的元素
     * boolean empty() 如果队列为空，返回 true ；否则，返回 false
     *
     * 说明：
     * 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
     * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
     */
    // 用两个栈实现队列
    Stack<Integer> stackIn;// 入栈
    Stack<Integer> stackOut;// 出栈

    // 初始化栈
    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }
    // 如果stackOut为空，则把stackIn的元素全部放入stackOut
    private void dumpstackIn(){
        if (!stackOut.isEmpty()) return;
        while(!stackIn.isEmpty()){
            stackOut.push(stackIn.pop());
        }
    }
    public void push(int x){
        stackIn.push(x);
    }
    public int pop(){
        dumpstackIn();
        return stackOut.pop();
    }
    public int peek(){
        dumpstackIn();
        return stackOut.peek();
    }
    public boolean empty(){
        return stackIn.isEmpty() && stackOut.isEmpty();
    }


}