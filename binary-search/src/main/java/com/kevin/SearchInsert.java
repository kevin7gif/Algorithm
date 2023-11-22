package com.kevin;

/**
 * 35题：搜索插入位置
 * @author kevin
 * @version 1.0
 * @date 2023-11-22 17:09
 */
public class SearchInsert {
    /**
     *  给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     *  示例 1:
     *  输入: nums = [1,3,5,6], target = 5
     *  输出: 2
     *
     * 示例 2:
     * 输入: nums = [1,3,5,6], target = 2
     * 输出: 1
     *
     * 示例 3:
     * 输入: nums = [1,3,5,6], target = 7
     * 输出: 4
     */
    public int searchInsert(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        if(nums[right]<target){
            return nums.length;
        }
        while(left<=right){
            int middle=(right+left)/2;
            if(nums[middle]<target){
                left=middle+1;
            }else if(nums[middle]>target){
                right=middle-1;
            }else{
                return middle;
            }
        }
        return right+1;
    }
}
