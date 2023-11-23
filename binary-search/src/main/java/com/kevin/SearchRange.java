package com.kevin;

import java.util.ArrayList;

/**
 * 34题：在排序数组中查找元素的第一个和最后一个位置
 * @author kevin
 * @version 1.0
 * @date 2023-11-22 17:49
 */
public class SearchRange {
    public static void main(String[] args) {
        int[] nums={5,7,7,8,8,10};
        int target=8;
        int[] result=searchRange(nums,target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    /**
     * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回 [-1, -1]
     *
     * 示例 1：
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     *
     * 示例 2：
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     *
     * 示例 3：
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     */

    public static int[] searchRange(int[] nums, int target) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        int[] result = new int[2];
        for (int i = 0, j = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                arrayList.add(i);
                j++;
            }
        }
        if (arrayList.size() == 0) {
            return new int[]{-1, -1};
        } else {
            int[] arr = arrayList.stream().mapToInt(i -> i).toArray();
            result[0] = arr[0];
            result[1] = arr[arr.length - 1];
            return result;
        }
    }
}
