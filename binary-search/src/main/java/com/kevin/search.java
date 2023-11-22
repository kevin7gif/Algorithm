package com.kevin;

/**
 * 704题：二分查找
 * @author kevin
 * @version 1.0
 * @date 2023-11-22 17:03
 */
public class search {
    /** 给定一个n个元素有序的（升序）整型数组nums和一个目标值target，
     * 写一个函数搜索nums中的target，如果目标值存在返回下标，否则返回-1
     *
     * 示例 1:
     * 输入: nums = [-1,0,3,5,9,12], target = 9
     * 输出: 4
     * 解释: 9 出现在 nums 中并且下标为 4
     *
     * 示例 2:
     * 输入: nums = [-1,0,3,5,9,12], target = 2
     * 输出: -1
     * 解释: 2 不存在 nums 中因此返回 -1
     * */
     public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<=right){
            int middle = (right+left)/2;
            if(nums[middle]<target){
                left=middle+1;
            }else if(nums[middle]>target){
                right=middle-1;
            }else{
                return middle;
            }
        }
        return -1;
    }
}
