package com.kevin;

/**
 * 707、设计链表
 * @author kevin
 * @version 1.0
 * @date 2024-01-09 17:15
 */
public class MyLinkedList {
    class ListNode {
        int val;
        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    /**
     * 你可以选择使用单链表或者双链表，设计并实现自己的链表。
     * 单链表中的节点应该具备两个属性：val 和 next 。val 是当前节点的值，next 是指向下一个节点的指针/引用。
     * 如果是双向链表，则还需要属性 prev 以指示链表中的上一个节点。假设链表中的所有节点下标从 0 开始。
     * 实现 MyLinkedList 类：
     * MyLinkedList() 初始化 MyLinkedList 对象。
     * int get(int index) 获取链表中下标为 index 的节点的值。如果下标无效，则返回 -1 。
     * void addAtHead(int val) 将一个值为 val 的节点插入到链表中第一个元素之前。在插入完成后，新节点会成为链表的第一个节点。
     * void addAtTail(int val) 将一个值为 val 的节点追加到链表中作为链表的最后一个元素。
     * void addAtIndex(int index, int val) 将一个值为 val 的节点插入到链表中下标为 index 的节点之前。如果 index 等于链表的长度，那么该节点会被追加到链表的末尾。如果 index 比长度更大，该节点将 不会插入 到链表中。
     * void deleteAtIndex(int index) 如果下标有效，则删除链表中下标为 index 的节点。
     */
    int size;
    ListNode head;
    public MyLinkedList(){
        size=0;
        head=new ListNode(0);
    }
    public int get(int index){
        if(index>=size||index<0){
            return -1;
        }else{
            ListNode cur=head;
            for(int i=0;i<=index;i++){
                cur=cur.next;
            }
            return cur.val;
        }
    }

    public void addAtIndex(int index, int val) {
        if(index>size){
            return;
        }
        // 判断index是否为开头的元素
        index=Math.max(0,index);
        size++;
        ListNode cur = head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        // 生成新节点
        ListNode newNode=new ListNode(val);
        // 将新节点插入index之前
        newNode.next = cur.next;
        cur.next = newNode;
    }

    // 将元素插入头部
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    // 将元素插入尾部
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    public void deleteAtIndex(int index){
        if(index < 0 || index>size){
            return;
        }
        size--;
        ListNode cur = head;
        for(int i=0;i<index;i++){
            cur=cur.next;
        }
        // 就算index为0也满足移位操作
        cur.next=cur.next.next;
    }

}
