package com.kevin;

/**
 * 24. 两两交换链表中的节点
 * @author kevin
 * @version 1.0
 * @date 2024-01-15 10:48
 */
public class SwapPairs {
    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。你必须在不修改节点内部的值的情况下完成本题（即，只能进行节点交换）。
     * <p>
     * 示例1：
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * <p>
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
    public ListNode swapPairs(ListNode head) {
        ListNode dummy=new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;// 用于遍历的指针
        ListNode tmp=null;
        ListNode tmp1=null;
        // 遍历链表
        while(cur.next != null && cur.next.next != null){
            // 先保存要改变方向的节点
            tmp=cur.next;
            tmp1=cur.next.next.next;
            cur.next=cur.next.next;
            cur.next.next=tmp;
            tmp.next=tmp1;
            cur=cur.next.next;
        }
        return dummy.next;
    }
}
