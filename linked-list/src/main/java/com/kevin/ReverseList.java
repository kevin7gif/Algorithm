package com.kevin;

/**
 * 206、反转链表
 *
 * @author kevin
 * @version 1.0
 * @date 2024-01-15 10:12
 */
public class ReverseList {
    /**
     * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
     * 示例1：
     * 输入：head = [1,2,3,4,5]
     * 输出：[5,4,3,2,1]
     *
     * 示例2：
     * 输入：head = []
     * 输出：[]
     */

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur= head;
        ListNode tmp = null;
        // 遍历链表
        while(cur != null){
            tmp=cur.next;
            cur.next=prev;
            prev=cur;
            cur=tmp;
        }
        return prev;
    }

}
