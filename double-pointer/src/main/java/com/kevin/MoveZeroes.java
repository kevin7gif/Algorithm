package com.kevin;

/**
 * 283题：移动零
 * @author kevin
 * @version 1.0
 * @date 2023-11-25 2:01
 */
public class MoveZeroes {

    /**
     *给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
     * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
     *
     * 示例 1:
     * 输入: nums = [0,1,0,3,12]
     * 输出: [1,3,12,0,0]
     *
     * 示例 2:
     * 输入: nums = [0]
     * 输出: [0]
     */

    public void moveZeroes(int[] nums) {
        if(nums.length==1&&nums[0]==0){
            return;
        }
        int fast=0;
        int slow=0;
        while(fast<=nums.length-1){
            if(nums[fast]!=0){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int[] nums,int left,int right){
        int tmp=nums[left];
        nums[left]=nums[right];
        nums[right]=tmp;
    }
}
