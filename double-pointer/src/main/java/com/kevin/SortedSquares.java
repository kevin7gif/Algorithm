package com.kevin;

/**
 * 977题：有序数组的平方
 * @author kevin
 * @version 1.0
 * @date 2023-11-25 2:16
 */
public class SortedSquares {

    /**
     * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
     *
     * 示例 1：
     * 输入：nums = [-4,-1,0,3,10]
     * 输出：[0,1,9,16,100]
     * 解释：平方后，数组变为 [16,1,0,9,100]
     * 排序后，数组变为 [0,1,9,16,100]
     *
     * 示例 2：
     * 输入：nums = [-7,-3,2,3,11]
     * 输出：[4,9,9,49,121]
     */
    public int[] sortedSquares(int[] nums) {
        int left = 0;// 起始点
        int right = nums.length - 1;// 结束点
        int[] result = new int[nums.length];// 结果集
        int count = result.length-1;
        while (left<=right){
            // 若最左边的元素大于最右边的，则将最左边的放入结果集
            if((nums[left]*nums[left])>=nums[right]*nums[right]){
                result[count]=nums[left]*nums[left];
                left++;
            }else{
                result[count] = nums[right]*nums[right];
                right--;
            }
            count--;
        }
        return result;
    }
}
