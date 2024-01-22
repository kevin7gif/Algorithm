package com.kevin;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 20：有效的括号
 * @author kevin
 * @version 1.0
 * @date 2024-01-22 17:35
 */
public class IsValid {
    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
     * 有效字符串需满足：
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * 每个右括号都有一个对应的相同类型的左括号。
     *
     * 示例 1：
     * 输入：s = "()"
     * 输出：true
     *
     * 示例 2：
     * 输入：s = "()[]{}"
     * 输出：true
     *
     * 示例 3：
     * 输入：s = "(]"
     * 输出：false
     */
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        Stack<Character> queue = new Stack<>();
        char ch;
        for(int i = 0; i <s.length(); i++){
            if(s.charAt(i)=='('){
                queue.push(')');
            }else if(s.charAt(i)=='{') {
                queue.push('}');
            }else if (s.charAt(i) == '[') {
                queue.push(']');
            }else if(queue.isEmpty() || queue.peek()!=s.charAt(i)){
                return false;
            }else{
                queue.pop();
            }
        }
        return queue.isEmpty();
    }
}
