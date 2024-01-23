package com.kevin;

import java.util.Stack;

/**
 * 1047：删除字符串中的所有相邻重复项
 * @author kevin
 * @version 1.0
 * @date 2024-01-23 10:26
 */
public class RemoveDuplicates {
    /**
     * 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
     * 在 S 上反复执行重复项删除操作，直到无法继续删除。
     * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
     *
     * 示例：
     * 输入："abbaca"
     * 输出："ca"
     * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。之后我们得到字符串 "aaca"，
     * 其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
     */
    public String removeDuplicates(String s) {
        // 初始化一个栈，来存储元素
        Stack<Character> stack = new Stack<Character>();
        char ch;
        for(int i = 0; i < s.length(); i++){
            ch=s.charAt(i);
            if(stack.isEmpty() || !stack.peek().equals(ch)){
                stack.push(ch);
            }else{
                stack.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        // 将sb反转为字符串
        return sb.reverse().toString();
    }
}
