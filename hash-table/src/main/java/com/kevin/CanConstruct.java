package com.kevin;

/**
 * 383、赎金信
 * @author kevin
 * @version 1.0
 * @date 2024-01-17 10:19
 */
public class CanConstruct {
    /**
     * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
     * 如果可以，返回 true ；否则返回 false 。
     * magazine 中的每个字符只能在 ransomNote 中使用一次。
     *
     * 示例 1：
     * 输入：ransomNote = "a", magazine = "b"
     * 输出：false
     *
     * 示例 2：
     * 输入：ransomNote = "aa", magazine = "ab"
     * 输出：false
     *
     * 示例 3：
     * 输入：ransomNote = "aa", magazine = "aab"
     * 输出：true
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        if(ransomNote.length() > magazine.length()){
            return false;
        }
        // 定义一个存放字符的数组
        int[] record = new int[26];
        for (char c : magazine.toCharArray()) {
            // 统计给定字符串中每个字符出现的次数
            record[c-'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            // 统计赎金信中每个字符出现的次数
            record[c-'a']--;
        }
        for (int i : record) {
            // 只要有一个字符出现次数为负，就说明不能构成赎金信
            if(i<0){
                return false;
            }
        }
        return true;
    }
}
