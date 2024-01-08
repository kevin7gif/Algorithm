package com.kevin;

/**
 * 209. 长度最小的子数组
 * @author kevin
 * @version 1.0
 * @date 2023-12-29 16:27
 */
public class MinSubArrayLen {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 target 。
     * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
     *
     *示例 1：
     * 输入：target = 7, nums = [2,3,1,2,4,3]
     * 输出：2
     * 解释：子数组 [4,3] 是该条件下的长度最小的子数组。
     *
     * 示例 2：
     * 输入：target = 4, nums = [1,4,4]
     * 输出：1
     *
     * 示例 3：
     * 输入：target = 11, nums = [1,1,1,1,1,1,1,1]
     * 输出：0
     */
    public int minSubArrayLen(int target, int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int sum = 0;
        int result=Integer.MAX_VALUE;
        for(int i=0,j=0;i<nums.length;i++){
            sum+=nums[i];
            while (sum>=target){
                result =Math.min(result,i-j+1);
                sum-=nums[j];
                j++;
            }
        }
        return result==Integer.MAX_VALUE ? 0: result;
    }

}
