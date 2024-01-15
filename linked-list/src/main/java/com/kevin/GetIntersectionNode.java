package com.kevin;

/**
 * 160、链表相交
 *
 * @author kevin
 * @version 1.0
 * @date 2024-01-15 11:40
 */
public class GetIntersectionNode {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    /**
     * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表没有交点，返回 null 。
     *
     * 主要是计算出两表的长度差，让较长的表先走长度差个单位，之后再让两张表一起移动
     */

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA=headA;
        ListNode curB=headB;
        int lenA=0,lenB=0;
        // 计算a表的长度
        while (curA!=null){
            curA=curA.next;
            lenA++;
        }
        // 计算b表的长度
        while (curB!=null){
            curB=curB.next;
            lenB++;
        }
        curA=headA;
        curB=headB;
        // 判断a表和b表的长度
        if(lenB>lenA){
            // 交换ab表，，让a表为最大
            int tmpLen=0;
            tmpLen=lenA;
            lenA=lenB;
            lenB=tmpLen;

            ListNode tmp=null;
            tmp=curA;
            curA=curB;
            curB=tmp;
        }
        int gap=lenA-lenB;// 计算ab表长度的差值
        for (int i = 0; i < gap; i++) {
            curA=curA.next;
        }
        while (curA!=null&&curB!=null){
            if(curA==curB){
                return curA;
            }
            curA=curA.next;
            curB=curB.next;
        }
        return null;
    }
}
