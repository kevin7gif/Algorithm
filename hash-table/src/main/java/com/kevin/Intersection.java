package com.kevin;

import java.util.HashSet;

/**
 * 349、两个数组的交集
 * @author kevin
 * @version 1.0
 * @date 2024-01-16 14:29
 */
public class Intersection {
    /**
     * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序
     *
     * 示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2]
     *
     * 示例 2：
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[9,4]
     * 解释：[4,9] 也是可通过的
     */

    public int[] intersection(int[] nums1, int[] nums2) {
        // 初始化一个set，用于存放两数组的交集
        HashSet<Integer> result = new HashSet<>();
        // 用hashset来存放数组的元素
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if(set.contains(nums2[i])){
                result.add(nums2[i]);
            }
        }
        // 将结果集转为数组
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
