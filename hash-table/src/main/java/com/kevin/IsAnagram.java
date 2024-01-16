package com.kevin;

/**
 * 242、有效的字母异位词
 * @author kevin
 * @version 1.0
 * @date 2024-01-16 14:11
 */
public class IsAnagram {
    /**
     * 给定两个字符串，编写一个函数来判断它们是否是字母异位词。
     * 示例 1:
     * 输入: s = "anagram", t = "nagaram"
     * 输出: true
     * 示例 2:
     * 输入: s = "rat", t = "car"
     * 输出: false
     */

    public boolean isAnagram(String s, String t) {
       // 初始化一个整型数组，并赋默认值0
        int[] hash=new int[26];
        for(int i=0;i<s.length(); i++){
            hash[s.charAt(i)-'a']++;
        }
        for(int i=0;i<t.length(); i++){
            hash[t.charAt(i)-'a']--;
        }
        for (int i : hash) {
            if(i!=0){
                return false;
            }
        }
        return true;
    }
}
