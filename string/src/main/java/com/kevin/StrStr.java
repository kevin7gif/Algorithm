package com.kevin;

/**
 * 28、找出字符串中第一个匹配项的下标
 * @author kevin
 * @version 1.0
 * @date 2024-01-18 20:36
 */
public class StrStr {
    /**
     * 给你两个字符串 haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。如果 needle 不是 haystack 的一部分，则返回  -1 。
     *
     * 示例 1：
     * 输入：haystack = "sadbutsad", needle = "sad"
     * 输出：0
     * 解释："sad" 在下标 0 和 6 处匹配。
     * 第一个匹配项的下标是 0 ，所以返回 0 。
     *
     * 示例 2：
     * 输入：haystack = "leetcode", needle = "leeto"
     * 输出：-1
     * 解释："leeto" 没有在 "leetcode" 中出现，所以返回 -1 。
     *
     * aabaab
     * 后缀：b ab aab baab abaab
     * 前缀：a aa aab aaba aabaa
     */
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0)return 0;
        int[] next=new int[needle.length()];
        getNext(next,needle);

        int j=0;
        for (int i=0;i<haystack.length();i++){
            while(j>0&&needle.charAt(j)!=haystack.charAt(i)){
                j=next[j-1];
            }
            if(needle.charAt(j)==haystack.charAt(i)){
                j++;
            }
            if(j==needle.length()){
                return i-needle.length()+1;
            }
        }
        return -1;
    }
    private void getNext(int[] next, String s){
        int j=0;
        next[0]=0;
        for(int i=1;i<s.length(); i++){
            while (j>0&&s.charAt(i)!=s.charAt(j)){
                j=next[j-1];
            }
            if(s.charAt(i)==s.charAt(j)){
                j++;
            }
            next[i]=j;
        }
    }
}
