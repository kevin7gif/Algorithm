package com.kevin;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * 347：前K个高频元素
 * @author kevin
 * @version 1.0
 * @date 2024-01-23 15:32
 */
public class TopKFrequent {
    /**
     * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
     *
     * 示例 1:
     * 输入: nums = [1,1,1,2,2,3], k = 2
     * 输出: [1,2]
     *
     * 示例 2:
     * 输入: nums = [1], k = 1
     * 输出: [1]
     */
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 首先遍历nums，用map存储每个元素出现的次数
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        // 初始化一个优先级队列，采用小顶堆
        PriorityQueue<Integer[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        // 遍历map，将每个元素和出现次数放入队列
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(pq.size() < k){
                pq.add(new Integer[]{entry.getKey(), entry.getValue()});
            }else if(pq.peek()[1] < entry.getValue()){
                // 如果当前元素的出现次数大于队列中最小元素的出现次数，那么就替换队列中的最小元素(堆顶)
                pq.poll();// 弹出堆顶元素
                pq.add(new Integer[]{entry.getKey(), entry.getValue()});
            }
        }
        int[] res=new int[k];
        for(int i=k-1;i>=0;i--){
            //依次弹出小顶堆,先弹出的是堆的根,出现次数少,后面弹出的出现次数多
            res[i]=pq.poll()[0];
        }
        return res;
    }
}
