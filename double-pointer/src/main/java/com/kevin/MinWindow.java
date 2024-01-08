package com.kevin;

import java.util.HashMap;

/**
 * 76、最小覆盖子串
 * @author kevin
 * @version 1.0
 * @date 2024-01-08 17:22
 */
public class MinWindow {
    /**
     *给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     *
     * 示例 1：
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 解释：最小覆盖子串 "BANC" 包含来自字符串 t 的 'A'、'B' 和 'C'。
     *
     * 示例 2：
     * 输入：s = "a", t = "a"
     * 输出："a"
     * 解释：整个字符串 s 是最小覆盖子串。
     *
     * 示例 3:
     * 输入: s = "a", t = "aa"
     * 输出: ""
     * 解释: t 中两个字符 'a' 均应包含在 s 的子串中，
     * 因此没有符合条件的子字符串，返回空字符串。
     */
    public String minWindow(String s, String t) {
        // 给定字符串s的哈希表
        HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
        // 目标字符串t的哈希表表
        HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
        // 将字符串t存入哈希表ht中
        for(int i=0;i<t.length();i++){
            ht.put(t.charAt(i),ht.getOrDefault(t.charAt(i),0)+1);
        }
        String ans="";
        int len=Integer.MAX_VALUE;
        int cnt=0;// 判断有多少个元素符合条件
        // 遍历字符串s
        for(int i=0,j=0;i<s.length();i++){
            // 存入哈希表hs中
            hs.put(s.charAt(i),hs.getOrDefault(s.charAt(i),0)+1);
            // 判断是否包含t中的所有元素
            if(ht.containsKey(s.charAt(i))&&hs.get(s.charAt(i))<=ht.get(s.charAt(i))) cnt++;
            // 窗口移动的条件
            while (j<i&&(!ht.containsKey(s.charAt(j))||hs.get(s.charAt(j))>ht.get(s.charAt(j)))){
                int count=hs.get(s.charAt(j))-1;
                hs.put(s.charAt(j),count);
                j++;
            }
            if(cnt==t.length()&& i-j+1<len){
                len=i-j+1;
                ans=s.substring(j,i+1);
            }
        }
        return ans;
    }
}
