package com.kevin;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239、滑动窗口最大值
 * @author kevin
 * @version 1.0
 * @date 2024-01-23 14:20
 */
public class MaxSlidingWindow {
    /**
     * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
     * 返回 滑动窗口中的最大值 。
     *
     * 示例 1：
     * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
     * 输出：[3,3,5,5,6,7]
     *
     * 示例 2：
     * 输入：nums = [1], k = 1
     * 输出：[1]
     */
    Deque<Integer> deque = new ArrayDeque<>();
    // 自己实现poll add peek方法
    void poll(int val){
        if(!deque.isEmpty()&&deque.peekFirst()==val){
            deque.pollFirst();
        }
    }
    void add(int val){
        while (!deque.isEmpty()&&deque.peekLast()<val){
            deque.pollLast();
        }
        deque.add(val);
    }
    int peek(){
        return deque.peekFirst();
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==1)return nums;
        int[] res = new int[nums.length-k+1];
        int index = 0;
        MaxSlidingWindow myQueue = new MaxSlidingWindow();
        for(int i=0;i<k; i++){
            myQueue.add(nums[i]);
        }
        res[index++]= myQueue.peek();
        for(int i=k;i<nums.length; i++){
            // 移除开头元素
            myQueue.poll(nums[i-k]);
            // 新增尾部元素
            myQueue.add(nums[i]);
            // 将新队列中的最大值放入结果数组
            res[index++]= myQueue.peek();
        }
        return res;
    }
}
