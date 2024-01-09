package com.kevin;

/**
 * 203、移除链表元素
 * @author kevin
 * @version 1.0
 * @date 2024-01-09 16:25
 */
public class RemoveElements {
    /**
     * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
     */

    class ListNode {
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

    public ListNode removeElements(ListNode head, int val) {
        // 创建虚拟头节点
        ListNode dummy = new ListNode(val-1);
        dummy.next = head;
        // 定义一个临时指针用来遍历整个链表
        ListNode tmp=dummy;
        while(tmp.next != null){
           if(tmp.next.val == val){
               tmp.next = tmp.next.next;
           }else {
               tmp = tmp.next;
           }
        }
        return dummy.next;
    }
}
