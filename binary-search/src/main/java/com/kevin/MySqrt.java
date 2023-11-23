package com.kevin;

/**
 * 69题：x的平方根
 * @author kevin
 * @version 1.0
 * @date 2023-11-23 9:05
 */
public class MySqrt {
    /**
     * 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
     * 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
     *
     * 示例 1：
     * 输入：x = 4
     * 输出：2
     *
     * 示例 2：
     * 输入：x = 8
     * 输出：2
     * 解释：8 的算术平方根是 2.82842..., 由于返回类型是整数，小数部分将被舍去。
     */

    public int mySqrt(int x){
        if(x==0){
            return 0;
        }
        int left =0;
        int right=x;
        int result=-1;
        while(left<=right){
            int middle=(right+left)/2;
            if((long)middle*middle<=x){
                result=middle;
                left=middle+1;
            }else{
                right=middle-1;
            }
        }
        return result;
    }



}
