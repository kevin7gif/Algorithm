package com.kevin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 350：两个数组的交集Ⅱ
 * @author kevin
 * @version 1.0
 * @date 2024-01-16 14:41
 */
public class Intersect {
    public static void main(String[] args) {
        Intersect intersect = new Intersect();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        intersect.intersect(nums1, nums2);
    }
    /**
     * 给你两个整数数组 nums1 和 nums2 ，请你以数组形式返回两数组的交集。返回结果中每个元素出现的次数，应与元素在两个数组中都出现的次数一致（如果出现次数不一致，则考虑取较小值）。可以不考虑输出结果的顺序。
     *
     *示例 1：
     * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
     * 输出：[2,2]
     *
     * 示例 2:
     * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
     * 输出：[4,9]
     */
    public int[] intersect(int[] nums1, int[] nums2) {
        // 先排序
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        // 先遍历nums1，统计出现次数
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
        }
        // 遍历nums2，并与map做比较
        for(int i = 0; i < nums2.length; i++){
            if(map.containsKey(nums2[i])){
                if(map.get(nums2[i]) > 0){
                    result.add(nums2[i]);
                }
                map.put(nums2[i], map.get(nums2[i]) - 1);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
