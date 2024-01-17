package com.kevin;

import java.util.HashMap;

/**
 * 454、四数之和Ⅱ
 * @author kevin
 * @version 1.0
 * @date 2024-01-17 9:41
 */
public class FourSumCount {
    /**
     * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
     * 0 <= i, j, k, l < n
     * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
     *
     * 示例 1：
     * 输入：nums1 = [1,2], nums2 = [-2,-1], nums3 = [-1,2], nums4 = [0,2]
     * 输出：2
     * 解释：
     * 两个元组如下：
     * 1. (0, 0, 0, 1) -> nums1[0] + nums2[0] + nums3[0] + nums4[1] = 1 + (-2) + (-1) + 2 = 0
     * 2. (1, 1, 0, 0) -> nums1[1] + nums2[1] + nums3[0] + nums4[0] = 2 + (-1) + (-1) + 0 = 0
     *
     * 示例 2：
     * 输入：nums1 = [0], nums2 = [0], nums3 = [0], nums4 = [0]
     * 输出：1
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        // 先统计前两个数组中两个元素和的次数
        for (int i : nums1) {
            for (int i1 : nums2) {
                map.put(i + i1, map.getOrDefault(i + i1, 0) + 1);
            }
        }
        for (int i : nums3) {
            for (int i1 : nums4) {
                int cur=0-(i + i1);
                if (map.containsKey(cur)) {
                    res += map.get(cur);
                }
            }
        }
        return res;
    }
}
